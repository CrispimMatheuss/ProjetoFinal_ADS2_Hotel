import model.*;
import repository.*;
import java.time.temporal.ChronoUnit;
import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
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

    private static void exibirTelaLogin() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] message = {
                "Login:", usernameField,
                "Senha:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(null, message,
                "Tela de Login", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (verificarCredenciais(username, password)) {
                chamaMenuPrincipal();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Credenciais inválidas. Tente novamente.", "Erro de login", JOptionPane.ERROR_MESSAGE);
                exibirTelaLogin();
            }
        } else {
            System.exit(0);
        }
    }

    private static boolean verificarCredenciais(String username, String password) {
        return username.equals("admin") && password.equals("123456");
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
        int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
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
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente");
        if (nome == null) {
         chamaMenuCadastros();
        }
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do cliente");
        if (cpf == null) {
          chamaMenuCadastros();
        }
        String celular = JOptionPane.showInputDialog(null, "Digite o celular do cliente");
        if (celular == null) {
           chamaMenuCadastros();
        }
        String email = JOptionPane.showInputDialog(null, "Digite o email do cliente");
        if (celular == null) {
           chamaMenuCadastros();
        }

        Hospede hospede = new Hospede(nome, cpf, celular, email);
        PessoaDAO.salvar(hospede);
        //chamaMenuPrincipal();
    }

    private static void alterarCadastroHospede() {
        Object[] selectionValuesHospede = PessoaDAO.findHospedeInArray();
        String initialSelectionHospede = (String) selectionValuesHospede[0];
        Object selectionHospede = JOptionPane.showInputDialog(null, "Selecione o código do hóspede",
                "Hospede", JOptionPane.QUESTION_MESSAGE, null, selectionValuesHospede, initialSelectionHospede);
        List<Hospede> hospedes = PessoaDAO.buscarPorNome((String) selectionHospede);
        Hospede hospede = hospedes.get(0);

        String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente", hospede.getNome());
        if (nome == null) {
            chamaMenuCadastros();
        }
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do cliente", hospede.getCpf());
        if (cpf == null) {
            chamaMenuCadastros();
        }
        String celular = JOptionPane.showInputDialog(null, "Digite o celular do cliente", hospede.getCelular());
        if (celular == null) {
            chamaMenuCadastros();
        }
        String email = JOptionPane.showInputDialog(null, "Digite o email do cliente", hospede.getEmail());
        if (celular == null) {
            chamaMenuCadastros();
        }

        hospede.setNome(nome);
        hospede.setCpf(cpf);
        hospede.setEmail(email);
        hospede.setCelular(celular);
        PessoaDAO.salvar(hospede);

        chamaMenuPrincipal();
    }

    private static void removerHospede() {
        Object[] selectionValuesHospede = HospedagemDAO.findhospedagensInArray();
        Object selectionHospede = JOptionPane.showInputDialog(null, "Selecione o hóspede para remover:",
                "Remover Hóspede", JOptionPane.DEFAULT_OPTION, null, selectionValuesHospede, null);

        if (selectionHospede != null) {
            Hospede hospedeSelecionado = (Hospede) selectionHospede;
            PessoaDAO.removerHospede(hospedeSelecionado);
            JOptionPane.showMessageDialog(null, "Hóspede removido com sucesso!");
        }
    }
    private static void hospedesCadastrados() {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Lista de Hóspedes:\n\n");

        List<Hospede> hospedes = HospedeDAO.todosHospedes();

        if (hospedes.isEmpty()) {
            mensagem.append("Nenhum hóspede cadastrado.");
        } else {
            for (Hospede hospede : hospedes) {
                mensagem.append("Nome: ").append(hospede.getNome()).append("\n\n");
                mensagem.append("Cpf: ").append(hospede.getCpf()).append("\n\n");
                mensagem.append("Celular").append(hospede.getCelular()).append("\n");
                mensagem.append("Email: ").append(hospede.getEmail()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, mensagem.toString(), "Lista de Hóspedes", JOptionPane.INFORMATION_MESSAGE);
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
        }
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do funcionário");
        if (cpf == null) {
            chamaMenuCadastros();
        }
        String celular = JOptionPane.showInputDialog(null, "Digite o celular do funcionário");
        if (celular == null) {
            chamaMenuCadastros();
        }
        String email = JOptionPane.showInputDialog(null, "Digite o email do funcionário");
        if (email == null) {
            chamaMenuCadastros();
        }

        Funcionario funcionario = new Funcionario(nome, cpf, celular, email);
        PessoaDAO.salvar(funcionario);
        chamaMenuPrincipal();
    }

    private static void alterarCadastroFuncionario() {
        Object[] selectionValuesFuncionario = PessoaDAO.findFunciInArray();
        String initialSelectionFuncionario = (String) selectionValuesFuncionario[0];
        Object selectionFuncionario = JOptionPane.showInputDialog(null, "Selecione o código do hóspede",
                "Funcionario", JOptionPane.QUESTION_MESSAGE, null, selectionValuesFuncionario, initialSelectionFuncionario);
        List<Funcionario> funcionarios = PessoaDAO.buscarPorNomef((String) selectionFuncionario);
        Funcionario funcionario = funcionarios.get(0);

        String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionário", funcionario.getNome());
        if (nome == null) {
        chamaMenuCadastros();
        }
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do funcionário", funcionario.getCpf());
        if (cpf == null) {
        chamaMenuCadastros();
        }
        String celular = JOptionPane.showInputDialog(null, "Digite o celular do funcionário", funcionario.getCelular());
        if (celular == null) {
        chamaMenuCadastros();
        }
        String email = JOptionPane.showInputDialog(null, "Digite o email do funcionário", funcionario.getEmail());
        if (email == null) {
        chamaMenuCadastros();
        }

        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setEmail(email);
        funcionario.setCelular(celular);
        PessoaDAO.salvar(funcionario);

        chamaMenuPrincipal();
}

    private static void removerFuncionario() {
        Object[] selectionValuesFuncionario = PessoaDAO.findFunciInArray();
        Object selectionFunci = JOptionPane.showInputDialog(null, "Selecione o funcionário para remover:",
                "Menu de cadastros", JOptionPane.DEFAULT_OPTION, null, selectionValuesFuncionario, null);

        if (selectionFunci != null) {
            Funcionario funcionarioSelecionado = (Funcionario) selectionFunci;
            PessoaDAO.removerFuncionario(funcionarioSelecionado);
            JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!");
        }
    }
    //////////////////////////QUARTO
    private static void quartosCadastrados() {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Lista de Quarto:\n\n");

        List<Quarto> quartos = QuartoDAO.buscaTodosQuarto();
        if (quartos.isEmpty()) {
            mensagem.append("Nenhum hóspede cadastrado.");
        } else {
            for (Quarto quarto : quartos) {
                mensagem.append("Nome: ").append(quarto.getNumQuarto()).append("\n\n");
                mensagem.append("Email: ").append(quarto.getTipoQuarto()).append("\n");
                mensagem.append("Celular: ").append(quarto.getLimitePessoas()).append("\n");
                mensagem.append("Disponibilidade do Quarto: ").append(quarto.getDisponibilidade()).append("\n");
                mensagem.append("Valor da Diária: ").append(quarto.getValor()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, mensagem.toString(), "Lista de Hóspedes", JOptionPane.INFORMATION_MESSAGE);
    }
    private static void funcionariosCadastrados() {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Lista de Funcionarios:\n\n");

        List<Funcionario> funcionarios = FuncionarioDAO.todosFuncionarios();
        if (funcionarios.isEmpty()) {
            mensagem.append("Nenhum funcionarios cadastrado.");
        } else {
            for (Funcionario funcionario : funcionarios) {
                mensagem.append("Nome: ").append(funcionario.getNome()).append("\n\n");
                mensagem.append("Cpf").append(funcionario.getCpf()).append("\n");
                mensagem.append("Celular").append(funcionario.getCelular()).append("\n");
                mensagem.append("Email: ").append(funcionario.getEmail()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, mensagem.toString(), "Lista de Hóspedes", JOptionPane.INFORMATION_MESSAGE);
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

            //case 1: Alterar
            //    alterarCadastro();
            //    break;

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
        String input = JOptionPane.showInputDialog(null, "Digite o valor do Serviço");
        BigDecimal valor = new BigDecimal(input);
        if (valor == null) {
            cadastroDeServico();
        }
        Servico servico = new Servico(tipo, valor);
        ServicoDAO.salvar(servico);
        chamaMenuPrincipal();
    }

    private static void removerServico() {
        Object[] selectionValuesServico = ServicoDAO.buscaTodos().toArray(new Servico[0]);
        Object selectionServico = JOptionPane.showInputDialog(null, "Selecione o serviço para remover:",
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
        String[] opcoesMenuProcessos = {"Check-in", "Check-out", "Consumos", "Manutenções", "Voltar"};
        int menuProcessos = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Processos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuProcessos, opcoesMenuProcessos[0]);

        switch (menuProcessos) {
            case 0: //Checkin
                chamaCheckin();
                break;
            case 1: //Checkout
                chamaCheckOut();
                break;
            case 2: //Cadastra consumos na hospedagem
                chamaServicos();
                break;
            case 3: //Manutenções
                chamaManut();
                break;
            case 4: //Voltar
                chamaMenuPrincipal();
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public static void chamaCheckin() {
        LocalDate dataEntrada = LocalDate.now();
        String inputData = JOptionPane.showInputDialog(null, "Data de entrada (formato: dd/MM/yyyy): ");

        try {
            dataEntrada = LocalDate.parse(inputData, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido!");
            chamaCheckin();
        }

        List<Quarto> quartos = QuartoDAO.buscaTodosQuarto();
        Object[] selectionQuarto = quartos.stream().map(Quarto::getNumQuarto).toArray();
        String initialSelectionQuarto = (String) selectionQuarto[0];
        Object selecQuarto = JOptionPane.showInputDialog(null, "Selecione o quarto",
                "Check-in", JOptionPane.QUESTION_MESSAGE, null, selectionQuarto, initialSelectionQuarto);
        List<Quarto> quartosSelect = QuartoDAO.buscarPorNumQuarto((String) selecQuarto);

        List<Hospede> hospedes = PessoaDAO.buscaTodosh();

        if (hospedes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum hóspede cadastrado!");
            chamaMenuPrincipal();
        }

        Object[] selectionHospede = hospedes.stream().map(Hospede::getNome).toArray();
        String initialSelectionHospede = (String) selectionHospede[0];
        Object selecHospede = JOptionPane.showInputDialog(null, "Selecione o hóspede",
                "Check-in", JOptionPane.QUESTION_MESSAGE, null, selectionHospede, initialSelectionHospede);

        List<Hospede> hospede = PessoaDAO.buscarPorNome((String) selecHospede);
        Hospedagem hospedagem = new Hospedagem(60, dataEntrada, null, hospede.get(0), 0, quartosSelect.get(0));
        HospedagemDAO.salvar(hospedagem);

        chamaMenuProcessos();
    }

    public static void chamaCheckOut() {

        Object[] selectionValuesHospedagem = HospedagemDAO.findhospedagensInArray();
        Integer initialSelectionHospedagem = (Integer) selectionValuesHospedagem[0];
        Object selectionHospedagem = JOptionPane.showInputDialog(null, "Selecione o código da hospedagem?",
                "Hospedagem", JOptionPane.QUESTION_MESSAGE, null, selectionValuesHospedagem, initialSelectionHospedagem);
        List<Hospedagem> hospedagens = HospedagemDAO.buscarPorCodigo((Integer) selectionHospedagem);

        LocalDate dataSaida = LocalDate.now();
        String inputData = JOptionPane.showInputDialog(null, "Data de saída (formato: dd/MM/yyyy): ");

        try {
            dataSaida = LocalDate.parse(inputData, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido!");
            return; // Retorna ou executa outra ação de tratamento de erro
        }

        Object[] selectionValuesPagamento = PagamentoDAO.findPagamentosInArray();
        Integer initialSelectionPagamento = (Integer) selectionValuesPagamento[0];
        Object selectionPagamento = JOptionPane.showInputDialog(null, "Selecione o código do pagamento",
                "Hospedagem", JOptionPane.QUESTION_MESSAGE, null, selectionValuesPagamento, initialSelectionPagamento);
        List<Pagamento> pagamentos = PagamentoDAO.buscarPorCodigo((Integer) selectionPagamento);

        Hospedagem hospedagem = hospedagens.get(0);
        hospedagem.setCheckout(dataSaida);
        LocalDate dataEntrada = hospedagem.getCheckin();
        long diasDif = Math.toIntExact(ChronoUnit.DAYS.between(dataSaida, dataEntrada));
        Integer diasDifInt = Math.toIntExact(diasDif);
        hospedagem.setQuantidadeDiarias(diasDifInt);
        hospedagem.setValorTotalHospedagem(hospedagem.calculaValorTotalHospedagem());
        HospedagemDAO.salvar(hospedagem);
        JOptionPane.showMessageDialog(null, hospedagem);

        Pagamento pagamento = pagamentos.get(0);
        pagamento.setHospedagem(hospedagem);
        BigDecimal valorPagto = hospedagem.getValorTotalHospedagem();
        pagamento.setValorTotal(valorPagto);
        PagamentoDAO.salvar(pagamento);
        JOptionPane.showMessageDialog(null, "pagamento aprovado!");
        JOptionPane.showMessageDialog(null, pagamento.mensagemPagto());
        chamaMenuPrincipal();

        chamaMenuProcessos();

    }

    public static void chamaServicos() {

        Object[] selectionValuesHospedagem = HospedagemDAO.findhospedagensInArray();
        Integer initialSelectionHospedagem = (Integer) selectionValuesHospedagem[0];
        Object selectionHospedagem = JOptionPane.showInputDialog(null, "Selecione o código da hospedagem?",
                "Hospedagem", JOptionPane.QUESTION_MESSAGE, null, selectionValuesHospedagem, initialSelectionHospedagem);
        List<Hospedagem> hospedagens = HospedagemDAO.buscarPorCodigo((Integer) selectionHospedagem);

        Object[] selectionValuesServico = ServicoDAO.findServicosInArray();
        String initialSelectionServico = (String) selectionValuesServico[0];
        Object selectionServico = JOptionPane.showInputDialog(null, "Selecione a descricao da Serviço?",
                "Hospedagem", JOptionPane.QUESTION_MESSAGE, null, selectionValuesServico, initialSelectionServico);
        List<Servico> servicos = ServicoDAO.buscarPorTipo((String) selectionServico);

        Hospedagem hospedagem = hospedagens.get(0);
        hospedagem.addServico(servicos.get(0));
        HospedagemDAO.salvar(hospedagem);
        JOptionPane.showMessageDialog(null, hospedagem);
        chamaMenuPrincipal();
    }

    public static void chamaManut() {
        Object[] selectManutencoes = {
                TipoManutencao.ELETRICA.getDescricao(),
                TipoManutencao.ESTRUTURAL.getDescricao(),
                TipoManutencao.LIMPEZA.getDescricao()};

        String initialSelectionManut = (String) selectManutencoes[0];
        Object selecManut = JOptionPane.showInputDialog(null, "Selecione o tipo de manutenção realizada",
                "Manutenções", JOptionPane.QUESTION_MESSAGE, null, selectManutencoes, initialSelectionManut);
    }

    /////////////////RELATÓRIOS////////////////////
    private static void listaCadastros() {
        String[] opcoesMenuRelatorios = {"Hóspedes", "Funcionários", "Serviços", "Manutenção", "Hospedagem", "Voltar"};
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
            case 3: //Manutenção
                chamaRelatorioManutencao();
                break;
            case 4: //Hospedagem
                //chamaRelatorioHospedagem();
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
        List<Hospede> hospedes = PessoaDAO.buscaTodosh();
        RelatorioHospedeForm.emitirRelatorio(hospedes);
    }

    private static void chamaRelatorioFuncionario() {
        List<Funcionario> funcionarios = PessoaDAO.buscaTodosf();
        RelatorioFuncionarioForm.emitirRelatorio(funcionarios);
    }

    private static void chamaRelatorioServico() {
        List<Servico> servicos = ServicoDAO.buscaTodos();
        RelatorioServicoForm.emitirRelatorio(servicos);
    }

    private static void chamaRelatorioManutencao() {
        List<Manutencao> manutencaos = ManutencaoDAO.buscaTodos();
        RelatorioManutencaoForm.emitirRelatorio(manutencaos);
    }

    private static void chamaRelatorioHospedagem() {
        List<Hospedagem> hospedagems = HospedagemDAO.buscaTodos();
        //RelatorioHospedagemForm.emitirRelatorio(hospedagems);
    }
}