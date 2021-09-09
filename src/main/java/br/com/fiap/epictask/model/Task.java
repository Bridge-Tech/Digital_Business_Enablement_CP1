package br.com.fiap.epictask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Task {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "O titulo é obrigatório")
	private String title;
	@Size(min=10, message = "Deve ter pelo menos 10 chars")
	private String description;
	@Min(value = 10, message = "A pontuação minima é 10")
	@Max(value = 100, message ="A pontuação Maxima é 100")
	private int points;

}