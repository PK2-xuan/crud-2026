package com.xuan.clientcrud.service.impl;


import com.xuan.clientcrud.exception.ResourceNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xuan.clientcrud.document.Client;
import com.xuan.clientcrud.dto.request.ClientRequestDto;
import com.xuan.clientcrud.dto.response.ClientResponseDto;
import com.xuan.clientcrud.repository.ClientRepository;
import com.xuan.clientcrud.service.ClientService;
import com.xuan.clientcrud.mapper.ClientMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    private final ClientMapper mapper;

    @Override
    public Page<ClientResponseDto> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponse);
    }

    @Override
    public ClientResponseDto findById(String id) {
        Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        //return ClientResponseDto.builder().id(client.getId()).nombre(client.getNombre()).email(client.getEmail()).build();
        return mapper.toResponse(client);
    }

    @Override
    public ClientResponseDto save(ClientRequestDto dto) {

        //Client client = Client.builder().nombre(dto.getNombre()).email(dto.getEmail()).build();
        Client client = mapper.toEntity(dto);

        Client savedClient = repository.save(client);

        //return ClientResponseDto.builder().id(savedClient.getId()).nombre(dto.getNombre()).email(savedClient.getEmail()).build();
        return mapper.toResponse(savedClient);
    }

    @Override
    public ClientResponseDto update(String id, ClientRequestDto dto) {
        Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        client.setNombre(dto.getNombre());
        client.setEmail(dto.getEmail());

        //Client client = mapper.toEntity(dto);

        Client updatedClient = repository.save(client);

        //return ClientResponseDto.builder().id(updatedClient.getId()).nombre(updatedClient.getNombre()).email(updatedClient.getEmail()).build();
        return mapper.toResponse(updatedClient);
    }

    @Override
    public void delete(String id) {
        Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        repository.delete(client);

    }

    @Override
    public List<ClientResponseDto> findByNombre(String nombre) {
        return repository.findByNombre(nombre)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

}
