package main;
import model.Student;
import java.util.Scanner;

class Main {
    Student[]  createArray(){
        Student[]  students = new Student[8];
        students[0] = new Student(1, "Кравчук Анастасія Дмитрівна", "07/09/2006",
                "Чернівці, вул. Садова, 12", "+380981112233",
                "Кібербезпека", 2, "КБ-23");

        students[1] = new Student(2, "Мельник Артем Владиславович", "19/01/2005",
                "Запоріжжя, вул. Перемоги, 44", "+380501234890",
                "Комп’ютерна інженерія", 3, "КІ-32");

        students[2] = new Student(3, "Соколенко Ліза Олексіївна", "25/12/2008",
                "Полтава, вул. Панаса Мирного, 3", "+380931007654",
                "Філологія (англійська)", 1, "ФА-11");

        students[3] = new Student(4, "Данилюк Олександр Ігорович", "03/05/2007",
                "Вінниця, вул. Театральна, 9", "+380637778899",
                "Обчислювальний інтелект смартсистем", 2, "ОІ-21");

        students[4] = new Student(5, "Гнатюк Марія Сергіївна", "14/02/2007",
                "Ужгород, вул. Легоцького, 21", "+380972225566",
                "Психологія", 2, "ПС-21");

        students[5] = new Student(6, "Петренко Ігор Сергійович", "10/05/2004",
                "Одеса, пр. Шевченка, 5", "+380509876543",
                "Кібербезпека", 2, "КБ-23");

        students[6] = new Student(7, "Захарчук Анна Олегівна", "01/01/2003",
                "Київ, вул. Героїв, 15", "+380961239876",
                "Обчислювальний інтелект смартсистем", 3, "ОІ-31");

        students[7] = new Student(8, "Іваненко Петро Миколайович", "22/07/2005",
                "Львів, вул. Городоцька, 7", "+380678881122",
                "Обчислювальний інтелект смартсистем", 1, "ОІ-12");

        return students;
    }

    void menu(Student[]  students) {
        int  choice = 0;
        while (choice < 1 || choice > 3){
            System.out.println("Дані введені в масив\nВиберіть, що робити далі:\n\n" +
                    "1. Вивести список студентів заданого факультету\n" +
                    "2. Вивести список студентів, які народились після заданого року\n" +
                    "3. Вивести список навчальної групи\n");

            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            if (choice == 1) studentsByFaculty(students);
            if (choice == 2) studentsByYear(students);
            if (choice == 3) listOfGroup(students);
            if (choice < 1 || choice > 3) {
                System.out.println("НЕПРАВИЛЬНО ВВЕДЕНЕ ЧИСЛО!!!!!!!!!!!\n Спробуйте ще раз :)");
            }
        }
    }
    void studentsByFaculty(Student[]  students) {
        String faculty;
        int check = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть назву факультету:\n");
        faculty = sc.nextLine();
        for (Student stud : students) {
            if (faculty.equals(stud.getFaculty())){
                System.out.println(stud + "\n");
                check = 1;
            }
        }
        if (check == 0) System.out.println("По запиту нічого не знайдено\n");

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
    void studentsByYear(Student[]  students) {
        int year, check = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть рік, з яким порівнювати (напр. 2005):\n");
        year = sc.nextInt();
        sc.nextLine();
        for (Student stud : students) {
            if (year < (stud.getDateOfBirth().getYear())) {
                System.out.println(stud + "\n");
                check = 1;
            }
        }
        if (check == 0) System.out.println("По запиту нічого не знайдено\n");

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
    void listOfGroup(Student[]  students) {
        String group;
        int check = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть групу для пошуку (напр. ОІ-11):\n");
        group = sc.nextLine();
        for (Student stud : students) {
            if (group.equals(stud.getGroup())){
                System.out.println(stud + "\n");
                check = 1;
            }
        }
        if (check == 0) System.out.println("По запиту нічого не знайдено\n");

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
    void main() {
        Student[] students = createArray();
        menu(students);
    }
}