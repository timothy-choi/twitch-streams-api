package com.example.twitch_api.Users;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID UserId;

    private String username;

    private String description;

    private String twitchUsername;

    private String profileImageUrl;

    public Users(String Username, String Description, String TwitchUsername, String ProfileImageUrl) {
        username = Username;
        description = Description;
        twitchUsername = TwitchUsername;
        profileImageUrl = ProfileImageUrl;
    }

    public UUID getUserId() {
        return this.UserId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getTwitchUsername() {
        return this.twitchUsername;
    }

    public void setTwitchUsername(String TwitchUsername) {
        this.twitchUsername = TwitchUsername;
    }

    public String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    public void setProfileImageUrl(String ImgUrl) {
        this.profileImageUrl = ImgUrl;
    }
}
