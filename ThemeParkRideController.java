package project.architecture.entity;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import project.architecture.repository.ThemeParkRideRepository;

import javax.validation.Valid;
import java.awt.*;

public class ThemeParkRideController {
    private final ThemeParkRideRepository themeParkRideRepository;

    public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {
        this.themeParkRideRepository = themeParkRideRepository;
    }

    @GetMapping(value="/ride", produces=

            PageAttributes.MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ThemeParkRide> getRide(){
        return themeParkRideRepository.findAll();

    }
    @GetMapping (value= "/ride/{id}",produces=
            PageAttributes.MediaType.APPLICATION_JSON_VALUE)

    public ThemeParkRide getRide (@PathVariable long id){
        return  themeParkRideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("invalide ride id%",id)));


    }
@PostMapping(value = "/ride", consumes =

        MediaType.APPLICATION_JSON_VALUE,produces =
MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide){
return themeParkRideRepository.save(new ThemeParkRide());
}

}
