package com.xuan.clientcrud.service;

import java.util.List;

import com.xuan.clientcrud.dto.request.ClientRequestDto;
import com.xuan.clientcrud.dto.response.ClientResponseDto;

public interface ClientService {
	
	List<ClientResponseDto> findAll();
	
	ClientResponseDto findById(String id);
	
	ClientResponseDto save(ClientRequestDto dto);
	
	ClientResponseDto update(String id, ClientRequestDto dto);
	
	void delete(String id);

}
