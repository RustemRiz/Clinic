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
    private void addClient(final Client client){
        for (int i=0;i<clients.length;i++){
            if(clients[i]==null) {this.clients[i] = client;break;}
        }
    }
    /*
    *Удалить клиента по его имени (регистр не учитывается)
     */
    private void deleteClientByHisName(String name){
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
    private void deleteClientByPetName(String petName){
        for (int i=0;i<clients.length;i++){
            if(petName.equalsIgnoreCase(clients[i].getPet().getName())){
                clients[i] = null;
                break;
            }
        }
    }
    /*
    *Поиск клиента по кличке питомца
    * @param name кличка питомца
    */
    private Client findClientsByPetName(final String name){
        Client client = null;
        for (int i = 0;i<clients.length;i++){
            if(name.equalsIgnoreCase(clients[i].getPet().getName()))
                client = clients[i];
        }
        return client;
    }

    /*
    *Поиск клиента по имени
     */
    private Client findClientByName(final String name){
        if (name.length()==0) throw new IllegalArgumentException("Некорректное имя");
        Client client = null;
        for (int i = 0;i<clients.length;i++){
            if(name.equalsIgnoreCase(clients[i].getName()))
                client = clients[i];
        }
        return client;
    }

    /**
     * Изменить имя клиента
     * @param oldName Старое имя
     * @param newName Новое имя
     */
    public void  renameClient(String oldName, String newName){
        for (int i = 0;i<clients.length;i++){
            if (oldName.equalsIgnoreCase(clients[i].getName())) {
                clients[i].rename(newName);
            }
        }
    }

    /**
     * Запрос имени пользователя
     * @return Возвращает имя пользователя
     */
    private String inputClientName(){
        System.out.println("Input client name");
        return scanner.next();
    }
    private String inputPetName(){
        System.out.println("Input pet name");
        return scanner.next();
    }
    /**
     * Обработка запросов клиента
     * @param choiceNumber выбор клиента
     */
    public void choice(int choiceNumber) {
        Scanner scanner = new Scanner(System.in);
        String name, petName, newName;
        Client client;
        int kind;
        switch (choiceNumber){
            case 1:
                //TODO добавить клиента
                name = this.inputClientName();
                System.out.println("Select a kind of pet: 1)Dog     2)Cat");
                kind = scanner.nextInt();
                petName = this.inputPetName();
                if(kind==1)this.addClient(new Client(name,new Dog(name)));
                else if(kind==2) this.addClient(new Client(name, new Cat(name)));
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
                client = this.findClientsByPetName(petName);
                break;
            case 4:
                //TODO Find by client's name
                name = this.inputClientName();
                client = this.findClientByName(name);
                break;
            case 5:
                //TODO Edit client name
                name = this.inputClientName();
                client = this.findClientByName(name);
                System.out.println("Input new name");
                newName = scanner.next();
                client.rename(newName);
                break;
            case 6:
                //TODO Edit pet name
                petName = this.inputPetName();
                client = this.findClientsByPetName(petName);
                System.out.println("Input new name");
                newName = scanner.next();
                client.getPet().setNamePet(newName);
                break;
            case 7:
                //TODO  Delete client by name
                name = inputClientName();
                this.deleteClientByHisName(name);
                break;
            case 8:
                //TODO Delete client by pet name
                petName = inputPetName();
                this.deleteClientByHisName(petName);
                break;
            case 9:
                //TODO isFullClinic?
                break;
            default:throw new IllegalArgumentException("Input numbers from 1 to 9!");
        }
    }
}
