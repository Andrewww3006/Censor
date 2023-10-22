package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        FileCreator test;
        test = new FileCreator("Привет! Как твои дела? Ты жопа. Ананас был кислый.","out.txt");

        FileCreator censor;
        censor = new FileCreator("Жопа\nАнанас\nНос","censor.txt");

        Censor censoredList;
        censoredList = new Censor("censor.txt");

        censoredList.getCensor();

        censoredList.checkFile("out.txt");

    }
}
