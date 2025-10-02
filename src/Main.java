import java.awt.*;
import java.util.Scanner;

class Main {
    // метод для створення масиву
    void menu() {
        int  choice = 0;
        while (choice < 1 || choice > 3){
            System.out.println("Дані введені в масив\nВиберіть, що робити далі:" +
                    "1. Вивести список студентів заданого факультету" +
                    "2. Вивести список студентів, які народились після заданого року" +
                    "3. Вивести список навчальної групи");

            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            if (choice == 1) studentsByFaculty();
            if (choice == 2) studentsByYear();
            if (choice == 3) listOfGroup();
            if (choice < 1 || choice > 3) {
                System.out.println("НЕПРАВИЛЬНО ВВЕДЕНЕ ЧИСЛО!!!!!!!!!!!\n Спробуйте ще раз :)");
            }
        }
    }

    void studentsByFaculty() {

    }
    void studentsByYear() {}
    void listOfGroup() {
    }
    void main() {
        Student[]  students = new Student[5];
        students[0] = new Student(1, "Кравчук Анастасія Дмитрівна", "07/09/03",
                "Чернівці, вул. Садова, 12", "+380981112233",
                "Кібербезпека", 2, "KB-23");

        students[1] = new Student(2, "Мельник Артем Владиславович", "19/01/02",
                "Запоріжжя, вул. Перемоги, 44", "+380501234890",
                "Комп’ютерна інженерія", 3, "KE-32");

        students[2] = new Student(3, "Соколенко Ліза Олексіївна", "25/12/04",
                "Полтава, вул. Панаса Мирного, 3", "+380931007654",
                "Філологія (англійська)", 1, "FA-11");

        students[3] = new Student(4, "Данилюк Олександр Ігорович", "03/05/01",
                "Вінниця, вул. Театральна, 9", "+380637778899",
                "Автоматизація та робототехніка", 4, "AR-41");

        students[4] = new Student(5, "Гнатюк Марія Сергіївна", "14/02/02",
                "Ужгород, вул. Легоцького, 21", "+380972225566",
                "Психологія", 2, "PS-21");

        menu();


    }
}