package meubanco;

import meubanco.views.ManterGerente;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import meubanco.views.ManterCliente;
import meubanco.views.ManterConta;
/**
 *
 * @author scar
 */
public class MeuBanco {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(ManterGerente.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }
    
    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Gerente \n 2 - Cliente \n 3 - Conta \n 4 - Sair";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                ManterGerente.menu();
                break;
            case 2:
                ManterCliente.menu();
                break;
            case 3:
                ManterConta.menu();
                break;
            case 4:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
                break;
            default:
                System.out.println("Opção inválido");
        }
    }
}
