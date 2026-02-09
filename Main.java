package centrosportivo;

public class Main {
    public static void main(String[] args) {
        // creare CentroSportivo
        Centrosportivo cs = new Centrosportivo();

        // creare 4 corsi (2 fitness, 2 nuoto) con almeno 1 corso pieno (posti=0)
        Corsofitness cf1 = new Corsofitness("F1", "Fitness Mattina", 5, true, 3);
        Corsofitness cf2 = new Corsofitness("F2", "Fitness Sera", 0, true, 4); 
        Corsonuoto cn1 = new Corsonuoto("N1", "Nuoto Base", 2, true, "Base");
        Corsonuoto cn2 = new Corsonuoto("N2", "Nuoto Avanzato", 1, true, "Avanzato");

        cs.aggiungiCorso(cf1);
        cs.aggiungiCorso(cf2);
        cs.aggiungiCorso(cn1);
        cs.aggiungiCorso(cn2);
        
        Iscritto i1 = new Iscritto("I1", "Mario Rossi");
        Iscritto i2 = new Iscritto("I2", "Luca Bianchi");
        Iscritto i3 = new Iscritto("I3", "Anna Verdi");

        cs.aggiungiIscritto(i1);
        cs.aggiungiIscritto(i2);
        cs.aggiungiIscritto(i3);

        cs.iscrivi("I1", "F1");
        cs.iscrivi("I1", "N1");
        cs.iscrivi("I1", "N2");
        cs.iscrivi("I2", "F2");

        cs.disiscrivi("I1", "N1");
        cs.iscrivi("I3", "N1");

        cs.stampaReportFinale();
    }
}
