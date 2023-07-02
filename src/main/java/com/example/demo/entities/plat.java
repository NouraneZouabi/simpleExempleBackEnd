package com.example.demo.entities;

import jakarta.persistence.*;


@Entity
public class plat {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    private String titre;
	    private String description;
	    private double prix;

		@Lob
	    private String photo;
	    
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getTitre() {
			return titre;
		}
		public void setTitre(String titre) {
			this.titre = titre;
		}
		public double getPrix() {
			return prix;
		}
		public void setPrix(double prix) {
			this.prix = prix;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		public plat() {
			super();
		}
		public plat(long id, String titre, String description, double prix, String photo) {
			super();
			this.id = id;
			this.titre = titre;
			this.description = description;
			this.prix = prix;
			this.photo = photo;
		}

		
	    
	    

}
