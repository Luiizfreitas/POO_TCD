package br.edu.ifnmg.poo.trabalhos.datapersistence.graphicInterface;

import br.edu.ifnmg.poo.trabalhos.datapersistence.graphicInterface.Bibliotecario.BuscarLivro;
import br.edu.ifnmg.poo.trabalhos.datapersistence.graphicInterface.Bibliotecario.CadastrarLivro;
import br.edu.ifnmg.poo.trabalhos.datapersistence.graphicInterface.telaAdmin.TelaCadastrarUsuario;
import br.edu.ifnmg.poo.trabalhos.datapersistence.graphicInterface.telaMeuPerfil.telaDadosPessoais;
import br.edu.ifnmg.poo.trabalhos.datapersistence.repository.ConnectionDao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.role.Role;
import br.edu.ifnmg.poo.trabalhos.datapersistence.role.RoleDao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.User;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    
    
    private static String nomeUser; 
    private static User userLogado; 
    
    
    
    public MenuPrincipal(User userLogado) throws Exception {
        
        initComponents();
        
        //Inicia a janela maximizada
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //Impede de ser Maximizado
        setResizable(false);
        
        this.userLogado = userLogado;
                
        setTitle("Sistema de Gestão Bibliotecário - " + this.userLogado.getName());
        
        Role r = new RoleDao().findById(userLogado.getRole().getId());
        
        
        
        Long id_bibliotecario = 0L, id_adm = 0L, id_leitor = 0L;
        
        try {
            Role bibliotecario = new Role(null, "Bibliotecario");
            Role leitor = new Role(null, "Leitor");
            Role admin = new Role(null, "Administrador");
            
            id_bibliotecario = bibliotecario.getId();
            id_leitor = leitor.getId();
            id_adm = admin.getId();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao criar Roles: " + e);
        }
        

        if(r.getId() == id_bibliotecario){
            // É um bibliotecário
            menuLivros.setVisible(false);
            menuAdministrador.setVisible(false);
            
        }else if(r.getId() == id_leitor){
            // É um leitor
            menuAdministrador.setVisible(false);
            menuBibliotecario.setVisible(false);
        }else if(r.getId() == id_adm){
            // É um adm
        }else{
            JOptionPane.showMessageDialog(rootPane, "Erro ao identificar o poder do usuário ");
        }
        
        
        
        // Adiciona um WindowListener para lidar com o fechamento da janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                retornarParaLogin();
            }
        });
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }
    

    private void retornarParaLogin() {
        Login login = new Login();
        
        login.setLocationRelativeTo(null);
        login.setVisible(true);
  
        dispose(); // Fecha a janela atual (MenuPrincipal)
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        desktopPaneMenuPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuLivros = new javax.swing.JMenu();
        menu_fazerReserva = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuBibliotecario = new javax.swing.JMenu();
        menu_operacoeslivros = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        menu_bibliotecario_relatorio = new javax.swing.JMenu();
        relatorio_leitores1 = new javax.swing.JMenuItem();
        menuAdministrador = new javax.swing.JMenu();
        menu_cadastrarUsuario = new javax.swing.JMenuItem();
        menu_atualizarCadastro = new javax.swing.JMenuItem();
        menu_admin_relatorio = new javax.swing.JMenu();
        relatorio_usuarios = new javax.swing.JMenuItem();
        relatorio_bibliotecarios = new javax.swing.JMenuItem();
        relatorio_leitores = new javax.swing.JMenuItem();
        menuPerfil = new javax.swing.JMenu();
        menuDadosPessoais = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        menuArquivo = new javax.swing.JMenu();
        menu_sair = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        desktopPaneMenuPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        desktopPaneMenuPrincipal.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(desktopPaneMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 810));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));

        menuLivros.setText("Livros");

        menu_fazerReserva.setText("Fazer reserva");
        menu_fazerReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_fazerReservaActionPerformed(evt);
            }
        });
        menuLivros.add(menu_fazerReserva);

        jMenuItem5.setText("Meus empréstimos");
        menuLivros.add(jMenuItem5);

        jMenuBar1.add(menuLivros);

        menuBibliotecario.setText("Bibliotecário");
        menuBibliotecario.setToolTipText("");

        menu_operacoeslivros.setText("Operações em Livros");

        jMenuItem7.setText("Efetuar empréstimo");
        menu_operacoeslivros.add(jMenuItem7);

        jMenuItem8.setText("Buscar livro");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        menu_operacoeslivros.add(jMenuItem8);

        jMenuItem11.setText("Cadastrar um livro");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        menu_operacoeslivros.add(jMenuItem11);

        menuBibliotecario.add(menu_operacoeslivros);

        menu_bibliotecario_relatorio.setText("Relatórios");

        relatorio_leitores1.setText("Lista de Leitores");
        relatorio_leitores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorio_leitores1ActionPerformed(evt);
            }
        });
        menu_bibliotecario_relatorio.add(relatorio_leitores1);

        menuBibliotecario.add(menu_bibliotecario_relatorio);

        jMenuBar1.add(menuBibliotecario);

        menuAdministrador.setText("Administrador");
        menuAdministrador.setToolTipText("");

        menu_cadastrarUsuario.setText("Cadastrar Usuário");
        menu_cadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cadastrarUsuarioActionPerformed(evt);
            }
        });
        menuAdministrador.add(menu_cadastrarUsuario);

        menu_atualizarCadastro.setText("Atualizar Cadastro");
        menuAdministrador.add(menu_atualizarCadastro);

        menu_admin_relatorio.setText("Relatórios");

        relatorio_usuarios.setText("Usuarios");
        relatorio_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorio_usuariosActionPerformed(evt);
            }
        });
        menu_admin_relatorio.add(relatorio_usuarios);

        relatorio_bibliotecarios.setText("Lista de Bibliotecários");
        relatorio_bibliotecarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorio_bibliotecariosActionPerformed(evt);
            }
        });
        menu_admin_relatorio.add(relatorio_bibliotecarios);

        relatorio_leitores.setText("Lista de Leitores");
        relatorio_leitores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorio_leitoresActionPerformed(evt);
            }
        });
        menu_admin_relatorio.add(relatorio_leitores);

        menuAdministrador.add(menu_admin_relatorio);

        jMenuBar1.add(menuAdministrador);

        menuPerfil.setText("Meu perfil");

        menuDadosPessoais.setText("Dados Pessoais");
        menuDadosPessoais.setToolTipText("");
        menuDadosPessoais.setActionCommand("Dados pessoais");
        menuDadosPessoais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDadosPessoaisActionPerformed(evt);
            }
        });
        menuPerfil.add(menuDadosPessoais);

        jMenuItem6.setText("Histórico de empréstimos");
        menuPerfil.add(jMenuItem6);

        jMenuBar1.add(menuPerfil);

        menuArquivo.setText("Arquivo");

        menu_sair.setText("Sair");
        menu_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_sairActionPerformed(evt);
            }
        });
        menuArquivo.add(menu_sair);

        jMenuBar1.add(menuArquivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuDadosPessoaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDadosPessoaisActionPerformed
       telaDadosPessoais telaMeuPerfil = new telaDadosPessoais(userLogado);
       desktopPaneMenuPrincipal.add(telaMeuPerfil);
       
       // Centraliza o JInternalFrame na tela pai (desktopPane)
       Dimension desktopSize = desktopPaneMenuPrincipal.getSize();
       Dimension frameSize = telaMeuPerfil.getSize();
       int x = (desktopSize.width - frameSize.width) / 2;
       int y = (desktopSize.height - frameSize.height) / 2;
            
       telaMeuPerfil.setLocation(x, y);
       
       telaMeuPerfil.setVisible(true);
       
       
       
        
        
    }//GEN-LAST:event_menuDadosPessoaisActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        
        if(CadastrarLivro.getInstance() == null || !CadastrarLivro.getInstance().isVisible()){
            CadastrarLivro cadLivro = CadastrarLivro.getInstance();
            if(cadLivro.getParent() == null){
                desktopPaneMenuPrincipal.add(cadLivro);
            }
            
            // Centraliza o JInternalFrame na tela pai (desktopPane)
            Dimension desktopSize = desktopPaneMenuPrincipal.getSize();
            Dimension frameSize = cadLivro.getSize();
            int x = (desktopSize.width - frameSize.width) / 2;
            int y = (desktopSize.height - frameSize.height) / 2;
            cadLivro.setLocation(x, y);
            
            cadLivro.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(null, "Janela já está aberta");
        }
        
                
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void menu_fazerReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_fazerReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_fazerReservaActionPerformed

    private void menu_cadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cadastrarUsuarioActionPerformed
        
        if (TelaCadastrarUsuario.getInstance() == null || !TelaCadastrarUsuario.getInstance().isVisible()) {
            TelaCadastrarUsuario telaCadUser = TelaCadastrarUsuario.getInstance();
            if (telaCadUser.getParent() == null) {
                desktopPaneMenuPrincipal.add(telaCadUser);
            }
            
            
            // Centraliza o JInternalFrame na tela pai (desktopPane)
            Dimension desktopSize = desktopPaneMenuPrincipal.getSize();
            Dimension frameSize = telaCadUser.getSize();
            int x = (desktopSize.width - frameSize.width) / 2;
            int y = (desktopSize.height - frameSize.height) / 2;
            telaCadUser.setLocation(x, y);
            
            telaCadUser.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Janela já está aberta");
        }
        
    }//GEN-LAST:event_menu_cadastrarUsuarioActionPerformed

    private void menu_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_sairActionPerformed
        retornarParaLogin();
    }//GEN-LAST:event_menu_sairActionPerformed

    private void relatorio_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorio_usuariosActionPerformed
        // TODO add your handling code here:
        String title = "Listagem de Usuários";

        try (InputStream in = getClass().getResourceAsStream("/relatorio_users.jasper")) {
            JasperPrint jasperPrint = JasperFillManager.fillReport(in, null, ConnectionDao.conectaBD());

            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);

            JDialog dialog = new JDialog(this);
            dialog.setContentPane(jasperViewer.getContentPane());
            dialog.setSize(jasperViewer.getSize());
            dialog.setTitle(title);
            dialog.setModal(true);

            // Centralizar o JDialog em relação à tela
            dialog.setLocationRelativeTo(null);

            dialog.setVisible(true);

            // Certifique-se de fechar o JDialog após a visualização do relatório (se necessário).
            // dialog.dispose();

        } catch (IOException | JRException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, "Erro ao gerar relatório", ex);
            // Exiba uma mensagem ao usuário informando sobre o erro.
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        
    }//GEN-LAST:event_relatorio_usuariosActionPerformed

    private void relatorio_leitoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorio_leitoresActionPerformed
        
        String title = "Listagem de Leitores";

        try (InputStream in = getClass().getResourceAsStream("/relatorio_leitores.jasper")) {
            JasperPrint jasperPrint = JasperFillManager.fillReport(in, null, ConnectionDao.conectaBD());

            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);

            JDialog dialog = new JDialog(this);
            dialog.setContentPane(jasperViewer.getContentPane());
            dialog.setSize(jasperViewer.getSize());
            dialog.setTitle(title);
            dialog.setModal(true);

            // Centralizar o JDialog em relação à tela
            dialog.setLocationRelativeTo(null);

            dialog.setVisible(true);

            // Certifique-se de fechar o JDialog após a visualização do relatório (se necessário).
            // dialog.dispose();

        } catch (IOException | JRException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, "Erro ao gerar relatório", ex);
            // Exiba uma mensagem ao usuário informando sobre o erro.
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_relatorio_leitoresActionPerformed

    private void relatorio_bibliotecariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorio_bibliotecariosActionPerformed
        String title = "Listagem de Bibliotecários";

        try (InputStream in = getClass().getResourceAsStream("/relatorio_bibliotecarios.jasper")) {
            
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("Parameter1", userLogado.getName()); // Substitua "seuParametro" pelo nome do parâmetro no seu relatório
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(in, parameters, ConnectionDao.conectaBD());

            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);

            JDialog dialog = new JDialog(this);
            dialog.setContentPane(jasperViewer.getContentPane());
            dialog.setSize(jasperViewer.getSize());
            dialog.setTitle(title);
            dialog.setModal(true);

            // Centralizar o JDialog em relação à tela
            dialog.setLocationRelativeTo(null);

            dialog.setVisible(true);

            // Certifique-se de fechar o JDialog após a visualização do relatório (se necessário).
            // dialog.dispose();

        } catch (IOException | JRException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, "Erro ao gerar relatório", ex);
            // Exiba uma mensagem ao usuário informando sobre o erro.
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relatorio_bibliotecariosActionPerformed

    private void relatorio_leitores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorio_leitores1ActionPerformed
        String title = "Listagem de Leitores";

        try (InputStream in = getClass().getResourceAsStream("/relatorio_leitores.jasper")) {
            JasperPrint jasperPrint = JasperFillManager.fillReport(in, null, ConnectionDao.conectaBD());

            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);

            JDialog dialog = new JDialog(this);
            dialog.setContentPane(jasperViewer.getContentPane());
            dialog.setSize(jasperViewer.getSize());
            dialog.setTitle(title);
            dialog.setModal(true);

            // Centralizar o JDialog em relação à tela
            dialog.setLocationRelativeTo(null);

            dialog.setVisible(true);

            // Certifique-se de fechar o JDialog após a visualização do relatório (se necessário).
            // dialog.dispose();

        } catch (IOException | JRException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, "Erro ao gerar relatório", ex);
            // Exiba uma mensagem ao usuário informando sobre o erro.
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relatorio_leitores1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if (BuscarLivro.getInstance() == null || !BuscarLivro.getInstance().isVisible()) {
            BuscarLivro buscarLivro = BuscarLivro.getInstance();
            if (buscarLivro.getParent() == null) {
                desktopPaneMenuPrincipal.add(buscarLivro);
            }
            
            
            // Centraliza o JInternalFrame na tela pai (desktopPane)
            Dimension desktopSize = desktopPaneMenuPrincipal.getSize();
            Dimension frameSize = buscarLivro.getSize();
            int x = (desktopSize.width - frameSize.width) / 2;
            int y = (desktopSize.height - frameSize.height) / 2;
            buscarLivro.setLocation(x, y);
            
            buscarLivro.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Janela já está aberta");
        }
        
        
        
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuPrincipal(userLogado).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPaneMenuPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuBibliotecario;
    private javax.swing.JMenuItem menuDadosPessoais;
    private javax.swing.JMenu menuLivros;
    private javax.swing.JMenu menuPerfil;
    private javax.swing.JMenu menu_admin_relatorio;
    private javax.swing.JMenuItem menu_atualizarCadastro;
    private javax.swing.JMenu menu_bibliotecario_relatorio;
    private javax.swing.JMenuItem menu_cadastrarUsuario;
    private javax.swing.JMenuItem menu_fazerReserva;
    private javax.swing.JMenu menu_operacoeslivros;
    private javax.swing.JMenuItem menu_sair;
    private javax.swing.JMenuItem relatorio_bibliotecarios;
    private javax.swing.JMenuItem relatorio_leitores;
    private javax.swing.JMenuItem relatorio_leitores1;
    private javax.swing.JMenuItem relatorio_usuarios;
    // End of variables declaration//GEN-END:variables
}
