package com.KDGroup.Knowledge_Deck.Menu;

import com.KDGroup.Knowledge_Deck.models.DeckRole;

public class LoginForm {
    private Long id;
    private String email_id;
    private String password;
    private boolean forgot_password;
    private DeckRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isForgot_password() {
        return forgot_password;
    }

    public void setForgot_password(boolean forgot_password) {
        this.forgot_password = forgot_password;
    }

    public DeckRole getRole() {
        return role;
    }

    public void setRole(DeckRole role) {
        this.role = role;
    }

}
