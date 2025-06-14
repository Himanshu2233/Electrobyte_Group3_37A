package controller;

import dao.UserTableDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import view.UserTable;
import view.Login;
import javax.swing.table.DefaultTableModel;

public class UserTableController {
    private final UserTable view;
    private final UserTableDao dao = new UserTableDao();
    private final Login login;

    public UserTableController(UserTable view, Login login) {
        this.view = view;
        this.login = login;
    }

    public void loadUsers() {
        List<Object[]> users = dao.getAllUsers();
        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0);
        for (Object[] row : users) {
            model.addRow(row);
        }
    }

    public void showUserTable() {
        view.setVisible(true);
        view.addLogoutListener(e -> {
        view.dispose();      // Dispose the current UserTable window
        });
    }
    public boolean deleteUserByUsername(String username) {
        try {
            Connection conn = dao.getConnection(); // Use your DAO's connection method
            String sql = "DELETE FROM users WHERE username = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            int affected = pst.executeUpdate();
            pst.close();
            conn.close();
            return affected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
