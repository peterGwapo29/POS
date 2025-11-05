package pos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pos.sidebar.SBController;

public class PosController implements Initializable {

    private Button logoutButton;
    private Button productButton;
    @FXML
    private Label cashierName;
    @FXML
    private Label roleType;
    @FXML
    private AnchorPane sidebarContainer;
    @FXML
    private AnchorPane contentArea;

    private String email;
    private String role;
    @FXML
    private AnchorPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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

    private void handleLogoutButton(ActionEvent event) throws IOException {
        if (event.getSource() == logoutButton) {
            Parent parent = FXMLLoader.load(getClass().getResource("/pos/view/Login.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();

            Stage logoutStage = (Stage) logoutButton.getScene().getWindow();
            logoutStage.close();
        }
    }

    private void handleProductAction(ActionEvent event) throws IOException {
        if (event.getSource() == productButton) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pos/view/Product.fxml"));
            Parent root = loader.load();

            ProductController productController = loader.getController();
            productController.setUserInfo(this.email, this.role);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    public void setUserInfo(String email, String role) {
        this.email = email;
        this.role = role;

        cashierName.setText(email);
        roleType.setText(role);

        loadSidebar();
    }
}
