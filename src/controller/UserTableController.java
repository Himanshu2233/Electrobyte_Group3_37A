package controller;

import dao.UserTableDao;
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
            login.setVisible(true); // Show the login window
        });
    }
}
