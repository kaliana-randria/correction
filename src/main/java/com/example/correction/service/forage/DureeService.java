package com.example.correction.service.forage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.forage.HoraireTravail;
import com.example.correction.repository.forage.HoraireTravailRepository;

@Service
public class DureeService {
    @Autowired
    private HoraireTravailRepository horaireTravailRepository;

    public Duration calculDureeTsotra(LocalDateTime debut, LocalDateTime fin) {
        return Duration.between(debut, fin);
    }

    private Duration calculPeriode(LocalDateTime debut, LocalDateTime fin, LocalDateTime periodeDebut, LocalDateTime periodeFin) {

        LocalDateTime start = debut;
        if (periodeDebut.isAfter(debut)) {
            start = periodeDebut;
        }

        LocalDateTime end = fin;
        if (periodeFin.isBefore(fin)) {
            end = periodeFin;
        }

        if (start.isBefore(end)) {
            return Duration.between(start, end);
        }

        return Duration.ZERO;
    }

    public Duration calculDureeSarotra(LocalDateTime debut, LocalDateTime fin) {

        if (debut == null || fin == null || !debut.isBefore(fin)) {
            return Duration.ZERO;
        }

        Duration totalDuree = Duration.ZERO;

        LocalDate dateCourante = debut.toLocalDate();
        LocalDate dateFin = fin.toLocalDate();

        while (!dateCourante.isAfter(dateFin)) {

            int jourSemaine = dateCourante.getDayOfWeek().getValue();

            HoraireTravail horaire = horaireTravailRepository.findByJourSemaineAndActifTrue(jourSemaine);

            if (horaire != null) {

                LocalDateTime debutJour = dateCourante.atStartOfDay();
                LocalDateTime finJour = dateCourante.atTime(23, 59, 59);

                if (dateCourante.equals(debut.toLocalDate())) {
                    debutJour = debut;
                }

                if (dateCourante.equals(fin.toLocalDate())) {
                    finJour = fin;
                }

                totalDuree = totalDuree.plus(calculPeriode(debutJour, finJour, LocalDateTime.of(dateCourante, horaire.getDebutMatin()),
                        LocalDateTime.of(dateCourante, horaire.getFinMatin())));

                totalDuree = totalDuree.plus(calculPeriode(debutJour, finJour, LocalDateTime.of(dateCourante, horaire.getDebutAprem()),
                        LocalDateTime.of(dateCourante, horaire.getFinAprem())));
            }

            dateCourante = dateCourante.plusDays(1);
        }

        return totalDuree;
    }

    public int calculerHeuresArrondies(Duration duration) {
        if (duration == null || duration.isNegative()) return 0;
        
        long heures = duration.toHours();
        int minutesRestantes = duration.toMinutesPart();

        if (minutesRestantes >= 30) {
            return (int) heures + 1;
        }
        return (int) heures;
    }
}
