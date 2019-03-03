package ru.inovus.carnumbergenerator.service;

import ru.inovus.carnumbergenerator.model.CarNumber;

import java.util.Arrays;
import java.util.Random;

public class CarNumberService {

    private static final String[] Letters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

    public CarNumber randomNumber() {

        CarNumber carNumber = new CarNumber();

        int min = 1;
        int max = 999;

        Random random = new Random();
        carNumber.setNum(random.nextInt(max - min) + min);

        carNumber.setFirstLetter(Letters[random.nextInt(Letters.length)]);
        carNumber.setSecondLetter(Letters[random.nextInt(Letters.length)]);
        carNumber.setThirdLetter(Letters[random.nextInt(Letters.length)]);

        return carNumber;
    }

    public CarNumber nextNumber(CarNumber carNumber) {

        if (carNumber.getNum() < 999) {
            carNumber.setNum(carNumber.getNum() + 1);
        } else if (!carNumber.getThirdLetter().equals("Х")) {
            carNumber.setThirdLetter(Letters[Arrays.asList(Letters).indexOf(carNumber.getThirdLetter()) + 1]);
            carNumber.setNum(1);
        } else if (!carNumber.getSecondLetter().equals("Х")) {
            carNumber.setSecondLetter(Letters[Arrays.asList(Letters).indexOf(carNumber.getSecondLetter()) + 1]);
            carNumber.setNum(1);
        } else if (!carNumber.getFirstLetter().equals("Х")) {
            carNumber.setFirstLetter(Letters[Arrays.asList(Letters).indexOf(carNumber.getFirstLetter()) + 1]);
            carNumber.setNum(1);
        } else {
            carNumber.setNum(1);
            carNumber.setFirstLetter(Letters[0]);
            carNumber.setSecondLetter(carNumber.getFirstLetter());
            carNumber.setThirdLetter(carNumber.getFirstLetter());
        }
        return carNumber;
    }

    public static String addZero(int num) {
        String valueOf = String.valueOf(num);
        if (num > 99) {
            return valueOf;
        } else if (num > 9) {
            return "0" + valueOf;
        } else return "00" + valueOf;
    }
}
