import model.*;
import repository.HospedagemDAO;
import repository.PagamentoDAO;
import repository.PessoaDAO;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

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
        String[] opcoesMenuCadastro = {"Hóspede", "Funcionário", "Pagamento", "Voltar"};
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
            case 2: //Pagamento

                break;
            case 3: //Voltar
                chamaMenuPrincipal();
                break;
        }
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
        String[] opcoesMenuProcessos = {"Check-in", "Check-out", "Pagamentos", "Voltar"};
        int menuProcessos = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Processos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuProcessos, opcoesMenuProcessos[0]);

        switch (menuProcessos) {
            case 0: //Checkin

                break;
            case 1: //Checkout

                break;
            case 2: //Pagamentos

                break;
            case 3: //Voltar
                chamaMenuPrincipal();
                break;
        }
    }

    public void cadastroPagamento() {

        Object[] selectionFormaPagto = {FormaPagamento.DINHEIRO.getDescricao(), FormaPagamento.CHEQUE.getDescricao(), FormaPagamento.CARTAO_CREDITO.getDescricao(), FormaPagamento.CARTAO_DEBITO.getDescricao()};// String da SELEÇÃO
        String initialSelectionForma = (String) selectionFormaPagto[0]; // valor inicial, o primeiro selecionado
        Object selectionForma = JOptionPane.showInputDialog(null, "Selecione o cliente da venda?",
                "Hotel", JOptionPane.QUESTION_MESSAGE, null, selectionFormaPagto, initialSelectionForma);
        FormaPagamento formaPagamento = FormaPagamento.valueOf((String) selectionForma);

        LocalDate dataPagamento = LocalDate.now();
        String inputData = JOptionPane.showInputDialog(null, "Digite uma data (formato: dd/MM/yyyy):");

        try {
            dataPagamento = LocalDate.parse(inputData, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido!");
        }

        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do funcionário");
        if (cpf == null) {
            chamaMenuCadastros();
        }

        //valorTotal; //PRECISA INFORMAR DIRETO
        //descontos;

        Object[] selectionValuesHospedagem = HospedagemDAO.findhospedagensInArray();
        String initialSelectionHospedagem = (String) selectionValuesHospedagem[0];
        Object selectionHospedagem = JOptionPane.showInputDialog(null, "Selecione o código da hospedagem?",
                "Hospedagem", JOptionPane.QUESTION_MESSAGE, null, selectionValuesHospedagem, initialSelectionHospedagem);
        List<Hospedagem> hospedagens = HospedagemDAO.buscarPorCodigo((Integer) selectionHospedagem);
    }


    /////////////////RELATÓRIOS////////////////////
    private static void listaCadastros() {
        String[] opcoesMenuRelatorios = {"Hóspedes", "Funcionários", "Voltar"};
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
            case 4: //Voltar
                chamaMenuPrincipal();
                break;
        }
    }
}