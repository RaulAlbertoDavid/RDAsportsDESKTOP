package com.rdacompany.sportsdesktop;

import com.rdacompany.sportsdesktop.api.Api;
import com.rdacompany.sportsdesktop.api.RdaSportsApiInterface;
import com.rdacompany.sportsdesktop.domain.Customer;
import com.rdacompany.sportsdesktop.domain.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import rx.Observable;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {

    public TextField delete;
    public TextField delete2;
    private RdaSportsApiInterface api;
    private Observable<List<Customer>> customerCall;
    private Observable<List<Employee>> employeeCall;
    public ListView<Customer> customerListView;
    public ListView<Employee> employeeListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        api = Api.buildInstance();
        listAllCustomers();
        listAllEmployees();
    }


    @FXML
    private void listAllCustomers() {
        customerListView.getItems().clear();
        customerCall = api.getCustomers();
        customerCall.flatMapIterable(customer -> customer)
                .subscribe(customer -> customerListView.getItems().add(customer));
    }

    @FXML
    private void listAllEmployees() {
        employeeListView.getItems().clear();
        employeeCall = api.getEmployees();
        employeeCall.flatMapIterable(employee -> employee)
                .subscribe(employee -> employeeListView.getItems().add(employee));
    }

    @FXML
    public void deleteCustomer (ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Estas seguro de que quieres eliminar?");
        alert2.setContentText("El cliente ha sido eliminado");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            Observable<Void> callDelete =  api.deleteCustomer(Integer.parseInt(delete.getText()));
            callDelete.subscribe(unused -> alert2.show());
        }
        listAllCustomers();
    }

    @FXML
    public void deleteEmployee (ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Estas seguro de que quieres eliminar?");
        alert2.setContentText("El empleado ha sido eliminado");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            Observable<Void> callDelete =  api.deleteEmployee(Integer.parseInt(delete2.getText()));
            callDelete.subscribe(unused -> alert2.show());
        }
        listAllEmployees();
    }
}
