package meubanco.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import meubanco.models.beans.Conta;
import meubanco.utils.Conexao;

/**
 *
 * @author scar
 */
public class DaoConta {
    private final Connection con;

    public DaoConta() throws SQLException, ClassNotFoundException {
        this.con = new Conexao().getConnection();
    }
    
    public Conta inserir(Conta conta) throws SQLException{
        String sql = "insert into Conta" + " values (?, ?, default, ?, ?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, conta.getIdCliente());
        stmt.setInt(2, conta.getIdGerente());
        stmt.setFloat(3, conta.getValor());
        stmt.setString(4, conta.getTipo());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            conta.setId(id);
        }
        stmt.close();
        return conta;
    }
    
    public Conta alterar(Conta conta) throws SQLException{
        String sql = "UPDATE Conta SET idCliente = ?, idGerente = ?, valor = ?, tipo = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, conta.getIdCliente());
        stmt.setInt(2, conta.getIdGerente());
        stmt.setFloat(3, conta.getValor());
        stmt.setString(4, conta.getTipo());
        stmt.setInt(5, conta.getId());

        // executa
        stmt.execute();
        stmt.close();
        return conta;
    }
    
    public Conta excluir(Conta conta) throws SQLException{
        String sql = "DELETE FROM Conta WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, conta.getId());
        // executa
        stmt.execute();
        stmt.close();
        con.close();
        return conta;
    }
    
    public Conta buscar(Conta contaEnt) throws SQLException{
        String sql = "SELECT * FROM Conta WHERE id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, contaEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Conta contaSaida = null;
            while (rs.next()) {
            // criando o objeto Usuario
                contaSaida = new Conta(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getFloat(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return contaSaida;
   }

   public List<Conta> listar() throws SQLException{
        // usus: array armazena a lista de registros

        List<Conta> contas = new ArrayList<>();
        
        String sql = "SELECT * FROM Conta";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        // seta os valores
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Conta conta = new Conta(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getFloat(4),
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            contas.add(conta);
        }
        
        rs.close();
        stmt.close();
        return contas;
   }
}
