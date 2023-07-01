package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.plat;
import com.example.demo.repo.platRepository;

public class PlatServiceImpl {
    @Autowired
    private platRepository platRepo;
    
    public plat AddPlat(plat p) {
    	return platRepo.save(p);
    }
}
