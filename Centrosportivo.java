package centrosportivo;

import java.util.ArrayList;
import java.util.List;

public class Centrosportivo {
    private List<Corso> corsi;
    private List<Iscritto> iscritti;
    public static int iscrizioniTotali = 0;
    
    public Centrosportivo() {
        this.corsi = new ArrayList<>();
        this.iscritti = new ArrayList<>();
    }
    public void aggiungiCorso(Corso c) {
        if (c != null) {
            corsi.add(c);
        }
    }
    public void aggiungiIscritto(Iscritto i) {
        if (i != null) {
            iscritti.add(i);
        }
    }
    public Corso cercaCorso(String id) {
        if (id == null) return null;
        for (Corso c : corsi) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }
    public Iscritto cercaIscritto(String id) {
        if (id == null) return null;
        for (Iscritto i : iscritti) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }
    public boolean iscrivi(String idIscritto, String idCorso) {
        Iscritto iscritto = cercaIscritto(idIscritto);
        Corso corso = cercaCorso(idCorso);
        if (iscritto == null || corso == null) {
            System.out.println("Iscrizione fallita: iscritto o corso non trovato.");
            return false;
        }
        boolean aggiunto = iscritto.aggiungiCorso(corso);
        if (!aggiunto) {
            System.out.println("Iscrizione fallita: regola max 2 corsi o corso già presente.");
            return false;
        }
        boolean okCorso = corso.iscrivi();
        if (!okCorso) {
            iscritto.rimuoviCorso(corso.getId());
            System.out.println("Iscrizione fallita: corso pieno o non attivo.");
            return false;
        }
        iscrizioniTotali++;
        System.out.println("Iscrizione riuscita: iscritto " + idIscritto + " al corso " + idCorso);
        return true;
    }
    public boolean disiscrivi(String idIscritto, String idCorso) {
        Iscritto iscritto = cercaIscritto(idIscritto);
        Corso corso = cercaCorso(idCorso);
        if (iscritto == null || corso == null) {
            System.out.println("Disiscrizione fallita: iscritto o corso non trovato.");
            return false;
        }
        boolean rimosso = iscritto.rimuoviCorso(idCorso);
        if (!rimosso) {
            System.out.println("Disiscrizione fallita: l'iscritto non era iscritto a questo corso.");
            return false;
        }
        corso.disiscrivi();
        System.out.println("Disiscrizione riuscita: iscritto " + idIscritto + " dal corso " + idCorso);
        return true;
    }
    public void stampaReportFinale() {
        System.out.println(" REPORT FINALE CENTRO SPORTIVO ");
        System.out.println("Corsi:");
        for (Corso c : corsi) {
            c.scheda();
            System.out.println();
        }
        System.out.println("Iscritti:");
        for (Iscritto i : iscritti) {
            i.stampaStato();
            System.out.println();
        }
        System.out.println("Iscrizioni totali effettuate: " + iscrizioniTotali);
    }
}
