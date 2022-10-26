package meubanco.controllers;

import java.sql.SQLException;
import java.util.List;
import meubanco.models.beans.Gerente;
import meubanco.models.daos.DaoGerente;

/**
 *
 * @author scar
 */
public class ControllerGerente {
    static DaoGerente daoGeren;
    
    public Gerente inserir (Gerente geren) throws SQLException, ClassNotFoundException {
        daoGeren = new DaoGerente(); 
        return daoGeren.inserir(geren);
    }
    
    public Gerente alterar (Gerente geren) throws SQLException, ClassNotFoundException {
        daoGeren = new DaoGerente(); 
        return daoGeren.alterar(geren);
    }
    
    public List<Gerente> listar () throws SQLException, ClassNotFoundException {
        daoGeren = new DaoGerente(); 
        return daoGeren.listar();
    }
    
    public Gerente excluir(Gerente geren) throws SQLException, ClassNotFoundException {
        daoGeren = new DaoGerente(); 
        return daoGeren.excluir(geren);
    }

    public Boolean validar(Gerente gerenEnt) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        daoGeren = new DaoGerente(); 
        Gerente gerenSaida = daoGeren.validar(gerenEnt);
        if(gerenSaida != null) retorno = true;
        return retorno;
    }
    
    public Gerente buscar(Gerente geren) throws SQLException, ClassNotFoundException {
        daoGeren = new DaoGerente(); 
        return daoGeren.buscar(geren);
    }
    
}
