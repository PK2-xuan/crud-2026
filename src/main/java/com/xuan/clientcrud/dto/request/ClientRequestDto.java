package com.xuan.clientcrud.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequestDto {
	
	@NotBlank (message = "El nombre es obligatorio makanaky")
	private String nombre;
	
	@Email (message = "El email no es valdio votante de castillo")
	@NotBlank (message = "El correo es obligatorio lapiz")
	private String	email;
	
}
