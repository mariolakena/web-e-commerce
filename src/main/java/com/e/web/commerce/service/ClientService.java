package com.e.web.commerce.service;


import com.e.web.commerce.dto.ClientRequestDto;
import com.e.web.commerce.dto.ClientResponseDto;
import com.e.web.commerce.entity.Client;
import com.e.web.commerce.repository.ClientRepository;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    private ModelMapper modelMapper = new ModelMapper();
    public Client createClient(ClientRequestDto requestDto){
        Optional<Client> optionalClient = this.clientRepository.findByEmail(requestDto.getEmail());
        if (optionalClient.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "we have another client with this email address");
        }

        Client client =modelMapper.map(requestDto, Client.class);

        return clientRepository.save(client);

    }

    public ClientResponseDto updateClient(Long id, ClientRequestDto clientResponseDto) {
        Client existingClient = this.clientRepository.findById(id).get();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(clientResponseDto, existingClient);
        return modelMapper.map(clientRepository.save(existingClient),
                ClientResponseDto.class);
    }
}