package br.edu.ifnmg.poo.trabalhos.datapersistence.credential;

import br.edu.ifnmg.poo.trabalhos.datapersistence.entity.Entity;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

/**
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class Credential extends Entity {

    private String username;
    private String password;
    private LocalDate lastAcess;
    private boolean enabled = true;
    private User user;

    public Credential() {
    }

    public Credential(String username, String password, LocalDate lastAcess, boolean enabled, User user) throws Exception {
        setUsername(username);
        setPassword(password);
        setLastAcess(lastAcess);
        setEnabled(enabled);
        setUser(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws Exception {
        if (username == null || username.length() > 15) {
            throw new Exception("O username deve possuir no máximo 15 caracteres e não pode ser nulo.");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        if (password == null || password.length() > 32) {
            throw new Exception("A senha deve possuir no máximo 32 caracteres e não pode ser nula.");
        }
        this.password = password;
    }

    public LocalDate getLastAcess() {
        return lastAcess;
    }

    public void setLastAcess(LocalDate lastAcess) {
        this.lastAcess = lastAcess;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return ">> Credencial encontrada: {"
                + "id=" + getId()
                + ", username=" + username
                + ", password=" + password
                + ", lastAcess=" + lastAcess
                + ", enabled=" + enabled
                + '}';
    }

}
