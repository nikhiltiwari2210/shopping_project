package shopping_project;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.shopping.exeception.BusinessException;
import com.shopping.model.Customer;
import com.shopping.model.Product;
import com.shopping.search.service.CustomerSearchService;
import com.shopping.search.service.impl.CustomerSearchServiceImpl;

public class TestingProduct {

	@Test
	public void testByName() throws BusinessException {
		
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
		assertNotNull(customerSearchService.getProductByName("Laptop"));
	}
	
	/*@Test
	public void testById() throws BusinessException {
		
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
		assertNotNull(customerSearchService.getProductById(105));
	}
	*/
	@Test
	public void testByManufactureCountry() throws BusinessException {
		
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
		assertNotNull(customerSearchService.getProductByCountry("USA"));
	}
	
	@Test
	public void testProductDetails() throws BusinessException {
		//Product product=new Product();
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
		Product product=new Product();
		assertNotNull(customerSearchService.getProductAllDetails(product));
	}
		
	@Test
	public void testCustomerDetails() throws BusinessException {
		//Product product=new Product();
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
		Customer customer=new Customer();
		assertNotNull(customerSearchService.getAllCustomerDetails(customer));
	}
	
	/*@Test
	public void testAddProduct() throws BusinessException {
		
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
		assertEquals(104,Book,500,));
	}
	
	@Test
	public void testDeleteProduct() throws BusinessException {
		
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
		assertNotNull(customerSearchService.getProductByName("Laptop"));
	}
	*/
}