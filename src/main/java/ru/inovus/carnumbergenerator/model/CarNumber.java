package ru.inovus.carnumbergenerator.model;

import static ru.inovus.carnumbergenerator.service.CarNumberService.addZero;

public class CarNumber {
    private final String past = "116 RUS";

    private String firstLetter;
    private String secondLetter;
    private String thirdLetter;

    private int num;

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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return firstLetter + addZero(num) + secondLetter + thirdLetter + " " + past;
    }
}
