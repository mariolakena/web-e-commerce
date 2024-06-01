package com.e.web.commerce.Controller;

import com.e.web.commerce.dto.ClientRequestDto;
import com.e.web.commerce.dto.ClientResponseDto;
import com.e.web.commerce.entity.Client;
import com.e.web.commerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> register(@RequestBody
                                               ClientRequestDto
                                                   requestDto) {
        Client response = clientService.createClient(requestDto);
        return new ResponseEntity<>(response,
                HttpStatus.CREATED);

    }

    @PatchMapping("{id}")
    public ResponseEntity<ClientResponseDto> updateClient(
            @RequestBody ClientRequestDto clientRequestDto, @PathVariable Long clientId) {
        ClientResponseDto client = clientService.updateClient(clientId, clientRequestDto);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

}