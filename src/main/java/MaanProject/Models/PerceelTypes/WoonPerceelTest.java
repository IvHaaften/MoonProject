package MaanProject.Models.PerceelTypes;

import MaanProject.Exceptions.MaxInwonerException;
import MaanProject.Models.Inwoner;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WoonPerceelTest {
    @Test
    public void intrekkenInwoner_throwsMaxInwonerException() {
        WoonPerceel woonPerceel = new WoonPerceel(new Polygon(), new Inwoner(), -1, Collections.emptyList());
        assertThrows(MaxInwonerException.class, () -> woonPerceel.intrekkenInwoner(new Inwoner()));
    }

}