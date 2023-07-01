package com.example.demo.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.plat;
import com.example.demo.repo.platRepository;


@RestController
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping("/plat")
public class platController {
	@Autowired
	private platRepository platsRepo;
	
	 @PostMapping("/addPlat")
	  public plat create(@RequestParam("file") MultipartFile file,
	                     @RequestParam("title") String title,
	                     @RequestParam("price") Float prix,
	                     @RequestParam("description") String description) {
	      try {
	    	  plat p = new plat();
	          p.setTitre(title);
	          p.setDescription(description);
	          p.setPrix(prix);

	          String destinationPath = "C:\\Users\\noura\\Desktop\\img";
	          file.transferTo(new File(destinationPath + file.getOriginalFilename()));
	          p.setPhoto(file.getOriginalFilename());
	          return platsRepo.save(p);
	      } catch (IOException e) {
	          e.printStackTrace();
	          return null; // Return an appropriate error response
	      }
	 }
	 
	    @PostMapping("/addPlat")
	    public plat addPlat(@RequestBody plat c){ 
	        return platsRepo.save(c);
	    }

	    @DeleteMapping("/DeleteC/{id}")
	    public String deleteC(@PathVariable("id") Long id){
	    	platsRepo.deleteById(id);
	        return "deleted";
	    }
	    //update
	    @PutMapping("/UpdatePlat/{id}")
	    public plat updateC(@PathVariable("id") Long id,@RequestBody Cinema c){
	        c.setId(id);
	        return platsRepo.save(c);
	    }
	    

}