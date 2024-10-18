package ru.gb.homework1;

/** Задача Создать проект из трёх классов (основной с точкой входа и два класса в другом
 * пакете), которые вместе должны составлять одну программу, позволяющую
 * производить четыре основных математических действия и осуществлять
 * форматированный вывод результатов пользователю
 * */

import ru.gb.homework1.service.MathAction;
import ru.gb.homework1.view.Decorator;

/**
 * Основной класс приложения. Здесь мы можем описать
 * его основное назначение и способы взаимодействия с ним.
 * */
public class Programm {

    /**
     * Точка входа в программу. С неё всегда всё начинается.
     * @param args стандартные аргументы командной строки
     * */

    public static void main(String[] args) {
        Decorator DR = new Decorator();
        MathAction MA = new MathAction(2,2);
        System.out.println(DR.decorate(MA.sum()));
        System.out.println(Decorator.decorate(MA.sub()));
        System.out.println(Decorator.decorate(MA.div()));
        System.out.println(Decorator.decorate(MA.mul()));

    }

}
