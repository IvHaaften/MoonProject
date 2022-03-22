package MaanProject;

import MaanProject.Models.Perceel;
import MaanProject.Models.PerceelTypes.LandbouwPerceel;
import MaanProject.Models.PerceelTypes.MijnbouwPerceel;
import MaanProject.Models.PerceelTypes.WoonPerceel;
import MaanProject.Service.*;
import MaanProject.constants.Delfstof;
import MaanProject.constants.DelfstofType;
import MaanProject.constants.GewasType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
final public class MaanAdministratie {
    PerceelService perceelService;
    TransactieService transactieService;
    MijnbouwPerceelService mijnbouwPerceelService;
    LandbouwPerceelService landbouwPerceelService;
    WoonperceelService woonPerceelService;

    @Autowired
    public MaanAdministratie(PerceelService perceelService, TransactieService transactieService,
                             MijnbouwPerceelService mijnbouwPerceelService, LandbouwPerceelService landbouwPerceelService,
                             WoonperceelService woonPerceelService) {
        this.perceelService = perceelService;
        this.transactieService = transactieService;
        this.mijnbouwPerceelService = mijnbouwPerceelService;
        this.landbouwPerceelService = landbouwPerceelService;
        this.woonPerceelService = woonPerceelService;
    }

    //Percelen die vaker dan gemiddeld zijn verkocht
    public List<Perceel> getPercelenVakerDanGemiddeldVerkocht(LocalDate beginDatum, LocalDate eindDatum) {
        var allePercelen = perceelService.findAll();
        if (allePercelen.size() == 0) {
            return null;
        }
        var alleTransacties = transactieService.findByDateRange(beginDatum, eindDatum);
        double gemiddelde = (double) alleTransacties.size() / (double) allePercelen.size();
        return allePercelen.stream()
                .filter(perceel -> perceel.transacties.stream()
                        .filter(transactie -> !transactie.getDatum().isBefore(beginDatum) &&
                                !transactie.getDatum().isAfter(eindDatum)).count() > gemiddelde)
                .collect(Collectors.toList());
    }

    //Percelen die veel vaker dan gemiddeld zijn verkocht
    public List<Perceel> getPercelenVeelVakerDanGemiddeldVerkocht(LocalDate beginDatum, LocalDate eindDatum) {
        var allePercelen = perceelService.findAll();
        if (allePercelen.size() == 0) {
            return null;
        }
        var alleTransacties = transactieService.findByDateRange(beginDatum, eindDatum);
        double gemiddelde = (double) alleTransacties.size() / (double) allePercelen.size();
        return allePercelen.stream()
                .filter(perceel -> perceel.transacties.stream()
                        .filter(transactie -> !transactie.getDatum().isBefore(beginDatum) &&
                                !transactie.getDatum().isAfter(eindDatum)).count() > (gemiddelde * 1.5))
                .collect(Collectors.toList());
    }

    //Percelen die minder gemiddeld zijn verkocht
    public List<Perceel> getPercelenMinderDanGemiddeldVerkocht(LocalDate beginDatum, LocalDate eindDatum) {
        var allePercelen = perceelService.findAll();
        if (allePercelen.size() == 0) {
            return null;
        }
        var alleTransacties = transactieService.findByDateRange(beginDatum, eindDatum);
        var gemiddelde = alleTransacties.size() / allePercelen.size();
        return allePercelen.stream()
                .filter(perceel -> perceel.getTransacties().stream()
                        .filter(transactie -> !transactie.getDatum().isBefore(beginDatum) &&
                                !transactie.getDatum().isAfter(eindDatum))
                        .count() < gemiddelde)
                .collect(Collectors.toList());
    }

