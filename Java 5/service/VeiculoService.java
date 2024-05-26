import java.util.ArrayList;
import java.util.List;


public class VeiculoService {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void cadastrarVeiculo(Veiculo veiculo) throws Exception {
        if (veiculo.getMarca().isEmpty() || veiculo.getModelo().isEmpty() || veiculo.getPlaca().isEmpty()) {
            throw new Exception("Campos em branco não são permitidos!");
        }
        if (veiculo.getAno() == 0) {
            throw new Exception("Ano inválido!");
        }
        if (veiculo instanceof Carro && ((Carro) veiculo).getNumeroPortas() == 0) {
            throw new Exception("Número de portas inválido!");
        }
        if (veiculos.contains(veiculo)) {
            throw new Exception("Placa já cadastrada!");
        }
        veiculos.add(veiculo);
    }

    public Veiculo pesquisarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public List<Veiculo> listarTodosVeiculos() {
        return veiculos;
    }

    public void removerVeiculos(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public boolean verificarPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarAno(int ano) {
        return ano <= 0;
    }

    public boolean verificarPortas(int portas) {
        return portas <= 0;
    }

    public boolean verificarMarca(String marca) {
       
        return false;
    }

    public boolean verificarModelo(String modelo) {
        
        return false;
    }
}