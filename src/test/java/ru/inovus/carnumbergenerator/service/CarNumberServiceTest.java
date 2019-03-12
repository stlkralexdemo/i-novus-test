package ru.inovus.carnumbergenerator.service;

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
    void findNextNumberNew() {

        service.setCarNumber(new CarNumber("А","А","Х", 999));

        String result = service.nextNumber();

        assertEquals("А001ВА 116 RUS", result);
    }


    @org.junit.jupiter.api.Test
    void findNextNumberTwo(){

        service.setCarNumber(new CarNumber("А","Х","Х", 999));

        String result = service.nextNumber();

        assertEquals("В001АА 116 RUS", result);
    }

    @org.junit.jupiter.api.Test
    void findNextNumberThree(){

        service.setCarNumber(new CarNumber("Х","Х","Х", 999));

        String result = service.nextNumber();

        assertEquals("А001АА 116 RUS", result);
    }

    @org.junit.jupiter.api.Test
    void findNextNumberFour(){

        service.setCarNumber(new CarNumber("А","Х","А", 999));

        String result = service.nextNumber();

        assertEquals("А001ХВ 116 RUS", result);
    }
    @org.junit.jupiter.api.Test
    void findNextNumberFive(){

        service.setCarNumber(new CarNumber("А","Х","А", 900));

        String result = service.nextNumber();

        assertEquals("А901ХА 116 RUS", result);
    }
}