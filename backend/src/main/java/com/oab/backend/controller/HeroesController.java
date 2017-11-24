package com.oab.backend.controller;

import com.oab.backend.domain.Hero;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
public class HeroesController {

    private List<Hero> heroes;

    @RequestMapping("heroes")
    public List<Hero> findHeroes() {
        heroes = Arrays.asList(
                new Hero(1L, "Superman", "fly"),
                new Hero(2L, "Bart Simpson", "drink"),
                new Hero(3L, "Batman", "nice car"),
                new Hero(4L, "Catwoman", "7 life")
        );
        return heroes;
    }

    @RequestMapping("heroes/{id}")
    public Hero getHero(@PathVariable Long id) {
        return heroes.stream().filter(hero -> hero.getId().equals(id)).findFirst().get();
    }
}
