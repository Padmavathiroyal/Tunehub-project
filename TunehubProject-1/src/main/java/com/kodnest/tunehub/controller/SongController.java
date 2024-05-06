package com.kodnest.tunehub.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.SongService;

@Controller
public class SongController {

	@Autowired
	SongService songService;

	@PostMapping("/addsongs")
	public String addsong(@ModelAttribute Song song){
		
		String name = song.getName();

		boolean songExists = songService.songExists(name);
		if(songExists==false) {
			songService.saveSong(song);	
			System.out.println("Song added Successfully");
		}
		else {
			System.out.println("Song already exists");
		}
		return "adminhome";
	}

	@GetMapping("/viewsongs")
	public String viewsongs(Model model) {
		boolean premium = false;
		if(premium) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		System.out.println(songList);
		return "viewsongs";
	}
		else {
			return "pay";
		}
	}

	@PostMapping("/playsongs")
	public String playsongs(Model model) {
	boolean premium = false;
		if(premium) {
			List<Song> songList = songService.fetchAllSongs();
			model.addAttribute("songs", songList);
			return "displaysongs";
		}else {
			return "subscriptionform";
		}
	}

}











