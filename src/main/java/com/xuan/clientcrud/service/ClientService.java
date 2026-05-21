package com.xuan.clientcrud.service;


// java.util.List;

import com.xuan.clientcrud.dto.request.ClientRequestDto;
import com.xuan.clientcrud.dto.response.ClientResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {

    //List<ClientResponseDto> findAll();
    Page<ClientResponseDto> findAll(Pageable pageable);

    ClientResponseDto findById(String id);

    ClientResponseDto save(ClientRequestDto dto);

    ClientResponseDto update(String id, ClientRequestDto dto);

    void delete(String id);

    //filter
    List<ClientResponseDto> findByNombre(String nombre);

}
