package ch.zhaw.avalanger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.avalanger.model.Avalange;
import ch.zhaw.avalanger.repository.AvalangeRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/avalange")
@RequiredArgsConstructor
public class AvalangeController {
private final AvalangeRepository avalangeRepository;

    @GetMapping({ "", "/{country}" })
    public String getAllAvelanges(@PathVariable(required = false) String country,
            @RequestParam(required = false) String state) {
        return "No avelanges found for country: " + country + ", state: " + state;
    }

    @PostMapping
    public String createAvalange(@RequestBody Avalange avalange) {
        avalangeRepository.save(avalange);
        return "Avalange created: " + avalange.getCountry() + ", " + avalange.getState() + ", "
                + avalange.getDescription();
    }
}