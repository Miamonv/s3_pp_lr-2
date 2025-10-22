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
            if (choice == 0) ReadFile.closeProgram(students);
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
            else if (choice.equalsIgnoreCase("Ні")) ReadFile.closeProgram(students);;

        } while (!choice.equals("Так") && !choice.equals("так") &&
                !choice.equals("Ні") && !choice.equals("ні"));
    }

    void printAllStudents(ArrayList<Student> students) {
        int counter = 0;
        for (Student student : students) {
            System.out.println(student);
            counter++;
        }
        System.out.print("Виведено " + counter + " студентів\n");

        returnToMenu(students);
    }
    void studentsByFaculty(ArrayList<Student> students) {
        String faculty;
        int check = 0, counter = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть назву факультету:\n");
        faculty = sc.nextLine();
        for (Student stud : students) {
            if (stud == null) break;
            if (faculty.equals(stud.getFaculty())) {
                System.out.println(stud + "\n");
                check = 1;
                counter++;
            }
        }
        if (check == 0) System.out.println("По запиту нічого не знайдено\n");
        System.out.print("Виведено " + counter + " студентів\n");

        returnToMenu(students);
    }

    void studentsByYear(ArrayList<Student> students) {
        int year, check = 0, counter = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть рік, з яким порівнювати (напр. 2005):\n");
        year = sc.nextInt();
        sc.nextLine();
        for (Student stud : students) {
            if (stud == null) break;
            if (year < (stud.getDateOfBirth().getYear())) {
                System.out.println(stud + "\n");
                check = 1;
                counter++;
            }
        }
        if (check == 0) System.out.println("По запиту нічого не знайдено\n");
        System.out.print("Виведено " + counter + " студентів\n");

        returnToMenu(students);
    }
    void listOfGroup(ArrayList<Student> students) {
        String group;
        int check = 0, counter = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть групу для пошуку (напр. ОІ-11):\n");
        group = sc.nextLine();
        for (Student stud : students) {
            if (stud == null) break;
            if (group.equals(stud.getGroup())){
                System.out.println(stud + "\n");
                check = 1;
                counter++;
            }
        }
        if (check == 0) System.out.println("По запиту нічого не знайдено\n");
        System.out.print("Виведено " + counter + " студентів\n");

        returnToMenu(students);
    }
    void  addStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть ПІБ студента: ");
        String name =  sc.nextLine();
        System.out.print("Введіть дату народження (напр. 01/12/2001): ");
        String date = sc.nextLine();
        System.out.print("Введіть місто проживання: ");
        String address = sc.nextLine();
        System.out.print("Введіть номер телефону: ");
        String phone_number = sc.nextLine();
        System.out.print("Введіть факультет: ");
        String faculty = sc.nextLine();

        int course;
        while (true) {
            System.out.print("Введіть номер курсу(магістратура 1 курс - 5 і тд): ");
            try {
                course = Integer.parseInt(sc.nextLine());
                if (course > 0 && course <= 7) {
                    break;
                } else {
                    System.out.println("Некоректний курс. Курс має бути числом від 1 до 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некоректний ввід. Введіть ціле число.");
            }
        }

        String expectedGroupStart = String.valueOf(course);
        while (true) {
            System.out.print("Введіть групу (напр. ОІ-11): ");
            String group = sc.nextLine().trim();

            String[] parts = group.split("-");
            String numberOfGroupStart = parts[1].substring(0, 1);

            if (expectedGroupStart.equals(numberOfGroupStart)) {
                int newId = students.get(students.size() - 1).getId() + 1;
                students.add(new Student(newId, name, date, address, phone_number, faculty, course, group));
                this.returnToMenu(students);
                return;
            } else {
                System.out.println("Група не відповідає курсу\n");
            }
        }
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