package br.edu.ifnmg.poo.trabalhos.datapersistence.user;

import br.edu.ifnmg.poo.trabalhos.datapersistence.credential.Credential;
import br.edu.ifnmg.poo.trabalhos.datapersistence.credential.CredentialDao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.repository.Dao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.role.Role;
import br.edu.ifnmg.poo.trabalhos.datapersistence.role.RoleDao;
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
 *
 */
public class UserDao extends Dao<User> {

    public static final String TABLE = "users";

    @Override
    public String getSaveStatement() {
        return "insert into " + TABLE + "(id, name, email, birthdate, role_id) values(?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update " + TABLE + " set name = ?, email = ?, birthdate = ?, role_id = ? where id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "select id, name, email, birthdate, role_id" + " from users where id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "select id, name, email, birthdate, role_id" + " from users";
    }

    @Override
    public String getDeleteStatement() {
        return "Delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, User e) {
        try {

            if (e.getId() != null && e.getId() < 0) {
                pstmt.setLong(1, e.getCredential().getId()); //o "id" de credential é reaproveitado aqui
                pstmt.setString(2, e.getName());
                pstmt.setString(3, e.getEmail());
                pstmt.setObject(4, e.getBirthdate(), Types.DATE);
                pstmt.setObject(5, e.getRole().getId());
            } else {
                pstmt.setString(1, e.getName());
                pstmt.setString(2, e.getEmail());
                pstmt.setObject(3, e.getBirthdate(), Types.DATE);
                pstmt.setObject(4, e.getRole().getId());
                pstmt.setLong(5, e.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public User extractObject(ResultSet resultSet) {

        User user = null;

        try {
            user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setBirthdate(resultSet.getObject("birthdate", LocalDate.class));
            Role role = new RoleDao().findById(resultSet.getLong("role_id"));
            user.setRole(role);
            Credential cred = new CredentialDao().findById(resultSet.getLong("id"));
            user.setCredential(cred);
//            user.getRole().setId(resultSet.getLong("role_id"));

        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

}
