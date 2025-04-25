package IteratorPattern;

public class MainIteratorTest {
    public static void main(String[] args) {
        // Создаём несколько эпизодов
        Episode ep1 = new Episode("IteratorPattern.Episode 1", 1000);
        Episode ep2 = new Episode("IteratorPattern.Episode 2", 1200);
        Episode ep3 = new Episode("IteratorPattern.Episode 3", 1100);
        Episode ep4 = new Episode("IteratorPattern.Episode 4", 1300);
        Episode ep5 = new Episode("IteratorPattern.Episode 5", 1250);

        // Создаём сезон и добавляем эпизоды
        Season season1 = new Season();
        season1.addEpisode(ep1);
        season1.addEpisode(ep2);

        Season season2 = new Season();
        season2.addEpisode(ep3);
        season2.addEpisode(ep4);
        season2.addEpisode(ep5);

        // Добавляем сезоны в сериал
        Series series = new Series();
        series.addSeason(season1);
        series.addSeason(season2);

        // Демонстрируем обычный итератор (IteratorPattern.SeasonIterator)
        System.out.println("Normal Order:");
        for (Episode e : season1) {
            System.out.println(e);
        }

        // Демонстрируем обратный итератор (IteratorPattern.ReverseSeasonIterator)
        System.out.println("\nReverse Order:");
        EpisodeIterator reverseIterator = new ReverseSeasonIterator(season1.getEpisodes());
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }

        // Демонстрируем случайный итератор (IteratorPattern.ShuffleSeasonIterator)
        System.out.println("\nShuffle Order:");
        EpisodeIterator shuffleIterator = new ShuffleSeasonIterator(season1.getEpisodes(), 42L);
        while (shuffleIterator.hasNext()) {
            System.out.println(shuffleIterator.next());
        }

        // Демонстрируем IteratorPattern.BingeIterator для всех сезонов
        System.out.println("\nBinge Mode (All Seasons):");
        EpisodeIterator bingeIterator = new BingeIterator(series.getSeasons());
        while (bingeIterator.hasNext()) {
            System.out.println(bingeIterator.next());
        }
    }
}
