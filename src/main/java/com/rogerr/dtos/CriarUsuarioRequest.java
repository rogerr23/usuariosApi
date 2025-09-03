package com.rogerr.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarUsuarioRequest {

	@NotBlank(message = "Nome é obrigátorio.")
	@Size(min = 8, max = 100, message = "Nome deve ter entre 8 e 100 caracteres.")
	private String nome;

	@NotBlank(message = "Email é obrigátorio.")
	@Email(message = "Email inválido.")
	private String email;

	@NotBlank(message = "Senha é obrigátoria.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "A senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial.")
	private String senha;

}
