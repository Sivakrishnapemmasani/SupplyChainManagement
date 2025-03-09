package jsp.supplychainmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.supplychainmanagement.entity.Customer;
import jsp.supplychainmanagement.exception.CustomerIdNotFoundException;
import jsp.supplychainmanagement.repository.CustomerRepository;

@Repository
public class CustomerDAO {
	@Autowired
	private CustomerRepository custometrrepositary;
	public Customer saveCustomer(Customer customer)
	{
		return custometrrepositary.save(customer);
	}
	public List<Customer> getCustomer()
	{
		return custometrrepositary.findAll();
	}
	public Optional<Customer> getCustomerByid(int id)
	{
		return custometrrepositary.findById(id);
	}
	public Customer updateCustomer(Customer customer)
	{
		return custometrrepositary.save(customer);
	}
	public Customer deleteCustomer(int id)
	{
		Optional<Customer> opt=custometrrepositary.findById(id);
		if(opt.isPresent())
		{
			custometrrepositary.delete(opt.get());
			return opt.get();
		}
		throw new CustomerIdNotFoundException();
	}

}
