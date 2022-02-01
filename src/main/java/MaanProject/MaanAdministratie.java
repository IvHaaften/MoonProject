package MaanProject;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

final public class MaanAdministratie {
    PerceelService perceelService;
    TransactieService transactieService;

    public MaanAdministratie(PerceelService perceelService, TransactieService transactieService) {
        this.perceelService = perceelService;
        this.transactieService = transactieService;
    }

    //Percelen die vaker dan gemiddeld zijn verkocht
    public List<Perceel> getPercelenVakerDanGemiddeldVerkocht(LocalDate eindDatum, LocalDate beginDatum) {
        var allePercelen = perceelService.findAll();
        var alleTransacties = transactieService.findByDateRange(eindDatum, beginDatum);
        double gemiddelde = (double) alleTransacties.size() /  (double) allePercelen.size();
        return allePercelen.stream()
                .filter(perceel -> perceel.transacties.stream()
                        .filter(transactie -> !transactie.getDatum().isBefore(beginDatum) &&
                                !transactie.getDatum().isAfter(eindDatum)).count() > gemiddelde)
                .collect(Collectors.toList());
    }

    //Percelen die veel vaker dan gemiddeld zijn verkocht
    public List<Perceel> getPercelenVeelVakerDanGemiddeldVerkocht(LocalDate eindDatum, LocalDate beginDatum) {
        var allePercelen = perceelService.findAll();
        var alleTransacties = transactieService.findByDateRange(eindDatum, beginDatum);
        double gemiddelde = (double) alleTransacties.size() /  (double) allePercelen.size();
        return allePercelen.stream()
                .filter(perceel -> perceel.transacties.stream()
                        .filter(transactie -> !transactie.getDatum().isBefore(beginDatum) &&
                                !transactie.getDatum().isAfter(eindDatum)).count() > (gemiddelde*1.5))
                .collect(Collectors.toList());
    }

    //Percelen die minder gemiddeld zijn verkocht
    public List<Perceel> getPercelenMinderDanGemiddeldVerkocht(LocalDate eindDatum, LocalDate beginDatum) {
        var allePercelen = perceelService.findAll();
        var alleTransacties = transactieService.findByDateRange(eindDatum, beginDatum);
        var gemiddelde = alleTransacties.size() / allePercelen.size();
        return allePercelen.stream()
                .filter(perceel -> perceel.transacties.stream()
                        .filter(transactie -> !transactie.getDatum().isBefore(beginDatum) &&
                                !transactie.getDatum().isAfter(eindDatum)).count() < gemiddelde)
                .collect(Collectors.toList());
    }

    //Percelen die veel minder gemiddeld zijn verkocht
    public List<Perceel> getPercelenVeelMinderDanGemiddeldVerkocht(LocalDate eindDatum, LocalDate beginDatum) {
        var allePercelen = perceelService.findAll();
        var alleTransacties = transactieService.findByDateRange(eindDatum, beginDatum);
        var gemiddelde = alleTransacties.size() / allePercelen.size();
        return allePercelen.stream()
                .filter(perceel -> perceel.transacties.stream()
                        .filter(transactie -> !transactie.getDatum().isBefore(beginDatum) &&
                                !transactie.getDatum().isAfter(eindDatum)).count() < (gemiddelde*0.5))
                .collect(Collectors.toList());
    }

    //Percelen die meer/minder delfstoffen/gewassen opleveren dan gemiddeld
/*    public List<Perceel> getPerceelMetMinderDelfstoffenDanGemiddeld(){
        var mijnbouwPercelen = perceelService.findByPerceelType(PerceelType.MIJN);
        var gemiddelde = mijnbouwPercelen.stream().map(MijnbouwPerceel::getJaarOpbrengst)./mijnbouwPercelen.size();
    }*/



    /** een methode zijn om het aantal verkochte maanpercelen te berekenen per periode uit te rekenen.
     * Een methode om het aantal delfstof percelen en het aantal gewas percelen te berekenen.
     * De gemiddelde opbrengst van een perceel per gewas en per delfstof moet berekend kunnen worden.
     * Het aantal inwoners ouder dan 30 jaar per woonperceel moet opgevraagd worden.*/

}
