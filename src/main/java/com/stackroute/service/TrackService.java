package com.stackroute.service;

import com.stackroute.domain.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    public Track saveTrack(Track track);

    public List<Track> getAll();

    public void deleteTrack(int id);


    public void updateTrack(Track track);


}
