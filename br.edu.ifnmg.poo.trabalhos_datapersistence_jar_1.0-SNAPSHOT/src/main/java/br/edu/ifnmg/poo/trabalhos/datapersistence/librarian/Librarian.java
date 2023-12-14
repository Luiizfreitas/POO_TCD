package br.edu.ifnmg.poo.trabalhos.datapersistence.librarian;

import br.edu.ifnmg.poo.trabalhos.datapersistence.credential.Credential;
import br.edu.ifnmg.poo.trabalhos.datapersistence.role.Role;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.User;
import java.time.LocalDate;

/**
 *
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class Librarian extends User {

    public Librarian() {
    }

    public Librarian(Long id, User user) throws Exception {
        super(user.getName(), user.getEmail(), user.getBirthdate());
        setId(id);
    }

    @Override
    public String toString() {
        return ">> Bibliotecário encontrado: {"
                + "id=" + getId()
                + ", name=" + getName()
                + ", email=" + getEmail()
                + ", birthdate=" + getBirthdate()
                + '}';
    }

}
