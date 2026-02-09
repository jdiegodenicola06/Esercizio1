package centrosportivo;

public abstract class Corso {
    private final String id;
    private String nome;
    private int postiDisponibili;
    private boolean attivo;

    public Corso(String id, String nome, int postiDisponibili, boolean attivo) {
        this.id = id;
        this.nome = nome;
        this.postiDisponibili = postiDisponibili;
        this.attivo = attivo;
    }
    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public int getPostiDisponibili() {
        return postiDisponibili;
    }
    public boolean isAttivo() {
        return attivo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }
    public boolean iscrivi() {
        if (!attivo || postiDisponibili <= 0) {
            return false;
        }
        postiDisponibili--;
        return true;
    }
    public void disiscrivi() {
        postiDisponibili++;
    }
    public void scheda() {
        System.out.println("=== Scheda corso ===");
        System.out.println("Tipo: " + getTipo());
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Posti disponibili: " + postiDisponibili);
        System.out.println("Attivo: " + (attivo ? "Sì" : "No"));
    }
    public abstract String getTipo();
}
