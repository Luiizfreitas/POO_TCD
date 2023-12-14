/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.poo.trabalhos.datapersistence.livro;

import br.edu.ifnmg.poo.trabalhos.datapersistence.entity.Entity;

/**
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class Exemplar extends Entity{
    private boolean status = false;
    private Long livro_id;
    private Livro livro;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(Long livro_id) {
        this.livro_id = livro_id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    
}
