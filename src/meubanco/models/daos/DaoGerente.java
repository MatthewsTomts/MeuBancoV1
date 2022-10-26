package meubanco.models.daos;

import meubanco.models.beans.Gerente;
import meubanco.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author scar
 */
public class DaoGerente {
    private final Connection con;

    public DaoGerente() throws SQLException, ClassNotFoundException {
        this.con = new Conexao().getConnection();
    }
    
    public Gerente validar(Gerente geren) throws SQLException {
        String sql = "select * from Gerente WHERE login = ? AND senha = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);

        stmt.setString(1,geren.getLogin());
        stmt.setString(2,geren.getSenha());

        ResultSet rs = stmt.executeQuery();

        Gerente gerenSaida = null;
        while (rs.next()) {      
            gerenSaida = new Gerente(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
        }
        stmt.close();
        return gerenSaida; 
    }
    
    public Gerente inserir(Gerente geren) throws SQLException{
        String sql = "insert into Gerente" + " values (default,?,?, ?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,geren.getNome());
        stmt.setString(2,geren.getLogin());
        stmt.setString(3,geren.getSenha());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            geren.setId(id);
        }
        stmt.close();
        return geren;
    }
    
    public Gerente alterar(Gerente geren) throws SQLException{
        String sql = "UPDATE Gerente SET nome = ?, login = ?, senha = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,geren.getNome());
        stmt.setString(2,geren.getLogin());
        stmt.setString(3,geren.getSenha());
        stmt.setInt(4,geren.getId());

        // executa
        stmt.execute();
        stmt.close();
        return geren;
    }
    
    public Gerente excluir(Gerente geren) throws SQLException{
        String sql = "DELETE FROM Gerente WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = con.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,geren.getId());
        // executa
        stmt.execute();
        stmt.close();
        con.close();
        return geren;
    }
    
    public Gerente buscar(Gerente gerenEnt) throws SQLException{
        String sql = "SELECT * FROM Gerente WHERE id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1, gerenEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Gerente gerenSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                gerenSaida = new Gerente(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return gerenSaida;
   }

   public List<Gerente> listar() throws SQLException{
        // usus: array armazena a lista de registros

        List<Gerente> gerens = new ArrayList<>();
        
        String sql = "SELECT * FROM Gerente";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        // seta os valores
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Gerente geren = new Gerente(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            gerens.add(geren);
        }
        
        rs.close();
        stmt.close();
        return gerens;
   }
}
