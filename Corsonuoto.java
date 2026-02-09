package centrosportivo;

public class Corsonuoto extends Corso {
    private String livello;

    public Corsonuoto(String id, String nome, int postiDisponibili, boolean attivo, String livello) {
        super(id, nome, postiDisponibili, attivo);
        this.livello = livello;
    }
    public String getLivello() {
        return livello;
    }
    public void setLivello(String livello) {
        this.livello = livello;
    }
    @Override
    public String getTipo() {
        return "CorsoNuoto (livello " + livello + ")";
    }
}

