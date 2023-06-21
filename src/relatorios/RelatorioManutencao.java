//package relatorios;
//import model.Hospede;
//import model.Manutencao;
//import model.Pessoa;
//import javax.swing.table.AbstractTableModel;
//import java.util.Vector;
//
//public class RelatorioManutencao extends AbstractTableModel{
//
//    private static final long serialVersionUID = 1L;
//    public static final int INDEX_CODIGO = 0;
//    public static final int INDEX_FUNCIONARIO = 1;
//    public static final int INDEX_DATA = 2;
//    public static final int INDEX_DESCRICAO = 3;
//    public static final int INDEX_ORDEMDESERVICO = 4;
//    public static final int INDEX_TIPO = 5;
//    public static final int INDEX_STATUS = 6;
//    public static final int INDEX_ESCONDIDO = 7;
//
//    protected String[] nomeColunas;
//    protected Vector<Manutencao> vetorDados;
//
//    public RelatorioManutencao(String[] columnNames, Vector<Manutencao> vetorDados) {
//        this.nomeColunas = columnNames;
//        this.vetorDados = vetorDados;
//    }
//
//    @Override
//    public String getColumnName(int column) {
//        return nomeColunas[column];
//    }
//
//    @Override
//    public boolean isCellEditable(int linha, int coluna) {
//        if (coluna == INDEX_ESCONDIDO) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    @Override
//    public Object getValueAt(int linha, int coluna) {
//        Manutencao registroManut = (Manutencao) vetorDados.get(linha);
//        switch (coluna) {
//            case INDEX_CODIGO:
//                return registroManut.getID();
//            case INDEX_FUNCIONARIO:
//                return registroManut.getFuncionario();
//            case INDEX_DATA:
//                return registroManut.getData();
//            case INDEX_DESCRICAO:
//                return registroManut.getDescricao();
//            case INDEX_ORDEMDESERVICO:
//                return registroManut.getOS();
//            case INDEX_TIPO:
//                return registroManut.getTipoManutencao();
//            case INDEX_STATUS:
//                return registroManut.getStatus();
//            default:
//                return new Object();
//        }
//    }
//
//    @Override
//    public int getRowCount() {
//        return vetorDados.size();
//    }
//
//    @Override
//    public int getColumnCount() {
//        return nomeColunas.length;
//    }
//}
//
