package MaanProject.Models.Vervoer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Reservering
{
	//record ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

}
