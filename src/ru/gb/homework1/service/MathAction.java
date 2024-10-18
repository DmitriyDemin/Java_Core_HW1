package ru.gb.homework1.service;

/**
 * Другой, очень полезный класс приложения. Здесь мы можем описать
 * его основное назначение и способы взаимодействия с ним.
 * */

public class MathAction {
    private int A;
    private int B;

    public MathAction(int a, int b) {
        this.A = a;
        this.B = b;
    }

    public int sum (){
        return A + B;
    }
/**
 * метод определения суммы двух чисел
 * */

    public int sub (){
        return A - B;
/**
 * метод определения разности двух чисел
 * */
    }
    public int div (){
        return A / B;
/**
 * метод определения частного одного числа от другого
 * */
    }
    public int mul (){
        return A * B;
/**
 * метод определения произведения двух чисел
 * */
    }

}
