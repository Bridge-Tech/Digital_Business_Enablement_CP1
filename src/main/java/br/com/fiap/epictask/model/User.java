package br.com.fiap.epictask.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "O nome é obrigatório")
	private String name;
	@Email(message = "Email inválido")
	private String email;
	@Size(min=10, message = "Deve ter pelo menos 8 caracteres")
	private String password;
}
