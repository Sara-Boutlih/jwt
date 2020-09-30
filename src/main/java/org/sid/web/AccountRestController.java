package org.sid.web;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sid.dao.RoleRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm){
		if(!userForm.getPassword().equals(userForm.getRepassword())) throw new  RuntimeException("you must comfirm your PSW");
		AppUser user=accountService.findUserByUsername(userForm.getUsername());
		if(user!=null)
			throw new  RuntimeException("this user exist");
		AppUser appUser=new AppUser();
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());
		accountService.saveUser(appUser);
		accountService.addRoleToUser(userForm.getUsername(), "USER");
		return appUser;
	}
	 
	@GetMapping("/displayUser")
	public List<AppUser> displayUser(){
		return userRepository.findAll();		
	}
	
	@PostMapping("/ajouterUtilisateur")
	public @ResponseBody AppUser ajouterUtilisateur(
			@RequestParam(name="nom" , defaultValue="") String nom,
			@RequestParam(name="password" , defaultValue="") String password,
			@RequestParam(name="email" , defaultValue="") String email,
			@RequestParam(name="idRole" , defaultValue="") Long idRole
			){
		
		AppUser utilisateur=new AppUser();
		AppRole role=roleRepository.getOne(idRole);
		Set<AppRole> idR=new HashSet<>();
		
		idR.add(role);
		utilisateur.setUsername(nom);
		utilisateur.setPassword(password);
		utilisateur.setEmail(email);
		utilisateur.setRoles(idR);
		
		return userRepository.save(utilisateur);
		
	}

}