    //Percelen die veel minder gemiddeld zijn verkocht
    public List<Perceel> getPercelenVeelMinderDanGemiddeldVerkocht(LocalDate beginDatum, LocalDate eindDatum) {
        var allePercelen = perceelService.findAll();
        if (allePercelen.size() == 0) {
            return null;
        }
        var alleTransacties = transactieService.findByDateRange(beginDatum, eindDatum);
        var gemiddelde = alleTransacties.size() / allePercelen.size();
        return allePercelen.stream()
                .filter(perceel -> perceel.transacties.stream()
                        .filter(transactie -> !transactie.getDatum().isBefore(beginDatum) &&
                                !transactie.getDatum().isAfter(eindDatum)).count() < (gemiddelde * 0.5))
                .collect(Collectors.toList());
    }

    //Percelen die meer/minder delfstoffen/gewassen opleveren dan gemiddeld
    public List<Perceel> getPerceelMetMinderDelfstoffenDanGemiddeld() {
        var mijnbouwPercelen = mijnbouwPerceelService.findAll();
        if (mijnbouwPercelen.size() == 0) {
            return null;
        }
        var gemiddelde = mijnbouwPercelen.stream()
                .collect(Collectors.averagingInt(MijnbouwPerceel::getJaarOpbrengst));
        return mijnbouwPercelen.stream()
                .filter(mijnbouwPerceel -> mijnbouwPerceel.getJaarOpbrengst() < gemiddelde)
                .collect(Collectors.toList());
    }

    public List<Perceel> getPerceelMetMeerDelfstoffenDanGemiddeld() {
        var mijnbouwPercelen = mijnbouwPerceelService.findAll();
        if (mijnbouwPercelen.size() == 0) {
            return null;
        }
        var gemiddelde = mijnbouwPercelen.stream()
                .collect(Collectors.averagingInt(MijnbouwPerceel::getJaarOpbrengst));
        return mijnbouwPercelen.stream()
                .filter(mijnbouwPerceel -> mijnbouwPerceel.getJaarOpbrengst() > gemiddelde)
                .collect(Collectors.toList());
    }

    //Percelen die meer/minder gewassen opleveren dan gemiddeld
    public List<Perceel> getPerceelMetMeerGewassenDanGemiddeld() {
        var landbouwPercelen = landbouwPerceelService.findAll();
        if (landbouwPercelen.size() == 0) {
            return null;
        }
        var gemiddelde = landbouwPercelen.stream()
                .collect(Collectors.averagingInt(LandbouwPerceel::getJaarOpbrengst));
        return landbouwPercelen.stream()
                .filter(landbouwPerceel -> landbouwPerceel.getJaarOpbrengst() > gemiddelde)
                .collect(Collectors.toList());
    }

    public List<Perceel> getPerceelMetMinderGewassenDanGemiddeld() {
        var landbouwPercelen = landbouwPerceelService.findAll();
        if (landbouwPercelen.size() == 0) {
            return null;
        }
        var gemiddelde = landbouwPercelen.stream()
                .collect(Collectors.averagingInt(LandbouwPerceel::getJaarOpbrengst));
        return landbouwPercelen.stream()
                .filter(landbouwPerceel -> landbouwPerceel.getJaarOpbrengst() < gemiddelde)
                .collect(Collectors.toList());
    }


    /**
     * een methode zijn om het aantal verkochte maanpercelen te berekenen per periode uit te rekenen.
     * Een methode om het aantal delfstof percelen en het aantal gewas percelen te berekenen.
     * De gemiddelde opbrengst van een perceel per gewas en per delfstof moet berekend kunnen worden.
     * Het aantal inwoners ouder dan 30 jaar per woonperceel moet opgevraagd worden.
     */

    public long aantalVerkochtePercelenPerPeriode(LocalDate beginDatum, LocalDate eindDatum) {
        var allePercelen = perceelService.findAll();
        if (allePercelen.size() == 0) {
            return 0;
        }
        return allePercelen.stream()
                .filter(perceel -> perceel.transacties.stream()
                        .anyMatch(transactie -> !transactie.getDatum().isBefore(beginDatum) &&
                                !transactie.getDatum().isAfter(eindDatum)))
                .count();
    }

