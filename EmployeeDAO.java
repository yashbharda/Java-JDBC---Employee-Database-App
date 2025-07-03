import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection conn;

    public EmployeeDAO(){
        conn=DBConnection.getConnection();
    }

    public void addEmployee(Employee e){
        String sql="insert into employees(name,email,salary) values(?,?,?)";
        try(PreparedStatement ps=conn.prepareStatement(sql)) {

            ps.setString(1,e.getName());
            ps.setString(2,e.getEmail());
            ps.setDouble(3,e.getSalary());
            ps.executeUpdate();
            System.out.println("Employee added successfully");

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Employee> getAllEmployee(){
        List<Employee> list=new ArrayList<>();
        String sql="select * from employees";
        try(Statement st=conn.createStatement(); ResultSet rs=st.executeQuery(sql)){

            while (rs.next()){
                Employee e=new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("salary")
                );
                list.add(e);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void updateEmployee(Employee e){
        String sql="update employees set name=?, email=?, salary=? where id = ?";
        try(PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1,e.getName());
            ps.setString(2,e.getEmail());
            ps.setDouble(3,e.getSalary());
            ps.setInt(4,e.getId());
            ps.executeUpdate();
            System.out.println("Employee updated successfully");

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void deleteEmployee(int id){
        String sql="delete from employees where id=?";
        try(PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Employee deleted successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
