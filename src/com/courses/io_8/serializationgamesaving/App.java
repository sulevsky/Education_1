package com.courses.io_8.serializationgamesaving;

import java.io.*;

/**
 * Created by VSulevskiy on 17.07.2015.
 */
public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CharacterType elf = new CharacterType("elf","blue");
        CharacterType ork = new CharacterType("ork","green");

        //save
        GameCharacter firstPlayer =
                new GameCharacter(100,"Legolas", elf,new String[]{"sword", "bow"});
        GameCharacter secondPlayer =
                new GameCharacter(85,"Ork", ork, new String[]{"hands", "axe"});

        FileOutputStream out = new FileOutputStream("save.dat");
        ObjectOutputStream objectOutputStream =  new ObjectOutputStream(out);

        objectOutputStream.writeObject(firstPlayer);
        objectOutputStream.writeObject(secondPlayer);

        objectOutputStream.close();

        //restore
        GameCharacter restoredFirstPlayer = null;
        GameCharacter restoredSecondPlayer = null;

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("save.dat"));
        restoredFirstPlayer = (GameCharacter) objectInputStream.readObject();
        System.out.println(restoredFirstPlayer);
        restoredSecondPlayer = (GameCharacter) objectInputStream.readObject();
        System.out.println(restoredSecondPlayer);
        objectInputStream.close();

    }
}
