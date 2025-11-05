package pos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pos.sidebar.SBController;

public class DashboardController implements Initializable {

    @FXML
    private Label adminName;
    @FXML
    private AnchorPane sidebarContainer;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private AnchorPane contentArea;

    private String role;
    private String email;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setUserInfo(String email, String role) {
        this.email = email;
        this.role = role;

        adminName.setText(email);

        loadSidebar();
    }

    private void loadSidebar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pos/sidebar/sidebar.fxml"));
            AnchorPane sidebar = loader.load();

            SBController sbController = loader.getController();

            sbController.setUserInfo(email, role);

            sidebarContainer.getChildren().setAll(sidebar);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
