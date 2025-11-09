package pos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import session.UserSession;


public class DashboardController implements Initializable {

    @FXML
    private Label adminName;
    @FXML
    private AnchorPane sidebarContainer;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private AnchorPane contentArea;
    @FXML
    private Label roleText;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadSidebar();
        adminName.setText(UserSession.getEmail());
        roleText.setText(UserSession.getRole());
    }

    private void loadSidebar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pos/sidebar/sidebar.fxml"));
            AnchorPane sidebar = loader.load();
            
            sidebarContainer.getChildren().setAll(sidebar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
