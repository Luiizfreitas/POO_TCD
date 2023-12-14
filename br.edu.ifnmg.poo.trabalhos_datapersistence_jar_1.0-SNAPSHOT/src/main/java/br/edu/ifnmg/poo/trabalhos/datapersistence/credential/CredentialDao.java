package br.edu.ifnmg.poo.trabalhos.datapersistence.credential;

import br.edu.ifnmg.poo.trabalhos.datapersistence.repository.Dao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.User;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.UserDao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class CredentialDao extends Dao<Credential> {

    public static final String TABLE = "credential";
    private static String SALT = "!asdf";

    @Override
    public String getSaveStatement() {
        return "insert into " + TABLE + "(username, password, lastAcess, enabled) values(?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update " + TABLE + " set username = ?, password = ?, lastAcess = ?, enabled = ? where id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "select id, username, password, lastAcess, enabled" + " from credential where id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "select id, username, password, lastAcess, enabled" + " from credential";
    }

    @Override
    public String getDeleteStatement() {
        return "Delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Credential e) {
        try {

            if (e.getUsername() != null) {
                pstmt.setString(1, e.getUsername());
            }
            if (e.getPassword() != null) {
                pstmt.setString(2, crypPass(e.getPassword()));
            }
            if (e.getLastAcess() != null) {
                pstmt.setObject(3, e.getLastAcess(), Types.DATE);
            }
            if ((Boolean) e.isEnabled() != null) {
                pstmt.setObject(4, e.isEnabled());
            }
            if (e.getId() != null) {
                pstmt.setLong(5, e.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(CredentialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Credential extractObject(ResultSet resultSet) {

        Credential credential = new Credential();

        try {
            credential.setId(resultSet.getLong("id"));
            credential.setUsername(resultSet.getString("username"));
            credential.setPassword(resultSet.getString("password"));
            credential.setLastAcess(resultSet.getObject("lastAcess", LocalDate.class));
            credential.setEnabled(resultSet.getObject("enabled", Boolean.class));

        } catch (Exception ex) {
            Logger.getLogger(CredentialDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return credential;
    }

    public User authenticate(Credential credential) {

        UserDao acesso = new UserDao();

        for (User user : acesso.findAll()) {

            //usuário com username e password validados
            if (credential != null
                    && credential.getUsername().equals(user.getCredential().getUsername())
                    && credential.getPassword().equals(user.getCredential().getPassword())) {

                return user; //retorna o usuário autenticado
            }

        }

        //retorna null se não for usuário válido
        return null;
    }

    public String crypPass(String password) {

        String saltedPassword = password + SALT;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedBytes = md.digest(saltedPassword.getBytes());

            // Converte bytes para representação hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Trate a exceção, por exemplo, registrando-a ou lançando-a como RuntimeException
            throw new RuntimeException("Erro ao criar hash MD5", e);
        }
    }

}
