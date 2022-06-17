import java.sql.*;

class DAO
{
    Connection con;
    ResultSet res;
    int rn;
    public DAO() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","toor");

        } catch (Exception e) { e.printStackTrace(); }
    }

    public void insert(int id, String name, int age, int salary, String address) {

        String query = "insert into data values(" +id+ ",'" + name + "'," +age + "," + salary  + ",'" + address + "')";
        Statement stm = null;
        int result = 0;
        try {
            stm = con.createStatement();
            result = stm.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(result == 1) System.out.println("successfully added");
            else System.out.println("failed to add");
        }

    }

    public void getData() throws SQLException {
        Statement stm = con.createStatement();
        res=stm.executeQuery("select * from data");
        System.out.println("ID\t\tNAME\t\tAGE\t\tSalary\t\tAddress");
        while(res.next())
        {
            System.out.print(res.getString(1)+"\t\t");
            System.out.print(res.getString(2)+"\t\t");
            System.out.print(res.getInt(3)+"\t\t");
            System.out.print(res.getInt(4)+"\t\t");
            System.out.println(res.getString(5)+"\t\t");
        }

    }

    public void delete(int id1){
            try {
//                res.next();
//            int rn= res.getRow();
            Statement stm = con.createStatement();
            String query = "delete * from data where id="+id1;
            stm.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            System.out.println("Successfully deleted");
        }
    }


    public static void main(String... a) throws SQLException {
        DAO db = new DAO();
        db.getData();

    }
}

