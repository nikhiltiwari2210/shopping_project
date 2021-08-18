package com.shopping;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.shopping.dao.CustomerSearchDAO;
import com.shopping.dao.impl.CustomerSearchDAOImpl;
import com.shopping.exeception.BusinessException;
import com.shopping.model.Customer;
import com.shopping.search.service.CustomerSearchService;
import com.shopping.search.service.impl.CustomerSearchServiceImp;

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
			log.info("-> 1)Employee Login");
			log.info("-> 2)Customer Login");
			log.info("-> 3)New Customer, then Register!!");
			log.info("-> 4)EXIT");
			log.info("Plese Enter your Choice(1-4)");

			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (ch) {
			case 1:
				log.info("WELCOME TO EMPLOYEE LOGIN");
				/*log.info("Enter UsnerName");
				String customerUserName = scanner.nextLine();
				log.info("Enter Password");
				String customerPassword = scanner.nextLine();

				log.info("Login Successfull");

				// log.info("Welcome "+customerUserName+", What you want");
*/
				break;
			case 2:
				log.info("WELCOME TO CUSTOMER LOGIN");
				int option = 0;
				log.info("Welcome ");
				// PlayerSearchService playerSearchService=new PlayerSearchServiceImpl();
				do {
					log.info("1)Search Products");
					log.info("2)View Orders");
					log.info("3)Logout");
					//log.info("4)Exit");
					log.info("Please enter your choice(1-4)");

					try {
						option = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
					}
					switch (option) {
					case 1:

						break;
					case 2:

						break;
					case 3:
						log.info("\n\nGOING BACK TO MAIN MENU......\n\n");

						break;

					default:
						log.warn("Invalid Option...Option Should Be Only Number Between 1-3 Only ");
						break;
					}
				} while (option != 3);

				break;
			case 3:
				int choice=0;
				CustomerSearchService customerSearchService= new CustomerSearchServiceImp();
				do {
					log.info("WELCOME, PLEASE GIVE YOUR DETAILS FOR REGISTRATION");
					log.info("-> 1) For Registration");
					log.info("-> 2) Back to Main Menu");
					try{
				  		choice=Integer.parseInt(scanner.nextLine());
				  		}catch(NumberFormatException e){
				  	  }
					switch (choice) {
					case 1:
						Customer customer=new Customer();
						log.info("Your First Name");
						customer.setCustomer_firstname(scanner.nextLine());
						log.info("Your Last Name");
						customer.setCustomer_lastname(scanner.nextLine());
						log.info("Your Email address");
						customer.setCustomer_email(scanner.nextLine());
						log.info("Create Your Password");
						customer.setCustomer_password(scanner.nextLine());
						
						CustomerSearchDAO customerSearchDAO=new CustomerSearchDAOImpl();
						try {
					    	int c=customerSearchDAO.createAccount(customer);	   
					       }catch(BusinessException e) {
					    	   log.error(e);
								//throw new BusinessException("Internal error occured, please contact admin");
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
				}while(choice!=2);
			
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
		}while(ch!=4);

	}

}
