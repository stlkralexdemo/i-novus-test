package ru.inovus.carnumbergenerator.service;

import org.springframework.stereotype.Service;
import ru.inovus.carnumbergenerator.model.CarNumber;

import java.util.Arrays;
import java.util.Random;

@Service
public class CarNumberService {

    private static final String[] LETTERS = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

    CarNumber carNumber = new CarNumber("А", "А", "А", 0);

    public String randomNumber() {

        int min = 1;
        int max = 999;

        Random rn = new Random();
        carNumber.setNumber(rn.nextInt(max - min) + min);

        carNumber.setFirstLetter(LETTERS[rn.nextInt(LETTERS.length)]);
        carNumber.setSecondLetter(LETTERS[rn.nextInt(LETTERS.length)]);
        carNumber.setThirdLetter(LETTERS[rn.nextInt(LETTERS.length)]);

        return carNumber.toString();
    }

    public String nextNumber() {

        String lastLetter = LETTERS[LETTERS.length - 1];

        if (carNumber.getNumber() < 999) {
            carNumber.setNumber(carNumber.getNumber() + 1);
        } else if (!carNumber.getThirdLetter().equals(lastLetter)) {
            carNumber.setThirdLetter(LETTERS[Arrays.asList(LETTERS).indexOf(carNumber.getThirdLetter()) + 1]);
            carNumber.setNumber(1);
        } else if (!carNumber.getSecondLetter().equals(lastLetter)) {
            carNumber.setSecondLetter(LETTERS[Arrays.asList(LETTERS).indexOf(carNumber.getSecondLetter()) + 1]);
            carNumber.setNumber(1);
        } else if (!carNumber.getFirstLetter().equals(lastLetter)) {
            carNumber.setFirstLetter(LETTERS[Arrays.asList(LETTERS).indexOf(carNumber.getFirstLetter()) + 1]);
            carNumber.setNumber(1);
        } else {
            carNumber.setNumber(1);
            carNumber.setFirstLetter(LETTERS[0]);
            carNumber.setSecondLetter(carNumber.getFirstLetter());
            carNumber.setThirdLetter(carNumber.getFirstLetter());
        }
        return carNumber.toString();
    }

    public static String addZero(int num) {
        if (num > 99) {
            return String.valueOf(num);
        } else if (num > 9) {
            return "0" + num;
        } else return "00" + num;
    }
}
