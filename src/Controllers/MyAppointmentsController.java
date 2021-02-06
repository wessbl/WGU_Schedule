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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wessl
 */
public class MyAppointmentsController implements Initializable {

    @FXML
    private TableView<?> table;
    @FXML
    private RadioButton radio_week;
    @FXML
    private ToggleGroup date_range;
    @FXML
    private RadioButton radio_month;
    @FXML
    private Button button_add_appt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("farts!");
    }    
    
        private void ChangeWindow(String window, Stage stage) throws IOException
    {
        //  Get Loader & load it
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/" + window + ".fxml"));
        Parent parent = loader.load();
        
        // TODO remove?
        //  Set controller for new window - always goes back to MainScreen
        //  MyAppointmentsController c = loader.getController();
        //  loader.setController(c);
        
        //  Show new stage
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
