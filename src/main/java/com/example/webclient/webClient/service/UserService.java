package com.example.webclient.webClient.service;

import com.example.webclient.webClient.config.UserProbes;
import com.example.webclient.webClient.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private UserProbes userProbes;
    private WebClient webClient;

    public UserService(UserProbes userProbes, WebClient webClient) {
        this.userProbes = userProbes;
        this.webClient = WebClient.create(userProbes.getBaserurl());
    }

    public User getUser(Integer id){
        User user = webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(User.class)
                .block();
        return user;
    }
    public List<User> getAllUsers(){
        User[] users = webClient.get()
                .uri("/")
                .retrieve()
                .bodyToMono(User[].class)
                .block();
        return Arrays.stream(users).toList();
    }
    public User addUser(User user){
        User resposneUser = webClient.post()
                .uri("/", user)
                .body(Mono.just(user),User.class)
                .retrieve()
                .bodyToMono(User.class)
                .block();
        return resposneUser;
    }

}
