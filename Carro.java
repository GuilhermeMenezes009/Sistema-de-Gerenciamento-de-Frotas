    public class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String marca, String modelo, int ano, int numeroPortas, String placa) {
        super(marca, modelo, ano, placa);
        this.numeroPortas = numeroPortas;
    }

    

    @Override
    public String toString() {
        return super.toString() + "\nNúmero de portas: " + numeroPortas;
    }



    public int getNumeroPortas() {
        return numeroPortas;
    }



    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }
}