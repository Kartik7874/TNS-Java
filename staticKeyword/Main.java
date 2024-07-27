package staticKeyword;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Kartik", 21);
        Student s2 = new Student("Malay", 24);
        Student s3 = new Student("Jay", 23);

        System.out.println(Student.getTotalStudent());
    }
}
