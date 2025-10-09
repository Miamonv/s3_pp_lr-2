package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadFile {
    public static ArrayList<Student> read() {
        ArrayList<Student> students = new ArrayList<>();
        File myObj = new File("list of students.txt");

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] parts = line.split(",\\s*");

                int ID = Integer.parseInt(parts[0]);
                String name = parts[1];
                String date_of_birth = parts[2];
                String address = parts[3];
                String phone_number = parts[4];
                String faculty = parts[5];
                int course = Integer.parseInt(parts[6]);
                String group = parts[7];

                students.add(new Student(ID, name, date_of_birth, address,
                        phone_number, faculty, course, group));
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return students;
    }
}
