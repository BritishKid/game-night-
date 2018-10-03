package uk.co.rowney.gamenight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.rowney.gamenight.model.Randomise;
import uk.co.rowney.gamenight.objects.Series;

import java.io.FileNotFoundException;

@RestController
public class SeriesRequestController {
    @RequestMapping("/series")
    public String index() throws FileNotFoundException {

        Randomise randomise = new Randomise();
        Series chosenSeries = randomise.randomSeries();

        return "Random series selected: " + chosenSeries.getName();
    }
}
