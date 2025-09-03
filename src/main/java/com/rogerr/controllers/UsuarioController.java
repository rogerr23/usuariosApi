package com.rogerr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rogerr.dtos.AutenticarUsuarioRequest;
import com.rogerr.dtos.AutenticarUsuarioResponse;
import com.rogerr.dtos.CriarUsuarioRequest;
import com.rogerr.dtos.CriarUsuarioResponse;
import com.rogerr.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("criar")
	public CriarUsuarioResponse criar(@RequestBody @Valid CriarUsuarioRequest request) {
		return usuarioService.criarUsuario(request);
	}

	@PostMapping("autenticar")
	public AutenticarUsuarioResponse autenticar(@RequestBody @Valid AutenticarUsuarioRequest request) {
		return usuarioService.autenticarUsuario(request);
	}
}
