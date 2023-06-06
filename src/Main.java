import model.*;
import model.EscolheServico;
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
        chamaMenuPrincipal();
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
                cadastroDeCliente();
                break;
            case 1: //Funcionario
                cadastroDeFuncionario();
                break;
            case 2: //Serviço
                cadastroDeServico();
                break;
            case 3: //Funcionario
                chamaMenuPrincipal();
                break;
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

    private static void cadastroDeCliente() {
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
        String[] opcoesMenuProcessos = {"Check-in", "Check-out", "Consumos", "Voltar"};
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
            case 3: //Voltar
                chamaMenuPrincipal();
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
                Quarto.TipoQuarto.PADRAO_CLASSICO.getDescricao(),
                Quarto.TipoQuarto.MASTER_VIP.getDescricao(),
                Quarto.TipoQuarto.VIP.getDescricao(),
                Quarto.TipoQuarto.STAR_VIP.getDescricao(),
                Quarto.TipoQuarto.BLACK_VIP.getDescricao(),
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

    /////////////////RELATÓRIOS////////////////////
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
        }
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
        System.out.println(hospedagem);
        chamaMenuPrincipal();
    }
}

