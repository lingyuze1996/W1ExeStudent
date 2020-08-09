/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * This class implements the PropertyRepository class. You will need to add the keyword
 * "implements" PropertyRepository. 
 * 
 * @author Yuze Ling
 */
public class SimplePropertyRepositoryImpl implements PropertyRepository{
	private List<Property> properties;

    public SimplePropertyRepositoryImpl() {
        properties = new ArrayList<>();
    }

	@Override
	public void addProperty(Property property) throws Exception {
		properties.add(property);			
	}

	@Override
	public Property searchPropertyById(int id) throws Exception {
		for (Property property: properties) {
			if (property.getId() == id)
				return property;
		}
		return null;
	}

	@Override
	public List<Property> getAllProperties() throws Exception {
		return properties;
	}
    
}
