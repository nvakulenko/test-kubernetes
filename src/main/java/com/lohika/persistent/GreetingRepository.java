package com.lohika.persistent;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends MongoRepository<Greeting, String> {

}
