package com.gamertings.backend.controller;

import com.gamertings.backend.service.IGDBService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
@CrossOrigin(origins = "http://localhost:4200")
public class IGDBController {

    private final IGDBService igdbService;

    public IGDBController(IGDBService igdbService) {
        this.igdbService = igdbService;
    }

    @GetMapping("/search")
    public String searchGames(@RequestParam String name) {
        // Wir rufen den Service auf und geben das Ergebnis (JSON) zurück
        System.out.println("Suche nach: " + name);
        return igdbService.getGameByName(name);
    }
}
