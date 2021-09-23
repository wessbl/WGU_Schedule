/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wessl
 */
public class AppointmentAddController extends WindowChild
        implements WindowParent, Initializable {

    @FXML
    private TextField text_appointmentID;
    @FXML
    private TextField text_title;
    @FXML
    private TextField text_type;
    @FXML
    private TextArea field_description;
    @FXML
    private TextField text_customerID;
    @FXML
    private TextField text_userID;
    @FXML
    private Button button_add_update;
    @FXML
    private Button button_cancel;
    @FXML
    private Hyperlink link_edit_time;
    @FXML
    private Label label_add_appt;
    @FXML
    private Label label_update_appt;
    @FXML
    private TextField text_location;
    @FXML
    private DatePicker date_start;
    @FXML
    private ComboBox<String> meridian_start;
    @FXML
    private DatePicker date_end;
    @FXML
    private ComboBox<String> meridian_end;
    @FXML
    private Spinner<?> spin_hour_start;
    @FXML
    private Spinner<?> spin_minute_start;
    @FXML
    private Spinner<?> spin_hour_end;
    @FXML
    private Spinner<?> spin_minute_end;
    @FXML
    private ComboBox<String> combo_contact;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //  Set Spinner Values for start & end hours
        SpinnerValueFactory hour_start = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12, 8);
        hour_start.setWrapAround(true);
        spin_hour_start.setValueFactory(hour_start);
        
        SpinnerValueFactory hour_end = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12, 9);
        hour_end.setWrapAround(true);
        spin_hour_end.setValueFactory(hour_end);
        
        //  Set Spinner values for start & end minutes
        ObservableList<String> minutes = FXCollections.observableArrayList();
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 10; j+=5)
                minutes.add(String.valueOf(i) + String.valueOf(j));
            
        SpinnerValueFactory minute_start = new SpinnerValueFactory.ListSpinnerValueFactory(minutes);
        minute_start.setWrapAround(true);
        spin_minute_start.setValueFactory(minute_start);
        
        SpinnerValueFactory minute_end = new SpinnerValueFactory.ListSpinnerValueFactory(minutes);
        minute_end.setWrapAround(true);
        spin_minute_end.setValueFactory(minute_end);

        
        //  Set meridian values
        meridian_start.getItems().addAll("am", "pm");
        meridian_end.getItems().addAll("am", "pm");
        
        //  TODO set contact values
        ObservableList<String> contacts = FXCollections.observableArrayList();
        contacts.add("sample contact 1");
        contacts.add("sample contact 2");
        combo_contact.setItems(contacts);
    }    

    @FXML
    private void confirm(MouseEvent event) throws IOException {
        // TODO Validate all form data
//        if (text_appointmentID.getText().equals("")){
//            show_error("Validate form when model is finished :)", event);
//            return;
//        }
        
        // TODO handle saving appointment
        
        // TODO Send data to receiver
        ArrayList<Object> data = new ArrayList();
        data.add("Appointment Add Controller");
        receiver.receiveData(data);
        
        // Close window
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancel(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void edit_customer(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Customers.fxml"));
        Parent parent = loader.load();

        //  Set this window as a receiver for data
        CustomersController ctrl = loader.getController();
        ctrl.setReceiver(this);
        
        // Launch Window
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }
    
    private void show_error(String text, MouseEvent event)
    {
        // Confirm deletion
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Entry");
        alert.setHeaderText("Invalid Entry");
        alert.setContentText(text);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            // Close this window
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    @Override
    public void receiveData(ArrayList<Object> o) {
        System.out.println("Appt Add received data from " + o.get(0).toString());
    }
}