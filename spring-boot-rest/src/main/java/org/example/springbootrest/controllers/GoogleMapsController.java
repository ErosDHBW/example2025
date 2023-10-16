package org.example.springbootrest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/googlemaps")
public class GoogleMapsController {
    Logger log = LoggerFactory.getLogger(GoogleMapsController.class);

    @GetMapping("/markers")
    public String getMarkers() throws IOException {
        File resource = new ClassPathResource("data/markers.json").getFile();
        String markers = new String(Files.readAllBytes(resource.toPath()));

        log.info(markers);

        return markers;
    }
}
