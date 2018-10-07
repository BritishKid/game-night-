package uk.co.rowney.gamenight.model.filter;

import uk.co.rowney.gamenight.objects.Game;
import uk.co.rowney.gamenight.objects.Series;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeriesFilter implements Filter {

    private List<Series> filteredList;

    @Override
    public List listWithTeam(List<?> seriesList) {
        List<Series> series = new ArrayList<>();

        castListToSeries(seriesList, series);

        filteredList = series.stream()
                .filter(Series::hasTeamModes)
                .collect(Collectors.toList());
        return filteredList;
    }

    @Override
    public List listWithFfa(List<?> seriesList) {
        List<Series> series = new ArrayList<>();

        castListToSeries(seriesList, series);

        filteredList = series.stream()
                .filter(Series::hasFfaModes)
                .collect(Collectors.toList());
        return filteredList;
    }

    private void castListToSeries(List<?> seriesList, List<Series> correctedSeriesList) {
        for (Object obj : seriesList) {
            Series series = (Series) obj;
            correctedSeriesList.add(series);
        }
    }
}
