package uk.co.rowney.gamenight.model.filter;

import uk.co.rowney.gamenight.objects.Game;

import java.util.List;

public interface Filter {

    public List<?> listWithTeam(List<?> list);

    public List<?> listWithFfa(List<?> list);
}
