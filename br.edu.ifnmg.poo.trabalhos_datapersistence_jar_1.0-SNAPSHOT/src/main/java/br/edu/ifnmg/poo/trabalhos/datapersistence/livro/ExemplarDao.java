/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.poo.trabalhos.datapersistence.livro;

import static br.edu.ifnmg.poo.trabalhos.datapersistence.livro.LivroDao.TABLE;
import br.edu.ifnmg.poo.trabalhos.datapersistence.repository.ConnectionDao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.repository.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class ExemplarDao extends Dao<Exemplar>{
    
    public static final String TABLE = "exemplar";
    @Override
    public String getSaveStatement() {
        return "insert into " + TABLE + "(livro_id, status) values (?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update " + TABLE + " set livro_id = ?, set status = ? where id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "select * from " + TABLE + " where id = ?"; 
    }

    @Override
    public String getFindAllStatement() {
        return "select * from " + TABLE; 
    }

    @Override
    public String getDeleteStatement() {
        return "Delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Exemplar e) {
        
        try {
            if (e.getId() != null && e.getId() < 0) {
                // Inserir um novo Exemplar
                               
               pstmt.setLong(1, e.getLivro().getId());
               pstmt.setBoolean(2, e.isStatus());             
                
                                
                
            } else {
                
               pstmt.setLong(1, e.getLivro().getId());
               pstmt.setBoolean(2, e.isStatus()); 
               pstmt.setLong(0, e.getId());
               
            }

        } catch (SQLException ex) {
            System.out.println("( ! ) ExemplarDao-composeSaveOrStatement-Exception: " + ex);
        }
        
    }

    @Override
    public Exemplar extractObject(ResultSet rs) {
        Exemplar exemplar = new Exemplar();

        try {
            exemplar.setId(rs.getLong("id"));
            exemplar.setLivro_id(rs.getLong("livro_id"));
            exemplar.setStatus(rs.getBoolean("status"));
            
            exemplar.setLivro(new LivroDao().findById(exemplar.getLivro_id()));
            

        } catch (Exception e) {
            System.out.println("ExemplarDAO - extractObject-Exception: " + e);

        }
        
        return exemplar;
    }
    
    
   
    
}
