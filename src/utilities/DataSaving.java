package utilities;

import dataClass.Faculty;

import java.io.*;
import java.util.ArrayList;

public class DataSaving {
  public static final String savingPath = "./data.bin";
  
  public static boolean serialize(String pathToFile , ArrayList<Faculty> personsList) {
    File personSerialized = new File(pathToFile);
    FileOutputStream fileOutputStream = null;
    ObjectOutputStream objectOutputStream = null;
    boolean success = false;
    try{
      fileOutputStream = new FileOutputStream(personSerialized);
      objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(personsList);
      success = true;
    } catch (Exception exception){
      success = false;
    }
    return success;
  }
  
  public static ArrayList<Faculty> deserialize(String pathToSerializedFile) {
    File fileToRead = new File(pathToSerializedFile);
    FileOutputStream fileOutputStream = null;
    ObjectOutputStream objectOutputStream = null;
    ArrayList<Faculty> person = null;
    try {
      FileInputStream fileInputStream = new FileInputStream(fileToRead);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      person = (ArrayList<Faculty>) objectInputStream.readObject();
    } catch (IOException | ClassNotFoundException deserializationException) {
      System.err.println(deserializationException.getMessage());
    }
    return person;
  }
}
