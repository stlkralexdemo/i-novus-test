package ru.inovus.carnumbergenerator.model;

import static ru.inovus.carnumbergenerator.service.CarNumberService.addZero;

public class CarNumber {

    private static final String PAST = "116 RUS";

    private String firstLetter;
    private String secondLetter;
    private String thirdLetter;

    private int number;

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String getSecondLetter() {
        return secondLetter;
    }

    public void setSecondLetter(String secondLetter) {
        this.secondLetter = secondLetter;
    }

    public String getThirdLetter() {
        return thirdLetter;
    }

    public void setThirdLetter(String thirdLetter) {
        this.thirdLetter = thirdLetter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return firstLetter + addZero(number) + secondLetter + thirdLetter + " " + PAST;
    }

    public CarNumber(String firstLetter, String secondLetter, String thirdLetter, int number) {
        this.firstLetter = firstLetter;
        this.secondLetter = secondLetter;
        this.thirdLetter = thirdLetter;
        this.number = number;
    }
}
