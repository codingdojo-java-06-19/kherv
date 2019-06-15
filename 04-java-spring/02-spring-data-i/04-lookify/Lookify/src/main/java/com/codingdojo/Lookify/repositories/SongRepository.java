package com.codingdojo.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.Lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long>{ // <>contains the class of the model file, long is type of its ID
	List<Song> findAll();
	List<Song> findByArtistContaining(String search);
//	List<Song> findTop10ByRatingDesc();

}
