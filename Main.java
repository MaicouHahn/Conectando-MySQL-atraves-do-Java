
import java.util.Date;

public class Main {

    public static void main(String[] args) {

            ContatoDAO contatoDAO=new ContatoDAO();
         //contatoDAO.getContatos();
//       Contato c1 = new Contato();
//       
//       c1.setNome("Maicou Hahn Fortuna");
//       c1.setIdade(26);
//       c1.setDataCadastro(new Date());
//       contatoDAO.save(c1);
//        ContatoDAO contatoDao = new ContatoDAO();
//
//        Contato contato = new Contato();
//        contato.setNome("Ana Roberta Almeida");
//        contato.setIdade(32);
//        contato.setDataCadastro(new Date());
//        contatoDao.save(contato);
//        
//        Atualizar um contato
//        Contato c1 = new Contato();
//        c1.setNome("Maicou Hahn Fortuna");
//        c1.setIdade(26);
//        c1.setDataCadastro(new Date());
//        //ID do banco
//        c1.setId(1);
          //contatoDao.update(c1);
          //Remover Deletar contato pelo ID
          //Visualização dos registros do banco de dados TODOS
        for(Contato c:contatoDAO.getContatos()){
           System.out.println("Contato: "+c.getNome());
        }
    }
}
