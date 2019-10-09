package com.stackroute.controller;


import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/v1")
@Api(value="trackList", description="songs and their description")

public class MuzixController {
    TrackService trackService ;

    @Autowired
    public MuzixController(TrackService trackService)
    {

        this.trackService = trackService;
    }
    @ApiOperation(value = "adds new track ")
    @PostMapping("track")
    public ResponseEntity<?> saveUser(@RequestBody Track track) throws TrackAlreadyExistException
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

    @ApiOperation(value = "updates the existing track with the new track")
    @PutMapping(value="/track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException
    {


        trackService.updateTrack(track);
        ResponseEntity responseEntity = new ResponseEntity<Track>(track,HttpStatus.OK);

        return responseEntity;
    }
    @ApiOperation(value = "deletes existing track")

    @DeleteMapping(value = "/track/{trackId}")
    public ResponseEntity<?> removeTrack(@PathVariable int trackId) throws TrackNotFoundException
    {

        trackService.deleteTrack(trackId);
        ResponseEntity<?> responseEntity = new ResponseEntity<String>(trackId+"is deleted",HttpStatus.OK);

        return responseEntity;
    }
    @ApiOperation(value = "searches track with given name")

    @GetMapping(value = "/track/{trackName}")
    public ResponseEntity<?> searchTrack(@PathVariable String trackName)
    {
        return new ResponseEntity<>(trackService.searchTrack(trackName),HttpStatus.OK);
    }

}
