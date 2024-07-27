import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentDAO studentDAO = new StudentDAO();

    public void addStudent(Student student){
        try {
            studentDAO.insertStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getStudentByErNo(String erNo){
        try {
            return studentDAO.selectStudent(erNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getAllStudent(){
        try {
            return studentDAO.selectAllStudent();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateStudent(Student student){
        try {
            return studentDAO.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteStudent(String erNo){
        try {
            return studentDAO.deleteStudent(erNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
