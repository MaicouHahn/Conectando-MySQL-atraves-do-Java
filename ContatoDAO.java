
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

//    CRUD 
//    C:Create - ok
//    R:Read -ok
//    U:Update -ok
//    D:Delete- ok

    public void save(Contato contato) {

        String sql = "insert into contatos(nome,idade,datacadastro)values (?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySql();
            //preparedStatement para executar a query do mysql
            pstm = conn.prepareStatement(sql);
            //valores que sao esperados pela query
            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
            //Executar  a query
            pstm.execute();
            System.out.println("Salvo com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //fechar as conexoes
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Contato> getContatos() {

        String sql = "select *from contatos";

        List<Contato> contatos = new ArrayList<Contato>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //classe que vai recuperar os dados do banco **SELECT****
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {

                Contato contato = new Contato();
                //Recuperar o ID
                contato.setId(rset.getInt("id"));
                //Recuperar o Nome
                contato.setNome(rset.getString("nome"));
                //Recuperar a idade
                contato.setIdade(rset.getInt("idade"));
                //Recuperar a data
                contato.setDataCadastro(rset.getDate("dataCadastro"));
                contatos.add(contato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return contatos;
    }

    public void update(Contato contato) {

        String sql = "update contatos set nome = ?,idade = ?, dataCadastro = ?" + " where id= ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar conexão com o banco
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(sql);

            //Adicionar os valores para atualizar
            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
            //Qual o id do registro que deseja atualizar?
            pstm.setInt(4, contato.getId());

            pstm.execute();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void deleteByID(int id) {

        String sql = "delete from contatos where id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                System.out.println(e);

            }
        }
    }
}

