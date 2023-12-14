package br.edu.ifnmg.poo.trabalhos.datapersistence;

import br.edu.ifnmg.poo.trabalhos.datapersistence.credential.Credential;
import br.edu.ifnmg.poo.trabalhos.datapersistence.credential.CredentialDao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.librarian.Librarian;
import br.edu.ifnmg.poo.trabalhos.datapersistence.librarian.LibrarianDao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.reader.Reader;
import br.edu.ifnmg.poo.trabalhos.datapersistence.reader.ReaderDao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.role.Role;
import br.edu.ifnmg.poo.trabalhos.datapersistence.role.RoleDao;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.User;
import br.edu.ifnmg.poo.trabalhos.datapersistence.user.UserDao;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Gabriel Davi
 * @author Luiz
 * @author Lucas Santos 
 *
 */
public class Teste {

    public static void testeA() throws Exception {

        // CRIANDO BIBLIOTECARIO
        System.out.println("------------ TESTE A -----------------------------------------------\n");
        System.out.println("Criando Bibliotecario: \n");

        Credential credential_lib = new Credential();
        User user_lib = new User();

        Role role_lib = new Role(null, "Bibliotecario");
        Long id5 = role_lib.getId();
        System.out.println("----> RoleID: " + role_lib.getId() + " é um " + role_lib.getName());

        credential_lib = new Credential("@bibliotec01", "senhaBibliotec", LocalDate.now(), true, user_lib);
        Long id = new CredentialDao().saveOrUpdate(credential_lib);
        credential_lib.setId(id);

        user_lib = new User(-1L, "Bibliotec numero 1", "bibliotec001@mail", LocalDate.of(1985, Month.JANUARY, 18), credential_lib, role_lib);
        new UserDao().saveOrUpdate(user_lib);
        user_lib.setId(credential_lib.getId());

        Librarian librarian = new Librarian(-user_lib.getId(), user_lib); //o ID negativo é consertado no compose de LibrarianDao
        new LibrarianDao().saveOrUpdate(librarian);
        librarian.setId(user_lib.getId());

        User u = new UserDao().findById(user_lib.getId());
        System.out.println("\n" + u);

        System.out.println("\nAtualizando Bibliotecario: \n");

        Role roleUpdate = new Role(null, "Bibliotecario");

        Long idBuscado = user_lib.getId(); //atualiza o que foi inserido acima

        Credential credentialUpdate = new Credential("@biblio_01", "senhaNovaBiblio", LocalDate.now(), true, user_lib);
        credentialUpdate.setId(user_lib.getId());

        User userUpdate = new User(idBuscado, "Bibliotecario numero 01", "bibliotecario1@mail.com.br", user_lib.getBirthdate(), credentialUpdate, roleUpdate);

        userUpdate.setRole(user_lib.getRole());
        userUpdate.setCredential(user_lib.getCredential());

        new UserDao().saveOrUpdate(userUpdate);

        new CredentialDao().saveOrUpdate(credentialUpdate);

        Librarian librarianUpdate = new Librarian(userUpdate.getId(), userUpdate);
        new LibrarianDao().saveOrUpdate(librarianUpdate);
        librarianUpdate.setId(userUpdate.getId());

        u = new UserDao().findById(userUpdate.getId());
        System.out.println("\n" + u);

    }

    public static void testeB() throws Exception {

        // CRIANDO LEITOR 1
        System.out.println("\n\n------------ TESTE B -----------------------------------------------\n");
        System.out.println("Criando Leitor 1: \n");

        Credential credential_reader = new Credential();
        User user_reader = new User();

        Role role_reader = new Role(null, "Leitor");
        Long id5 = role_reader.getId();
        System.out.println("----> RoleID: " + role_reader.getId() + " é um " + role_reader.getName());

        credential_reader = new Credential("@leitor01", "senhaLeitor01", LocalDate.now().minusMonths(3), true, user_reader);
        Long id = new CredentialDao().saveOrUpdate(credential_reader);
        credential_reader.setId(id);

        user_reader = new User(-1L, "Leitor número 1", "leitor01@mail", LocalDate.of(2000, Month.AUGUST, 12), credential_reader, role_reader);
        new UserDao().saveOrUpdate(user_reader);
        user_reader.setId(credential_reader.getId());

        Reader reader = new Reader(-user_reader.getId(), user_reader); //o ID negativo é consertado no compose de LibrarianDao
        new ReaderDao().saveOrUpdate(reader);
        reader.setId(user_reader.getId());

        User u = new UserDao().findById(user_reader.getId());
        System.out.println("\n" + u);

        System.out.println("\nAtualizando Leitor: \n");

        Role roleUpdate = new Role(null, "Leitor");

        Long idBuscado = user_reader.getId(); //atualiza o que foi inserido acima

        Credential credentialUpdate = new Credential("@leitor01update", "789012", LocalDate.now(), true, user_reader);
        credentialUpdate.setId(user_reader.getId());

        User userUpdate = new User(idBuscado, "Leitor numero 1 update", "leitor01update@mail.com.br", user_reader.getBirthdate(), credentialUpdate, roleUpdate);

        userUpdate.setRole(user_reader.getRole());
        userUpdate.setCredential(user_reader.getCredential());

        new UserDao().saveOrUpdate(userUpdate);

        new CredentialDao().saveOrUpdate(credentialUpdate);

        Reader readerUpdate = new Reader(userUpdate.getId(), userUpdate);
        new ReaderDao().saveOrUpdate(readerUpdate);
        readerUpdate.setId(userUpdate.getId());

        u = new UserDao().findById(userUpdate.getId());
        System.out.println("\n" + u);

    }

