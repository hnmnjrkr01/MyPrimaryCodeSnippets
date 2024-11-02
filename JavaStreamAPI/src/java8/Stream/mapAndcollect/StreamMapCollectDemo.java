package java8.Stream.mapAndcollect;

import java.util.ArrayList;
import java.util.List;

public class StreamMapCollectDemo {
	
	public static void main(String []args) {
		
		List<User> users = new ArrayList<>();
		
		users.add(new User(1,"heena","abcdef","heenajava10@gmail.com"));
		users.add(new User(2,"haider","uvwxyz","haider@gmail.com"));
		users.add(new User(3,"abrahem","a1b2c3","abrahem@gmail.com"));
		users.add(new User(4,"bablu","123abc","bablu@gmail.com"));
		users.add(new User(5,"tommy","456def","tommy@gmail.com"));
		
		List<UserDTO> userDTO = new ArrayList<>();
		for(User user: users) {
			userDTO.add(new UserDTO(user.getId(),user.getUserName(),user.getEmail()));
		}
		
		for(UserDTO userdto : userDTO)
			System.out.println(userdto);
		
		//Java 8 Map Collect
		
		System.out.println("------------------------------------------------------------");
		users.stream().
			map((User user)->new UserDTO(user.getId(),user.getUserName(),user.getEmail())).
			forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
