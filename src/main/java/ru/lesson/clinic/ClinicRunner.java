package ru.lesson.clinic;

import java.util.Scanner;

/**
 * Работа клиники
 * Created by Рустем on 24.08.2017.
 */
public class ClinicRunner {
    public static void main(String[] args){
        Clinic clinic = new Clinic(10);
        String salutation = "Select operation number: 1)Add client   2)Get client's pet  3)Find by pet name\n" +
                "4)Find be client name  5)Edit client name 6)Edit pet name 7)Delete client by name\n" +
                "8)Delete client by pet name 9)Check availability   For exit input exit";
        System.out.println(salutation);
        Scanner scanner = new Scanner(System.in);
        String choiceNumber = scanner.next();
        while(!choiceNumber.equalsIgnoreCase("exit")) {
            try {
                int i = Integer.parseInt(choiceNumber);
                clinic.choice(i);
            } catch (NumberFormatException e) {
                System.out.println("Input number from 1 to 9 for select operation");
            }finally {
                choiceNumber = scanner.next();
            }
        }
        scanner.close();
    }
}
