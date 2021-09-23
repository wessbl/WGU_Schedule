/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wessl
 */
public class LoginController implements Initializable {

    @FXML
    private Label lbl_error;
    @FXML
    private Label lbl_userid;
    @FXML
    private TextField txt_userid;
    @FXML
    private TextField txt_password;
    @FXML
    private Label lbl_password;
    @FXML
    private Button btn_login;
    @FXML
    private Label lbl_location_section;
    @FXML
    private Label lbl_location;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }


    @FXML
    private void login(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ChangeWindow("Appointments", stage);
    }
    
    private void ChangeWindow(String window, Stage stage) throws IOException
    {
        //  Get Loader & load it
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/" + window + ".fxml"));
        Parent parent = loader.load();
        
        //  Set controller for new window - always goes back to MainScreen
//	MyAppointmentsController c = loader.getController();
//	loader.setController(c);
        
        //  Show new stage
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
