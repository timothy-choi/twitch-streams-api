package com.example.twitch_api.Users;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserRepository _userRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserByUserId(@PathVariable UUID userId) {
        Users curr = _userRepository.findByUserId(userId);
        if (curr == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(curr);
        }
        return ResponseEntity.status(HttpStatus.OK).body(curr);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable String username) {
        Users curr = _userRepository.findByUsername(username);
        if (curr == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(curr);
        }
        return ResponseEntity.status(HttpStatus.OK).body(curr);
    }

    @GetMapping("/twitchUsername/{twitchUsername}")
    public ResponseEntity<Users> getUserByTwitchUsername(@PathVariable String twitchUsername) {
        Users curr = _userRepository.findByTwitchUsername(twitchUsername);
        if (curr == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(curr);
        }
        return ResponseEntity.status(HttpStatus.OK).body(curr);
    }
}
