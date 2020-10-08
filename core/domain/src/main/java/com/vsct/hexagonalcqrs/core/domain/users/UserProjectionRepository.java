package com.vsct.hexagonalcqrs.core.domain.users;

import com.vsct.hexagonalcqrs.core.domain.users.events.UserCreatedEvent;
import com.vsct.hexagonalcqrs.core.domain.users.events.UserDeletedEvent;
import com.vsct.hexagonalcqrs.core.domain.users.events.UserUpdatedEvent;
import com.vsct.hexagonalcqrs.core.domain.users.queries.FindAllUsers;
import com.vsct.hexagonalcqrs.core.domain.users.queries.FindUserByEmailQuery;
import com.vsct.hexagonalcqrs.core.domain.users.queries.UserExistsQuery;
import com.vsct.hexagonalcqrs.core.domain.users.queries.views.UserView;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;

import java.util.List;
import java.util.Optional;

public interface UserProjectionRepository {

    // Event handlers

    @EventHandler
    void onUserCreatedEvent(UserCreatedEvent event);

    @EventHandler
    void onUserUpdatedEvent(UserUpdatedEvent event);

    @EventHandler
    void onUserDeletedEvent(UserDeletedEvent event);

    // Query handlers

    @QueryHandler
    Boolean onUserExistsQuery(UserExistsQuery query);

    @QueryHandler
    Optional<UserView> onFindUserByEmailQuery(FindUserByEmailQuery query);

    @QueryHandler
    List<UserView> onFindUserByEmailQuery(FindAllUsers query);
}
