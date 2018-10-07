package uk.co.rowney.gamenight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.rowney.gamenight.model.Randomise.SeriesRandomiser;
import uk.co.rowney.gamenight.objects.Series;

import java.io.FileNotFoundException;

@RestController
public class SeriesRequestController {
    @RequestMapping("/series")
    public String getRandomSeries() throws FileNotFoundException {

        SeriesRandomiser seriesRandomiser = new SeriesRandomiser();
        Series chosenSeries = seriesRandomiser.randomSeries();

        return "Random series selected: " + chosenSeries.getName();
    }

    @RequestMapping("/series/team")
    public String getRandomTeamSeries() throws FileNotFoundException {

        SeriesRandomiser seriesRandomiser = new SeriesRandomiser();
        Series chosenSeries = seriesRandomiser.randomTeamSeries();

        return "Random team series selected: " + chosenSeries.getName();
    }

    @RequestMapping("/series/ffa")
    public String getRandomFfaSeries() throws FileNotFoundException {

        SeriesRandomiser seriesRandomiser = new SeriesRandomiser();
        Series chosenSeries = seriesRandomiser.randomFfaSeries();

        return "Random FFA series selected: " + chosenSeries.getName();
    }
}
