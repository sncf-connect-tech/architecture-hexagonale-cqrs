package com.vsct.hexagonalcqrs.core.infrastructure.users;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoUserRepository extends MongoRepository<UserDocument, String> {

    UserDocument findByEmail(String email);

    Boolean existsByEmail(String email);

    Optional<UserDocument> findOptionalByEmail(String email);
}
