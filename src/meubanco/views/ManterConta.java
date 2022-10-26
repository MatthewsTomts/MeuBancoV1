package meubanco.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import meubanco.controllers.ControllerConta;
import meubanco.models.beans.Conta;

/**
 *
 * @author scar
 */
public class ManterConta {

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
        int idGerente = Integer.parseInt(JOptionPane.showInputDialog("ID DO GERENTE"));
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("ID DO CLIENTE"));
        float valor = Float.parseFloat(JOptionPane.showInputDialog("VALOR"));
        String tipo = JOptionPane.showInputDialog("TIPO");
        
        Conta conta = new Conta(idGerente, idCliente, valor, tipo);
        ControllerConta contclien = new ControllerConta();
        conta = contclien.inserir(conta);
        JOptionPane.showMessageDialog(null, conta.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idGerente = Integer.parseInt(JOptionPane.showInputDialog("ID DO GERENTE"));
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("ID DO CLIENTE"));
        float valor = Float.parseFloat(JOptionPane.showInputDialog("VALOR"));
        String tipo = JOptionPane.showInputDialog("TIPO");
        
        Conta conta = new Conta(id, idGerente, idCliente, valor, tipo);
        ControllerConta contclien = new ControllerConta();
        conta = contclien.alterar(conta);
        JOptionPane.showMessageDialog(null,conta.toString());
    }
    
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        
        Conta conta = new Conta(id);
        ControllerConta contclien = new ControllerConta();
        conta = contclien.buscar(conta);
        JOptionPane.showMessageDialog(null, conta.toString());
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        
        Conta conta = new Conta(id);
        ControllerConta contclien = new ControllerConta();
        conta = contclien.excluir(conta);
        JOptionPane.showMessageDialog(null, conta.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String lista = "";
        ControllerConta contconta = new ControllerConta();
        List<Conta> listaConta = contconta.listar();
        for (Conta contaSaida : listaConta) {
            lista = lista + contaSaida.toString() + '\n';
        }
        JOptionPane.showMessageDialog(null,lista);
    }
}
