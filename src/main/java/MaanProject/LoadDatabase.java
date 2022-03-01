package MaanProject;

import MaanProject.PerceelTypes.LandbouwPerceel;
import MaanProject.PerceelTypes.MijnbouwPerceel;
import MaanProject.PerceelTypes.WoonPerceel;
import MaanProject.Service.*;
import MaanProject.constants.Delfstof;
import MaanProject.constants.DelfstofType;
import MaanProject.constants.GewasType;
import MaanProject.constants.Vergunning;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Configuration
@Slf4j
public class LoadDatabase {

    //Will get automatically loaded by Spring to set up some sample data.
    @Bean
    CommandLineRunner initDatabase(InwonerService inwonerService, WoonperceelService woonperceelService, MijnbouwPerceelService mijnbouwPerceelService,
                                   LandbouwPerceelService landbouwPerceelService, DelfstofVergunningService delfstofVergunningService,
                                   GewasVergunningService gewasVergunningService, DelfstofService delfstofService) {
        return args -> {
            log.info("Preloading inwoners");
            Inwoner jan = inwonerService.save(new Inwoner("Jan Jansen", LocalDate.of(1949, 1, 1)));
            Inwoner john = inwonerService.save(new Inwoner("John Doe", LocalDate.of(1950, 1, 1)));
            Inwoner jean = inwonerService.save(new Inwoner("Jean Dupont", LocalDate.of(2020, 1, 1)));
            Inwoner max = inwonerService.save(new Inwoner("Max Mustermann", LocalDate.of(1911, 1, 1)));

            Inwoner eva = inwonerService.save(new Inwoner("Eva Nováková", LocalDate.of(1911, 1, 1)));
            Inwoner navn = inwonerService.save(new Inwoner("Navn Navnesen", LocalDate.of(1920, 1, 1)));
            Inwoner kovacs = inwonerService.save(new Inwoner("Kovács János", LocalDate.of(2001, 1, 1)));

            for  (Delfstof d : DelfstofType.values()) {
                delfstofService.save(d);
            }


            Vergunning<Delfstof> irridiumVergunning = delfstofVergunningService.save(new Vergunning<>(jan, DelfstofType.IRIDIUM, LocalDate.now().minusMonths(2), LocalDate.now().plusMonths(2)));
            Vergunning<GewasType> maanzaadVergunning = gewasVergunningService.save(new Vergunning<>(jan, GewasType.MAANZAAD, LocalDate.now().minusMonths(5), LocalDate.now().plusMonths(3)));
            Vergunning<GewasType> cannabisVergunning = gewasVergunningService.save(new Vergunning<>(jan, GewasType.CANNABIS, LocalDate.now().minusMonths(11), LocalDate.now().plusMonths(5)));

            log.info("Preloading " + woonperceelService.save(new WoonPerceel(new Polygon(), jan, 4, List.of(jan, john, jean, max))));
            log.info("Preloading " + woonperceelService.save(new WoonPerceel(new Polygon(), eva, 4, List.of(eva, navn, kovacs))));

            log.info("Preloading " + mijnbouwPerceelService.save(new MijnbouwPerceel(new Polygon(), jan, DelfstofType.GOUD, 100, Optional.empty())));

            log.info("Preloading " + mijnbouwPerceelService.save(new MijnbouwPerceel(new Polygon(), jan, DelfstofType.HELIUM3, 5, Optional.empty())));
            log.info("Preloading " + mijnbouwPerceelService.save(new MijnbouwPerceel(new Polygon(), jan, DelfstofType.HELIUM3, 15, Optional.empty())));

            log.info("Preloading " + mijnbouwPerceelService.save(new MijnbouwPerceel(new Polygon(), john, DelfstofType.REGOLIET, 45, Optional.empty())));
            log.info("Preloading " + mijnbouwPerceelService.save(new MijnbouwPerceel(new Polygon(), john, DelfstofType.REGOLIET, 60, Optional.empty())));

            log.info("Preloading " + landbouwPerceelService.save(new LandbouwPerceel(new Polygon(), max, GewasType.KOMKOMMER, 60, Optional.empty())));
            log.info("Preloading " + landbouwPerceelService.save(new LandbouwPerceel(new Polygon(), max, GewasType.KOMKOMMER, 68, Optional.empty())));
            log.info("Preloading " + landbouwPerceelService.save(new LandbouwPerceel(new Polygon(), john, GewasType.KOMKOMMER, 680, Optional.empty())));

            log.info("Preloading " + mijnbouwPerceelService.save(new MijnbouwPerceel(new Polygon(), jan, DelfstofType.IRIDIUM, 45, Optional.empty())));
            log.info("Preloading " + mijnbouwPerceelService.save(new MijnbouwPerceel(new Polygon(), john, DelfstofType.IRIDIUM, 60, Optional.of(irridiumVergunning))));

            log.info("Preloading " + landbouwPerceelService.save(new LandbouwPerceel(new Polygon(), jean, GewasType.MAANZAAD, 23, Optional.of(maanzaadVergunning))));
            log.info("Preloading " + landbouwPerceelService.save(new LandbouwPerceel(new Polygon(), eva, GewasType.MAANZAAD, 52, Optional.empty())));
            log.info("Preloading " + landbouwPerceelService.save(new LandbouwPerceel(new Polygon(), kovacs, GewasType.CANNABIS, 233, Optional.of(cannabisVergunning))));
        };
    }
}