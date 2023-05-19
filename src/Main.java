import model.Funcionario;
import model.Hospede;
import repository.PessoaDAO;

import javax.swing.*;
import java.time.LocalDate;

public class Main {

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

                break;

            case 2: //Relatorios
                listaCadastros();
                break;

            case 3: //SAIR

                break;
        }
    }

    private static void chamaMenuCadastros() {
        String[] opcoesMenuCadastro = {"Hóspede", "Funcionário", "Consumo", "Pagamento", "Voltar"};
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
            case 2: //Consumo
                break;
            case 3: //Pagamento
                break;
            case 4: //Voltar
                chamaMenuPrincipal();
                break;
        }
    }

    private static void cadastroDeCliente() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente");
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do cliente");
        String celular = JOptionPane.showInputDialog(null, "Digite o celular do cliente");
        String email = JOptionPane.showInputDialog(null, "Digite o email do cliente");

        Hospede hospede = new Hospede(nome, cpf, celular, email);

        PessoaDAO.salvar(hospede);
        chamaMenuPrincipal();
    }

    private static void cadastroDeFuncionario() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionário");
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do funcionário");
        String celular = JOptionPane.showInputDialog(null, "Digite o celular do funcionário");
        String email = JOptionPane.showInputDialog(null, "Digite o email do funcionário");

        Funcionario funcionario = new Funcionario(nome, cpf, celular, email);

        PessoaDAO.salvar(funcionario);
        chamaMenuPrincipal();
    }

    private static void listaCadastros(){
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