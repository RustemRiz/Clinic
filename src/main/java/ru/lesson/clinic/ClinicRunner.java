package ru.lesson.clinic;

/**
 * Работа клиники
 * Created by Рустем on 24.08.2017.
 */
public class ClinicRunner {
    public static void main(String[] args){
        Clinic clinic = new Clinic(10);
        clinic.addClient(0, new Client("Brown",new Cat("Digy")));
        clinic.addClient(1, new Client("Nick",new Dog("Sparky")));
        clinic.addClient(2, new Client("Ann",new Cat("Tom")));

    }
}
