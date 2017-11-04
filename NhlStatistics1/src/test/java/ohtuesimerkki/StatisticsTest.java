package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    public StatisticsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void haeOikeaPelaaja() {
        Player gretzky = new Player("Gretzky", "EDM", 35, 89);
        assertEquals(gretzky, stats.search("Gretzky"));
    }

    @Test
    public void palautaNullJosPelaajaaEiLoydy() {
        assertEquals(null, stats.search("Maaret"));
    }

    @Test
    public void haeOikeanJoukkueenPelaajat() {
        Player lemieux = new Player("Lemieux", "PIT", 45, 54);
        assertEquals(lemieux, stats.team("PIT").get(0));
        assertEquals(1, stats.team("PIT").size());
    }

    @Test
    public void haeTopScorer() {
        Player gretzky = new Player("Gretzky", "EDM", 35, 89);
        assertEquals(gretzky, stats.topScorers(1).get(0));
    }

}
