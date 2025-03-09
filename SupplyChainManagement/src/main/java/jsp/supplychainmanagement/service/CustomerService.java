package jsp.supplychainmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.supplychainmanagement.dao.CustomerDAO;
import jsp.supplychainmanagement.dto.ResponseStructure;
import jsp.supplychainmanagement.entity.Customer;
import jsp.supplychainmanagement.exception.CustomerIdNotFoundException;

@Service
public class CustomerService {
	@Autowired
	private CustomerDAO customerdao;
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer)
	{
		customerdao.saveCustomer(customer);
		ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("created sucees");
		structure.setData(customer);
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<List<Customer>>> getCustomer()
	{
		List<Customer>l=customerdao.getCustomer();
		ResponseStructure<List<Customer>> structure=new ResponseStructure<List<Customer>>();
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage("fetched sucess");
		structure.setData(l);
		return new ResponseEntity<ResponseStructure<List<Customer>>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Customer>> getCustomerByid(int id)
	{
		Optional<Customer> opt=customerdao.getCustomerByid(id);
		ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage("sucess");
		if(opt.isPresent())
		{
		structure.setData(opt.get());
		}
		else {
			throw new CustomerIdNotFoundException();
		}
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer)
	{
		Customer c=customerdao.saveCustomer(customer);
		ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("update sucees");
		structure.setData(c);
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.ACCEPTED);
	}
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int id)
	{
		Customer customer=customerdao.deleteCustomer(id);
		ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage("sucess");
	    structure.setData(customer);
	   
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
	}

}
