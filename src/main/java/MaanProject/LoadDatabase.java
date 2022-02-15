package MaanProject;

import MaanProject.PerceelTypes.LandbouwPerceel;
import MaanProject.PerceelTypes.MijnbouwPerceel;
import MaanProject.PerceelTypes.WoonPerceel;
import MaanProject.Service.InwonerService;
import MaanProject.Service.LandbouwPerceelService;
import MaanProject.Service.MijnbouwPerceelService;
import MaanProject.Service.WoonperceelService;
import MaanProject.constants.DelfstofType;
import MaanProject.constants.GewasType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

@Configuration
@Slf4j
public class LoadDatabase {

    //Will get automatically loaded by Spring to set up some sample data.
    @Bean
    CommandLineRunner initDatabase(InwonerService inwonerService, WoonperceelService woonperceelService, MijnbouwPerceelService mijnbouwPerceelService,
                                   LandbouwPerceelService landbouwPerceelService) {
        return args -> {
            log.info("Preloading inwoners");
            Inwoner jan = inwonerService.save(new Inwoner("Jan Jansen", LocalDate.of(1949, 1, 1)));
            Inwoner john = inwonerService.save(new Inwoner("John Doe", LocalDate.of(1950, 1, 1)));
            Inwoner jean = inwonerService.save(new Inwoner("Jean Dupont", LocalDate.of(2020, 1, 1)));
            Inwoner max = inwonerService.save(new Inwoner("Max Mustermann", LocalDate.of(1911, 1, 1)));

            Inwoner eva = inwonerService.save(new Inwoner("Eva Nováková", LocalDate.of(1911, 1, 1)));
            Inwoner navn = inwonerService.save(new Inwoner("Navn Navnesen", LocalDate.of(1920, 1, 1)));
            Inwoner kovacs = inwonerService.save(new Inwoner("Kovács János", LocalDate.of(2001, 1, 1)));

            log.info("Preloading " + woonperceelService.save(new WoonPerceel(new Polygon(), jan, 4, List.of(jan, john, jean, max))));
            log.info("Preloading " + woonperceelService.save(new WoonPerceel(new Polygon(), eva, 4, List.of(eva, navn, kovacs))));

            log.info("Preloading " + mijnbouwPerceelService.save(new MijnbouwPerceel(new Polygon(), jan, DelfstofType.GOUD, 100)));

            log.info("Preloading " + mijnbouwPerceelService.save(new MijnbouwPerceel(new Polygon(), jan, DelfstofType.HELIUM3, 5)));
            log.info("Preloading " + mijnbouwPerceelService.save(new MijnbouwPerceel(new Polygon(), jan, DelfstofType.HELIUM3, 15)));

            log.info("Preloading " + mijnbouwPerceelService.save(new MijnbouwPerceel(new Polygon(), john, DelfstofType.REGOLIET, 45)));
            log.info("Preloading " + mijnbouwPerceelService.save(new MijnbouwPerceel(new Polygon(), john, DelfstofType.REGOLIET, 60)));

            log.info("Preloading " + landbouwPerceelService.save(new LandbouwPerceel(new Polygon(), max, GewasType.KOMKOMMER, 60)));
            log.info("Preloading " + landbouwPerceelService.save(new LandbouwPerceel(new Polygon(), max, GewasType.KOMKOMMER, 68)));
            log.info("Preloading " + landbouwPerceelService.save(new LandbouwPerceel(new Polygon(), john, GewasType.KOMKOMMER, 680)));
        };
    }
}