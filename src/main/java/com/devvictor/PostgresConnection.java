package com.devvictor;

import java.sql.*;

public class PostgresConnection {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/default_db";
        String user = "admin";
        String password = "admin123";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão estabelecida com sucesso!");

            Driver driver = DriverManager.getDriver(url);
            System.out.println(driver);

            Statement statement = connection.createStatement();
            String query = "SELECT version()";

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Versão do PostgreSQL: " + resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

