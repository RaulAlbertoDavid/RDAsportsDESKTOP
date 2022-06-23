package com.rdacompany.sportsdesktop.api;

import com.rdacompany.sportsdesktop.domain.Customer;
import com.rdacompany.sportsdesktop.domain.Employee;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

import java.util.List;

public interface RdaSportsApiInterface {

    @GET("/customers")
    Observable<List<Customer>> getCustomers();

    @DELETE("/customer/{customerId}")
    Observable<Void> deleteCustomer(@Path("customerId") int customerId);

    @GET("/employees")
    Observable<List<Employee>> getEmployees();

    @DELETE("/employee/{employeeId}")
    Observable<Void> deleteEmployee(@Path("employeeId") int employeeId);


}
