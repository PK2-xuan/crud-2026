package com.xuan.clientcrud.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientResponseDto {

	private String id;
	
	private String nombre;
	
	private String email;
	
}
