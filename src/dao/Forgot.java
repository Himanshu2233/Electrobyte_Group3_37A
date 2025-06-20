/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.*;

/**
 *
 * @author sahki
 */
public class Forgot {
    Mysql mysql = new Mysql();
    
    public boolean validateSecurityAnswer(String username, String email, String security_ans) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT security_ans FROM users WHERE username = ? AND email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                String storedAnswer = result.getString("security_ans");
                return storedAnswer.equals(security_ans); // Compare answers
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
    public boolean updatePasswordWithSecurityAnswer(String username, String email, String securityQuestion, String securityAnswer, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE username = ? AND email = ? AND security_question = ? AND security_ans = ?";
        try (Connection conn = mysql.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newPassword);
            stmt.setString(2, username);
            stmt.setString(3, email);
            stmt.setString(4, securityQuestion);
            stmt.setString(5, securityAnswer);
            int updated = stmt.executeUpdate();
            return updated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public String getSecurityQuestion(String username, String email) {
        String sql = "SELECT security_question FROM users WHERE username = ? AND email = ?";
        try (Connection conn = mysql.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("security_question");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
