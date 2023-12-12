package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Main class
public class Main {

    public static void folderCreation(String Folder) {

        File folder = new File(Folder);
        if (folder.mkdir()) {
            System.out.println("Folder created " + folder.getName());
        } else {
            System.out.println("Folder already exists");
            System.out.println("Location is " + folder.getAbsolutePath());
        }

    }

    public static void fileCreation(String Folder, String fileName) {

        try {
            File file = new File(Folder + File.separator + fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());

            } else {
                System.out.println("File already exists");
                System.out.println("Here is location of file " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error........");
            e.printStackTrace();
        }
    }

    public static void fileWrite(String Folder, String FileName) {
        try {
            FileWriter file = new FileWriter(Folder + File.separator + FileName);
            Scanner input = new Scanner(System.in);
            System.out.println("Enter text here:");
            String dataInput = input.nextLine();
            file.write(dataInput);
            file.close();
            System.out.println("File input accepted");
        } catch (IOException e) {
            System.out.println("Error.....");
            e.printStackTrace();
        }
    }

    public static void fileExistingWrite(String Folder, String FileName) {
        try {
            FileWriter file = new FileWriter(Folder + File.separator + FileName, true);
            Scanner input = new Scanner(System.in);
            System.out.println("Enter text here:");
            String dataInput = input.nextLine();
            file.append(dataInput);
            file.close();
            System.out.println("File input accepted");
        } catch (IOException e) {
            System.out.println("Error.....");
            e.printStackTrace();
        }
    }

    public static void fileRead(String Folder, String FileName) {
        try {
            File file = new File(Folder + File.separator + FileName);
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String data = read.nextLine();
                System.out.println(data);
            }
            read.close();
        } catch (IOException e) {
            System.out.println("Error...");
            e.printStackTrace();
        }
    }


    public static void fileDelete(String Folder, String FileName) {
        File file = new File(Folder + File.separator + FileName);
        if (file.delete()) {
            System.out.println("Deleted file: " + file.getName());
        } else {
            System.out.println("Error wrong name");
        }
    }

    public static void folderDelete(String Folder) {
        File file = new File(Folder);
        if (file.delete()) {
            System.out.println("Deleted folder " + file.getName());
        } else {
            System.out.println("Error wrong name");
        }
    }

    // functions available: fileCreation();fileWrite();fileRead();fileDelete();folderDelete;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Already have a folder or file, yes or no?\nDelete option available\n");
        String option = input.nextLine().toLowerCase();
        System.out.println("Enter folder name:");
        String Folder = input.nextLine().toUpperCase();
        System.out.println("Enter file name:");
        String fileName = input.nextLine().toUpperCase();



        while (!option.isEmpty()) {


            if (option.equals("q"))
            {
                break;
            }
            switch (option) {
                case "no":
                    System.out.println("You are creating a file");
                    folderCreation(Folder);
                    fileCreation(Folder, fileName);
                    fileWrite(Folder, fileName);
                    fileRead(Folder, fileName);
                    break;
                case "yes":
                    System.out.println("You're editing the file");
                    fileExistingWrite(Folder, fileName);
                    fileRead(Folder, fileName);
                    break;
                case "delete":
                    System.out.println("You are deleting a folder");
                    fileDelete(Folder, fileName);
                    folderDelete(Folder);
                    break;
                case "q":
                    input.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose yes, no, delete, or 'q' for quit.");
                    break;
            }
            System.out.println("Already have a folder or file, yes or no?\nDelete option available\n");
            option = input.nextLine().toLowerCase();
            if (option.equals("yes") || option.equals("no")) {
                System.out.println("Enter folder name:");
                Folder = input.nextLine().toUpperCase();
                System.out.println("Enter file name:");
                fileName = input.nextLine().toUpperCase();
            }
        }
    }
}