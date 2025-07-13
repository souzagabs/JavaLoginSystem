package br.com.login.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Conexao {
    public Connection getConnection() throws SQLException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            Properties props = new Properties();
            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            return DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            throw new SQLException("Erro ao carregar o arquivo db.properties", e);
        }
    }
}
