package j2ee.fullStack.basepackage.exceptions;

public class UserDoesNotExist extends RuntimeException{

	
	public UserDoesNotExist(Long userId) {
		super("User with the ID  :"+userId+" does not exist.");
	}
	public UserDoesNotExist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDoesNotExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserDoesNotExist(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserDoesNotExist(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserDoesNotExist(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
