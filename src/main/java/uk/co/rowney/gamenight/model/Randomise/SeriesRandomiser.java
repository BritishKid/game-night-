package uk.co.rowney.gamenight.model.Randomise;

import uk.co.rowney.gamenight.model.JsonParser;
import uk.co.rowney.gamenight.model.filter.Filter;
import uk.co.rowney.gamenight.model.filter.SeriesFilter;
import uk.co.rowney.gamenight.objects.Series;

import java.io.FileNotFoundException;
import java.util.List;

public class SeriesRandomiser extends CommonRandomiser {
    private JsonParser jsonParser = new JsonParser();
    private List<Series> series;

    public Series randomSeries() throws FileNotFoundException {
        series = jsonParser.getSeriesList();
        return series.get(getRandomForList(series.size()));
    }

    public Series randomTeamSeries() throws FileNotFoundException {
        Filter seriesFilter = new SeriesFilter();
        series = jsonParser.getSeriesList();
        List<Series> teamSeries = (List<Series>) seriesFilter.listWithTeam(series);

        return teamSeries.get(getRandomForList(teamSeries.size()));
    }

    public Series randomFfaSeries() throws FileNotFoundException {
        Filter seriesFilter = new SeriesFilter();
        series = jsonParser.getSeriesList();
        List<Series> ffaSeries = (List<Series>) seriesFilter.listWithFfa(series);

        return ffaSeries.get(getRandomForList(ffaSeries.size()));
    }
}
