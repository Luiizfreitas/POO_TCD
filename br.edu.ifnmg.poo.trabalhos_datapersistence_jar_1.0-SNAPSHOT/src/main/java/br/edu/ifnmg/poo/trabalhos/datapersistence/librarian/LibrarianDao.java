package br.edu.ifnmg.poo.trabalhos.datapersistence.librarian;

import br.edu.ifnmg.poo.trabalhos.datapersistence.repository.Dao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.UserDao;
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
public class LibrarianDao extends Dao<Librarian> {

    public static final String TABLE = "librarian";

    @Override
    public String getSaveStatement() {
        return "insert into " + TABLE + "(id, name, email, birthdate) values(?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatement() {
        return "update " + TABLE + " set name = ?, email = ?, birthdate = ? where id = ?";
    }

    @Override
    public String getFindByIdStatement() {
        return "select id, name, email, birthdate" + " from librarian where id = ?";
    }

    @Override
    public String getFindAllStatement() {
        return "select id, name, email, birthdate" + " from librarian";
    }

    @Override
    public String getDeleteStatement() {
        return "Delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Librarian e) {
        try {

            if (e.getId() != null && e.getId() < 0) {
                pstmt.setLong(1, -e.getId()); //o "id" de credential é reaproveitado aqui
                pstmt.setString(2, e.getName());
                pstmt.setString(3, e.getEmail());
                pstmt.setObject(4, e.getBirthdate(), Types.DATE);
            } else {
                pstmt.setString(1, e.getName());
                pstmt.setString(2, e.getEmail());
                pstmt.setObject(3, e.getBirthdate(), Types.DATE);
                pstmt.setLong(4, e.getId()); //o "id" de credential é reaproveitado aqui
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Librarian extractObject(ResultSet resultSet) {

        Librarian librarian = null;

        try {
            librarian = new Librarian();
            librarian.setId(resultSet.getLong("id"));
            librarian.setName(resultSet.getString("name"));
            librarian.setEmail(resultSet.getString("email"));
            librarian.setBirthdate(resultSet.getObject("birthdate", LocalDate.class));

        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return librarian;

    }

}
