package ru.lesson.clinic;

/**
 * Клиент
 * Created by Рустем on 23.08.2017.
 */
public class Client {
    private String id;
    private final Pet pet;

    /*
    *Конструктор для клиента
    *@param id номер клиета
    *@param ru.lesson.clinic.Pet питомец
     */
    public Client(String id, Pet pet){
        this.id=id;
        this.pet = pet;
    }


    /*Редактировать имя клиента
     */
    public void editClientName(String name){
        this.id = name;
    }

}
