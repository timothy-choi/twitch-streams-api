package com.example.twitch_api.Users;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserRepository _userRepository;

    @GetMapping("/") 
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> allUsers = _userRepository.findAll();

        return ResponseEntity.status(200).body(allUsers);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserByUserId(@PathVariable String userId) {
        var uId = UUID.fromString(userId);

        Users curr = _userRepository.findByUserId(uId);
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

    @PostMapping("/")
    public ResponseEntity<Users> createUser(@RequestBody Map<String, Object> reqBody) {
        try {
            Users currUser = _userRepository.findByTwitchUsername(reqBody.get("twitchUsername").toString());

            if (currUser != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            Users incomingUser = new Users(reqBody.get("username").toString(), reqBody.get("description").toString(), reqBody.get("twitchUsername").toString(), reqBody.get("twitchImageUrl").toString());

            _userRepository.save(incomingUser);

            return ResponseEntity.status(HttpStatus.OK).body(incomingUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{userId}") 
    public ResponseEntity deleteUser(@PathVariable String userId) {
        try {
            var uId = UUID.fromString(userId);

            Users currUser = _userRepository.findByUserId(uId);

            if (currUser == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            _userRepository.delete(currUser);

            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
}
