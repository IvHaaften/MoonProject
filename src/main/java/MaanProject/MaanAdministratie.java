package MaanProject;

import MaanProject.Models.Perceel;
import MaanProject.Models.PerceelTypes.LandbouwPerceel;
import MaanProject.Models.PerceelTypes.MijnbouwPerceel;
import MaanProject.Models.PerceelTypes.WoonPerceel;
import MaanProject.Models.Vervoer.Rit;
import MaanProject.Service.*;
import MaanProject.constants.Delfstof;
import MaanProject.constants.DelfstofType;
import MaanProject.constants.GewasType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
final public class MaanAdministratie implements Serializable {
    public static final String EXPORT_PAD = "src/main/resources";
    PerceelService perceelService;
    TransactieService transactieService;
    MijnbouwPerceelService mijnbouwPerceelService;
    LandbouwPerceelService landbouwPerceelService;
    WoonperceelService woonPerceelService;
    RitService ritService;
    InwonerService inwonerService;

    @Autowired
    public MaanAdministratie(PerceelService perceelService, TransactieService transactieService,
                             MijnbouwPerceelService mijnbouwPerceelService, LandbouwPerceelService landbouwPerceelService,
                             WoonperceelService woonPerceelService, RitService ritService, InwonerService inwonerService) {
        this.perceelService = perceelService;
        this.transactieService = transactieService;
        this.mijnbouwPerceelService = mijnbouwPerceelService;
        this.landbouwPerceelService = landbouwPerceelService;
        this.woonPerceelService = woonPerceelService;
        this.ritService = ritService;
        this.inwonerService = inwonerService;
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

        var alleRitten = ritService.findAll();
        try (ObjectOutputStream bw = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(EXPORT_PAD + "/rittenlijst.txt"))))) {
            for (Rit rit : alleRitten) {
                bw.writeObject(rit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream bw = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(EXPORT_PAD + "/rittenlijst.txt"))));
             BufferedWriter illegaal = new BufferedWriter(new FileWriter(new File(EXPORT_PAD + "/illegaal.txt")))) {

            while (true) {
                Rit rit = (Rit) bw.readObject();
                var perceel = rit.getBeginStation().getPerceel();
                if (perceel instanceof LandbouwPerceel) {
                    if (((LandbouwPerceel) perceel).getvergunning().isEmpty() && ((LandbouwPerceel) perceel).getGewas().isOpiaat()) {
                        //regel naar bestand
                        illegaal.write("illegaal opiaat perceelId " + perceel.getId());
                    }
                } else if (perceel instanceof MijnbouwPerceel) {
                    if (((MijnbouwPerceel) perceel).getvergunning().isEmpty() && ((MijnbouwPerceel) perceel).getDelfstof().isRadioactief()) {
                        //regel naar bestand
                        illegaal.write("illegale radioactieve delfstof perceelId " + perceel.getId());
                    }

                }
                System.out.println("rit uit bestand gehaald ");
            }
        } catch (EOFException e) {
            System.out.println("einde bestand");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        var inwoners = inwonerService.findAll();
        inwoners.forEach(inwoner -> Path.of(EXPORT_PAD, "inwoners", inwoner.getNaam().replace(" ", "_")).toFile().mkdirs());
        alleRitten.forEach(rit -> {
            Path p = Path.of(EXPORT_PAD, "inwoners",
                rit.getBeginStation().getPerceel().getEigenaar().getNaam().replace(" ", "_"),rit.getId() + ".txt");
            p.toFile().getParentFile().mkdirs();
            try (var nbw = Files.newBufferedWriter(p)) {
                p.toFile().createNewFile();
                nbw.write(rit.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}
