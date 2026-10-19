package ch.zhaw.avalanger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.avalanger.model.Avalange;
import ch.zhaw.avalanger.repository.AvalangeRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/avalange")
public class AvalangeController {
    private final AvalangeRepository avalangeRepository;

    public AvalangeController(AvalangeRepository avalangeRepository) {
        this.avalangeRepository = avalangeRepository;
    }

    @GetMapping({ "", "/{country}" })
    public String getAllAvelanges(@PathVariable(required = false) String country,
            @RequestParam(required = false) String state) {
        return "No avelanges found for country: " + country + ", state: " + state;
    }

    @PostMapping
    public ResponseEntity<Avalange> createAvalange(@RequestBody Avalange avalange) {
        Avalange savedAvalange = avalangeRepository.save(avalange);
        return ResponseEntity.ok(savedAvalange);
    }
}
