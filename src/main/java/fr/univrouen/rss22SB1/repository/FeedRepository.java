package fr.univrouen.rss22SB1.repository;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import fr.univrouen.rss22SB1.models.Feed;

@Repository
public interface FeedRepository extends MongoRepository<Feed, String>{
	
	@Query(value="{'title' : ?0, 'pubDate' : ?1, 'copyright' : ?2 }")
	Optional<Feed> findIfExist(String title, String pubDate, String copyright);

}
