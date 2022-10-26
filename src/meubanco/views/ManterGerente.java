package meubanco.views;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import meubanco.controllers.ControllerGerente;
import meubanco.models.beans.Gerente;

/**
 *
 * @author scar
 */
public class ManterGerente {
    
    public static boolean validar() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        
        Gerente gerenEnt = new Gerente(login, senha);
        ControllerGerente contgeren = new ControllerGerente();
        return contgeren.validar(gerenEnt);
    }
    
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
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        
        Gerente geren = new Gerente(nome, login, senha);
        ControllerGerente contgeren = new ControllerGerente();
        geren = contgeren.inserir(geren);
        JOptionPane.showMessageDialog(null,geren.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        
        Gerente geren = new Gerente(id, nome, login, senha);
        ControllerGerente contgeren = new ControllerGerente();
        geren = contgeren.alterar(geren);
        JOptionPane.showMessageDialog(null,geren.toString());
    }
    
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        
        Gerente geren = new Gerente(id);
        ControllerGerente contgeren = new ControllerGerente();
        geren = contgeren.buscar(geren);
        JOptionPane.showMessageDialog(null,geren.toString());
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        
        Gerente geren = new Gerente(id);
        ControllerGerente contgeren = new ControllerGerente();
        geren = contgeren.excluir(geren);
        JOptionPane.showMessageDialog(null,geren.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        String lista = "";
        ControllerGerente contgeren = new ControllerGerente();
        List<Gerente> listaGeren = contgeren.listar();
        for (Gerente gerenSaida : listaGeren) {
            lista = lista + gerenSaida.toString() + '\n';
        }
        JOptionPane.showMessageDialog(null,lista);
    }
}