    public int aantalMijnbouwPercelen() {
        return mijnbouwPerceelService.findAll().size();
    }

    public int aantalLandbouwPercelen() {
        return landbouwPerceelService.findAll().size();
    }

    public double gemiddeldeOpbrengstPerperceelPerGewas(GewasType gewasType) {
        return landbouwPerceelService.findAll().stream()
                .filter(landbouwPerceel -> landbouwPerceel.getGewas() == gewasType)
                .collect(Collectors.averagingInt(LandbouwPerceel::getJaarOpbrengst));
    }

    public double gemiddeldeOpbrengstPerperceelPerDelfStof(Delfstof delfstof) {
        return mijnbouwPerceelService.findAll().stream()
                .filter(mijnbouwPerceel -> mijnbouwPerceel.getDelfstof().equals(delfstof))
                .collect(Collectors.averagingInt(MijnbouwPerceel::getJaarOpbrengst));
    }

    public long aantalInwonersOuderDan30(WoonPerceel woonPerceel) {
        return woonPerceel.getInwoners().stream().filter(inwoner -> inwoner.getLeeftijdInJaren() > 30).count();
    }

    public void maakRapportage(LocalDate beginDatum, LocalDate eindDatum) {
        System.out.println("Maan rapportage voor de periode: " + beginDatum + " - " + eindDatum);
        System.out.println("Percelen vaker dan gemiddeld verkocht: " + getPercelenVakerDanGemiddeldVerkocht(beginDatum, eindDatum));
        System.out.println("Percelen VEEL vaker dan gemiddeld verkocht: " + getPercelenVeelVakerDanGemiddeldVerkocht(beginDatum, eindDatum));
        System.out.println("Percelen minder dan gemiddeld verkocht: " + getPercelenMinderDanGemiddeldVerkocht(beginDatum, eindDatum));
        System.out.println("Percelen VEEL minder dan gemiddeld verkocht: " + getPercelenVeelMinderDanGemiddeldVerkocht(beginDatum, eindDatum));

        System.out.println("Percelen lagere delfstof opbrengst dan gemiddeld: " + getPerceelMetMinderDelfstoffenDanGemiddeld());
        System.out.println("Percelen hogere delfstof opbrengst dan gemiddeld: " + getPerceelMetMeerDelfstoffenDanGemiddeld());

        System.out.println("Percelen lagere gewas opbrengst dan gemiddeld: " + getPerceelMetMinderGewassenDanGemiddeld());
        System.out.println("Percelen hogere gewas opbrengst dan gemiddeld: " + getPerceelMetMeerGewassenDanGemiddeld());

        System.out.println("Totaal aantal verkochte maan percelen deze periode: " + aantalVerkochtePercelenPerPeriode(beginDatum, eindDatum));
        System.out.println("Totaal aantal delfstof percelen: " + aantalMijnbouwPercelen());
        System.out.println("Totaal aantal gewas percelen: " + aantalLandbouwPercelen());

        for (GewasType g : GewasType.values()) {
            System.out.println("Gemiddelde opbrengst van landbouw percelen die " + g + " verbouwen: " + gemiddeldeOpbrengstPerperceelPerGewas(g));
        }

        for (Delfstof d : DelfstofType.values()) {
            System.out.println("Gemiddelde opbrengst van mijnbouw percelen die " + d + " winnen: " + gemiddeldeOpbrengstPerperceelPerDelfStof(d));
        }

        System.out.println("Aantal inwoners ouder dan 30 per woonperceel:");
        System.out.println("ID | aantal");
        var alleWoonPercelen = woonPerceelService.findAll();
        for (WoonPerceel woonPerceel : alleWoonPercelen) {
            System.out.println(woonPerceel.getId() + " | " + aantalInwonersOuderDan30(woonPerceel));
        }
    }

}
