package org.example.projektspringboot;


import org.example.projektspringboot.Domain.*;
import org.example.projektspringboot.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader  implements ApplicationRunner {
    @Autowired
    private KundeRepository kundeRepository;

    @Autowired
    private PoliceRepositroy policeRepository;

    @Autowired
    private ZahlungRepository zahlungRepository;

    @Autowired
    private VersicherungsartRepository versicherungsartRepository;

    @Autowired
    private ArbeiterRepository arbeiterRepository;

    @Autowired
    private ArbeitenAnRepository arbeitenAnRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Arbeiter arbeiter1 = new Arbeiter();
        arbeiter1.setName("Max Mustermann");
        arbeiter1.setAbteilung("Vertrieb");
        arbeiterRepository.save(arbeiter1);

        Arbeiter arbeiter2 = new Arbeiter();
        arbeiter2.setName("Anna Müller");
        arbeiter2.setAbteilung("Kundenservice");
        arbeiterRepository.save(arbeiter2);


        Kunde kunde1 = new Kunde();
        kunde1.setName("Schmidt");
        kunde1.setVorname("Hans");
        kunde1.setAdresse("Musterstrasse 1");
        kunde1.setVersicherbar(true);
        kunde1.setAlter(45);
        kunde1.setArbeiter(arbeiter1);
        kundeRepository.save(kunde1);

        Kunde kunde2 = new Kunde();
        kunde2.setName("Meyer");
        kunde2.setVorname("Sabine");
        kunde2.setAdresse("Beispielweg 5");
        kunde2.setVersicherbar(true);
        kunde2.setAlter(34);
        kunde2.setArbeiter(arbeiter2);
        kundeRepository.save(kunde2);

        Versicherungsart unfall = new Versicherungsart();
        unfall.setArt("Unfall");
        versicherungsartRepository.save(unfall);

        Versicherungsart hausrat = new Versicherungsart();
        hausrat.setArt("Hausrat");
        versicherungsartRepository.save(hausrat);

        Versicherungsart auto = new Versicherungsart();
        auto.setArt("Auto");
        versicherungsartRepository.save(auto);


        Police police1 = new Police();
        police1.setPolicenummer("P12345");
        police1.setKunde(kunde1);
        police1.setVersicherungsart(unfall);
        police1.setArbeiter(arbeiter1);
        policeRepository.save(police1);

        Police police2 = new Police();
        police2.setPolicenummer("P67890");
        police2.setKunde(kunde2);
        police2.setVersicherungsart(auto);
        police2.setArbeiter(arbeiter2);
        policeRepository.save(police2);



        Zahlung zahlung1 = new Zahlung();
        zahlung1.setMonatsbetrag(100.00);
        zahlung1.setPolice(police1);
        zahlungRepository.save(zahlung1);

        Zahlung zahlung2 = new Zahlung();
        zahlung2.setMonatsbetrag(150.00);
        zahlung2.setPolice(police2);
        zahlungRepository.save(zahlung2);


        ArbeitenAn arbeitenAn1 = new ArbeitenAn();
        arbeitenAn1.setPolice(police1);
        arbeitenAn1.setVersicherungsart(unfall);
        arbeitenAnRepository.save(arbeitenAn1);

        ArbeitenAn arbeitenAn2 = new ArbeitenAn();
        arbeitenAn2.setPolice(police2);
        arbeitenAn2.setVersicherungsart(auto);
        arbeitenAnRepository.save(arbeitenAn2);
    }
}

