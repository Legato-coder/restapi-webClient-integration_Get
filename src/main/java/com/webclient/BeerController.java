package com.webclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class BeerController {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public BeerController(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/beers")
    public Mono<String> getBeers() {
        WebClient webClient = webClientBuilder.build();
        return webClient.get()
                .uri("https://api.sampleapis.com/beers/ale")
                .retrieve()
                .bodyToMono(String.class);
    }
}
