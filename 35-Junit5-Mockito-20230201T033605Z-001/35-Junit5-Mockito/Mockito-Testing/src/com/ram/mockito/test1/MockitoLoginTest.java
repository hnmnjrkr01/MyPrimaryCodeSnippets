package com.ram.mockito.test1;

import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class MockitoLoginTest {
	private LoginServiceImpl service;
	private UserDAO mockDao;

	@Before
	public void setup() {
		service = new LoginServiceImpl();
		mockDao = EasyMock.createMock(UserDAO.class);
		service.setUserDao(mockDao);
	}
	@Test
	public void testLogin(){
		User user = new User();
		String username="ram";
		String password = "ram123";
		/* expect tells your mock object to expect the method */
		EasyMock.expect
		(mockDao.loadByUserNameAndPassword(username, password))
		.andReturn(user); //tells mock object what to return after this method is called
		
		/* replay() tells EasyMock : "we are done declaring 
		 * our expectations. Its time to run what we told you" */
		EasyMock.replay(mockDao);
		
		/* assertTrue() does two things:
		 * 1. executes the code to be tested
		 * 2. Tests that the result is true
		 */
		assertTrue(service.login(username, password));
		
		/* verify() : tells EasyMock to validate that 
		 * all expected method calls were executed and in the correct order */
		EasyMock.verify(mockDao);
	}
}
