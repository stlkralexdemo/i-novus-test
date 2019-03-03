package ru.inovus.carnumbergenerator.service;

import ru.inovus.carnumbergenerator.model.CarNumber;

import java.util.Arrays;
import java.util.Random;

public class CarNumberService {

    private static final String[] LETTERS = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

    public static CarNumber randomNumber() {

        CarNumber carNumber = new CarNumber();

        int min = 1;
        int max = 999;

        Random random = new Random();
        carNumber.setNumber(random.nextInt(max - min) + min);

        carNumber.setFirstLetter(LETTERS[random.nextInt(LETTERS.length)]);
        carNumber.setSecondLetter(LETTERS[random.nextInt(LETTERS.length)]);
        carNumber.setThirdLetter(LETTERS[random.nextInt(LETTERS.length)]);

        return carNumber;
    }

    public static CarNumber nextNumber(CarNumber carNumber) {

        if (carNumber.getNumber() < 999) {
            carNumber.setNumber(carNumber.getNumber() + 1);
        } else if (!carNumber.getThirdLetter().equals("Х")) {
            carNumber.setThirdLetter(LETTERS[Arrays.asList(LETTERS).indexOf(carNumber.getThirdLetter()) + 1]);
            carNumber.setNumber(1);
        } else if (!carNumber.getSecondLetter().equals("Х")) {
            carNumber.setSecondLetter(LETTERS[Arrays.asList(LETTERS).indexOf(carNumber.getSecondLetter()) + 1]);
            carNumber.setNumber(1);
        } else if (!carNumber.getFirstLetter().equals("Х")) {
            carNumber.setFirstLetter(LETTERS[Arrays.asList(LETTERS).indexOf(carNumber.getFirstLetter()) + 1]);
            carNumber.setNumber(1);
        } else {
            carNumber.setNumber(1);
            carNumber.setFirstLetter(LETTERS[0]);
            carNumber.setSecondLetter(carNumber.getFirstLetter());
            carNumber.setThirdLetter(carNumber.getFirstLetter());
        }
        return carNumber;
    }

    public static String addZero(int num) {
        if (num > 99) {
            return String.valueOf(num);
        } else if (num > 9) {
            return "0" + num;
        } else return "00" + num;
    }
}
