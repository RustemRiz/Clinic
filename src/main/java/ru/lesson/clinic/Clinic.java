package ru.lesson.clinic;

import java.util.Scanner;

/**
 * Клиника
 * Created by Рустем on 23.08.2017.
 */
public class Clinic {
    /*
    *Список клиентов
     */
    private final Client[] clients;
    private Scanner scanner = new Scanner(System.in);
    /**
     *
     * @param size размер клиники(Максимальное количество посетителей
     */
    public Clinic(final int size){
        this.clients = new Client[size];
    }
    public Client getClient(int id){
        return this.clients[id];
    }
    /*
    *Добавить клиента
    *@param  position Позиция
    * @param name Имя клиента
     */
    public void addClient(final Client client){
        for (int i=0;i<clients.length;i++){
            if(clients[i]==null) {this.clients[i] = client;break;}
        }
    }
    /**
    *Удалить клиента по его имени (регистр не учитывается)
     */
    public void deleteClientByHisName(String name){
        for (int i=0;i<clients.length;i++){
            if(name.equalsIgnoreCase(clients[i].getName())){
                clients[i] = null;
                break;
            }
        }
    }

    /**
     * УДалить клиента по имени питомца
     * @param petName кличка питомца
     */
    public void deleteClientByPetName(String petName){
        for (int i=0;i<clients.length;i++){
            if(petName.equalsIgnoreCase(clients[i].getPet().getName())){
                clients[i] = null;
                break;
            }
        }
    }
    /**
    *Поиск клиента по кличке питомца
    *@param name кличка питомца
    */
    public Client findClientByPetName(final String name){
        Client client = null;
        for (int i = 0;i<clients.length;i++){
            if(clients[i]!=null && name.equalsIgnoreCase(clients[i].getPet().getName()))
                client = clients[i];
        }
        return client;
    }

    /**
    *Поиск клиента по имени
     */
    public Client findClientByName(final String name){
        if (name.length()==0) throw new IllegalArgumentException("Некорректное имя");
        Client client = null;
        for (int i = 0;i<clients.length;i++){
            if(clients[i]!=null && name.equalsIgnoreCase(clients[i].getName()))
                client = clients[i];
        }
        return client;
    }

    /**
     * Изменить имя клиента
     */
    public void  renameClient(){
        String oldName = this.inputClientName();
        Client client = this.findClientByName(oldName);
        if (client == null) throw new NullPointerException("Client not found");
        System.out.println("Input new name");
        String newName = scanner.next();
        if (newName.length()==0) throw new IllegalArgumentException("Name must have t least one character!");
        client.rename(newName);
    }

    /**
     * Переименовать питомца
     */
    public void renamePet(){
        String oldPetName = this.inputPetName();
        Client client = this.findClientByPetName(oldPetName);
        if (client == null) throw new NullPointerException("Pet not found");
        System.out.println("Input new name");
        String newName = scanner.next();
        if (newName.length()==0) throw new IllegalArgumentException("Name must have t least one character!");
        client.getPet().setNamePet(newName);
    }

    public boolean isFull(){
        for(int i = 0; i<clients.length; i++){
            if (clients[i] == null) return false;
        }
        return true;
    }

    /**
     * Запрос имени пользователя
     * @return Возвращает имя пользователя
     */
    public String inputClientName(){
        System.out.println("Input client name");
        return scanner.next();
    }
    public String inputPetName(){
        System.out.println("Input pet name");
        return scanner.next();
    }
    /**
     * Обработка запросов клиента
     * @param choiceNumber выбор клиента
     */
    public void choice(int choiceNumber) {
        Scanner scanner = new Scanner(System.in);
        String name, petName;
        Client client;
        int kind;
        switch (choiceNumber){
            case 1:
                //TODO добавить клиента
                name = this.inputClientName();
                System.out.println("Select a kind of pet: 1)Dog     2)Cat");
                kind = scanner.nextInt();
                petName = this.inputPetName();
                if(kind==1)this.addClient(new Client(name,new Dog(petName)));
                else if(kind==2) this.addClient(new Client(name, new Cat(petName)));
                else throw new IllegalArgumentException();
                break;
            case 2:
                //TODO   Client's pet
                name = this.inputClientName();
                client = this.findClientByName(name);
                System.out.printf("Client %s has a %s named %s", client.getName(), client.getPet().getClass(),client.getPet().getName());
                break;
            case 3:
                //TODO Find by pet's name
                petName = this.inputPetName();
                client = this.findClientByPetName(petName);
                System.out.println(client);
                break;
            case 4:
                //TODO Find by client's name
                name = this.inputClientName();
                client = this.findClientByName(name);
                System.out.println(client);
                break;
            case 5:
                //TODO Edit client name
                this.renameClient();
                break;
            case 6:
                //TODO Edit pet name
                this.renamePet();
                break;
            case 7:
                //TODO  Delete client by name
                name = inputClientName();
                this.deleteClientByHisName(name);
                break;
            case 8:
                //TODO Delete client by pet name
                petName = inputPetName();
                this.deleteClientByPetName(petName);
                break;
            case 9:
                //TODO isFullClinic?
                if(isFull())  System.out.println("Clinic is full");
                else System.out.println("Clinic is not full");
                break;
            default:throw new IllegalArgumentException("Input numbers from 1 to 9!");
        }
    }
}
