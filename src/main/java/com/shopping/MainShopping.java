package com.shopping;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.shopping.dao.CustomerSearchDAO;
import com.shopping.dao.impl.CustomerSearchDAOImpl;
import com.shopping.exeception.BusinessException;
import com.shopping.model.Customer;
import com.shopping.model.Product;
import com.shopping.search.service.CustomerSearchService;
import com.shopping.search.service.impl.CustomerSearchServiceImpl;

public class MainShopping {

	private static Logger log = Logger.getLogger(MainShopping.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		log.info("||=====================================||");
		log.info("||  WELCOME TO SHOPPING APP Verson.0.1 ||");
		log.info("||=====================================||");

		int ch = 0;
		do {
			log.info("-------------------------------------------");
			log.info("MAIN MENU CHOOSE ANY ONE STEP");
			log.info("->1) Employee Login");
			log.info("->2) Customer Login");
			log.info("->3) New Customer, then Register!!");
			log.info("->4) EXIT");
			log.info("Plese Enter your Choice(1-4)");

			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (ch) {
			case 1:
				log.info("WELCOME TO EMPLOYEE LOGIN");
				try {
					log.info("Enter UserName");
					String employee_username = scanner.nextLine();
					log.info("Enter Password");
					String employee_password = scanner.nextLine();

					CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
					int e = customerSearchService.employeeLoginDetails(employee_username, employee_password);
					if (e == 1) {
						log.info("Failed");
					} else {
						log.info("Login successfull");
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					break;
				}
				int p = 0;
				do {
					log.info("Welcome!! what u want ");
					log.info("->1) Add Product");
					log.info("->2) Delete Product");
					log.info("->3) View Customers");
					log.info("->4) View Products");
					log.info("->5) Logout");
					log.info("Please enter your choice(1-5)");
					try {
						p = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						log.info("error");
					}
					switch (p) {
					case 1:
						log.info(".....Add the Product Details.....");
						Product product=new Product();
						log.info("Enter Product ID");
		            	product.setP_id(Integer.parseInt(scanner.nextLine()));
		            	log.info("Enter Product Name");
		            	product.setP_name(scanner.nextLine());
		            	log.info("Enter Product Price");
		            	product.setP_price(Double.parseDouble(scanner.nextLine()));
		            	log.info("Enter Product Manufacture country");
		            	product.setP_manufacture(scanner.nextLine());
		            	
		            	CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
		            	try {
		            		int n=customerSearchService.addproduct(product);
		            		log.info("Your New Product Add Successfully");
		           		}catch(BusinessException e) {
		           			log.warn(e);
		            	}

						break;
					case 2:
						log.info(".....Delete the Product Details.....");

						break;
					case 3:
						log.info(".....Here the details of all the Customers.....");
						Customer customer=new Customer();
		            	CustomerSearchService customerSearService = new CustomerSearchServiceImpl();
		            	try {
		            		log.info(customerSearService.getAllCustomerDetails(customer));
		            	}catch(BusinessException e) {
		            		log.warn(e.getMessage());
		            	}	 
		            	
		            	break;
					case 4:
						log.info(".....Here the details of all the Products......");
			        	Product products=new Product();
			        	CustomerSearchService customerSearchServiceImpl= new CustomerSearchServiceImpl();
			        	try {
			        	log.info(customerSearchServiceImpl.getProductAllDetails(products));
			        	}catch(BusinessException e) {
			        		log.warn(e.getMessage());
			        	}
						break;
					case 5:
						log.info("LOG OUT Successfully!!!!!");
						log.info("\n\nGOING BACK TO MAIN MENU......\n\n");
						break;

					default:
						log.warn("Invalid Option...Option Should Be Only Number Between 1-5 Only");
						break;
					}
				} while (p != 5);

				break;
			case 2:
				log.info("WELCOME TO CUSTOMER LOGIN");
				try {
					log.info("Enter User Email");
					String customer_email = scanner.nextLine();
					log.info("Enter Password");
					String customer_password = scanner.nextLine();

					CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
					int c=customerSearchService.checkLoginDetails(customer_email, customer_password);
					if (c==1) {
						log.info("Failed");
					} else {
						log.info("Login successfull");
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
					break;
				}
				int option = 0;
				do {
					log.info("Welcome!! what u want ");
					log.info("->1) Search Products");
					log.info("->2) View Orders");
					log.info("->3) Logout");
					log.info("Please enter your choice(1-3)");
					try {
						option = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
					}
					switch (option) {
					case 1:
						log.info("Welcome once again!! You can search product by.......");
						int pick = 0;
						do {
							log.info("->1) By Name");
							log.info("->2) By ID");
							log.info("->3) By Manufacture country");
							log.info("->4) Back to Previous Menu");
							log.info("Please enter your choice(1-4)");
							try {
								pick= Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {
							}
							switch (pick) {
							case 1:
								log.info("Enter the product name to get the details");
								String p_name=scanner.nextLine();
								try {
								CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
								List <Product> playerList=customerSearchService.getProductByName(p_name);
								if(playerList!=null && playerList.size()>0)
									log.info("Only "+playerList.size()+" memeber is present with name "+p_name.toUpperCase());
									for(Product i:playerList) {
										log.info(i);
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}

								break;
							case 2:
								log.info("Enter Product id to get details");
								int p_id=Integer.parseInt(scanner.nextLine());
								try {
								CustomerSearchDAO customerSearchDAO = new CustomerSearchDAOImpl();
								Product product =customerSearchDAO.getProductById(p_id);
								if(product!=null) {
									log.info("Product with id "+p_id+" founded");
									log.info(product);
								}
								}catch(NumberFormatException e) {
									log.warn("Product Id should be digit only... Try Again");
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								
								break;
							case 3:
								log.info("Enter the country name to get the details");
								String p_manufacture=scanner.nextLine();
								try {
								CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
								List <Product> playerList=customerSearchService.getProductByCountry(p_manufacture);
								if(playerList!=null && playerList.size()>0)
									log.info("Only "+playerList.size()+" Country with name "+p_manufacture.toUpperCase()+" is present");
									for(Product i:playerList) {
										log.info(i);
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}

								break;
							case 4:
								log.info("\nGOING BACK TO PREVIOUS MENU");
								break;

							default:
								break;
							}
						} while (pick != 4);
						break;
					case 2:
						log.info("List All the products Details");
			        	Product product=new Product();
			        	CustomerSearchServiceImpl customerSearchServiceImpl= new CustomerSearchServiceImpl();
			        	try {
			        	log.info(customerSearchServiceImpl.getProductAllDetails(product));
			        	}catch(BusinessException e) {
			        		log.info(e.getMessage());
			        	}
						break;
					case 3:
						log.info("LOG OUT Successfully!!!!!");
						log.info("\n\nGOING BACK TO MAIN MENU......\n\n");

						break;
					default:
						log.warn("Invalid Option...Option Should Be Only Number Between 1-3 Only ");
						break;
					}
				} while (option != 3);

				break;
			case 3:
				int choice = 0;
				do {
					log.info("WELCOME, PLEASE GIVE YOUR DETAILS FOR REGISTRATION");
					log.info("-> 1) For Registration");
					log.info("-> 2) Back to Main Menu");
					try {
						choice = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
					}
					switch (choice) {
					case 1:
						Customer customer = new Customer();
						log.info("Please Provide correct Details");
						log.info("Your First Name");
						customer.setCustomer_firstname(scanner.nextLine());
						log.info("Your Last Name");
						customer.setCustomer_lastname(scanner.nextLine());
						log.info("Your Email address");
						customer.setCustomer_email(scanner.nextLine());
						log.info("Create Your Password");
						customer.setCustomer_password(scanner.nextLine());

						CustomerSearchDAO customerSearchDAO = new CustomerSearchDAOImpl();
						try {
							int c = customerSearchDAO.createAccount(customer);
						} catch (BusinessException e) {
							log.error(e);
						}
						log.info("Congrats! Your Account Has been Created Successfully");

						break;
					case 2:
						log.info("\\n\\nGOING BACK TO MAIN MENU......\\n\\n");

						break;
					default:
						log.warn("Invalid Option...Option Should Be Only Number Between 1-2 Only");
						break;
					}
				} while (choice != 2);

				break;
			case 4:
				log.info("||=====================================||");
				log.info("||    THANKS FOR USING THIS APP        ||");
				log.info("||=====================================||");

				break;
			default:
				log.warn("Invalid Option...Option Should Be Only Number Between 1-4 Only");
				break;
			}
		} while (ch != 4);

	}

}