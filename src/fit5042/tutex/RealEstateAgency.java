package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * This is the main driver class. This class contains the main method for Exercise 1A
 * 
 * This program can run without the completion of Exercise 1B.
 * 
 * @author Yuze Ling
 */
public class RealEstateAgency {
    private String name;
    private final PropertyRepository propertyRepository;

    public RealEstateAgency(String name) throws Exception {
        this.name = name;
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
    }
    
    // this method is for initializing the property objects
    public void createProperty() {
    	try {
    		propertyRepository.addProperty(new Property(1, "Address1", 2, 45, 600000));
    		propertyRepository.addProperty(new Property(2, "Address2", 1, 25, 300000));
    		propertyRepository.addProperty(new Property(3, "Address3", 3, 70, 850000));
    		propertyRepository.addProperty(new Property(4, "Address4", 3, 75, 900000));
    		propertyRepository.addProperty(new Property(5, "Address5", 5, 120, 3000000));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    // this method is for displaying all the properties
    public void displayProperties() {
    	try {
	    	for (Property property: propertyRepository.getAllProperties()) {
	    		System.out.println(property.toString());
	    	}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    // this method is for searching the property by ID
    public void searchPropertyById() {    
    	System.out.print("Please enter a property ID to search for: ");
    	
    	try {
    		Scanner scanner = new Scanner(System.in);
        	int id = scanner.nextInt();
        	scanner.close();
    		Property property = propertyRepository.searchPropertyById(id);
    		
    		if (property == null) {
    			System.out.println("Property Not Found!");
    			return;
    		}
    		
    		System.out.println(property.toString());
    		
    	} catch(InputMismatchException e) {
    		System.out.println("Input error! Please enter a number!");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void run() {
        createProperty();
        System.out.println("********************************************************************************");
        displayProperties();
        System.out.println("********************************************************************************");
        searchPropertyById();
    }
    
    public static void main(String[] args) {
        try {
            new RealEstateAgency("FIT5042 Real Estate Agency").run();
        } catch (Exception ex) {
            System.out.println("Application fail to run: " + ex.getMessage());
        }
    }
}
