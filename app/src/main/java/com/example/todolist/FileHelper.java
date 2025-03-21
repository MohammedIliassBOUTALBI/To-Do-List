package com.example.todolist;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHelper {
    //i'll write saving code in this class
    public static final String FILENAME = "listinfo.dat";

    //write the data to the file, save a list to this method,//write data into a file(data writing method)
    public static void writeData(ArrayList<String> item, Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);/*create a
             file in the device memory and open it,MODE_PRIVATE = i can reach this file from everywhere else
             inside of the app but other apps will not be able to reach this file*/
            ObjectOutputStream oas = new ObjectOutputStream(fos);//open the file that i created
            oas.writeObject(item);//"item" will be written into the file
            oas.close();//close the file is obligatory
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //read the file(data reading method)
    public static ArrayList<String> readData(Context context) {
        ArrayList<String> itemList = null;

        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemList = (ArrayList<String>) ois.readObject();
        } catch (FileNotFoundException e) {

            itemList = new ArrayList<>();

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return itemList;
    }

}
