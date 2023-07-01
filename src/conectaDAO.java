
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {

    private String url = "jdbc:mysql://localhost:3306/leiloes"; //Nome da base de dados
    private String user = "root"; //nome do usuário do MySQL
    private String password = "z5abg0ty";
    Connection conn = null;

    public Connection connectDB() {

        try {

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com sucesso");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }   

}
