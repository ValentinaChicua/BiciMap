package com.example.BiciMap.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GraphHopperService {

    private final String apiKey = "566ed7a9-5e2d-4767-bba4-215341cd0c38";  // Api Key graphhopper dominio de Eduard Patiño
    private final String apiUrl = "https://graphhopper.com/api/1/route";

    public String obtenerRuta(double inicioLat, double inicioLon, double finLat, double finLon) {
        RestTemplate restTemplate = new RestTemplate();

        String url = apiUrl + "?key=" + apiKey + "&point=" + inicioLat + "," + inicioLon + "&point=" + finLat + "," + finLon;

        System.out.println(url);
        System.out.println(restTemplate.getForObject(url, String.class));

        return restTemplate.getForObject(url, String.class);
    }
}

