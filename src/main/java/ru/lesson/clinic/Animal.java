package ru.lesson.clinic;

/**
 * Created by Рустем on 24.08.2017.
 */
public abstract class Animal implements Pet{
    protected String name;
    protected Animal(String name){
        this.name = name;
    }

    public void makeSound() {

    }

    public String getName() {
        return this.name;
    }



    /*

    *Переименовать питомца
     */  @Override
    public void setNamePet(String name){
        this.name = name;
    }
}
