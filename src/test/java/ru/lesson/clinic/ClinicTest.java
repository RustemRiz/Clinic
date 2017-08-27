package ru.lesson.clinic;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Рустем on 27.08.2017.
 */
public class ClinicTest {


    Pet dog = new Dog("Chappy");
    Pet cat1 = new Cat("Felix");
    Pet dog2 = new Dog("Third");
    Client client = new Client("Rustem",dog);
    Client client1 = new Client("Ruslan",cat1);
    Client client2 = new Client ("Guzel",dog2);
    Clinic clinic = new Clinic(5);

    @Before
    public void setUp() throws Exception {

        clinic.addClient(client);
        clinic.addClient(client1);
        clinic.addClient(client2);
    }


    @Test
    public void addClient() throws Exception {
        Client client3 = new Client("Rob",new Cat ("Murka"));
        clinic.addClient(client3);
        assertEquals(client3, clinic.getClient(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addClientWhenClinicIsFull() throws Exception {
        Client client3 = new Client("Rob",new Cat ("Murka"));
        clinic.addClient(client3);
        clinic.addClient(new Client("Mary", new Dog("Sparky")));
        clinic.addClient(new Client("Vadim", new Dog("Jacky")));
    }

    @Test
    public void findClientsByPetName() throws Exception {
        Client client3 = clinic.findClientByPetName("felix");
        assertEquals(client3,client1);
    }
    @Test
    public void findClientsByPetNameWhenClientIsNot() throws Exception {
        Client client3 = clinic.findClientByPetName("Verder");
        assertEquals(client3,null);
    }

    @Test
    public void findClientByName() throws Exception {
        Client client3 = clinic.findClientByName("Guzel");
        assertEquals(client3,client2);
    }

    @Test
    public void deleteClientByHisName() throws Exception {
        assertEquals(clinic.findClientByName("Rustem"),client);
        clinic.deleteClientByHisName("Rustem");
        assertEquals(clinic.findClientByName("Rustem"),null);

    }

    @Test
    public void deleteClientByPetName() throws Exception {
        clinic.deleteClientByPetName("Felix");
        assertEquals(clinic.findClientByPetName("Felix"),null);
        assertEquals(clinic.getClient(1),null);
    }

    @Test
    public void getClient() throws Exception {
        assertEquals(clinic.getClient(0),client);
    }

    @Test
    public void renameClient() throws Exception {
        clinic.renameClient("Rustem","Farid");
        assertEquals(clinic.getClient(0).getName(), "Farid");
    }

    @Test
    public void choice() throws Exception {

    }
    @Test
    public void renamePet() throws Exception {
        clinic.renamePet("Felix","Foxy");
        assertEquals(clinic.getClient(1).getPet().getName(), "Foxy");
    }

    @Test
    public void isFullWhenFull() throws Exception {
        clinic.addClient(new Client("Tansily", new Cat("Timmy")));
        clinic.addClient(new Client("Tanya", new Dog("Pitty")));
        assertEquals(clinic.isFull(),true);
    }
    @Test
    public void isFullWhenNotFull() throws Exception {
        assertEquals(clinic.isFull(),false);

    }
}