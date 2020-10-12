package com.vsct.hexagonalcqrs.core.presentation.io;

import com.vsct.hexagonalcqrs.core.domain.users.queries.views.UserView;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class UserOutput implements Serializable {

    private String email;
    private String name;
    private LocalDate subscriptionDate;

    public UserOutput() {
    }

    public UserOutput(String email, String name, LocalDate subscriptionDate) {
        this.email = email;
        this.name = name;
        this.subscriptionDate = subscriptionDate;
    }

    public UserOutput(UserView userView) {
        this.email = userView.getEmail();
        this.name = userView.getName();
        this.subscriptionDate = userView.getSubscriptionDate();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    @Override
    public String toString() {
        return "UserOutput{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", subscriptionDate=" + subscriptionDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOutput that = (UserOutput) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(name, that.name) &&
                Objects.equals(subscriptionDate, that.subscriptionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, subscriptionDate);
    }
}
