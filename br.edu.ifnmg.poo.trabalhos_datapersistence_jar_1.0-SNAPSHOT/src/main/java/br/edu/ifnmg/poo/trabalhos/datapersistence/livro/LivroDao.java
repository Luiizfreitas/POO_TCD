/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.poo.trabalhos.datapersistence.livro;

import br.edu.ifnmg.poo.trabalhos.datapersistence.repository.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class LivroDao extends Dao<Livro>{
    
    public static final String TABLE = "livro";
    @Override
    public String getSaveStatement() {
        return "insert into " + TABLE + "(title, authors, page, year, edition, qtdExemplares, qtdExemplaresDisponiveis) values (?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update " + TABLE + " set title = ?, authors = ?, page = ?, year = ?, edition = ?, qtdExemplares = ?, qtdExemplaresDisponiveis = ? where id = ?";
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
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Livro e) {
       try {
            if (e.getId() != null && e.getId() < 0) {
                // Inserir um novo Livro
                // title, authors, page, year, edition) values (?, ?, ?, ?, ?)
                
                pstmt.setString(1, e.getTitle());
                pstmt.setString(2, e.getAuthors());
                pstmt.setShort(3, e.getPages());
                pstmt.setShort(4, e.getYear());
                pstmt.setByte(5, e.getEdition());
                pstmt.setInt(6, e.getQtdExemplares());
                pstmt.setInt(7, e.getQtdExemplaresDisponiveis());
                                
                
            } else {
                
                //title = ?, authors = ?, page = ?, year = ?, edition = ? where id = ?";
                pstmt.setString(1, e.getTitle());
                pstmt.setString(2, e.getAuthors());
                pstmt.setShort(3, e.getPages());
                pstmt.setShort(4, e.getYear());
                pstmt.setByte(5, e.getEdition());
                pstmt.setInt(6, e.getQtdExemplares());
                pstmt.setInt(7, e.getQtdExemplaresDisponiveis());
                pstmt.setLong(8, e.getId());
            }

        } catch (SQLException ex) {
            System.out.println("( ! ) composeSaveOrStatement-Exception: " + ex);
        }
    }

    @Override
    public Livro extractObject(ResultSet rs) {
        Livro livro = new Livro();
        
        try {
            livro.setId(rs.getLong("id"));
            livro.setTitle(rs.getString("title"));
            livro.setAuthors(rs.getString("authors"));
            livro.setPages(rs.getShort("page"));
            livro.setYear(rs.getShort("year"));
            livro.setEdition(rs.getByte("edition"));
            livro.setQtdExemplares(rs.getInt("qtdExemplares"));
            livro.setQtdExemplaresDisponiveis(rs.getInt("qtdExemplaresDisponiveis"));
            
        } catch (Exception e) {
            System.out.println("extractObject-Exception: " + e);

        }
        
        return livro;   
    }
    
    
}
