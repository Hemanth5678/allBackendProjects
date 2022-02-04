package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.repository.MoviesRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.WebseriesRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.MoviesService;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.WebseriesService;

@SpringBootApplication
public class Main2 {

	public static void main(String[] args) {
	ConfigurableApplicationContext applicationContext= SpringApplication.run(Zee5appspringbootApplication.class, args);
	
	
//	Role role = new Role();
//	role.setRoleName(EROLE.ROLE_ADMIN);
//	
//	Role role2 = new Role();
//	role2.setRoleName(EROLE.ROLE_USER);
//	
//	RoleService roleService = applicationContext.getBean(RoleService.class);
//	RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
////	
//	System.out.println(roleService.addRole(role));
//	System.out.println(roleService.addRole(role2));
////	
//	
//	UserRepository repository = applicationContext.getBean(UserRepository.class);
//	Register register;
//	register = new Register("Hemu004","Hemanth","A V","hemu25@gmail.com","iforgotit",null,null);
//	register.setContactnumber(new BigDecimal("9975477765"));
//	Set<Role> roles = new HashSet<>();
//	roles.add(roleRepository.findById(1).get());
//	roles.add(roleRepository.findById(2).get());
//	register.setRoles(roles);
//	
//	UserService service = applicationContext.getBean(UserService.class);
//	try {
//		System.out.println(service.addUser(register));
//	} catch (AlreadyExistsException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
	//System.out.println(repository.existsByEmailAndContactnumber("hemu6@gmail.com",new BigDecimal("9975477765")));
	
	
//	MoviesRepository repository1 = applicationContext.getBean(MoviesRepository.class);
//	Movies Movies;
//	Movies = new Movies("Mov0001","Avengers",18,"Chrisevans, Robert downey jr","action","youtube","2011","English");
//	
//	MoviesService service1 = applicationContext.getBean(MoviesService.class);
//	System.out.println(service1.addMovie(Movies));
//	
//	System.out.println(repository1.existsByName("Avengers"));
//	System.out.println(repository1.findByNameAndLanguage("Avengers", "English"));
	
	WebseriesRepository repository = applicationContext.getBean(WebseriesRepository.class);
	WebseriesService webService = applicationContext.getBean(WebseriesService.class);
	EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
	
	Webseries series1 = new Webseries("SER001", "Mirzapur", 18, "Vikram", "action", "youtube", "2018", "Hindi", 9, null);
	System.out.println(webService.addWebseries(series1));
	
	Episodes episode = new Episodes("Ep001", "Blablabla", 45, series1);
	System.out.println(episodeService.addEpisode(episode));
	
	applicationContext.close();
	}
}

