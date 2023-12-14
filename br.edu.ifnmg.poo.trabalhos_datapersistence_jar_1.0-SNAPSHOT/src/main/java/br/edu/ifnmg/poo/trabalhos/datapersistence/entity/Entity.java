package br.edu.ifnmg.poo.trabalhos.datapersistence.entity;

/**
 *
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public abstract class Entity {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
