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
    /*Редактировать имя клиента
     */
    public void editClientName(String name){
        this.name = name;
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
        this.name = newName;
    }
}
