package com.kodnest.tunehub.service;


import java.util.List;

import com.kodnest.tunehub.entity.Song;

public interface SongService {

	 List<Song> fetchAllSongs();

	 boolean songExists(String name);

 void updateSong(Song song);

	 void saveSong(Song song);

}