package com.example.twitch_api.Users;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    public Users findByUserId(UUID userId);

    public Users findByUsername(String username);

    public Users findByTwitchUsername(String twitchUsername);
}
