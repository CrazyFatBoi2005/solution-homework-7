package IteratorPattern;

public class MainIteratorTest {
    public static void main(String[] args) {
        Episode ep1 = new Episode("E1", 1000);
        Episode ep2 = new Episode("E2", 1200);
        Episode ep3 = new Episode("E3", 1100);
        Episode ep4 = new Episode("E4", 1300);
        Episode ep5 = new Episode("E5", 1250);

        Season season1 = new Season();
        season1.addEpisode(ep1);
        season1.addEpisode(ep2);

        Season season2 = new Season();
        season2.addEpisode(ep3);
        season2.addEpisode(ep4);
        season2.addEpisode(ep5);

        Series series = new Series();
        series.addSeason(season1);
        series.addSeason(season2);

        System.out.println("Normal Order:");
        for (Episode e : season1) {
            System.out.println(e);
        }

        System.out.println("\nReverse Order:");
        EpisodeIterator reverseIterator = new ReverseSeasonIterator(season1.getEpisodes());
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }

        System.out.println("\nShuffle Order:");
        EpisodeIterator shuffleIterator = new ShuffleSeasonIterator(season1.getEpisodes(), 42L);
        while (shuffleIterator.hasNext()) {
            System.out.println(shuffleIterator.next());
        }

        System.out.println("\nBinge Mode (All Seasons):");
        EpisodeIterator bingeIterator = new BingeIterator(series.getSeasons());
        while (bingeIterator.hasNext()) {
            System.out.println(bingeIterator.next());
        }
    }
}
