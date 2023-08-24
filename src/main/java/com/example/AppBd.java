package com.example;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class AppBd {

    // Contantes contendo as informações para acesso ao banco de dados.
    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://Localhost/postgres";

    public static void main(String[] args) {
        carregarDriverJDBC(); // O driver JDBC só precisa ser carregado uma unica vez por isso ele pode ficar diretamente o main.
        listarEstados(); // Metodo que chama a funcão de listar todos os estados
    }

    // Metodo usado para listar os Estados, a clausa try cach é usada, pois o metodo getConnection delegou o tratamento da excessão para quem chamar o metrodo.
    private static void listarEstados() { 
 
        Statement consulta = null; // 

        try(var conn = getConnection()) {

            consulta = conn.createStatement();
            var resultConsulta = consulta.executeQuery("select * from estado");

            //Aqui o laço é usado para mostrar todos os estados encontrados, e o .next() serve para manter o laço em execução até não haver mais estados.
            while(resultConsulta.next()){
                System.out.printf("ID: %d Nome: %s UF: %s \n", resultConsulta.getInt("id"), resultConsulta.getString("nome"), resultConsulta.getString("uf"));
            }
                
        } 
        catch (SQLException e) {
            System.out.println("Nao foi possivel fazer a conexão com o banco de dados");   
        }
    }

    // Método que cria a conexão com o banco de dados, carregando a biblioteca do DriverManager, com as constantes contendo as informçãoes de acesso ao banco
    private static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }


    // Carrega a classe JDBC para acessar o banco de dados postgres, o java obriga a tratar a excessão em caso de não conseguir acesso ao banco de dados por isso a clausula try cach
    private static void carregarDriverJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
                System.out.println("Conexão com o banco de dados bem sucedida");
        }
        catch (ClassNotFoundException e) {
                System.out.println("Não foi possivel carregar o driver do bando de dados: " + e.getMessage());
        
        }
    }
}

