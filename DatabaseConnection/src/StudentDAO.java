import java.security.spec.RSAOtherPrimeInfo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String INSERT_STUDENT_QUERY =
            "INSERT INTO students (enrollment_no, name, age, email, subjects) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_STUDENT_BY_ERNO = "SELECT * FROM students WHERE enrollment_no = ?";
    private static final String SELECT_ALL_STUDENT = "SELECT * FROM students";
    private static final String UPDATE_STUDENT =
            "UPDATE students SET name=?, age=?, email=?, subjects=? WHERE enrollment_no = ?";
    private static final String DELETE_STUDENT = "DELETE FROM students WHERE enrollment_no = ?";

    public void insertStudent(Student student) throws SQLException {
        try (Connection conn = Conn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_STUDENT_QUERY)) {
            stmt.setString(1, student.getEnrollmentNo());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getAge());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, String.join(", ", student.getSubjects()));
            stmt.executeUpdate();
        }
    }

    //update
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdated;
        try (Connection conn = Conn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_STUDENT)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, String.join(", ", student.getSubjects()));
            stmt.setString(5, student.getEnrollmentNo());
            rowUpdated =  stmt.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    //delete
    public boolean deleteStudent(String enrollmentNo) throws SQLException {
        boolean rowDeleted;
        try (Connection conn = Conn.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DELETE_STUDENT)) {
            preparedStatement.setString(1, enrollmentNo);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    //select
    public Student selectStudent(String enrollmentNo) throws SQLException {
        Student student  = null;
        try (Connection conn = Conn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_STUDENT_BY_ERNO)) {
            stmt.setString(1, enrollmentNo);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String subjects = rs.getString("subjects");

                student = new Student(enrollmentNo, name, age, email, List.of(subjects.split(", ")));
            }
        }
        return student;
    }

    //selectAll
    public List<Student> selectAllStudent() throws SQLException {
        List<Student> students  = new ArrayList<>();
        try (Connection conn = Conn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_STUDENT)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String enrollmentNo = rs.getString("enrollment_no");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String subjects = rs.getString("subjects");

                students.add(new Student(enrollmentNo, name, age, email, List.of(subjects.split(", "))));
            }
        }
        return students;
    }
}
