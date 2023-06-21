import model.*;

import repository.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static repository.TelaLogin.exibirTelaLogin;
import static repository.TelaLogin.verificarCredenciais;

public class Main {

    public static void main(String[] args) {
        QuartoDAO.buscaTodosQuarto();
        HospedeDAO.buscaTodosh();
        HospedagemDAO.buscaTodos();
        FuncionarioDAO.todosFuncionarios();
//        ManutencaoDAO.buscaTodosManutencao();
        ServicoDAO.buscaTodos();
        exibirMensagemBoasVindas();
        exibirTelaLogin();
        chamaMenuPrincipal();
    }

    private static void exibirMensagemBoasVindas() {
        JOptionPane.showOptionDialog(null, "Bem-vindo ao Hotel",
                "Mensagem de Boas-vindas", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Entrar"}, "Entrar");
    }



    public static void chamaMenuPrincipal() {
        String[] opcoesMenu = {"Cadastros", "Processos", "Relatorios", "Sair"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

        switch (opcao) {
            case 0: //Cadastros
                chamaMenuCadastros();
                break;

            case 1: //Processos
                chamaMenuProcessos();
                break;

            case 2: //Relatorios
                listaCadastros();
                break;

            case 3: //SAIR
                int opcaoSair = JOptionPane.showOptionDialog(null, " Deseja realmente sair ? ",
                        "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (opcaoSair == JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                } else {
                    chamaMenuPrincipal();
                }
        }
    }

    public static void chamaMenuCadastros() {
        String[] opcoesMenuCadastro = {"Hóspede", "Funcionário", "Serviço", "Voltar"};
        int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha o cadastro que deseja acessar:",
                "Menu Cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

        switch (menuCadastro) {
            case 0: //Hospede
                chamaMenuHospede();
                break;
            case 1: //Funcionario
                chamaMenuFuncionario();
                break;
            case 2: //Serviço
                chamaMenuServico();
                break;
            case 3: //Voltar
                chamaMenuPrincipal();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    ////////////////////////////////HOSPEDES
    public static void chamaMenuHospede() {
        String[] opcoesMenuHospede = {"Inserir", "Alterar", "Excluir", "Voltar"};
        int opcao = 0;
        opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu de cadastros HOSPEDE",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuHospede, opcoesMenuHospede[0]
        );

        switch (opcao) {
            case 0: // Inserir Hospede
                cadastroDeHospede();
                break;
            case 1: // Alterar Hospede
                alterarCadastroHospede();
                break;
            case 2: // Excluir Hospede
                removerHospede();
                break;
            case 3: // Voltar
                chamaMenuPrincipal();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    private static void cadastroDeHospede() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do hóspede");
        if (nome == null) {
            chamaMenuCadastros();
        }
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do hóspede");
        if (cpf == null) {
            chamaMenuCadastros();
        }
        String celular = JOptionPane.showInputDialog(null, "Digite o celular do hóspede");
        if (celular == null) {
            chamaMenuCadastros();
        }
        String email = JOptionPane.showInputDialog(null, "Digite o email do hóspede");
        if (celular == null) {
            chamaMenuCadastros();
        }

        EscolheClassificacao[] classificacoes = EscolheClassificacao.values();
        String[] classificacoesNomes = new String[classificacoes.length];
        for (int i = 0; i < classificacoes.length; i++) {
            classificacoesNomes[i] = classificacoes[i].getDescricao();
        }

        int option = JOptionPane.showOptionDialog(null, "Selecione a classificação", "Classificação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, classificacoesNomes, classificacoesNomes[0]);

        EscolheClassificacao classificacaoSelecionada = null;
        if (option != JOptionPane.CLOSED_OPTION) {
            classificacaoSelecionada = classificacoes[option];
        } else {
            chamaMenuCadastros();
        }
        Hospede hospede = new Hospede(nome, cpf, celular, email, classificacaoSelecionada);
        HospedeDAO.salvar(hospede);
        chamaMenuPrincipal();
    }

    private static void alterarCadastroHospede() {
        Object[] selectionValuesHospede = HospedeDAO.findHospedeInArray();
        String initialSelectionHospede = (String) selectionValuesHospede[0];
        Object selectionHospede = JOptionPane.showInputDialog(null, "Selecione o código do hóspede",
                "Hospede", JOptionPane.QUESTION_MESSAGE, null, selectionValuesHospede, initialSelectionHospede);
        List<Hospede> hospedes = HospedeDAO.buscarPorNome((String) selectionHospede);
        Hospede hospede = hospedes.get(0);

        String nome = JOptionPane.showInputDialog(null, "Digite o nome do hóspede", hospede.getNome());
        if (nome == null) {
            chamaMenuCadastros();
        }
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do hóspede", hospede.getCpf());
        if (cpf == null) {
            chamaMenuCadastros();
        }
        String celular = JOptionPane.showInputDialog(null, "Digite o celular do hóspede", hospede.getCelular());
        if (celular == null) {
            chamaMenuCadastros();
        }
        String email = JOptionPane.showInputDialog(null, "Digite o email do hóspede", hospede.getEmail());
        if (celular == null) {
            chamaMenuCadastros();
        }

        hospede.setNome(nome);
        hospede.setCpf(cpf);
        hospede.setEmail(email);
        hospede.setCelular(celular);
        HospedeDAO.salvar(hospede);

        chamaMenuPrincipal();
    }

    private static void removerHospede() {
        Object[] selectionValuesHospede = HospedeDAO.findHospedeInArray();
        Object selectionHospede = JOptionPane.showInputDialog(null, "Selecione o hóspede que deseja remover:",
                "Remover Hóspede", JOptionPane.DEFAULT_OPTION, null, selectionValuesHospede, null);

        if (selectionHospede != null) {
            Hospede hospedeSelecionado = (Hospede) selectionHospede;
            HospedeDAO.removerHospede(hospedeSelecionado);
            JOptionPane.showMessageDialog(null, "Hóspede removido com sucesso!");
        }
    }

    /////////////////////////////FUNCIONARIO
    public static void chamaMenuFuncionario() {
        String[] opcoesMenuFuncionario = {"Inserir", "Alterar", "Excluir", "Voltar"};
        int opcao = 0;
        opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu de cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuFuncionario, opcoesMenuFuncionario[0]
        );

        switch (opcao) {
            case 0: // Inserir
                cadastroDeFuncionario();
                break;
            case 1: //Alterar
                alterarCadastroFuncionario();
                break;
            case 2: // Excluir
                removerFuncionario();
                break;
            case 3: // Voltar
                chamaMenuPrincipal();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    private static void cadastroDeFuncionario() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionário");
        if (nome == null) {
            chamaMenuCadastros();
            return;
        }

        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do funcionário");
        if (cpf == null) {
            chamaMenuCadastros();
            return;
        }

        String celular = JOptionPane.showInputDialog(null, "Digite o celular do funcionário");
        if (celular == null) {
            chamaMenuCadastros();
            return;
        }

        String email = JOptionPane.showInputDialog(null, "Digite o email do funcionário");
        if (email == null) {
            chamaMenuCadastros();
            return;
        }

        String cargo = JOptionPane.showInputDialog(null, "Digite o cargo do funcionário");
        if (cargo == null) {
            chamaMenuCadastros();
            return;
        }

        String input = JOptionPane.showInputDialog(null, "Digite o salário do funcionário");
        if (input == null || input.isEmpty()) {
            chamaMenuCadastros();
            return;
        }

        BigDecimal salario = BigDecimal.ZERO;
        if (!tryParseBigDecimal(input, salario)) {
            System.out.println("Valor inválido para o salário. Verifique o formato.");
            chamaMenuCadastros();
            return;
        }

        Funcionario funcionario = new Funcionario(nome, cpf, celular, email, cargo, salario);
        FuncionarioDAO.salvar(funcionario);
        chamaMenuPrincipal();
    }

    private static boolean tryParseBigDecimal(String input, BigDecimal output) {
        try {
            output = new BigDecimal(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void alterarCadastroFuncionario() {
        Object[] selectionValuesFuncionario = FuncionarioDAO.findFunciInArray();
        String initialSelectionFuncionario = (String) selectionValuesFuncionario[0];
        Object selectionFuncionario = JOptionPane.showInputDialog(null, "Selecione o código do funcionário",
                "Funcionario", JOptionPane.QUESTION_MESSAGE, null, selectionValuesFuncionario, initialSelectionFuncionario);
        List<Funcionario> funcionarios = FuncionarioDAO.buscarPorNomef((String) selectionFuncionario);
        Funcionario funcionario = funcionarios.get(0);

        String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionário", funcionario.getNome());
        if (nome == null) {
            chamaMenuCadastros();
            return;
        }
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do funcionário", funcionario.getCpf());
        if (cpf == null) {
            chamaMenuCadastros();
            return;
        }
        String celular = JOptionPane.showInputDialog(null, "Digite o celular do funcionário", funcionario.getCelular());
        if (celular == null) {
            chamaMenuCadastros();
            return;
        }
        String email = JOptionPane.showInputDialog(null, "Digite o email do funcionário", funcionario.getEmail());
        if (email == null) {
            chamaMenuCadastros();
            return;
        }

        String cargo = JOptionPane.showInputDialog(null, "Digite o cargo do funcionário", funcionario.getCargo());
        if (cargo == null) {
            chamaMenuCadastros();
            return;
        }

        String input = JOptionPane.showInputDialog(null, "Digite o salário do funcionário", funcionario.getSalario());
        BigDecimal salario = BigDecimal.ZERO;
        if (!tryParseBigDecimal(input, salario)) {
            System.out.println("Valor inválido para o salário. Verifique o formato.");
            chamaMenuCadastros();
            return;
        }

        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setEmail(email);
        funcionario.setCelular(celular);
        funcionario.setCargo(cargo);
        funcionario.setSalario(salario);
        FuncionarioDAO.salvar(funcionario);

        chamaMenuPrincipal();
    }

    private static boolean tryParseBigDecimal2(String input, BigDecimal output) {
        try {
            output = new BigDecimal(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void removerFuncionario() {
        Object[] selectionValuesFuncionario = FuncionarioDAO.findFunciInArray();
        Object selectionFunci = JOptionPane.showInputDialog(null, "Selecione o funcionário que deseja remover:",
                "Menu de cadastros", JOptionPane.DEFAULT_OPTION, null, selectionValuesFuncionario, null);

        if (selectionFunci != null) {
            Funcionario funcionarioSelecionado = (Funcionario) selectionFunci;
            FuncionarioDAO.removerFuncionario(funcionarioSelecionado);
            JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!");
        }
    }

    /////////////////////////////////SERVIÇO
    public static void chamaMenuServico() {
        String[] opcoesMenuServico = {"Inserir", "Alterar", "Excluir", "Voltar"};
        int opcao = 0;
        opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu de cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuServico, opcoesMenuServico[0]
        );

        switch (opcao) {
            case 0: // Inserir
                cadastroDeServico();
                break;
            case 1:// Alterar
                alterarCadastroServico();
                break;
            case 2: // Excluir
                removerServico();
                break;
            case 3: // Voltar
                chamaMenuPrincipal();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    private static void cadastroDeServico() {

        String tipo = JOptionPane.showInputDialog(null, "Digite o tipo de Serviço");
        if (tipo == null) {
            cadastroDeServico();
        }
//        String input = JOptionPane.showInputDialog(null, "Digite o valor do Serviço");
//        BigDecimal valor = new BigDecimal(input);

        String input = JOptionPane.showInputDialog(null, "Digite o valor do Serviço");
        BigDecimal valor = null;

        try {
            valor = new BigDecimal(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um valor válido!");
            cadastroDeServico();
        }
//        if (valor == null) {
//            cadastroDeServico();
//        }
        Servico servico = new Servico(tipo, valor);
        ServicoDAO.salvar(servico);
        chamaMenuPrincipal();
    }


    private static void alterarCadastroServico() {
        Object[] selectionValuesServico = ServicoDAO.findServicosInArray();
        String initialSelectionServico = (String) selectionValuesServico[0];
        Object selectionServico = JOptionPane.showInputDialog(null, "Selecione o código do serviço",
                "Servicos", JOptionPane.QUESTION_MESSAGE, null, selectionValuesServico, initialSelectionServico);
        List<Servico> servicos = ServicoDAO.buscarPorTipo((String) selectionServico);
        Servico servico = servicos.get(0);

        String tipo = JOptionPane.showInputDialog(null, "Digite o tipo de serviço", servico.getTipo());
        if (tipo == null) {
            cadastroDeServico();
        }

        String input = JOptionPane.showInputDialog(null, "Digite o valor do serviço", servico.getValor());
        BigDecimal valor = new BigDecimal(input);
        if (valor == null) {
            cadastroDeServico();
        }

        servico.setTipo(tipo);
        servico.setValor(valor);
        ServicoDAO.salvar(servico);

        chamaMenuPrincipal();
    }

    private static void removerServico() {
        Object[] selectionValuesServico = ServicoDAO.buscaTodos().toArray(new Servico[0]);
        Object selectionServico = JOptionPane.showInputDialog(null, "Selecione o serviço que deseja remover:",
                "Remover Serviço", JOptionPane.DEFAULT_OPTION, null, selectionValuesServico, null);

        if (selectionServico != null) {
            Servico servicoSelecionado = (Servico) selectionServico;
            ServicoDAO.excluirServico(servicoSelecionado);
            JOptionPane.showMessageDialog(null, "Serviço removido com sucesso!");
        }

        chamaMenuPrincipal();
    }

    //////////////////////////PROCESSOS
    public static void chamaMenuProcessos() {
        String[] opcoesMenuProcessos = {"Check-in", "Consumos", "Check-out", "Voltar"};
        int menuProcessos = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Processos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuProcessos, opcoesMenuProcessos[0]);

        switch (menuProcessos) {
            case 0: //Checkin
                chamaCheckin();
                break;
            case 1: //Cadastra consumos na hospedagem
                chamaServicos();
                break;
            case 2: //Checkout
                chamaCheckOut();
                break;
//            case 3: //Manutenções (no chamaMenuCadastros precisa ter a opção de cadastrar ordem de serviço para na chamaManut selecionar qual a ordem relacionada)
//                chamaManut();
//                break;
            case 3: //Voltar
                chamaMenuPrincipal();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public static void chamaCheckin() {
        boolean continua = true;

        while (continua == true) {


            List<Quarto> quartos = QuartoDAO.buscaTodosQuarto();
            Object[] selectionQuarto = quartos.stream().map(Quarto::getNumQuarto).toArray();
            String initialSelectionQuarto = (String) selectionQuarto[0];

            Object selecQuarto = JOptionPane.showInputDialog(null, "Selecione o quarto",
                    "Check-in", JOptionPane.QUESTION_MESSAGE, null, selectionQuarto, initialSelectionQuarto);

            if (selecQuarto == null) {
                JOptionPane.showMessageDialog(null, "Operação de check-in cancelada.");
                chamaMenuPrincipal();
                return; // Encerrar o método atual
            }

            List<Quarto> quartosSelect = QuartoDAO.buscarPorNumQuarto((String) selecQuarto);

            List<Hospede> hospedes = HospedeDAO.buscaTodosh();

            if (hospedes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum hóspede cadastrado!");
                chamaMenuPrincipal();
            }

            Object[] selectionHospede = hospedes.stream().map(Hospede::getNome).toArray();
            String initialSelectionHospede = (String) selectionHospede[0];

            Object selecHospede = JOptionPane.showInputDialog(null, "Selecione o hóspede",
                    "Check-in", JOptionPane.QUESTION_MESSAGE, null, selectionHospede, initialSelectionHospede);

            if (selecHospede == null) {
                JOptionPane.showMessageDialog(null, "Operação de check-in cancelada.");
                chamaMenuPrincipal();

            }

            LocalDate dataEntrada = LocalDate.now();
            String inputData = JOptionPane.showInputDialog(null, "Data de entrada (formato: dd/MM/yyyy): ");

            if (inputData == null) {
                JOptionPane.showMessageDialog(null, "Operação de check-in cancelada.");
                chamaMenuPrincipal();
                return;
            }


            try {
                dataEntrada = LocalDate.parse(inputData, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de data inválido!");
                chamaCheckin();
                continue;
            }

            List<Hospede> hospede = HospedeDAO.buscarPorNome((String) selecHospede);
            Quarto quarto = quartosSelect.get(0);
            Hospedagem hospedagem = new Hospedagem(dataEntrada, hospede.get(0), quarto);
            HospedagemDAO.salvar(hospedagem);
            continua = false;

        }

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realizar outro check-in?", "Continuar", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION){
            chamaCheckin();
        }

        if (resposta == JOptionPane.NO_OPTION) {
            chamaMenuProcessos();
        }


    }

    public static void chamaServicos() {
        Object[] selectionValuesQuarto = QuartoDAO.findquartosInArray();
        Integer initialSelectionQuarto = (Integer) selectionValuesQuarto[0];
        Object selectionQuarto = JOptionPane.showInputDialog(null, "Selecione o número do quarto",
                "Quarto", JOptionPane.QUESTION_MESSAGE, null, selectionValuesQuarto, initialSelectionQuarto);
        List<Quarto> quartos = QuartoDAO.buscarPorNumQuarto(String.valueOf((Integer) selectionQuarto));

        Quarto quarto = quartos.get(0);

        List<Hospedagem> hospedagens = HospedagemDAO.buscarPorCodigo(quarto.getNumQuarto());

        List<Integer> selectionValuesHospedagem = new ArrayList<>();
        for (Hospedagem hospedagem : hospedagens) {
            if (hospedagem.getCheckout() == null) {
                selectionValuesHospedagem.add(hospedagem.getCodigo());
            }
        }

        if (selectionValuesHospedagem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma hospedagem disponível para o quarto selecionado.");
            chamaMenuPrincipal();
            return;
        }

        Integer initialSelectionHospedagem = selectionValuesHospedagem.get(0);
        Object selectionHospedagem = JOptionPane.showInputDialog(null, "Selecione o código da hospedagem",
                "Hospedagem", JOptionPane.QUESTION_MESSAGE, null, selectionValuesHospedagem.toArray(), initialSelectionHospedagem);

        Hospedagem hospedagem = null;
        for (Hospedagem h : hospedagens) {
            if (h.getCodigo().equals(selectionHospedagem)) {
                hospedagem = h;
                break;
            }
        }

        Object[] selectionValuesServico = ServicoDAO.findServicosInArray();
        String initialSelectionServico = (String) selectionValuesServico[0];
        Object selectionServico = JOptionPane.showInputDialog(null, "Selecione a descrição do serviço",
                "Serviço", JOptionPane.QUESTION_MESSAGE, null, selectionValuesServico, initialSelectionServico);
        List<Servico> servicos = ServicoDAO.buscarPorTipo((String) selectionServico);

        Servico servico = servicos.get(0);

        hospedagem.addServico(servico); // Adiciona o serviço à lista de serviços da hospedagem

        // Salvar a hospedagem atualizada no banco de dados
        HospedagemDAO.salvar(hospedagem);

        JOptionPane.showMessageDialog(null, "Serviço " + servico.getTipo() + " adicionado na hospedagem " +
                selectionHospedagem + " no quarto " + selectionQuarto + " com sucesso!");

        chamaMenuPrincipal();
    }


    public static void chamaCheckOut() {
        Object[] selectionValuesHospedagem = HospedagemDAO.findhospedagensInArray();

        if (selectionValuesHospedagem.length == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma hospedagem encontrada!");
            return;
        }

        Integer initialSelectionHospedagem = (Integer) selectionValuesHospedagem[0];

        Object selectionHospedagem = JOptionPane.showInputDialog(null, "Selecione o código da hospedagem",
                "Hospedagem", JOptionPane.QUESTION_MESSAGE, null, selectionValuesHospedagem, initialSelectionHospedagem);

        if (selectionHospedagem == null) {
            return; // O usuário cancelou a seleção
        }

        List<Hospedagem> hospedagens = HospedagemDAO.buscarPorCodigo(String.valueOf((Integer) selectionHospedagem));

        if (hospedagens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hospedagem não encontrada!");
            return;
        }

        Hospedagem hospedagem = hospedagens.get(0);
        LocalDate dataCheckin = hospedagem.getCheckin();

        String inputData = JOptionPane.showInputDialog(null, "Data de saída (formato: dia/mês/ano): ");

        LocalDate dataSaida;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataSaida = LocalDate.parse(inputData, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido!");
            return;
        }

        if (dataSaida.isBefore(dataCheckin)) {
            JOptionPane.showMessageDialog(null, "A data de saída não pode ser anterior à data de check-in!");
            return;
        }

        hospedagem.setCheckout(dataSaida);
        long diasDif = ChronoUnit.DAYS.between(dataCheckin, dataSaida);
        int diasDifInt = Math.toIntExact(diasDif);
        hospedagem.setQuantidadeDiarias(diasDifInt);
        hospedagem.calculaValorConsumo();
        hospedagem.setValorTotalHospedagem(hospedagem.calculaValorTotalHospedagem());
        HospedagemDAO.salvar(hospedagem);

        JOptionPane.showMessageDialog(null, "O valor total da hospedagem é: " + hospedagem.getValorTotalHospedagem() + " reais");
        JOptionPane.showMessageDialog(null, hospedagem);
        JOptionPane.showMessageDialog(null, "Selecione a forma de pagamento");

        LocalDateTime dataHoraPagto = LocalDateTime.now();
        FormaPagamento[] formaPagamentos = FormaPagamento.values();
        String[] formasPagtoNomes = new String[formaPagamentos.length];
        for (int i = 0; i < formaPagamentos.length; i++) {
            formasPagtoNomes[i] = formaPagamentos[i].getDescricao();
        }

        int option = JOptionPane.showOptionDialog(null, "Selecione a forma de pagamento", "Formas de Pagamento",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, formasPagtoNomes, formasPagtoNomes[0]);

        if (option != JOptionPane.CLOSED_OPTION) {
            FormaPagamento formaPagtoSelecionada = formaPagamentos[option];

            Pagamento pagamento = new Pagamento(formaPagtoSelecionada, dataHoraPagto, hospedagem.getValorTotalHospedagem(), hospedagem);
            PagamentoDAO.salvar(pagamento);

            JOptionPane.showMessageDialog(null, "Processando pagamento...");
            JOptionPane.showMessageDialog(null, pagamento.mensagemPagto());
            JOptionPane.showMessageDialog(null, "Pagamento aprovado!");



            chamaMenuProcessos();
        }
    }




//    public static void chamaManut() {
//        Object[] selectManutencoes = {
//                TipoManutencao.ELETRICA.getDescricao(),
//                TipoManutencao.ESTRUTURAL.getDescricao(),
//                TipoManutencao.LIMPEZA.getDescricao()};
//
//        String initialSelectionManut = (String) selectManutencoes[0];
//        Object selecManut = JOptionPane.showInputDialog(null, "Selecione o tipo de manutenção realizada",
//                "Manutenções", JOptionPane.QUESTION_MESSAGE, null, selectManutencoes, initialSelectionManut);
//        chamaMenuPrincipal();
//    }

    /////////////////RELATÓRIOS////////////////////
    private static void listaCadastros() {
        String[] opcoesMenuRelatorios = {"Hóspedes", "Funcionários", "Serviços", "Hospedagens", "Quartos", "Voltar"};
        int menuRelatorios = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Relatórios",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuRelatorios, opcoesMenuRelatorios[0]);

        switch (menuRelatorios) {
            case 0: //Hospedes
                chamaRelatorioHospede();
                break;
            case 1: //Funcionarios
                chamaRelatorioFuncionario();
                break;
            case 2: //Serviços
                chamaRelatorioServico();
                break;
//            case 3: //Manutenção
//                chamaRelatorioManutencao();
//                break;
            case 3: //Hospedagem
                chamaRelatorioHospedagem();
                break;
            case 4: //Quarto
                chamaRelatorioQuarto();
                break;
            case 5: //Voltar
                chamaMenuPrincipal();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    private static void chamaRelatorioHospede() {
        List<Hospede> hospedes = HospedeDAO.buscaTodosh();
        RelatorioHospedeForm.emitirRelatorio(hospedes);
    }
    private static void chamaRelatorioFuncionario() {
        List<Funcionario> funcionarios = FuncionarioDAO.todosFuncionarios();
        RelatorioFuncionarioForm.emitirRelatorio(funcionarios);
    }
    private static void chamaRelatorioServico() {
        List<Servico> servicos = ServicoDAO.buscaTodos();
        RelatorioServicoForm.emitirRelatorio(servicos);
    }

//    private static void chamaRelatorioManutencao() {
//        List<Manutencao> manutencaos = ManutencaoDAO.buscaTodos();
//        RelatorioManutencaoForm.emitirRelatorio(manutencaos);
//    }

    private static void chamaRelatorioQuarto() {
        List<Quarto> quartos = QuartoDAO.buscaTodosQuarto();
        RelatorioQuartoForm.emitirRelatorio(quartos);
    }
    private static void chamaRelatorioHospedagem() {
        List<Hospedagem> hospedagens = HospedagemDAO.buscaTodos();
        RelatorioHospedagemForm.emitirRelatorio(hospedagens);
    }
}