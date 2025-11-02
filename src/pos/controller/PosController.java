/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Devbyte
 */
public class PosController implements Initializable {

    @FXML
    private Button logoutButton;
    @FXML
    private Button productButton;
    @FXML
    private Label cashierName;
    @FXML
    private Label roleType;
    @FXML
    private Label cashierName2;
    
    private String email;
    private String role;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLogoutButton(ActionEvent event) throws IOException {
        if(event.getSource() == logoutButton){
            Parent parent = FXMLLoader.load(getClass().getResource("/pos/view/Login.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();

            Stage logoutStage = (Stage) logoutButton.getScene().getWindow();
            logoutStage.close();
        }
    }

    @FXML
    private void handleProductAction(ActionEvent event)throws IOException {
        if(event.getSource() == productButton){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pos/view/Product.fxml"));
        Parent root = loader.load();

        ProductController productController = loader.getController();
        productController.setUserInfo(this.email, this.role);

        // Replace current scene (reuse same window)
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        }
    }
    
    public void setUserInfo(String email, String role) {
        this.email = email;
        this.role = role;

        cashierName.setText(email);
        cashierName2.setText(email);
        roleType.setText(role);
    }
}
