package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Qualifier("Dummy")
public class TrackDummyServiceImpl implements TrackService {


    TrackRepository trackRepository;


    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
     public Track saveTrack(Track track) {

        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAll() {


        return trackRepository.findAll();
    }

    @Override
    public void deleteTrack(int id)
    {
        if(trackRepository.existsById(id)){
            trackRepository.deleteById(id);
        }

    }

    @Override
    public void updateTrack(Track track)
    {
        if(trackRepository.existsById(track.getId()))
            return;trackRepository.save(track);

    }
    @Override
    public List<String> searchTrack(String name)
    {
        return trackRepository.trackSearch(name);
    }


}