
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    //nome usuario mysql
    private static final String USERNAME = "root";
    //senha do banco
    private static final String PASSWORD = "";
    //caminho do banco de dados, porta, e o nome do banco de dados
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
    //private static final String DATABASE_URL = "jdbc:mysql://www.cedup.net.br:33061/phpmyadmin/maicou/maicou_locadora";

//    conexão com o banco de dado
    public static Connection createConnectionToMySql() throws Exception {
//        faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
//        cria conexão com o banco de dados
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception {
        //Recuperar uma conexão com o banco de dados
        Connection con = createConnectionToMySql();
        //testar se a conexão é nula
        if (con != null) {
            System.out.println("Conexao obtida com sucesso!");
            con.close();
        }
    }
}
