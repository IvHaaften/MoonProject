package MaanProject.Models.Vervoer;

import MaanProject.constants.AggregatieToestand;
import MaanProject.constants.KratFormaat;
import MaanProject.constants.VervoerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RitTest {

    private Rit rit;

    @BeforeEach
    void setUp() {
        rit = new Rit(1, new Vervoersmiddel(4, VervoerType.MONORAIL, 200, null), null, new CopyOnWriteArrayList<>(), ZonedDateTime.now(), new Station(), new Station());
    }

    @Test
    public void vrachtToevoegen_isDraadVeilig() throws InterruptedException {
        var executor = Executors.newFixedThreadPool(5);
        ArrayList<Future<?>> futures = new ArrayList<>();
        for (int n = 1; n < 22; n++) {
            int finalN = n;
            futures.add(executor.submit(() -> rit.plaatsVracht(new Vracht(finalN, KratFormaat.MEDIUM, AggregatieToestand.GAS, true, 29, 29))));
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        assertEquals(20, rit.getVrachtLijst().size());
        //assertEquals(2, futures.stream().filter(future -> future.get()));
    }
}