/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.megacitycab.webservice;

import com.megacitycab.webservice.filter.CorsFilter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Sumedh Adhikari
 */
@ApplicationPath("/api") // Base path for all RESTful endpoints
public class MegaCityCabApplication extends ResourceConfig { // Extend ResourceConfig
    public MegaCityCabApplication() {
        packages("com.megacitycab.webservice"); // Scan for JAX-RS resources in this package
        register(CorsFilter.class);  // Register the CORS filter
    }
}
