package ch.zhaw.avalanger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.avalanger.model.Avalange;
import ch.zhaw.avalanger.model.AvalangeCreateDTO;
import ch.zhaw.avalanger.repository.AvalangeRepository;

import java.util.List;

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
    public ResponseEntity<List<Avalange>> getAllAvelanges(@PathVariable(required = false) String country,
            @RequestParam(required = false) String state) {
        return ResponseEntity.ok(avalangeRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Avalange> createAvalange(@RequestBody AvalangeCreateDTO avalange) {
        Avalange avalangeToSave = new Avalange(avalange.getCountry(), avalange.getDescription());
        Avalange savedAvalange = avalangeRepository.save(avalangeToSave);
        return ResponseEntity.ok(savedAvalange);
    }
}
