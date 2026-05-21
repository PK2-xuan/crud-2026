package com.xuan.clientcrud.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.xuan.clientcrud.dto.request.ClientRequestDto;
import com.xuan.clientcrud.dto.response.ClientResponseDto;
import com.xuan.clientcrud.service.ClientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;


    @PostMapping
    public ResponseEntity<ClientResponseDto> save(@Valid @RequestBody ClientRequestDto dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<Page<ClientResponseDto>> findAll(Pageable pageable) {

        return ResponseEntity.ok(service.findAll(pageable));
    }
    /*public boolean active() { return true; }*/

    /* public String active() {return "EL APRA NUNCA MUERE";} */

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable String id) {

        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> update(@PathVariable String id, @Valid @RequestBody ClientRequestDto dto) {

        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
