package ru.inovus.carnumbergenerator.service;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import ru.inovus.carnumbergenerator.model.CarNumber;
import ru.inovus.carnumbergenerator.repository.RandomCarNumberRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarNumberServiceTest {

    private CarNumberService service;


    @BeforeEach
    void setUp() {

        RandomCarNumberRepository repository = new RandomCarNumberRepository();
        repository.add(
                new CarNumber("А", "А", "А", 0));
        service = new CarNumberService(repository);
    }

    @org.junit.jupiter.api.Test
    void findRandomNumber() {
        String result = service.randomNumber();
        List<String> results = new ArrayList<>();
        results.add(result);

        assertEquals(1, results.size());
    }

    @org.junit.jupiter.api.Test
    void findNextNumber() {
        String result = service.nextNumber();

        assertEquals("А001АА 116 RUS", result);
    }
}