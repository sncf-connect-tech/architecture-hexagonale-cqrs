package com.vsct.hexagonalcqrs.core.domain.users.commands;

import com.vsct.hexagonalcqrs.core.domain.users.entities.User;
import com.vsct.hexagonalcqrs.core.domain.users.events.UserCreatedEvent;
import com.vsct.hexagonalcqrs.core.domain.users.events.UserDeletedEvent;
import com.vsct.hexagonalcqrs.core.domain.users.events.UserUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class UserAggregate {

    @AggregateIdentifier
    private String email;
    private String name;

    public UserAggregate() {
        // TODO Subscription date
        // TODO Test cas marginaux
        // TODO Travis
    }

    // Command handlers

    @CommandHandler
    public UserAggregate(CreateUserCommand command) {
        User user = command.getUser();
        user.validateEmail();
        AggregateLifecycle.apply(new UserCreatedEvent(user));
    }

    @CommandHandler
    public void onUpdateUserCommand(UpdateUserCommand command) {
        command.getUser().validateNameIsDifferent(name);
        AggregateLifecycle.apply(new UserUpdatedEvent(command.getUser()));
    }

    @CommandHandler
    public void onDeleteUserCommand(DeleteUserCommand command) {
        AggregateLifecycle.apply(new UserDeletedEvent(command.getEmail()));
    }

    // Event handlers

    @EventSourcingHandler
    public void onUserCreatedEvent(UserCreatedEvent event) {
        this.email = event.getUser().getEmail();
        this.name = event.getUser().getName();
    }

    @EventSourcingHandler
    public void UserUpdatedEvent(UserUpdatedEvent event) {
        this.name = event.getUser().getName();
    }

    @EventSourcingHandler
    public void onUserDeletedEvent(UserDeletedEvent event) {
    }
}
