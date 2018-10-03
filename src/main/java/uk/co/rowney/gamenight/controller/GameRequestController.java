package uk.co.rowney.gamenight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.rowney.gamenight.model.Randomise;
import uk.co.rowney.gamenight.objects.Game;

import java.io.FileNotFoundException;

@RestController
public class GameRequestController {
    @RequestMapping("/game")
    public String index() throws FileNotFoundException {

        Randomise randomise = new Randomise();
        Game chosenGame = randomise.randomGame();

        return "Random game selected: " + chosenGame.getName();
    }
}
