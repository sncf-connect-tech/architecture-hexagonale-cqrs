package com.vsct.hexagonalcqrs.core.infrastructure.users;

import com.vsct.hexagonalcqrs.core.domain.users.entities.User;
import com.vsct.hexagonalcqrs.core.domain.users.queries.views.UserView;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("user")
public class UserDocument {
    @Id
    private String id;
    private String email;
    private String name;
    private LocalDateTime subscriptionDate;

    public UserDocument(String id, User user, LocalDateTime subscriptionDate) {
        this.id = id;
        email = user.getEmail();
        name = user.getName();
        this.subscriptionDate = subscriptionDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserView toUserView() {
        return new UserView(email, name, subscriptionDate);
    }
}
