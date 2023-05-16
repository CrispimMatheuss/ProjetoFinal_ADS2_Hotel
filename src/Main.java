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
                JOptionPane.showMessageDialog(null, PessoaDAO.buscaTodos());
                chamaMenuPrincipal();
                break;
            case 3: //SAIR

                break;
        }
    }

    private static void chamaMenuCadastros() {
        String[] opcoesMenuCadastro = {"Hóspede", "Consumo", "Pagamento", "Voltar"};
        int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

        switch (menuCadastro) {
            case 0: //Pessoa
             //   cadastroDeCliente();
                break;
            case 1: //Consumo
                break;
            case 2: //Pagamento
                break;
            case 3: //Voltar
                chamaMenuPrincipal();
                break;
        }
    }

//    private static void cadastroDeCliente() {
//        String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente");
//        //LocalDate dataNascimento = JOptionPane.showInputDialog(null, "Digite a data de nascimento do cliente");
//        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do cliente");
//        String celular = JOptionPane.showInputDialog(null, "Digite o celular do cliente");
//        String email = JOptionPane.showInputDialog(null, "Digite o email do cliente");

        //Hospede hospede = new Hospede(nome, dataNascimento, cpf, celular, email);

        //PessoaDAO.salvar(hospede);
        //chamaMenuPrincipal();
   // }
}