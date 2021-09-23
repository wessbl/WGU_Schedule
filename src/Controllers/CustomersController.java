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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wessl
 */
public class CustomersController extends WindowChild 
        implements WindowParent, Initializable {

    @FXML
    private Label label_add_appt;
    @FXML
    private Button button_add;
    @FXML
    private TableView<?> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add(MouseEvent event) throws IOException {
        //  TODO handle saving
        Stage stage = new Stage();
        ChangeWindow("CustomerAdd", stage);
    }

    @FXML
    private void view(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        ChangeWindow("CustomerView", stage);
        // TODO tell controller to do View mode
    }

    @FXML
    private void select(MouseEvent event) {
        // TODO Send data to receiver
        ArrayList<Object> data = new ArrayList();
        data.add("Customers Controller");
        receiver.receiveData(data);

        // Close window
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    
    private void ChangeWindow(String window, Stage stage) throws IOException
    {
        //  Get Loader & load it
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/" + window + ".fxml"));
        Parent parent = loader.load();
        
        //  Set receiver for the controller
        switch(window)
        {
            case "CustomerView":
                CustomerViewController cvc = loader.getController();
                cvc.setReceiver(this);
                break;
                
            case "CustomerAdd":
                CustomerAddController cac = loader.getController();
                cac.setReceiver(this);
                break;
        }
        
        //  Show new stage
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void receiveData(ArrayList<Object> o) {
        System.out.println("Customers received data from " + o.get(0).toString());
    }
}
