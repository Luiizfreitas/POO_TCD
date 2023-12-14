package br.edu.ifnmg.poo.trabalhos.datapersistence.role;

import br.edu.ifnmg.poo.trabalhos.datapersistence.entity.Entity;
import br.edu.ifnmg.poo.trabalhos.datapersistence.repository.ConnectionDao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 *
 */
public class Role extends Entity {

    private String name;

    public Role() {
    }

    public Role(Long id, String name) throws Exception {
        setId(id);
        setName(name);
        createRole();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.length() > 20) {
            throw new Exception("O nome deve ter no máximo 150 caracteres e não pode ser nulo.");
        }
        this.name = name;
    }

    private void createRole() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionDao().conectaBD();

            // Verificar se a regra já existe com o mesmo nome
            String checkIfExistsSQL = "SELECT id FROM role WHERE name = ?";
            pstmt = conn.prepareStatement(checkIfExistsSQL);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            if (rs.next()) { // Se existe, obtemos o ID existente e definimos no objeto Role
                long existingId = rs.getLong("id");
                setId(existingId);  // Define o id existente no objeto Role
            } else { // Se não existe, realiza a inserção
                String insertSQL = "INSERT INTO role (name) VALUES (?)";
                pstmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, name);
                pstmt.executeUpdate();

                // Obtenção do id gerado
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    long generatedId = rs.getLong(1);
                    setId(generatedId);  // Define o id gerado no objeto Role
                }
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao criar/receber regra: " + erro.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro 4001: " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return ">> Role encontrado: {"
                + "id=" + getId()
                + ", name=" + name + '}';
    }

}
