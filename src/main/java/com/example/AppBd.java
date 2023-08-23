package com.example;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppBd {


    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
                System.out.println("Conexão com o banco de dados bem sucedida");
        }
        catch (ClassNotFoundException e) {
                System.out.println("Não foi possivel carregar o driver do bando de dados: " + e.getMessage());
        
        }
        

        Statement consulta = null;

        try(var conn = DriverManager.getConnection("jdbc:postgresql://Localhost/postgres", "gitpod", "")) {

            consulta = conn.createStatement();
            var resultConsulta = consulta.executeQuery("select * from estado");

            while(resultConsulta.next()){
                System.out.printf("ID: %d Nome: %s UF: %s \n", resultConsulta.getInt("id"), resultConsulta.getString("nome"), resultConsulta.getString("uf"));
            }
                
        } 
        catch (SQLException e) {
            System.out.println("Nao foi possivel fazer a conexão com o banco de dados");   
        }
            
    
}
}

