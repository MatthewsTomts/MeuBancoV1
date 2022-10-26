package meubanco.controllers;

import java.sql.SQLException;
import java.util.List;
import meubanco.models.beans.Conta;
import meubanco.models.daos.DaoConta;

/**
 *
 * @author scar
 */
public class ControllerConta {
    static DaoConta daoConta;
    
    public Conta inserir (Conta conta) throws SQLException, ClassNotFoundException {
        daoConta = new DaoConta(); 
        return daoConta.inserir(conta);
    }
    
    public Conta alterar (Conta conta) throws SQLException, ClassNotFoundException {
        daoConta = new DaoConta(); 
        return daoConta.alterar(conta);
    }
    
    public List<Conta> listar () throws SQLException, ClassNotFoundException {
        daoConta = new DaoConta(); 
        return daoConta.listar();
    }
    
    public Conta excluir(Conta conta) throws SQLException, ClassNotFoundException {
        daoConta = new DaoConta(); 
        return daoConta.excluir(conta);
    }
    
    public Conta buscar(Conta conta) throws SQLException, ClassNotFoundException {
        daoConta = new DaoConta(); 
        return daoConta.buscar(conta);
    }
    
}
