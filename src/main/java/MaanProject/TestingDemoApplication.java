package MaanProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class TestingDemoApplication {
    public static void main(String[] args) {
        ApplicationContext a = SpringApplication.run(TestingDemoApplication.class, args);
        a.getBean(MaanAdministratie.class).maakRapportage(LocalDate.now().minusWeeks(1), LocalDate.now());
    }
}
