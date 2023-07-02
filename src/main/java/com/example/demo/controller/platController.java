package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.plat;
import com.example.demo.repo.platRepository;


@RestController
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping("/plat")
public class platController {
	@Autowired
	private platRepository platsRepo;
	
//	 @PostMapping("/addPlat")
//	  public plat create(@RequestParam("file") MultipartFile file,
//	                     @RequestParam("title") String title,
//	                     @RequestParam("price") Float prix,
//	                     @RequestParam("description") String description) {
//	      try {
//	    	  plat p = new plat();
//	          p.setTitre(title);
//	          p.setDescription(description);
//	          p.setPrix(prix);
//
//	          String destinationPath = "C:\\Users\\noura\\Desktop\\img";
//	          file.transferTo(new File(destinationPath + file.getOriginalFilename()));
//	          p.setPhoto(file.getOriginalFilename());
//	          return platsRepo.save(p);
//	      } catch (IOException e) {
//	          e.printStackTrace();
//	          return null; // Return an appropriate error response
//	      }
//	 }
	 
	    @PostMapping("/addPlat")
	    public plat addPlat(@RequestBody plat c){ 
	        return platsRepo.save(c);
	    }

		@DeleteMapping("/DeleteP/{id}")
		public ResponseEntity<String> deleteC(@PathVariable("id") Long id) {
			platsRepo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"deleted\"}");
		}
	    //update
	    @PutMapping("/UpdatePlat/{id}")
	    public plat updateC(@PathVariable("id") Long id,@RequestBody plat c){
	        c.setId(id);
	        return platsRepo.save(c);
	    }
		@GetMapping()
	 	public List<plat>lstplats(){
			return platsRepo.findAll();
		}


		@GetMapping("/getPlat/{id}")
		public plat getPlat(@PathVariable("id") Long id) {
			return platsRepo.findById(id).get();
		}
	    

}