package main;
import model.ReadFile;
import model.Student;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
    void menu(ArrayList<Student> students) {
        int  choice = -1;
        while (choice < 0 || choice > 6){
            System.out.println("Дані введені в масив\nВиберіть, що робити далі:\n\n" +
                    "0. Вийти з програми\n" +
                    "1. Вивести список студентів\n" +
                    "2. Вивести список студентів заданого факультету\n" +
                    "3. Вивести список студентів, які народились після заданого року\n" +
                    "4. Вивести список навчальної групи\n" +
                    "5. Додати запис\n" +
                    "6. Видалити запис\n");


            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            if (choice == 1) printAllStudents(students);
            if (choice == 2) studentsByFaculty(students);
            if (choice == 3) studentsByYear(students);
            if (choice == 4) listOfGroup(students);
            if (choice == 5) addStudent(students);
            if (choice == 6) deleteStudent(students);
            if (choice == 0) return;
            if (choice < 0 || choice > 6) {
                System.out.println("НЕПРАВИЛЬНО ВВЕДЕНЕ ЧИСЛО!!!!!!!!!!!\n Спробуйте ще раз :)");
            }
        }
    }

    void returnToMenu(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Повернутися до меню? (Так/ні)\n");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Так")) {
                menu(students);
                break;
            }
            else if (choice.equalsIgnoreCase("Ні")) return;

        } while (!choice.equals("Так") && !choice.equals("так") &&
                !choice.equals("Ні") && !choice.equals("ні"));
    }

    void printAllStudents(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }

        returnToMenu(students);
    }
    void studentsByFaculty(ArrayList<Student> students) {
        String faculty;
        int check = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть назву факультету:\n");
        faculty = sc.nextLine();
        for (Student stud : students) {
            if (stud == null) break;
            if (faculty.equals(stud.getFaculty())) {
                System.out.println(stud + "\n");
                check = 1;
            }
        }
        if (check == 0) System.out.println("По запиту нічого не знайдено\n");

        returnToMenu(students);
    }

    void studentsByYear(ArrayList<Student> students) {
        int year, check = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть рік, з яким порівнювати (напр. 2005):\n");
        year = sc.nextInt();
        sc.nextLine();
        for (Student stud : students) {
            if (stud == null) break;
            if (year < (stud.getDateOfBirth().getYear())) {
                System.out.println(stud + "\n");
                check = 1;
            }
        }
        if (check == 0) System.out.println("По запиту нічого не знайдено\n");

        returnToMenu(students);
    }
    void listOfGroup(ArrayList<Student> students) {
        String group;
        int check = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть групу для пошуку (напр. ОІ-11):\n");
        group = sc.nextLine();
        for (Student stud : students) {
            if (stud == null) break;
            if (group.equals(stud.getGroup())){
                System.out.println(stud + "\n");
                check = 1;
            }
        }
        if (check == 0) System.out.println("По запиту нічого не знайдено\n");

        returnToMenu(students);
    }
    void  addStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть ПІБ студента: ");
        String name =  sc.nextLine();
        System.out.print("Введіть дату народження: ");
        String date = sc.nextLine();
        System.out.print("Введіть місто проживання: ");
        String address = sc.nextLine();
        System.out.print("Введіть номер телефону: ");
        String phone_number = sc.nextLine();
        System.out.print("Введіть факультет: ");
        String faculty = sc.nextLine();
        System.out.print("Введіть номер курсу: ");
        int course = Integer.parseInt(sc.nextLine());
        System.out.print("Введіть групу (напр. ОІ-11): ");
        String group = sc.nextLine();

        int newId = students.get(students.size() - 1).getId() + 1;
        students.add(new Student(newId, name, date, address, phone_number, faculty, course, group));

        returnToMenu(students);
    }

    void deleteStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть ID студента, якого хочете видалити: ");
        int id = sc.nextInt();

        boolean found = false;  //чи знайдено студента з таким ID
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                found = true;
                System.out.println("Студента видалено");
                break;
            }
        }

        if (!found) {
            System.out.println("Студента з таким ID не знайдено");
        }
        returnToMenu(students);
    }

    void main() {
        ArrayList<Student> students = ReadFile.read();
        menu(students);
    }
}