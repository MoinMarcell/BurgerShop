package de.neuefische.burgershop.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class IdServiceTest {

    IdService idService = new IdService();

    @Test
    void generateIt() {
        assertNotNull(idService.generateIt());
    }
}