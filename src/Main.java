import model.*;
import model.EscolheServico;
import relatorios.RelatorioHospede;
import repository.*;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import repository.OrdemDeServicoDAO;

public class Main {

    private static Object PessoaDAODAO;

    public static void main(String[] args) {
        ServicoDAO.buscaTodos();
        exibirMensagemBoasVindas();
        chamaMenuPrincipal();
    }

        private static void exibirMensagemBoasVindas() {
        JOptionPane.showOptionDialog(null, "Bem-vindo ao Hotel",
                "Mensagem de Boas-vindas", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Entrar"}, "Entrar");
    }

        private static void chamaMenuPrincipal() {
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
                break;
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
                break;
            case 2: //Serviço
                chamaMenuServico();
                break;
            case 3: //Voltar
                chamaMenuPrincipal();
                break;
        }
    }

    ////////////////////////////////HOSPEDES
        public static void chamaMenuHospede() {
        String[] opcoesMenuHospede = {"Inserir", "Alterar", "Excluir", "Voltar"};
        int opcao = 0;
        while (opcao != 3) {
            opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                    "Menu de cadastros",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuHospede, opcoesMenuHospede[0]
            );

            switch (opcao) {
                case 0: // Inserir Hospede
                    cadastroDeHospede();
                    break;

                //case 1: Alterar Hospede
                //    alterarCadastro();
                //    break;

                case 2: // Excluir Hospede
                    removerHospede();
                    break;

                case 3: // Voltar
                    chamaMenuPrincipal();
                    break;
            }
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

    /////////////////////////////FUNCIONARIO
        public static void chamaMenuFuncionario () {
            String[] opcoesMenuFuncionario = {"Inserir", "Alterar", "Excluir", "Voltar"};
            int opcao = 0;
            while (opcao != 3) {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                        "Menu de cadastros",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuFuncionario, opcoesMenuFuncionario[0]
                );

                switch (opcao) {
                    case 0: // Inserir
                        cadastroDeFuncionario();
                        break;

                    //case 1: Alterar
                    //    alterarCadastro();
                    //    break;

                    case 2: // Excluir
                        removerFuncionario();
                        break;

                    case 3: // Voltar
                        chamaMenuPrincipal();
                        break;
                }
            }
    }

        private static void cadastroDeFuncionario () {
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

        private static void removerFuncionario () {
            Object[] selectionValuesFuncionario = PessoaDAO.findFunciInArray();
            Object selectionFunci = JOptionPane.showInputDialog(null, "Selecione o funcionário para remover:",
                    "Menu de cadastros", JOptionPane.DEFAULT_OPTION, null, selectionValuesFuncionario, null);

            if (selectionFunci != null) {
                Funcionario funcionarioSelecionado = (Funcionario) selectionFunci;
                PessoaDAO.removerFuncionario(funcionarioSelecionado);
                JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!");
            }
        }

    /////////////////////////////////SERVIÇO
        public static void chamaMenuServico () {
        String[] opcoesMenuServico = {"Inserir", "Alterar", "Excluir", "Voltar"};
        int opcao = 0;
        while (opcao != 3) {
            opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                    "Menu de cadastros",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuServico, opcoesMenuServico[0]
            );

            switch (opcao) {
                case 0: // Inserir
                    cadastroDeServico();
                    break;

                case 1: //Alterar
//                    alterarServico();
                    break;

                case 2: // Excluir
                    removerServico();
                    break;

                case 3: // Voltar
                    chamaMenuPrincipal();
                    break;
            }
        }
    }

        private static void cadastroDeServico () {

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
        Object[] selectionValuesServico = ServicoDAO.findServicosInArray();
        Object selectionServico = JOptionPane.showInputDialog(null, "Selecione o serviço para remover:",
                "Remover Serviço", JOptionPane.DEFAULT_OPTION, null, selectionValuesServico, null);

        if (selectionServico != null) {
            String servicoDescricaoSelecionado = (String) selectionServico;

            Servico servicoSelecionado = null;
            List<Servico> servicos = ServicoDAO.buscaTodos();
            for (Servico servico : servicos) {
                if (servico.getTipo().equals(servicoDescricaoSelecionado)) {
                    servicoSelecionado = servico;
                    break;
                }
            }

            if (servicoSelecionado != null) {
                ServicoDAO.excluirServico(servicoSelecionado);
                JOptionPane.showMessageDialog(null, "Serviço removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao encontrar o serviço selecionado!");
            }
        }

        chamaMenuPrincipal();
    }


