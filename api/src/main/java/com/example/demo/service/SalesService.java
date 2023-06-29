package com.example.demo.service;

import com.example.demo.model.dto.request.SalesCreationRequestDTO;
import com.example.demo.model.dto.request.UserCreationRequestDTO;
import com.example.demo.model.entity.Sales;
import com.example.demo.repository.SalesRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final SalesRepository salesRepository;

    public void create(SalesCreationRequestDTO request){
        salesRepository.save(request.toEntity());
    }
}
