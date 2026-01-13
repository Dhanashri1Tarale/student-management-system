import java.sql.*;

public class StudentDAOImpl {

    Connection con = DBConnection.getConnection();
    
    public StudentDAOImpl() throws Exception {
        if (con != null) {
            Statement st = con.createStatement();
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS students (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "email VARCHAR(100) NOT NULL," +
                "course VARCHAR(100) NOT NULL," +
                "marks DOUBLE NOT NULL" +
                ")"
            );
        } else {
            throw new Exception("Database connection is null");
        }
    }

    public void addStudent(Student s) throws Exception {
        String query = "INSERT INTO students(name,email,course,marks) VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getCourse());
        ps.setDouble(4, s.getMarks());
        ps.executeUpdate();
        System.out.println("Student Added Successfully");
    }

    public void viewStudents() throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM students");
        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " " +
                rs.getString("name") + " " +
                rs.getString("course")
            );
        }
    }
}
