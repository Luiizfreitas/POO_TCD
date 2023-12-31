package br.edu.ifnmg.poo.trabalhos.datapersistence.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 * 
 */
public interface IDao<E> {
    public String getSaveStatement();
    public String getUpdateStatement();
    public String getFindByIdStatement();
    public String getFindAllStatement();
    public String getDeleteStatement();
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, E e);
    public E extractObject(ResultSet rs);
    public List<E> extractObjects(ResultSet rs);
    
    public Long saveOrUpdate(E e);
    public E findById(Long id);
    public List<E> findAll();
    public void delete(Long id);
}
