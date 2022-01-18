package src.main.java;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Perceel {
    private UUID id;
    private int oppervlakte;
    private  List<Map<Double, Double>> begrenzing;
    private boolean beperking;
    private Inwoner eigenaar;

    public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public int getOppervlakte() {
		return oppervlakte;
	}
	public void setOppervlakte(int oppervlakte) {
		this.oppervlakte = oppervlakte;
	}
	public List<Map<Double, Double>> getBegrenzing() {
		return begrenzing;
	}
	public void setBegrenzing(List<Map<Double, Double>> begrenzing) {
		this.begrenzing = begrenzing;
	}
	public boolean isBeperking() {
		return beperking;
	}
	public void setBeperking(boolean beperking) {
		this.beperking = beperking;
	}
	public Inwoner getEigenaar() {
		return eigenaar;
	}
	public void setEigenaar(Inwoner eigenaar) {
		this.eigenaar = eigenaar;
	}

}
