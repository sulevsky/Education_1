package com.courses.io_8.serializationgamesaving;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by VSulevskiy on 17.07.2015.
 */
public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        CharacterType elf = new CharacterType("elf","blue");
//        CharacterType ork = new CharacterType("ork","green");

        //save
//        GameCharacter firstPlayer =
//                new GameCharacter(100,"Legolas", elf,new String[]{"sword", "bow"});
//        GameCharacter secondPlayer =
//                new GameCharacter(85,"Ork", ork, new String[]{"hands", "axe"});

//        FileOutputStream out = new FileOutputStream("save.dat");
//        ObjectOutputStream objectOutputStream =  new ObjectOutputStream(out);
//
//        objectOutputStream.writeObject(firstPlayer);
//        objectOutputStream.writeObject(secondPlayer);
//
//        objectOutputStream.close();

        //restore
//        GameCharacter restoredFirstPlayer = null;
//        GameCharacter restoredSecondPlayer = null;
//
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("save.dat"));
//        restoredFirstPlayer = (GameCharacter) objectInputStream.readObject();
//        System.out.println(restoredFirstPlayer);
//        restoredSecondPlayer = (GameCharacter) objectInputStream.readObject();
//        System.out.println(restoredSecondPlayer);
//        objectInputStream.close();
        String verysimple = "very";
        String simple = "secret";
        String stronger = "goodforyou";
        String strongest = "$urHacker!1";

        System.out.println("Custom MD5:");
        System.out.println(App.md5Custom(verysimple));
        System.out.println(App.md5Custom(simple));
        System.out.println(App.md5Custom(stronger));
        System.out.println(App.md5Custom(strongest));

    }
    public static String md5Custom(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            // ��� ����� ���������� ������
            // ��������� ��� ���� � ������������ �������� � getInstance(,,,) �� ����������
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }
}
