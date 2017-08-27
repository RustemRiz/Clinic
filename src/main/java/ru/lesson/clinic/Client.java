package ru.lesson.clinic;

/**
 * Клиент
 * Created by Рустем on 23.08.2017.
 */
public class Client {
    private String name;
    private final Pet pet;

    /*
    *Конструктор для клиента
    *@param id номер клиета
    *@param ru.lesson.clinic.Pet питомец
     */
    public Client(String id, Pet pet){
        this.name=id;
        this.pet = pet;
    }

    public String getName(){
        return this.name;
    }

    /*
    *Имя питомца
     */
    public Pet getPet(){
        return this.pet;
    }

    /**
     * Переименовать клиента
     * @param newName Новое имя
     */
    public void rename(String newName){
        if (newName.length()==0) throw new IllegalArgumentException("The name must contain at least one character!");
        this.name = newName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", pet=" + pet +
                '}';
    }
}
