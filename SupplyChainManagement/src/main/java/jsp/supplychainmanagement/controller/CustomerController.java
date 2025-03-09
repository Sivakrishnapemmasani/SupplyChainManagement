package jsp.supplychainmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.supplychainmanagement.dto.ResponseStructure;
import jsp.supplychainmanagement.entity.Customer;
import jsp.supplychainmanagement.service.CustomerService;

@RequestMapping("/api/customer")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerservice;
	@PostMapping
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer)
	{
		return customerservice.saveCustomer(customer);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Customer>>> getCustomer()
	{
		return customerservice.getCustomer();
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Customer>> getCustomer(@PathVariable int id)
	{
		return customerservice.getCustomerByid(id);
		
	}
	@PutMapping()
	public ResponseEntity<ResponseStructure<Customer>> updateCutomer(@RequestBody Customer customer)
	{
		return customerservice.updateCustomer(customer);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@PathVariable int id)
	{
		return customerservice.deleteCustomer(id);
	}
}
