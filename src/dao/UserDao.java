/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.Mysql;
import java.sql.*;
import model.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sahki
 */
public class UserDao {
    Mysql mysql = new Mysql();
    
    
    // Data access methods for User entities
    public void signUp(User user) {
        // Code to save user to the database
        Connection conn = mysql.openConnection();
        if (conn == null) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, "Failed to establish database connection.");
            return;
        }
        String sql = "INSERT INTO users (username, email, password, security_question, security_ans) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getSecurity_question());
            pstmt.setString(5, user.getSecurity_ans());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close resources
            mysql.closeConnection(conn);
        }
    }
    
    public boolean checkUser(User user) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users WHERE email = ? OR username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getUsername());
            ResultSet result = pstmt.executeQuery();
            return result.next(); // If a user is found, return true
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }

    public String getUsernameById(int userId) {
        String username = "";
        String sql = "SELECT username FROM users WHERE user_id = ?";
        try (Connection conn = mysql.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                username = rs.getString("username");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return username;
    }

    public int getTotalActiveUsers() {
        String sql = "SELECT COUNT(*) FROM users"; // Or add WHERE active=1 if you have such a column
        try (Connection conn = mysql.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}