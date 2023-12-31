/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.edu.ifnmg.poo.trabalhos.datapersistence.graphicInterface.Bibliotecario;

import br.edu.ifnmg.poo.trabalhos.datapersistence.livro.Exemplar;
import br.edu.ifnmg.poo.trabalhos.datapersistence.livro.ExemplarDao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.livro.Livro;
import br.edu.ifnmg.poo.trabalhos.datapersistence.livro.LivroDao;
import javax.swing.JOptionPane;

/**
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class CadastrarLivro extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastrarLivro
     */
    
    private static CadastrarLivro instance; 
    
    public CadastrarLivro() {
        initComponents();
    }
    
    public static CadastrarLivro getInstance(){
        if(instance == null)
            instance = new CadastrarLivro();
        
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAno = new javax.swing.JFormattedTextField();
        txtEdicao = new javax.swing.JFormattedTextField();
        txtExemplares = new javax.swing.JFormattedTextField();
        txtPaginas = new javax.swing.JFormattedTextField();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitulo.setBackground(new java.awt.Color(255, 255, 255));
        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });
        jPanel2.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 393, -1));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Título do livro");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtAutor.setBackground(new java.awt.Color(255, 255, 255));
        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });
        jPanel2.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 393, -1));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Autor do Livro");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Ano de lançamento");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Edição");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 104, -1));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Páginas");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Quantidade de Exemplares");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        txtAno.setBackground(new java.awt.Color(255, 255, 255));
        txtAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0000"))));
        jPanel2.add(txtAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 100, -1));

        txtEdicao.setBackground(new java.awt.Color(255, 255, 255));
        txtEdicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jPanel2.add(txtEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 100, -1));

        txtExemplares.setBackground(new java.awt.Color(255, 255, 255));
        txtExemplares.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jPanel2.add(txtExemplares, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 150, -1));

        txtPaginas.setBackground(new java.awt.Color(255, 255, 255));
        txtPaginas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jPanel2.add(txtPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 100, -1));

        btnLimpar.setBackground(new java.awt.Color(0, 0, 0));
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(0, 0, 0));
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        
        txtAno.setText("");
        txtAutor.setText("");
        txtEdicao.setText("");
        txtExemplares.setText("");
        txtPaginas.setText("");
        txtTitulo.setText("");
        
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        if(txtAno.getText().isEmpty() || txtAno.getText().isEmpty() || txtEdicao.getText().isEmpty() || txtExemplares.getText().isEmpty() || txtPaginas.getText().isEmpty() || txtTitulo.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Todos os campos devem ser preenchidos");
            return;
        }
        
        Livro livro = new Livro();
        
        try {
            livro.setTitle(txtTitulo.getText());
            livro.setAuthors(txtAutor.getText());
            livro.setEdition(Byte.valueOf(txtEdicao.getText()));
            livro.setYear(Short.valueOf(txtAno.getText()));
            livro.setPages(Short.valueOf(txtPaginas.getText()));
            livro.setQtdExemplares(Integer.parseInt(txtExemplares.getText()));
            livro.setQtdExemplaresDisponiveis(livro.getQtdExemplares());
            
            livro.setId(-1L); // Inserir Livro
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao inserir Livro: " + e);
        }
        
        livro.setId(new LivroDao().saveOrUpdate(livro));
        
        Exemplar exemplar = new Exemplar();
        
        for(int i = 0; i < livro.getQtdExemplares(); i++){
            
            exemplar.setLivro(livro);
            exemplar.setLivro_id(livro.getId());
            exemplar.setStatus(false);
            exemplar.setId(-1L);
            
            exemplar.setId(new ExemplarDao().saveOrUpdate(exemplar));
        }
        
        JOptionPane.showMessageDialog(rootPane, "Livro salvo com sucesso!");
        btnLimpar.doClick();
        
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFormattedTextField txtAno;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JFormattedTextField txtEdicao;
    private javax.swing.JFormattedTextField txtExemplares;
    private javax.swing.JFormattedTextField txtPaginas;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
