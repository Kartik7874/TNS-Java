import java.util.List;

public class Student {
    private String enrollmentNo;
    private String name;
    private int age;
    private String email;
    private List<String> subjects;

    public Student(String enrollmentNo, String name, int age, String email, List<String> subjects) {
        this.enrollmentNo = enrollmentNo;
        this.name = name;
        this.age = age;
        this.email = email;
        this.subjects = subjects;
    }

    public String getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "enrollmentNo='" + enrollmentNo + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
