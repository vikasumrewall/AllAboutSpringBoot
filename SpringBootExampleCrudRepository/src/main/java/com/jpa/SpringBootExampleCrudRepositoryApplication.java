package com.jpa;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.dao.UserRepository;
import com.jpa.entity.User;

@SpringBootApplication
public class SpringBootExampleCrudRepositoryApplication {

	public static void main(String[] args) {
	 ApplicationContext cx=	SpringApplication.run(SpringBootExampleCrudRepositoryApplication.class, args);
	
	 UserRepository userRepo=cx.getBean(UserRepository.class);
	 	User user=new User();
	 user.setName("vikas");
	 user.setCity("calcutta");
	
	 
	 User u=userRepo.save(user);
	 System.out.println("saved data="+u);
	 
	 List<User>  lstUser=  userRepo.findByName("vikas");
	 
	 for(User currUser: lstUser)
	 {
		 System.out.println(currUser.getName());
		 System.out.println(currUser.getCity());
		 System.out.println(currUser.getUserId());
		 
		 
	 }
	 
  lstUser=  userRepo.findByNameOrderByCity("vikas");
	 
	 for(User currUser: lstUser)
	 {
		 System.out.println(currUser.getName());
		 System.out.println(currUser.getCity());
		 System.out.println(currUser.getUserId());
		 
		 
	 }
	
	 System.out.println("findByNameAndCity");
	 
 lstUser=  userRepo.findByNameAndCity("vikas","delhi");
	 
	 for(User currUser: lstUser)
	 {
		 System.out.println(currUser.getName());
		 System.out.println(currUser.getCity());
		 System.out.println(currUser.getUserId());
		 
		 
	 }
	 
	 System.out.println("fetchAllHQLusers");
	 
 lstUser=  userRepo.fetchAllHQLusers();
	 
	 for(User currUser: lstUser)
	 {
		 System.out.println(currUser.getName());
		 System.out.println(currUser.getCity());
		 System.out.println(currUser.getUserId());
		 
		 
	 }
	 System.out.println("fetchHQLUsersAll");
lstUser=  userRepo.fetchHQLUsersAll();
	 
	 for(User currUser: lstUser)
	 {
		 System.out.println(currUser.getName());
		 System.out.println(currUser.getCity());
		 System.out.println(currUser.getUserId());
		 
		 
	 }
	 
	 
	 
	 System.out.println("********fetchUsersAllNativeQuery**********");
	 lstUser=  userRepo.fetchUsersAllNativeQuery();
	 	 
	 	 for(User currUser: lstUser)
	 	 {
	 		 System.out.println(currUser.getName());
	 		 System.out.println(currUser.getCity());
	 		 System.out.println(currUser.getUserId());
	 		 
	 		 
	 	 }
	 	 
	 	 
	 	 System.out.println("############fetchUsersHQlWithWhereClause####");
		 lstUser=  userRepo.fetchUsersHQlWithWhereClause("vikas","Delhi");
		 	 
		 	 for(User currUser: lstUser)
		 	 {
		 		 System.out.println(currUser.getName());
		 		 System.out.println(currUser.getCity());
		 		 System.out.println(currUser.getUserId());
		 		 
		 		 
		 	 }
	 
	 
	 
	 
	}

}
