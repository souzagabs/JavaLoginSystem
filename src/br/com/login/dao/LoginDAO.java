/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Joe
 */
public class LoginDAO {
    
    public void cadastrarUsuario (String nome, String email, String senha) throws SQLException{
        Connection conexao = new Conexao().getConnection();


        
        String sql = "INSERT INTO login (nome, email, senha) VALUES(?,?,?)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setString(1, nome);
        statement.setString(2, email);
        statement.setString(3, senha);

        statement.execute();
        conexao.close();
    }
    
    public void login (String email, String senha) throws SQLException{
        Connection conexao = new Conexao().getConnection();

        String sql = "SELECT email,senha FROM login WHERE (email) =? AND (senha)=?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setString(1, email);
        statement.setString(2, senha);
        
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
        System.out.println("Login bem-sucedido!");
        } else {
       System.out.println("Email ou senha incorretos.");
       
        }

        /*if (resultSet.next()) {
        JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
    } else {
        JOptionPane.showMessageDialog(null, "Email ou senha incorretos.");
    }*/
        conexao.close();
    }

}
