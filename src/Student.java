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

    Student(int id, String name_surn_middlen,
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        this.date_of_birth = LocalDate.parse(dateOfBirth, formatter);
        this.address = address;
        this.phone_number = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    // гетери
    public  int getId(int id) {
        return id;
    }
    public String getName(String name_surn_middlen) {
        return name_surn_middlen;
    }
    public LocalDate getDateOfBirth() {
        return date_of_birth;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phone_number;
    }
    public String getFaculty() {
        return faculty;
    }
    public int getCourse() {
        return course;
    }
    public String getGroup() {
        return group;
    }
}


