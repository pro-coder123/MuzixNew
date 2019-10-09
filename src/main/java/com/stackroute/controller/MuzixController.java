package com.stackroute.controller;


import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/v1")
public class MuzixController {
    TrackService trackService ;

    @Autowired
    public MuzixController(TrackService trackService)
    {

        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveUser(@RequestBody Track track)
    {
        ResponseEntity responseEntity;

        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<>(track, HttpStatus.CREATED);
        } catch (Exception e){

            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/track")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<List<Track>>(trackService.getAll(),HttpStatus.OK);
    }


    @PutMapping(value="/track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track)
    {


        trackService.updateTrack(track);
        ResponseEntity responseEntity = new ResponseEntity<Track>(track,HttpStatus.OK);

        return responseEntity;
    }

    @DeleteMapping(value = "/track/{trackId}")
    public ResponseEntity<?> removeTrack(@PathVariable int trackId)
    {

        trackService.deleteTrack(trackId);
        ResponseEntity<?> responseEntity = new ResponseEntity<String>(trackId+"is deleted",HttpStatus.OK);

        return responseEntity;
    }

}
