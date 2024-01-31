package si.um.feri.measurements;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import si.um.feri.measurements.dao.*;
import si.um.feri.measurements.dto.post.PostMeasurementDTO;
import si.um.feri.measurements.vao.*;

import java.util.logging.Logger;

@ApplicationScoped
public class MeasurementsApplicationLifecycle {

    private static final Logger log = Logger.getLogger(MeasurementsApplicationLifecycle.class.getName());

    @Inject
    ProductRepository productRepository;

    @Inject
    MeasurementRepository measurementRepository;

    @Inject
    InternetRepository internetRepository;

    @Inject
    PhoneRepository phoneRepository;

    @Inject
    TVRepository tvRepository;

    void onStart(@Observes StartupEvent ev) {
        log.info("The application is starting...");
        populateTestDataIfNotPresent();
    }

    @Transactional
    void populateTestDataIfNotPresent() {
        if (productRepository.count() > 0) {
            log.info("populateTestData - skipped.");
            return;
        }
        log.info("populateTestData initiated.");

        Product p1 = new Product();
        p1.setName("Milka Classic");
        p1.setMinMeasure(-5.0);
        p1.setMaxMeasure(18.0);
        productRepository.persist(p1);

        Product p2 = new Product();
        p2.setName("Chicken Breasts");
        p2.setMinMeasure(-25.0);
        p2.setMaxMeasure(-8.0);
        productRepository.persist(p2);

        PostMeasurementDTO m1 = new PostMeasurementDTO(p1.getId(), 12);
        Measurement me1 = new Measurement(m1, p1);
        measurementRepository.persist(me1);

        PostMeasurementDTO m2 = new PostMeasurementDTO(p2.getId(), -10);
        Measurement me2 = new Measurement(m2, p2);
        measurementRepository.persist(me2);

        Internet i1 = new Internet(0L, "A1 Ultra net", 19.99F, "1000/200 Mbit/s", "IP TV priključek z vmesnikom Amino Kamai 7, Programska shema XL HD z več kot 200 programi, TV časovne funkcije, Aplikacija tv2go Mini, Dodaten TV paket: HBO Premium z vključenim HBO Max, Videoteka Epic Drama");
        Internet i11 = new Internet(i1);
        Internet i2 = new Internet(1L, "A1 Fix net", 22.99F, "500/100 Mbit/s", "IP TV priključek z vmesnikom Amino Kamai, Programska shema L z več kot 180 programi, Dostop do TV funkcionalnosti (Avditorij Videoteka snemalnik spored), 130+ radijskih programov, Aplikacija tv2go Mini");
        Internet i22 = new Internet(i2);
        Internet i3 = new Internet(2L, "A1 Hitri", 23.99F, "100/20 Mbit/s ", "IP TV priključek z vmesnikom Amino Kamai 7, Programska shema M z več kot 120 programi, Dostop do TV funkcionalnosti (Avditorij Videoteka snemalnik spored), 130+ radijskih programov)");
        Internet i33 = new Internet(i3);

        internetRepository.persist(i11);
        internetRepository.persist(i22);
        internetRepository.persist(i33);

        Phone ph1 = new Phone("Za mlade", 9.99F, 20, 1000, "2/1 Mb/s");
        Phone ph2 = new Phone("midiMIO", 17.99F, 10, 1500, "2/1 Mb/s");
        Phone ph3 = new Phone("maksiMIO", 23.99F, 40, 2000, "2/1 Mb/s");

        phoneRepository.persist(ph1);
        phoneRepository.persist(ph2);
        phoneRepository.persist(ph3);

        TV t1 = new TV(0L, "TOTAL TV START", 12.95F, 80, false, "Satelitski sprejemnik HD EON, mobilna aplikacija");
        TV t2 = new TV(0L, "TOTAL TV EXTRA", 14.95F, 120, true, "Satelitski sprejemnik HD EON, mobilna aplikacija, Ogled nazaj do 7 dni EON");
        TV t3 = new TV(0L, "TOTAL TV PREMIUM", 16.95F, 140, true, "Satelitski sprejemnik HD EON, mobilna aplikacija, Ogled nazaj do 7 dni EON");

        TV tv11 = new TV(t1);
        TV tv22 = new TV(t2);
        TV tv33 = new TV(t3);

        tvRepository.persist(tv11);
        tvRepository.persist(tv22);
        tvRepository.persist(tv33);

    }
}