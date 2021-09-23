/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wessl
 */
public class CustomerAddController extends WindowChild implements Initializable {

    @FXML
    private TextField text_customer_id;
    @FXML
    private TextField text_name;
    @FXML
    private TextField text_phone;
    @FXML
    private Button button_add_update;
    @FXML
    private Button button_cancel;
    @FXML
    private Label label_add_appt;
    @FXML
    private Label label_update_appt;
    @FXML
    private TextField text_address;
    @FXML
    private TextField text_postal_code;
    @FXML
    private ComboBox<?> drop_country;
    @FXML
    private ComboBox<?> drop_division;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirm(MouseEvent event) throws IOException {
        //  TODO handle saving customer
        
        // TODO Send data to receiver
        ArrayList<Object> data = new ArrayList();
        data.add("Customer Add Controller");
        receiver.receiveData(data);

        //  Go back to parent window
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancel(MouseEvent event)  throws IOException {
        // Close this window and go back
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    
    private void ChangeWindow(String window, Stage stage) throws IOException
    {
        //  Get Loader & load it
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/" + window + ".fxml"));
        Parent parent = loader.load();
        
        //  Show new stage
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
