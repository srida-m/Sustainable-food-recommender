package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/foods")
public class FoodRecomendationController {
   
    private String apikey = "bv53hJBqT64fFsc4nvsneo4PKsQn6df9X0hk7VLM";
    private final String baseUrl = "https://api.nal.usda.gov/fdc/v1/foods/search";


    
    public String Apikey(){
        return apikey;
    }
    public void setApikey(String apikey){
            this.apikey = apikey;
    }

        private String dish;
        String url = baseUrl + "?query=" + dish + "&diet=vegan&addRecipeImformation";

    
    // create an endpoint
    //https://localhost:8081/api.data.gov/foods/search
  

    public static class Sustainable_alt {



        
    }


    public String getApikey() {
        return apikey;
    }
    public String getBaseUrl() {
        return baseUrl;
    }
    public String getDish() {
        return dish;
    }
    public void setDish(String dish) {
        this.dish = dish;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchFoods(
        @RequestParam String query,
        @RequestParam(defaultValue = "vegan") String diet) {
            try {
                String url = baseUrl + "?query=" + query + "&api key=" + apikey;
                if (!diet.isEmpty()) {
                url += "&diet=" + diet;
                }
                RestTemplate restTemplate = new RestTemplate();
                String response = restTemplate.getForObject(url, String.class);

                return ResponseEntity.ok(response);

            } catch (Exception e) {

                return ResponseEntity.status(500).body("Error: " + e.getMessage());


            } 
        }
    }