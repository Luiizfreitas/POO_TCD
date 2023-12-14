/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.poo.trabalhos.datapersistence.livro;

import br.edu.ifnmg.poo.trabalhos.datapersistence.repository.Dao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.User;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.UserDao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class EmprestimoDao extends Dao<Emprestimo>{
    
    
    public static final String TABLE = "emprestimo";
    
    @Override
    public String getSaveStatement() {
        return "insert into " + TABLE + "(exemplar_id, reader_id, autorizacao, dataEmprestimo, dataPrevistaDevolucao, statusDevolucao values (?, ?, ?, ?, ?, ?)";

    }

    @Override
    public String getUpdateStatement() {
        return "update " + TABLE + " set exemplar_id = ?, reader_id = ?, autorizacao = ?, dataEmprestimo = ?, dataPrevistaDevolucao = ?, statusDevolucao = ? where id = ?";
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
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Emprestimo e) {
       try {
            if (e.getId() != null && e.getId() < 0) {
                // Inserir um novo Livro
                
                
                pstmt.setLong(1, e.getExemplar_id());
                pstmt.setLong(2, e.getReader_id());
                pstmt.setBoolean(3, e.isAutorizacao());
                pstmt.setObject(4, e.getDataEmprestimo());
                pstmt.setObject(5, e.getDataDevolucao());
                pstmt.setBoolean(6, e.isStatusDevolucao());
                
                                
                
            } else {
                
                pstmt.setLong(1, e.getExemplar_id());
                pstmt.setLong(2, e.getReader_id());
                pstmt.setBoolean(3, e.isAutorizacao());
                pstmt.setObject(4, e.getDataEmprestimo());
                pstmt.setObject(5, e.getDataDevolucao());
                pstmt.setBoolean(6, e.isStatusDevolucao());
                pstmt.setLong(7, e.getId());
            }

        } catch (SQLException ex) {
            System.out.println("( ! ) Emprestimo-composeSaveOrStatement-Exception: " + ex);
        }
    }

    @Override
    public Emprestimo extractObject(ResultSet rs) {
        Emprestimo emprestimo = new Emprestimo();
        try {
            
            
            emprestimo.setExemplar_id(rs.getLong("exemplar_id"));
            emprestimo.setReader_id(rs.getLong("reader_id"));
            
            
            emprestimo.setExemplar(new ExemplarDao().findById(emprestimo.getExemplar_id()));
            emprestimo.setReader(new UserDao().findById(emprestimo.getReader_id()));
            
            emprestimo.setAutorizacao(rs.getBoolean("autorizacao"));
            emprestimo.setDataDevolucao(rs.getObject("dataPrevistaDevolucao", LocalDate.class));
            emprestimo.setDataEmprestimo(rs.getObject("dataEmprestimo", LocalDate.class));
            
            emprestimo.setStatusDevolucao(rs.getBoolean("statusDevolucao"));
            emprestimo.setId(rs.getLong("id"));
            
            

        } catch (Exception e) {
            System.out.println("EmprestimoDao-extractObject-Exception: " + e);

        }

        return emprestimo;
    }
    
    
    
}
