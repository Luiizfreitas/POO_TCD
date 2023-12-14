package br.edu.ifnmg.poo.trabalhos.datapersistence.livro;

import br.edu.ifnmg.poo.trabalhos.datapersistence.entity.Entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class Livro extends Entity {
    
    private String title, authors;
    private Short pages, year;
    private Byte edition; 
    private int qtdExemplares; 
    private int qtdExemplaresDisponiveis;

    public int getQtdExemplaresDisponiveis() {
        return qtdExemplaresDisponiveis;
    }

    public void setQtdExemplaresDisponiveis(int qtdExemplaresDisponiveis) {
        this.qtdExemplaresDisponiveis = qtdExemplaresDisponiveis;
    }
    

    public int getQtdExemplares() {
        return qtdExemplares;
    }

    public void setQtdExemplares(int qtdExemplares) {
        this.qtdExemplares = qtdExemplares;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {
        if (title != null && title.length() > 150) {
            throw new Exception("O título não pode ter mais de 150 caracteres.");
        }
        this.title = title;
    }
    
    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) throws Exception {
        if (authors != null && authors.length() > 250) {
            throw new Exception("Os autores não podem ter mais de 250 caracteres.");
        }
        this.authors = authors;
    }

    public Short getPages() {
        return pages;
    }

    public void setPages(Short pages) {
        this.pages = pages;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public Byte getEdition() {
        return edition;
    }

    public void setEdition(Byte edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Livro{" + "title=" + title + ", authors=" + authors + ", pages=" + pages + ", year=" + year + ", edition=" + edition + ", qtdExemplares=" + qtdExemplares + ", qtdExemplaresDisponiveis=" + qtdExemplaresDisponiveis + '}';
    }

    
    
    
    
    
    
}
