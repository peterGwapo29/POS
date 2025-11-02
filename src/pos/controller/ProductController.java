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
public class ProductController implements Initializable {

    @FXML
    private Button logoutButton;
    @FXML
    private Label cashierName;
    @FXML
    private Label roleType;
    
    private String role;
    private String email;


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
    
    public void setUserInfo(String email, String role) {
        this.email = email;
        this.role = role;

        cashierName.setText(email);
        roleType.setText(role);
    }
    
}
