package MaanProject.PerceelTypes;

import MaanProject.Exceptions.MaxInwonerException;
import MaanProject.Inwoner;
import java.awt.Polygon;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class WoonPerceelTest
{
	@Test
	public void intrekkenInwoner_throwsMaxInwonerException() {
		WoonPerceel woonPerceel = new WoonPerceel(new Polygon(), new Inwoner(), -1, Collections.emptyList());
		assertThrows(MaxInwonerException.class, () -> woonPerceel.intrekkenInwoner(new Inwoner()));
	}

}