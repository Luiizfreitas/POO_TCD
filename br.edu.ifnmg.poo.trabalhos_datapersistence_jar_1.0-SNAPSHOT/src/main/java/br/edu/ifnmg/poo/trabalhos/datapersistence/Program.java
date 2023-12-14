package br.edu.ifnmg.poo.trabalhos.datapersistence;

import br.edu.ifnmg.poo.trabalhos.datapersistence.graphicInterface.Login;
import br.edu.ifnmg.poo.trabalhos.datapersistence.livro.Emprestimo;
import br.edu.ifnmg.poo.trabalhos.datapersistence.livro.EmprestimoDao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.livro.Exemplar;
import br.edu.ifnmg.poo.trabalhos.datapersistence.livro.ExemplarDao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.livro.Livro;
import br.edu.ifnmg.poo.trabalhos.datapersistence.livro.LivroDao;

/**
 *
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class Program {

    public static void main(String[] args) throws Exception {

        /*
        Teste.testeA();
        Teste.testeB();
        Teste.testeC();
        Teste.testeD();
        Teste.testeE();
        Teste.testeF();
        */
        
        /*
        
        
        Livro livro = new Livro();
        try {
            livro.setId(1L);
            livro.setTitle("Quarto de despejo");
            livro.setAuthors("Carolina Maria de Jesus");
            
            livro.setPages(Short.valueOf((short) 200));
            livro.setYear(Short.valueOf((short) 1960));
            livro.setEdition(Byte.valueOf((byte) 1));
            livro.setQtdExemplares(10);
            livro.setQtdExemplaresDisponiveis(livro.getQtdExemplares());
            
            
        } catch (Exception e) {
            System.out.println("( ! ) Erro ao criar livro " + e );
        }
        
        
        System.out.println(livro.toString());
        livro.setId(new LivroDao().saveOrUpdate(livro));
        System.out.println(livro.getId());
        
        
        
        Exemplar exemplar = new Exemplar();
        
        exemplar.setId(-1L);
        exemplar.setLivro(livro);
        exemplar.setLivro_id(livro.getId());
        exemplar.setStatus(false);
        
        exemplar.setId(new ExemplarDao().saveOrUpdate(exemplar));
        
        System.out.println("ID do Exemplar: " + exemplar.getId());
        
        
        
        */
        
        
        Login telaDeLogin = new Login();
        telaDeLogin.setVisible(true);
        

    }
}
