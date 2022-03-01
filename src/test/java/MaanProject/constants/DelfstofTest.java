package MaanProject.constants;

import MaanProject.Exceptions.DelfstofException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DelfstofTest {
    @Test
    public void Delfstof_throwsException() {
        assertThrows(DelfstofException.class, () -> Delfstof.builder().elementnaam(null).build());
    }

}