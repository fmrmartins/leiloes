
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public int cadastrarProduto(ProdutosDTO produto) {
        int status;
        conn = new conectaDAO().connectDB();
        try {
            prep = conn.prepareStatement("INSERT INTO produtos(nome, valor, status) VALUES(?,?,?)");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            
            status = prep.executeUpdate();            
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());            
            return ex.getErrorCode();            
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        String sql = "select * from produtos";
        conn = new conectaDAO().connectDB();

        try {
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();
            while (resultset.next()) {
                ProdutosDTO pd = new ProdutosDTO();
                pd.setId(resultset.getInt("id"));
                pd.setNome(resultset.getString("nome"));
                pd.setValor(resultset.getInt("valor"));
                pd.setStatus(resultset.getString("status"));
                listagem.add(pd);
            }            
            return listagem;           
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            return null;            
        }
        
    }

}
