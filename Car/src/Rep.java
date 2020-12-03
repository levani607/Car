import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Rep {

    private final Connection myConn;
    private final Statement myStatement;
    public Rep() throws Exception{
        Class.forName("org.h2.Driver");
        myConn = DriverManager.getConnection ("jdbc:h2:tcp://localhost/~/test", "sa","123");
        System.out.println("daukavshirda");

        myStatement=myConn.createStatement();

    }
    public  void insert() throws Exception{
        String query= "INSERT INTO Car (id,manufacturer,model,price) VALUES ('1','toyota','prius','6000')";

        myStatement.executeUpdate(query);
        System.out.println("მონაცემები ჩაიწერა");
    }
    public void update() throws Exception{
        String query = " UPDATE Car SET price='5000' WHERE id=1";

        myStatement.executeUpdate(query);
        System.out.println("Succsess");
    }
    public void  select() throws Exception{

        ResultSet myResultSet = myStatement.executeQuery("select * from Car");


        while (myResultSet.next()) {
            System.out.println(myResultSet.getString("id") + " " + myResultSet.getString("manufacturer") + " "+ myResultSet.getString("model") +" "+ myResultSet.getString("price") );
        }
    }
    public void delete() throws Exception{
        String query = "DELETE FROM Car WHERE model='prius'";

        int deletedRows=myStatement.executeUpdate(query);  //
        System.out.println("deleted : "+deletedRows+" Row");
        System.out.println("Succsess");
    }



}
