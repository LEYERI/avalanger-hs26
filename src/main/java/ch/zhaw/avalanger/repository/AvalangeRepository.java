package ch.zhaw.avalanger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.avalanger.model.Avalange;

public interface AvalangeRepository extends MongoRepository<Avalange, String> {
    
}
