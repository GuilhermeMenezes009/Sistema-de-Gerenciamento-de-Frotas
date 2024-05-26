import java.util.List;
import java.util.Scanner;

public class CadVeiculo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VeiculoService veiculoService = new VeiculoService();

        int opcao;
        do {
            System.out.print("\033[H\033[2J");
            System.out.println("Sistema de Gerenciamento de Frotas");
            System.out.println("Opções:");
            System.out.println("1 - Cadastrar Novo Veículo");
            System.out.println("2 - Listar todos Veículos cadastrados");
            System.out.println("3 - Pesquisar um Veículo por placa");
            System.out.println("4 - Remover um Veículo");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        System.out.println("Cadastro de Veículo - Início"); 
                        System.out.println("Digite: 1 para automovel ou 2 para motocicleta");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();
                        if (tipo == 1) {
                            System.out.print("Digite a marca: ");
                            String marca = scanner.nextLine();
                            System.out.print("Digite o modelo: ");
                            String modelo = scanner.nextLine();
                            System.out.print("Digite o ano: ");
                            int ano = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Digite o número de portas: ");
                            int numeroPortas = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Digite a placa: ");
                            String placa = scanner.nextLine();
                            Carro carro = new Carro(marca, modelo, ano, numeroPortas, placa);
                            veiculoService.cadastrarVeiculo(carro);
                            System.out.println("Veículo cadastrado com sucesso!");
                            System.out.println("Pressione Enter para voltar ao Menu Inicial");
                            scanner.nextLine();
                        } else if (tipo == 2) {
                            System.out.print("Digite a marca: ");
                            String marca = scanner.nextLine();
                            System.out.print("Digite o modelo: ");
                            String modelo = scanner.nextLine();
                            System.out.print("Digite o ano: ");
                            int ano = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Digite a placa: ");
                            String placa = scanner.nextLine();
                            Moto moto = new Moto(marca, modelo, ano, false, placa);
                            veiculoService.cadastrarVeiculo(moto);
                            System.out.println("Moto cadastrada com sucesso!");
                            System.out.println("Pressione Enter para voltar ao Menu Inicial");
                            scanner.nextLine();
                        }
                        break;
                    case 2:
                        System.out.println("Listar todos Veículos");
                        List<Veiculo> veiculos = veiculoService.listarTodosVeiculos();
                        for (Veiculo veiculo : veiculos) {
                            System.out.println(veiculo);
                        }
                        System.out.println("Pressione Enter para voltar ao Menu Inicial");
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("Pesquisa de Veículo por placa");
                        System.out.print("Digite a placa: ");
                        String placa = scanner.nextLine();
                        Veiculo veiculoPesquisado = veiculoService.pesquisarVeiculoPorPlaca(placa);
                        if (veiculoPesquisado!= null) {
                            System.out.println(veiculoPesquisado);
                        } else {
                            System.out.println("Veículo não encontrado!");
                        }
                        System.out.println("Pressione Enter para voltar ao Menu Inicial");
                        scanner.nextLine();
                        break;
                    case 4:
                        System.out.println("Remoção de Veículo por placa");
                        System.out.print("Digite a placa: ");
                        placa = scanner.nextLine();
                        veiculoPesquisado = veiculoService.pesquisarVeiculoPorPlaca(placa);
                        if (veiculoPesquisado!= null) {
                            veiculoService.removerVeiculos(veiculoPesquisado);
                            System.out.println("Veículo removido com sucesso!");
                        } else {
                            System.out.println("Veículo não encontrado!");
                        }
                        System.out.println("Pressione Enter para voltar ao Menu Inicial");
                        scanner.nextLine();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e){
                System.out.println("NÃO FOI POSSÍVEL CADASTRAR VEÍCULO: " + e.getMessage());
                System.out.println("Precione enter para voltar ao Menu Inicial");
                scanner.nextLine();
            }         
        } while (opcao!= 0); 

        scanner.close();
    }
}