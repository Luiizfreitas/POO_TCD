package br.edu.ifnmg.poo.trabalhos.datapersistence.user;

import br.edu.ifnmg.poo.trabalhos.datapersistence.credential.Credential;
import br.edu.ifnmg.poo.trabalhos.datapersistence.entity.Entity;
import br.edu.ifnmg.poo.trabalhos.datapersistence.role.Role;
import java.time.LocalDate;

/**
 *
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class User extends Entity {

    private String name;
    private String email;
    private LocalDate birthdate;
    private Credential credential;
    private Role role;

    public User() {
    }

    public User(Long id, String name, String email, LocalDate birthdate, Credential credential, Role role) throws Exception {
        setId(id);
        setName(name);
        setEmail(email);
        setBirthdate(birthdate);
        setCredential(credential);
        setRole(role);
    }

    public User(String name, String email, LocalDate birthdate) throws Exception {
        setName(name);
        setEmail(email);
        setBirthdate(birthdate);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.length() > 150) {
            throw new Exception("O nome deve ter no máximo 150 caracteres e não pode ser nulo.");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (email == null || email.length() > 255) {
            throw new Exception("O Email deve ter no máximo 150 caracteres e não pode ser nulo.");
        }
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) throws Exception {
        if (birthdate == null) {
            throw new Exception("A data não pode ser nula.");
        }
        this.birthdate = birthdate;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    @Override
    public String toString() {
        return ">> Usuário encontrado: {"
                + "id=" + getId()
                + ", name=" + name
                + ", email=" + email
                + ", birthdate=" + birthdate
                + ", role_id=" + role.getId()
                + '}';
    }

}
