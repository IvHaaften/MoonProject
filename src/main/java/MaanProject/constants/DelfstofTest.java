package MaanProject.constants;

import MaanProject.Exceptions.DelfstofException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class DelfstofTest
{
	@Test
	public void Delfstof_throwsException(){
		assertThrows(DelfstofException.class, () -> Delfstof.builder().elementnaam(null).build());
	}

}