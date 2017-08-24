package ru.lesson.clinic;

/**
 * Клиника
 * Created by Рустем on 23.08.2017.
 */
public class Clinic {
    /*
    *Список клиентов
     */
    private final Client[] clients;

    public Clinic(final int size){
        this.clients = new Client[size];
    }

    /*
    *Добавить клиента
    *@param  position Позиция
    * @param name Имя клиента
     */
    public void addClient(int position, final Client client){
        this.clients[position] = client;
    }
/*
*Поиск клиента по кличке питомца
* @param name кличка питомца
 */
    public Client[] findClientsByPetName(final String name){
        /* TODO реализовать */
        return new Client[]{};
    }

    /*
    *Поиск клиента по имени
     */
    public Client[] findClientByName(final String name){
        /*TODO реализовать         */
        return new Client[]{};
    }
}
