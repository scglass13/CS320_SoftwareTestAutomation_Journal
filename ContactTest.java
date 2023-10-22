package contact_service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	// Contact creation test
	@Test	// test for creation of valid contact
	public void testValidContactCreation() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
		assertNotNull(contact);
	}
	
	// Contact ID tests
	
	@Test	// testing valid contact ID within the 10-character limit
    public void testValidContactID() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        contact.setContactID("54321");
        String contactID = contact.getContactID();
        assertNotNull(contactID);
        assertTrue(contactID.length() < 10);
    }
	
	@Test	// testing valid contact ID exactly 10 characters
    public void testValidContactID_10Chars() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        contact.setContactID("1234567890");
        String contactID = contact.getContactID();
        assertNotNull(contactID);
        assertEquals(10, contactID.length());
    }

    @Test	// contact ID longer than 10 characters should throw an exception
    public void testInvalidContactID_TooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertThrows(IllegalArgumentException.class, () -> contact.setContactID("12345678901"));
    }
    
    @Test	// contact ID null
    public void testInvalidContactID_Null() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertThrows(IllegalArgumentException.class, () -> contact.setContactID(null));
    }
    
    @Test	// contact ID not null
    public void testValidContactID_NotNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertNotNull(contact.getContactID());
    }

	// First Name tests
	
	@Test	// test name within 10 characters
    public void testValidFirstName() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }
	
	@Test	// test if first name is exactly 10 characters
    public void testValidFirstNameLength10Chars() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        contact.setFirstName("Sammanthaa");
        String firstName = contact.getFirstName();
        assertNotNull(firstName);
        assertEquals(10, firstName.length());
    }
    
	@Test	// test if first name is greater than 10 characters throws an exception
    public void testInvalidFirstName_TooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("JohnJohnJohn"));
    }
    

    @Test	// test if exception thrown if first name is null
    public void testInvalidFirstName_Null() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }
    
    @Test	// test if first name is not null
    public void testValidFirstName_NotNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertNotNull(contact.getFirstName());
    }

    
    // Last Name tests
    
    @Test	// Setting a valid last name within the 10-character limit
    public void testValidLastName() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }
    
    @Test	// test if last name is exactly 10 characters
    public void testValidLastNameLength10Chars() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        contact.setLastName("Smithsonia");
        String lastName = contact.getLastName();
        assertNotNull(lastName);
        assertEquals(10, lastName.length());
    }

    @Test	// Setting a last name longer than 10 characters should throw an exception
    public void testInvalidLastName_TooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("JohnsonSmith"));
    }
    
    @Test	// Setting a null last name should throw an exception
    public void testInvalidLastName_Null() {
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
    	assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }
    
    @Test	// test if last name is not null
    public void testValidLastName_NotNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertNotNull(contact.getLastName());
    }
    
    // phone tests
    
    @Test	// Setting a valid phone number with exactly 10 digits
    public void testValidPhone() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());
    }

    @Test	// Setting a null phone number should throw an exception
    public void testInvalidPhone_Null() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
    }
    
    @Test	// test if phone number is not null
    public void testValidPhone_NotNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertNotNull(contact.getPhone());
    }

    @Test	// Setting a phone number greater than 10 characters should throw an exception
    public void testPhoneTooLong() {
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345678901"));
    }
    
    @Test	// Setting a phone number with less than 10 characters should throw an exception
    public void testPhoneTooShort() {
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345"));
    }
    
    
    // address tests
    
    @Test	// Setting a valid address within the 30-character limit
    public void testValidAddress() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }
    
    @Test	// Setting a valid address exactly 30 characters
    public void testValidAddressLengthExactly30() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        contact.setAddress("Lorem ipsum dolor sit amet, ca");
        assertEquals("Lorem ipsum dolor sit amet, ca", contact.getAddress());
    }

    @Test	// Setting an address longer than 30 characters should throw an exception
    public void testInvalidAddress_TooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("This is a very long address that exceeds 30 characters"));
    }

    @Test	// Setting a null address should throw an exception
    public void testInvalidAddress_Null() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }
    
    @Test	// test if address is not null
    public void testValidAddress_NotNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Dr");
        assertNotNull(contact.getAddress());
    }

}
