package IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public EpisodeIterator iteratorCustom() {
        return new SeasonIterator(episodes);
    }

    @Override
    public Iterator<Episode> iterator() {
        return episodes.iterator();
    }
}
