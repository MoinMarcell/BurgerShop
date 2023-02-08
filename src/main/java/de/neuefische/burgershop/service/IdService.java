package de.neuefische.burgershop.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdService {
    public String generateIt(){
        return UUID.randomUUID().toString();
    }
}
