package MaanProject.constants;

import MaanProject.Inwoner;
import java.time.LocalDate;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Access(AccessType.FIELD)
public class Vergunning<T extends GenericType>
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Inwoner verlener;

	@Transient
	private T type;

	private LocalDate startDatum;
	private LocalDate eindDatum;

	public Vergunning(Inwoner verlener, T type, LocalDate startDatum, LocalDate eindDatum)
	{
		this.verlener = verlener;
		this.type = type;
		this.startDatum = startDatum;
		this.eindDatum = eindDatum;
	}

}
