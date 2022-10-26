package meubanco.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import meubanco.controllers.ControllerCliente;
import meubanco.models.beans.Cliente;

/**
 *
 * @author scar
 */
public class ManterCliente {
    
    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar " ;
        
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1 -> inserir();
            case 2 -> alterar();
            case 3 -> buscar();
            case 4 -> excluir();
            case 5 -> listar();
            default -> System.out.println("Opcao inválido");
        }
    }
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        String rg = JOptionPane.showInputDialog("RG");
        String cpf = JOptionPane.showInputDialog("CPF");
        String email = JOptionPane.showInputDialog("EMAIL");
        String telefone = JOptionPane.showInputDialog("TELEFONE");
        
        Cliente clien = new Cliente(nome, rg, cpf, email, telefone);
        ControllerCliente contclien = new ControllerCliente();
        clien = contclien.inserir(clien);
        JOptionPane.showMessageDialog(null, clien.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String rg = JOptionPane.showInputDialog("RG");
        String cpf = JOptionPane.showInputDialog("CPF");
        String email = JOptionPane.showInputDialog("EMAIL");
        String telefone = JOptionPane.showInputDialog("TELEFONE");
        
        Cliente clien = new Cliente(id, nome, rg, cpf, email, telefone);
        ControllerCliente contclien = new ControllerCliente();
        clien = contclien.alterar(clien);
        JOptionPane.showMessageDialog(null,clien.toString());
    }
    
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        
        Cliente clien = new Cliente(id);
        ControllerCliente contclien = new ControllerCliente();
        clien = contclien.buscar(clien);
        JOptionPane.showMessageDialog(null, clien.toString());
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        
        Cliente clien = new Cliente(id);
        ControllerCliente contclien = new ControllerCliente();
        clien = contclien.excluir(clien);
        JOptionPane.showMessageDialog(null, clien.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String lista = "";
        ControllerCliente contclien = new ControllerCliente();
        List<Cliente> listaClien = contclien.listar();
        for (Cliente clienSaida : listaClien) {
            lista = lista + clienSaida.toString() + '\n';
        }
        JOptionPane.showMessageDialog(null,lista);
    }
}
