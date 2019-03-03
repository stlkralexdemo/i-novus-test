package ru.inovus.carnumbergenerator.repository;

import org.springframework.stereotype.Repository;
import ru.inovus.carnumbergenerator.model.CarNumber;

import java.util.*;

@Repository
public class RandomCarNumberRepository {

    public RandomCarNumberRepository(List<CarNumber> randomNumberList) {
        this.randomNumberList = randomNumberList;
    }

    private List<CarNumber>randomNumberList = new ArrayList<>();

    public void add(CarNumber carNumber) {
        this.randomNumberList.add(carNumber);
    }

    public boolean contains(CarNumber carNumber) {
        return this.randomNumberList.indexOf(carNumber) >= 0;
    }
}
