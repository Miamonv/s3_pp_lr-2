package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private int id;
    private String name_surn_middlen;
    private LocalDate date_of_birth;
    private String address;
    private String phone_number;
    private String faculty;
    private int course;
    private String group;

    public Student(int id, String name_surn_middlen,
            String date_of_birth, String address, String phone_number,
            String faculty, int course, String group) {

        setInfo(id, name_surn_middlen, date_of_birth, address,
                phone_number, faculty, course, group);

    }
    //сетер
    private void setInfo(int id, String nameSurnMiddlen, String dateOfBirth,
                         String address, String phoneNumber, String faculty,
                         int course, String group) {
        this.id = id;
        this.name_surn_middlen = nameSurnMiddlen;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.date_of_birth = LocalDate.parse(dateOfBirth, formatter);
        this.address = address;
        this.phone_number = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    @Override
    public String toString() {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = date_of_birth.format(outputFormatter);

        return  "\n -- Студент № " + id + "--" +
                "\n ПІБ:" + name_surn_middlen +
                "\n Факультет:" + faculty +
                "\n Курс:" + course +
                "\n Група:" + group +
                "\n Дата народження:" + formattedDate +
                "\n Адреса:" + address +
                "\n Номер телефону:" + phone_number;

    }

    // гетери
    public  int getId() {
        return this.id;
    }
    public String getName() {
        return this.name_surn_middlen;
    }
    public LocalDate getDateOfBirth() {
        return this.date_of_birth;
    }
    public String getAddress() {
        return this.address;
    }
    public String getPhoneNumber() {
        return this.phone_number;
    }
    public String getFaculty() {
        return this.faculty;
    }
    public int getCourse() {
        return this.course;
    }
    public String getGroup() {
        return this.group;
    }
}


