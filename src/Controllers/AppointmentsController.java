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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wessl
 */
public class AppointmentsController implements Initializable, WindowParent {

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
    @FXML
    private Button button_view_appt;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO anything?
    }    
    
    
    @FXML
    private void by_week(MouseEvent event) {
        // TODO only show items for this week?
        System.out.println("Unimplemented event!");
    }

    
    @FXML
    private void by_month(MouseEvent event) {
        // TODO show items for this month?
        System.out.println("Unimplemented event!");
    }

    
    @FXML
    private void add_appointment(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        ChangeWindow("AppointmentAdd", stage);
    }
    
    @FXML
    private void view_appointment(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        ChangeWindow("AppointmentView", stage);
    }
    
    private void ChangeWindow(String window, Stage stage) throws IOException
    {
        //  Get Loader & load it
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/" + window + ".fxml"));
        Parent parent = loader.load();
        
        // Give controller data transfer
        switch (window){
            case "AppointmentAdd":
                AppointmentAddController aac = loader.getController();
                aac.setReceiver(this);
                break;
            
            case "AppointmentView":
                AppointmentViewController avc = loader.getController();
                avc.setReceiver(this);
                break;
        }
        
        //  Show new stage
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void receiveData(ArrayList<Object> data)
    {
        for (Object o : data)
            System.out.println("My Appointments received data from " + o.toString());
    }
}
