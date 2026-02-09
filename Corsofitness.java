package centrosportivo;

public class Corsofitness extends Corso {
    private int intensita; // 1..5

    public Corsofitness(String id, String nome, int postiDisponibili, boolean attivo, int intensita) {
        super(id, nome, postiDisponibili, attivo);
        if (intensita < 1) intensita = 1;
        if (intensita > 5) intensita = 5;
        this.intensita = intensita;
    }
    public int getIntensita() {
        return intensita;
    }
    public void setIntensita(int intensita) {
        if (intensita >= 1 && intensita <= 5) {
            this.intensita = intensita;
        }
    }
    @Override
    public String getTipo() {
        return "CorsoFitness (intensità " + intensita + ")";
    }
}

