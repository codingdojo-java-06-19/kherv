package com.codingdojo.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.Lookify.models.Song;
import com.codingdojo.Lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}

	//returns all songs
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
	
	//create a song
	public Song createSong(Song s) {
		return songRepository.save(s); //Repository extended the CrudRepository
	}
	
	//retrieve a song by id
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}
		else {
			return null;
		}
	}
	
	//update....not needed/used
	//public Language updateSong(
	
	
	//delete
	public void deleteSong(Long id ) {
		Song song = findSong(id);
		songRepository.delete(song);
	}
	
	//find top 10
	public List<Song> findTopTen() {
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
	//find by search string, Artist:
	public List<Song> findArtist(String search) {
		return songRepository.findByArtistContaining(search);
	}
	
	
	
}  // end SongService class
