package com.vsct.hexagonalcqrs.core.infrastructure.users;

import com.vsct.hexagonalcqrs.core.domain.users.UserProjectionRepository;
import com.vsct.hexagonalcqrs.core.domain.users.events.UserCreatedEvent;
import com.vsct.hexagonalcqrs.core.domain.users.events.UserDeletedEvent;
import com.vsct.hexagonalcqrs.core.domain.users.events.UserUpdatedEvent;
import com.vsct.hexagonalcqrs.core.domain.users.queries.FindAllUsers;
import com.vsct.hexagonalcqrs.core.domain.users.queries.FindUserByEmailQuery;
import com.vsct.hexagonalcqrs.core.domain.users.queries.UserExistsQuery;
import com.vsct.hexagonalcqrs.core.domain.users.queries.views.UserView;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class MongoUserProjectionRepository implements UserProjectionRepository {

    private final MongoUserRepository mongoUserRepository;

    @Autowired
    public MongoUserProjectionRepository(MongoUserRepository mongoUserRepository) {
        this.mongoUserRepository = mongoUserRepository;
    }

    // Event handlers

    @Override
    @EventHandler
    public void onUserCreatedEvent(UserCreatedEvent event) {
        String newId = UUID.randomUUID().toString();
        UserDocument userDocument = new UserDocument(newId, event.getUser(), LocalDate.now());
        mongoUserRepository.save(userDocument);
    }

    @Override
    @EventHandler
    public void onUserUpdatedEvent(UserUpdatedEvent event) {
        UserDocument existingUser = mongoUserRepository.findByEmail(event.getUser().getEmail());
        existingUser.setName(event.getUser().getName());
        mongoUserRepository.save(existingUser);
    }

    @Override
    @EventHandler
    public void onUserDeletedEvent(UserDeletedEvent event) {
        UserDocument existingUser = mongoUserRepository.findByEmail(event.getEmail());
        mongoUserRepository.delete(existingUser);
    }

    // Query handlers

    @Override
    @QueryHandler
    public Boolean onUserExistsQuery(UserExistsQuery query) {
        return mongoUserRepository.existsByEmail(query.getEmail());
    }

    @Override
    @QueryHandler
    public Optional<UserView> onFindUserByEmailQuery(FindUserByEmailQuery query) {
        return mongoUserRepository.findOptionalByEmail(query.getEmail())
                .map(UserDocument::toUserView);
    }

    @Override
    @QueryHandler
    public List<UserView> onFindUserByEmailQuery(FindAllUsers query) {
        return mongoUserRepository.findAll()
                .stream()
                .map(UserDocument::toUserView)
                .collect(Collectors.toList());
    }
}
