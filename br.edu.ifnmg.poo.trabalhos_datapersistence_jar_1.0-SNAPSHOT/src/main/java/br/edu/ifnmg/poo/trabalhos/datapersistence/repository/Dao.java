package br.edu.ifnmg.poo.trabalhos.datapersistence.repository;

import br.edu.ifnmg.poo.trabalhos.datapersistence.entity.Entity;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.User;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.UserDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
public abstract class Dao<E> implements IDao<E> {

    public static final String DB = "alphasystem";

    @Override
    public ArrayList<E> extractObjects(ResultSet resultSet) {
        ArrayList<E> list = new ArrayList<>();

        try {
            while (resultSet.next()) {
                E object = extractObject(resultSet);
                list.add(object);
            }
        } catch (Exception ex) {
            System.out.println(">> " + ex);
        }

        return list;
    }

    @Override
    public Long saveOrUpdate(E e) {

        // Primary key
        Long id = 0L;

        if (((Entity) e).getId() == null || ((Entity) e).getId() <= 0) {

            try (PreparedStatement preparedStatement = ConnectionDao.conectaBD().
                    prepareStatement(getSaveStatement(), Statement.RETURN_GENERATED_KEYS)) {

//                System.out.println(">>> CHEGOU NO IF DE SAVE!!!");
                composeSaveOrUpdateStatement(preparedStatement, e);

                System.out.println(">> SQL: " + preparedStatement);

                preparedStatement.executeUpdate();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {
                    id = resultSet.getLong(1);
                }

            } catch (Exception ex) {
                System.out.println(">> " + ex);
            }

        } else {
            // Update existing record
            try (PreparedStatement preparedStatement = ConnectionDao.conectaBD().prepareStatement(getUpdateStatement())) {

//                System.out.println(">>> CHEGOU NO ELSE DE UPDATE!!!");
                // Assemble the SQL statement with the data (->?)
                composeSaveOrUpdateStatement(preparedStatement, e);

                // Show the full sentence
                System.out.println(">> SQL: " + preparedStatement);

                // Performs the update on the database
                preparedStatement.executeUpdate();

                // Keep the primary key
                id = ((Entity) e).getId();

            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
        return id;
    }

    @Override
    public E findById(Long id) {
        try (PreparedStatement preparedStatement = ConnectionDao.conectaBD().prepareStatement(getFindByIdStatement())) {

            preparedStatement.setLong(1, id);

            System.out.println(">> SQL: " + preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return extractObject(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    }

    @Override
    public List<E> findAll() {
        try (PreparedStatement preparedStatement = ConnectionDao.conectaBD().prepareStatement(getFindAllStatement())) {

            System.out.println(">> SQL: " + preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            return extractObjects(resultSet);

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    }

    @Override
    public void delete(Long id) {

        try (PreparedStatement preparedStatement = ConnectionDao.conectaBD().prepareStatement(getDeleteStatement())) {
            // Set the ID of the entity to be deleted in the DELETE statement
            preparedStatement.setLong(1, id);

            System.out.println(">> SQL: " + preparedStatement);

            // Execute the DELETE statement
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

}