    //////////////////////////PROCESSOS
        public static void chamaMenuProcessos () {
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
            }
        }

        public static void chamaCheckin () {
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

            List<Hospede> hospedes = PessoaDAO.buscaTodosh();

            if (hospedes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum hóspede cadastrado!");
                chamaMenuPrincipal();
            }

            Object[] selectionHospede = hospedes.stream().map(Hospede::getNome).toArray();
            String initialSelectionHospede = (String) selectionHospede[0];
            Object selecHospede = JOptionPane.showInputDialog(null, "Selecione o hóspede",
                    "Check-in", JOptionPane.QUESTION_MESSAGE, null, selectionHospede, initialSelectionHospede);

            if (selecHospede == null) {
                // Nenhum hóspede selecionado, encerrar o check-in
                return;
            }

            String selectedHospede = (String) selecHospede;

            Object[] selectionValuesServico = ServicoDAO.findServicosInArray();
            String initialSelectionServico = (String) selectionValuesServico[0];
            Object selectionServico = JOptionPane.showInputDialog(null, "Selecione a descrição do Serviço",
                    "Hospedagem", JOptionPane.QUESTION_MESSAGE, null, selectionValuesServico, initialSelectionServico);
            String selectedServico = (String) selectionServico;

            List<Servico> servicos = ServicoDAO.buscarPorTipo(selectedServico);
        }

        public static void chamaCheckOut () {

//            Object[] selectionValuesHospedagem = HospedagemDAO.findhospedagensInArray();
//            String initialSelectionHospedagem = (String) selectionValuesHospedagem[0];
//            Object selectionHospedagem = JOptionPane.showInputDialog(null, "Selecione o código da hospedagem?",
//                    "Hospedagem", JOptionPane.QUESTION_MESSAGE, null, selectionValuesHospedagem, initialSelectionHospedagem);
//            List<Hospedagem> hospedagens = HospedagemDAO.buscarPorCodigo((Integer) selectionHospedagem);
//

            String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do funcionário pelo check-out");
            if (cpf == null) {
                chamaMenuPrincipal();
            }//selecionar funcionario

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

//            LocalDate dataPagamento = LocalDate.now();
//            String inputData1 = JOptionPane.showInputDialog(null, "Digite uma data (formato: dd/MM/yyyy):");
//
//            try {
//                dataPagamento = LocalDate.parse(inputData, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//            } catch (DateTimeParseException o) {
//                JOptionPane.showMessageDialog(null, "Formato de data inválido!");
//            }
        }

        public static void chamaServicos () {

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

        public static void chamaManut () {
            Object[] selectManutencoes = {
                    TipoManutencao.ELETRICA.getDescricao(),
                    TipoManutencao.ESTRUTURAL.getDescricao(),
                    TipoManutencao.LIMPEZA.getDescricao()};

            String initialSelectionManut = (String) selectManutencoes[0];
            Object selecManut = JOptionPane.showInputDialog(null, "Selecione o tipo de manutenção realizada",
                    "Manutenções", JOptionPane.QUESTION_MESSAGE, null, selectManutencoes, initialSelectionManut);
        }

        /////////////////RELATÓRIOS////////////////////
        private static void listaCadastros () {
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
//                    chamaMenuPrincipal();
                    break;
            }

        }

        private static void chamaRelatorioHospede () {
            List<Hospede> hospedes = PessoaDAO.buscaTodosh();
            RelatorioHospedeForm.emitirRelatorio(hospedes);
        }

        private static void chamaRelatorioFuncionario () {
            List<Funcionario> funcionarios = PessoaDAO.buscaTodosf();
            RelatorioFuncionarioForm.emitirRelatorio(funcionarios);
        }

        private static void chamaRelatorioServico () {
            List<Servico> servicos = ServicoDAO.buscaTodos();
            RelatorioServicoForm.emitirRelatorio(servicos);
        }

        private static void chamaRelatorioManutencao () {
            List<Manutencao> manutencaos = ManutencaoDAO.buscaTodos();
            RelatorioManutencaoForm.emitirRelatorio(manutencaos);
        }

        private static void chamaRelatorioHospedagem () {
            List<Hospedagem> hospedagems = HospedagemDAO.buscaTodos();
        //    RelatorioHospedagemForm.emitirRelatorio(hospedagems);
    }
    }