    public static void testeC() throws Exception {

        // CRIANDO LEITOR 2
        System.out.println("\n\n------------ TESTE C -----------------------------------------------\n");
        System.out.println("Criando Leitor 2: \n");

        Credential credential_reader = new Credential();
        User user_reader = new User();

        Role role_reader = new Role(null, "Leitor");
        Long id5 = role_reader.getId();
        System.out.println("----> RoleID: " + role_reader.getId() + " é um " + role_reader.getName());

        credential_reader = new Credential("@leitor_2", "senhaLeitor02", LocalDate.now().minusDays(3), true, user_reader);
        Long id = new CredentialDao().saveOrUpdate(credential_reader);
        credential_reader.setId(id);

        user_reader = new User(-1L, "Leitor número 2", "leitor02@mail", LocalDate.of(1992, Month.MARCH, 27), credential_reader, role_reader);
        new UserDao().saveOrUpdate(user_reader);
        user_reader.setId(credential_reader.getId());

        Reader reader = new Reader(-user_reader.getId(), user_reader); //o ID negativo é consertado no compose de LibrarianDao
        new ReaderDao().saveOrUpdate(reader);
        reader.setId(user_reader.getId());

        User u = new UserDao().findById(user_reader.getId());
        System.out.println("\n" + u);

        System.out.println("\nAtualizando Leitor: \n");

        Role roleUpdate = new Role(null, "Leitor");

        Long idBuscado = user_reader.getId(); //atualiza o que foi inserido acima

        Credential credentialUpdate = new Credential("@leitor_2update", "senhaL02update", LocalDate.now(), true, user_reader);
        credentialUpdate.setId(user_reader.getId());

        User userUpdate = new User(idBuscado, "Leitor numero 2 update", "leitor02update@mail.com", user_reader.getBirthdate(), credentialUpdate, roleUpdate);

        userUpdate.setRole(user_reader.getRole());
        userUpdate.setCredential(user_reader.getCredential());

        new UserDao().saveOrUpdate(userUpdate);

        new CredentialDao().saveOrUpdate(credentialUpdate);

        Reader readerUpdate = new Reader(userUpdate.getId(), userUpdate);
        new ReaderDao().saveOrUpdate(readerUpdate);
        readerUpdate.setId(userUpdate.getId());

        u = new UserDao().findById(userUpdate.getId());
        System.out.println("\n" + u);

    }

    public static void testeD() {

        // RECUPERAR TODOS OS BIBLIOTECÁRIOS
        System.out.println("\n\n------------ TESTE D -----------------------------------------------\n");
        System.out.println("Recuperando todos os Bibliotecários: \n");

        try {

            LibrarianDao acesso = new LibrarianDao();

            System.out.println("Carga de todos os bibliotecários: ");

            for (Librarian lib : acesso.findAll()) {
                // buscando todos os bibliotecários
                System.out.println(lib);
            }
            System.out.println("\n");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void testeE() {

        // RECUPERAÇÃO DE TODOS OS LEITORES
        System.out.println("\n\n------------ TESTE E -----------------------------------------------\n");
        System.out.println("Recuperando todos os Leitores: \n");

        try {

            ReaderDao acesso = new ReaderDao();

            System.out.println("Carga de todos os leitores: ");

            for (Reader r : acesso.findAll()) {
                // buscando todos os leitores
                System.out.println(r);
            }
            System.out.println("\n");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void testeF() {

        System.out.println("\n\n------------ TESTE F -----------------------------------------------\n");
        System.out.println("Autenticações!!!");

        try {

            System.out.println("\nAutenticando o Bibliotecario: ");

            CredentialDao acesso = new CredentialDao();
            Credential credential = new Credential();
            credential.setUsername("@biblio_01");
            credential.setPassword(acesso.crypPass("senhaNovaBiblio"));
            User u = acesso.authenticate(credential);

            Role r = new RoleDao().findById(u.getRole().getId());

            System.out.println("\n");
            System.out.println("Retorno da autenticação: " + u);
            System.out.println("Papel: " + r.getName());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {

            System.out.println("\nAutenticando o Leitor 1: ");

            CredentialDao acesso = new CredentialDao();
            Credential credential = new Credential();
            credential.setUsername("@leitor01update");
            credential.setPassword(acesso.crypPass("789012"));
            User u = acesso.authenticate(credential);

            Role r = new RoleDao().findById(u.getRole().getId());

            System.out.println("\n");
            System.out.println("Retorno da autenticação: " + u);
            System.out.println("Papel: " + r.getName());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {

            System.out.println("\nAutenticando o Leitor 2: ");

            CredentialDao acesso = new CredentialDao();
            Credential credential = new Credential();
            credential.setUsername("@leitor_2update");
            credential.setPassword(acesso.crypPass("senhaL02update"));
            User u = acesso.authenticate(credential);

            Role r = new RoleDao().findById(u.getRole().getId());

            System.out.println("\n");
            System.out.println("Retorno da autenticação: " + u);
            System.out.println("Papel: " + r.getName());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
