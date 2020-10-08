package com.vsct.hexagonalcqrs.core.domain.users.queries;

import com.vsct.hexagonalcqrs.core.domain.axon.AxonQuery;
import com.vsct.hexagonalcqrs.core.domain.users.queries.views.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserQueries {

    private final AxonQuery axonQuery;

    @Autowired
    public UserQueries(AxonQuery axonQuery) {
        this.axonQuery = axonQuery;
    }

    public boolean userExists(String email) {
        return axonQuery.query(new UserExistsQuery(email), Boolean.class);
    }

    public Optional<UserView> findUser(String email) {
        return axonQuery.queryOptional(new FindUserByEmailQuery(email), UserView.class);
    }

    public List<UserView> findAllUsers() {
        return axonQuery.queryList(new FindAllUsers(), UserView.class);
    }
}
