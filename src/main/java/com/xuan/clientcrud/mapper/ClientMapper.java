package com.xuan.clientcrud.mapper;

import com.xuan.clientcrud.document.Client;
import com.xuan.clientcrud.dto.request.ClientRequestDto;
import com.xuan.clientcrud.dto.response.ClientResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientRequestDto dto) {
        return Client.builder().nombre(dto.getNombre()).email(dto.getEmail()).build();
    }

    public ClientResponseDto toResponse(Client client) {
        return ClientResponseDto.builder().id(client.getId()).nombre(client.getNombre()).email(client.getEmail()).build();
    }

}
