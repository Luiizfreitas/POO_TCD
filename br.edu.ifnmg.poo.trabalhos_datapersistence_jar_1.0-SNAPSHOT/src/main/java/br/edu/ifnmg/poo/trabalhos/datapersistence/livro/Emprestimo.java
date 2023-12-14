/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.poo.trabalhos.datapersistence.livro;

import br.edu.ifnmg.poo.trabalhos.datapersistence.entity.Entity;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.User;
import java.time.LocalDate;

/**
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class Emprestimo extends Entity{
    private Long exemplar_id;
    private Long reader_id; 
    
    private User reader;
    private Exemplar exemplar;
    
    
    
    private boolean autorizacao; 
    private boolean statusDevolucao;

    public boolean isStatusDevolucao() {
        return statusDevolucao;
    }

    public User getReader() {
        return reader;
    }

    public void setReader(User reader) {
        this.reader = reader;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
    
    
    
    public void setStatusDevolucao(boolean statusDevolucao) {
        this.statusDevolucao = statusDevolucao;
    }
    
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao; 

    public Long getExemplar_id() {
        return exemplar_id;
    }

    public void setExemplar_id(Long exemplar_id) {
        this.exemplar_id = exemplar_id;
    }

    public Long getReader_id() {
        return reader_id;
    }

    public void setReader_id(Long reader_id) {
        this.reader_id = reader_id;
    }

    public boolean isAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(boolean autorizacao) {
        this.autorizacao = autorizacao;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    
    public void realizarEmprestimo(Exemplar exemplar){
        
    }

    
}
