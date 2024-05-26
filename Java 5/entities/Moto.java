public class Moto extends Veiculo {
    private boolean partidaEletrica;

    public Moto(String marca, String modelo, int ano, boolean partidaEletrica, String placa) {
        super(marca, modelo, ano, placa);
        this.partidaEletrica = partidaEletrica;
    }

    

    @Override
    public String toString() {
        return super.toString() + "\nPartida elétrica: " + partidaEletrica;
    }



    public boolean isPartidaEletrica() {
        return partidaEletrica;
    }



    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }
}