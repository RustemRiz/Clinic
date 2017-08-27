package ru.lesson.clinic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Рустем on 27.08.2017.
 */
public class ClientTest {
    Dog dog = new Dog("Chappy");
    Client client = new Client("Rustem",dog);

    @Test
    public void getName() throws Exception {
        Assert.assertEquals("Rustem", client.getName());
    }

    @Test
    public void rename() throws Exception {
        client.rename("Ruslan");
        Assert.assertEquals("Ruslan",client.getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void renameWhenInputEmpty() throws Exception {
        client.rename("");
    }

    @Test
    public void getPet() throws Exception {
        Assert.assertEquals(client.getPet(),dog);
    }


}