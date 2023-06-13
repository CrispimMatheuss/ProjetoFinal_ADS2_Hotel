import model.*;
import repository.*;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import model.TipoQuarto;
public class Main {
    private static Object PessoaDAODAO;
    private static repository.HospedagemDAO HospedagemDAO;
    public static void main(String[] args) {
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
                "Menu de Login", JOptionPane.OK_CANCEL_OPTION);

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
        }}
    private static boolean verificarCredenciais(String username, String password) {
        return username.equals("admin") && password.equals("123456");
    }
    private static void chamaMenuPrincipal() {

        String[] opcoesMenu = {"Cadastros", "Processos", "Relatorios", "Sair"};
        int opcao1 = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

        switch (opcao1) {
            case 0: //Cadastros
                chamaMenuCadastros();
                break;

            case 1: //Processos
                chamaMenuProcessos();
                break;

            case 2: //Relatorios
                listaCadastros();
                break;

            case 3: //Sair
                int opcaoSair = JOptionPane.showOptionDialog(null," Deseja realmente sair ? ",
                        "Confirmação",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);

                if (opcaoSair == JOptionPane.YES_NO_OPTION){
                    System.exit(0);
                }else {
                    chamaMenuPrincipal();
                }}}

    public static void chamaMenuHospede(){
        String[] opcoesMenu1 = {"Inserir", "Alterar", "Excluir", "Voltar"};
        int opcao = 0;
        while (opcao != 3) {
            opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                    "Menu Secundário",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu1, opcoesMenu1[0]
            );

            switch (opcao) {
                case 0: // Inserir Hospede
                    cadastroDeHospede();
                    break;

                case 1: // Alterar Hospede
//                    alterarHospede(HospedagemDAO);
                    break;
                case 2: // Excluir Hospede
                    removerHospede();
                    break;
//                pessoa = selecaoDePessoa();
//                getPessoaDAO().remover(pessoa);
//                pessoa = null;

                case 3: // Voltar
                    chamaMenuPrincipal();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }}}
    public static void chamaMenuFuncionario(){
        String[] opcoesMenu1 = {"Inserir", "Alterar", "Excluir", "Voltar"};
        int opcao = 0;
        while (opcao != 3) {
            opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                    "Menu Secundário",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu1, opcoesMenu1[0]);

            switch (opcao) {
                case 0: // Inserir Funcionario
                    cadastroDeFuncionario();
                    break;
                case 1: // Alterar Funcionario
                    //alterarCadastro();
                    break;

                case 2: // Excluir Funcionario
                    //excluirCadastro();
                    break;

                case 3: // Voltar
                    chamaMenuPrincipal();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }}}
    public static void chamaMenuServico(){
        String[] opcoesMenu1 = {"Selecionar", "Inserir", "Alterar", "Excluir", "Voltar"};
        int opcao = 0;
        while (opcao != 4) {
            opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                    "Menu Secundário",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu1, opcoesMenu1[0]
            );

            switch (opcao) {
                case 0: // Selecionar Serviço
                    selecionarServico();
                    break;

                case 1: //Inserir novo serviço
                    cadastroDeServico();
                    break;

                case 2: // Alterar Serviço
                    //selecionarServico();
                    break;

                case 3: // Excluir Serviço
                    //alterarCadastro();
                    break;

                case 4: // Voltar
                    chamaMenuPrincipal();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
    private static void chamaMenuCadastros() {
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
                ///cadastroDeFuncionario();
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

    private static void selecionarServico() {
        String[] servicos = {"Cafe da manhã simples", "Cafe da manhã premium", "Almoço" , "Janta" , "Serviço de quarto" , "Voltar"};
        int opcao = 0;

        while (opcao != 5) {
            opcao = JOptionPane.showOptionDialog(null, "Escolha um serviço:",
                    "Selecionar Serviço",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, servicos, servicos[0]);

            if (opcao == 0) {
            } else if (opcao == 1) {
            } else if (opcao == 2) {
            } else if (opcao == 3) {
            } else if (opcao == 4) {
            } else if (opcao == 5) {
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private static void cadastroDeServico() {

        String tipo = JOptionPane.showInputDialog(null, "Digite o tipo de Serviço");
        if (tipo == null) {
            cadastroDeServico();
        }
        Double valor = Double.valueOf(JOptionPane.showInputDialog(null, "Digite o valor do Serviço"));
        if (valor == null) {
            cadastroDeServico();
        }
        Servico servico = new Servico(tipo, valor);
        ServicoDAO.salvar(servico);
        chamaMenuPrincipal();
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
        if (email == null) {
            chamaMenuCadastros();
        }
        Hospede hospede = new Hospede(nome, cpf, celular, email);
        PessoaDAO.salvar(hospede);
        chamaMenuPrincipal();
    }

// (op == 1) { //Edição
//
//        if (tipoPessoa == TipoPessoa.FISICA) {
//
//            String cpf;
//            PessoaFisica pf;
//            while (true) {
//                cpf = JOptionPane.showInputDialog(null,
//                        "Digite o cpf no formato ***.***.***-**");
//
//                 (FormatoCpf.verificarFormato(cpf)) {
//                    pf = PessoaFisicaDAO.buscarPorCpf(cpf);
//                    if (pf != null) {
//                        PessoaFisicaDAO.editar(pf);
//                        break;
//                    }  {
//                        JOptionPane.showMessageDialog(null,
//                                "Erro! não existe nenhum cadastro com este Cpf, tente novamente",
//                                "Erro", JOptionPane.ERROR_MESSAGE);
//
//                    JOptionPane.showMessageDialog(null,
//                            "Erro! o cpf informado deve estar no formato ***.***.***-**",
//                            "Erro de formato do Cpf", JOptionPane.ERROR_MESSAGE);
//                }}}



    private static void removerHospede() {
        Object[] selectionValuesHospede = HospedagemDAO.findhospedagensInArray();
        Object selectionHospede = JOptionPane.showInputDialog(null, "Selecione o hóspede para remover:",
                "Remover Hóspede", JOptionPane.DEFAULT_OPTION, null, selectionValuesHospede, null);

        if (selectionHospede != null) {
            Hospede hospedeSelecionado = (Hospede) selectionHospede;
            HospedagemDAO.removerHospede(hospedeSelecionado);
            JOptionPane.showMessageDialog(null, "Hóspede removido com sucesso!");
        }

        chamaMenuPrincipal();
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
            case 2: //Tipos de Serviços
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

        Object[] selectionQuarto = {
                TipoQuarto.PADRAO_CLASSICO.getDescricao(),
                TipoQuarto.MASTER_VIP.getDescricao(),
                TipoQuarto.VIP.getDescricao(),
                TipoQuarto.STAR_VIP.getDescricao(),
                TipoQuarto.BLACK_VIP.getDescricao(),
        };

        String initialSelectionQuarto = (String) selectionQuarto[0];
        Object selecQuarto = JOptionPane.showInputDialog(null, "Selecione o quarto escolhido",
                "Quartos", JOptionPane.QUESTION_MESSAGE, null, selectionQuarto, initialSelectionQuarto);

        Object[] selectionHospede = PessoaDAO.findHospedeInArray();
        String initialSelectionHospede = (String) selectionHospede[0];
        Object selecHospede = JOptionPane.showInputDialog(null, "Selecione o hóspede",
                "Check-in", JOptionPane.QUESTION_MESSAGE, null, selectionHospede, initialSelectionHospede);
        String selectedHospede = (String) selecHospede;
        List<Hospede> hospedes = PessoaDAO.buscaTodosh();


        Object[] selectionValuesServico = ServicoDAO.findServicosInArray();
        String initialSelectionServico = (String) selectionValuesServico[0];
        Object selectionServico = JOptionPane.showInputDialog(null, "Selecione a descrição do Serviço",
                "Hospedagem", JOptionPane.QUESTION_MESSAGE, null, selectionValuesServico, initialSelectionServico);
        String selectedServico = (String) selectionServico;

        List<Servico> servicos = ServicoDAO.buscarPorTipo(selectedServico);
    }

    public static void chamaCheckOut() {
        LocalDate dataSaida = LocalDate.now();
        String inputData = JOptionPane.showInputDialog(null, "Data de saída (formato: dd/MM/yyyy): ");

        try {
            dataSaida = LocalDate.parse(inputData, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido!");
            return; // Retorna ou executa outra ação de tratamento de erro
        }

        Object[] selectionFormaPagto = {
                FormaPagamento.DINHEIRO.getDescricao(),
                FormaPagamento.PIX.getDescricao(),
                FormaPagamento.CARTAO_CREDITO.getDescricao(),
                FormaPagamento.CARTAO_DEBITO.getDescricao()
        };
        String initialSelectionForma = (String) selectionFormaPagto[0]; // valor inicial, o primeiro selecionado
        Object selectionForma = JOptionPane.showInputDialog(null, "Selecione a forma de pagamento",
                "Hotel", JOptionPane.QUESTION_MESSAGE, null, selectionFormaPagto, initialSelectionForma);

        if (selectionForma == null) {
            JOptionPane.showMessageDialog(null, "Seleção de forma de pagamento cancelada!");
            return; // Retorna ou executa outra ação de tratamento de erro
        }

        FormaPagamento formaPagamento = FormaPagamento.valueOf((String) selectionForma);

        LocalDate dataPagamento = LocalDate.now();
        String inputData1 = JOptionPane.showInputDialog(null, "Digite uma data (formato: dd/MM/yyyy):");

        try {
            dataPagamento = LocalDate.parse(inputData, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException o) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido!");
        }

        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do funcionário");
        if (cpf == null) {
            chamaMenuCadastros();
        }

        Object[] selectionValuesHospedagem = HospedagemDAO.findhospedagensInArray();
        String initialSelectionHospedagem = (String) selectionValuesHospedagem[0];
        Object selectionHospedagem = JOptionPane.showInputDialog(null, "Selecione o código da hospedagem?",
                "Hospedagem", JOptionPane.QUESTION_MESSAGE, null, selectionValuesHospedagem, initialSelectionHospedagem);
        List<Hospedagem> hospedagens = HospedagemDAO.buscarPorCodigo((Integer) selectionHospedagem);
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

    private static void listaCadastros() {
        String[] opcoesMenuRelatorios = {"Hóspedes", "Funcionários", "Serviços", "Manutenção", "Voltar"};
        int menuRelatorios = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Relatórios",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuRelatorios, opcoesMenuRelatorios[0]);

        switch (menuRelatorios) {
            case 0: //Hospedes
                JOptionPane.showMessageDialog(null, PessoaDAO.buscaTodosh());
                chamaMenuPrincipal();
                break;
            case 1: //Funcionarios
                JOptionPane.showMessageDialog(null, PessoaDAO.buscaTodosf());
                chamaMenuPrincipal();
                break;
            case 2: //Serviços
                JOptionPane.showMessageDialog(null, ServicoDAO.buscaTodos());
                chamaMenuProcessos();
                break;
            case 3: //Manutenção
                JOptionPane.showMessageDialog(null, ManutencaoDAO.buscaTodos());
                chamaServicos();
                break;
            case 4: //Voltar
                chamaMenuPrincipal();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }}
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
        System.out.println(hospedagem);
        chamaMenuPrincipal();

    }}