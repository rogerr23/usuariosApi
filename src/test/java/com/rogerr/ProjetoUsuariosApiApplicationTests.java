package com.rogerr;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.rogerr.dtos.CriarUsuarioRequest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
class ProjetoUsuariosApiApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	@Order(1)
	@DisplayName("Deve criar um usuário com sucesso.")
	void deveCriarUsuarioComSucesso() {

		try {

			var faker = new Faker();

			var request = new CriarUsuarioRequest();
			request.setNome(faker.name().fullName());
			request.setEmail(faker.internet().emailAddress());
			request.setSenha("@Teste2025");

			var result = mockMvc.perform(post("/api/v1/usuario/criar").contentType("application/json")
					.content(objectMapper.writeValueAsString(request)));

			result.andExpect(status().isOk());
		}

		catch (Exception e) {
			fail("Erro: " + e.getMessage());
		}

	}

	@Test
	@Order(2)
	@DisplayName("Deve autenticar um usuário com sucesso.")
	void deveAutenticarUsuarioComSucesso() {
		fail("Teste não implementado.");
	}

	@Test
	@Order(3)
	@DisplayName("Não deve permitir cadastrar usuários com o mesmo email.")
	void naoDevePermitirCadastrarUsuariosComMesmoEmail() {
		fail("Teste não implementado.");
	}

	@Test
	@Order(4)
	@DisplayName("Não deve permitir autenticar um usuário inválido.")
	void naoDevePermitirAutenticarUsuarioInvalido() {
		fail("Teste não implementado.");
	}

	@Test
	@Order(5)
	@DisplayName("Não deve permitir o cadastro de um usuário com senha fraca.")
	void naoDevePermitirCadastroDeUsuarioComSenhaFraca() {
		fail("Teste não implementado.");
	}

}
