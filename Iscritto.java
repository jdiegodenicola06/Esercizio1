package centrosportivo;

public class Iscritto {
    private final String id;
    private String nome;
    private Corso corso1;
    private Corso corso2;

    public Iscritto(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean aggiungiCorso(Corso c) {
        if (c == null){
           return false;
        }
        if ((corso1 != null && corso1.getId().equals(c.getId())) ||
            (corso2 != null && corso2.getId().equals(c.getId()))) {
            System.out.println("Iscritto " + id + ": già iscritto al corso " + c.getId());
            return false;
        }
        if (corso1 == null) {
            corso1 = c;
            return true;
        } else if (corso2 == null) {
            corso2 = c;
            return true;
        } else {
            return false; // già 2 corsi
        }
    }
    public boolean rimuoviCorso(String idCorso) {
        if (idCorso == null) {
            return false;
        }
        if (corso1 != null && corso1.getId().equals(idCorso)) {
            corso1 = null;
            return true;
        }
        if (corso2 != null && corso2.getId().equals(idCorso)) {
            corso2 = null;
            return true;
        }
        return false;
    }
    public void stampaStato() {
        System.out.println(" Stato iscritto ");
        System.out.println("ID: " + id + " - Nome: " + nome);
        System.out.println("Corsi a cui è iscritto:");
        if (corso1 == null && corso2 == null) {
            System.out.println("  Nessun corso.");
        } else {
            if (corso1 != null) {
                System.out.println("  - " + corso1.getId() + " (" + corso1.getNome() + ")");
            }
            if (corso2 != null) {
                System.out.println("  - " + corso2.getId() + " (" + corso2.getNome() + ")");
            }
        }
    }
}

