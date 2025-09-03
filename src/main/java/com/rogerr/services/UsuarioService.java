package com.rogerr.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerr.components.CryptoComponent;
import com.rogerr.dtos.AutenticarUsuarioRequest;
import com.rogerr.dtos.AutenticarUsuarioResponse;
import com.rogerr.dtos.CriarUsuarioRequest;
import com.rogerr.dtos.CriarUsuarioResponse;
import com.rogerr.entities.Usuario;
import com.rogerr.exceptions.AcessoNegadoException;
import com.rogerr.exceptions.EmailJaCadastradoException;
import com.rogerr.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	CryptoComponent cryptoComponent;

	public CriarUsuarioResponse criarUsuario(CriarUsuarioRequest request) {

		if (usuarioRepository.existsByEmail(request.getEmail())) {
			throw new EmailJaCadastradoException();
		}

		var usuario = new Usuario();

		usuario.setNome(request.getNome());
		usuario.setEmail(request.getEmail());
		usuario.setSenha(cryptoComponent.getSHA256(request.getSenha()));

		usuarioRepository.save(usuario);

		var response = new CriarUsuarioResponse();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setDataHoraCriacao(LocalDateTime.now());

		return response;

	}

	public AutenticarUsuarioResponse autenticarUsuario(AutenticarUsuarioRequest request) {

		var usuario = usuarioRepository.find(request.getEmail(), cryptoComponent.getSHA256(request.getSenha()));

		if (usuario == null) {
			throw new AcessoNegadoException();
		}

		var response = new AutenticarUsuarioResponse();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setDataHoraAcesso(LocalDateTime.now());
		response.setToken("");

		return response;

	}

}
