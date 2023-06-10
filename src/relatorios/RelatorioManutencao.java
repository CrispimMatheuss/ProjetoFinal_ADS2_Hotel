package relatorios;
import model.Hospede;
import model.Manutencao;
import model.Pessoa;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class RelatorioManutencao extends AbstractTableModel{

    private static final long serialVersionUID = 1L;

    public static final int INDEX_NOME = 0;
    public static final int INDEX_CLASSIFICACAO = 1;
    public static final int INDEX_DOCUMENTO = 2;
    public static final int INDEX_ESCONDIDO = 3;

    protected String[] nomeColunas;
    protected Vector<Manutencao> vetorDados;

    public RelatorioManutencao(String[] columnNames, Vector<Manutencao> vetorDados) {
        this.nomeColunas = columnNames;
        this.vetorDados = vetorDados;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        if (coluna == INDEX_ESCONDIDO) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Manutencao registroManut = (Manutencao) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_NOME:
                return registroManut.getData();
            case INDEX_CLASSIFICACAO:
                return registroManut.getDescricao();
            case INDEX_DOCUMENTO:
                return registroManut.getTipoManutencao();
            default:
                return new Object();
        }
    }

    @Override
    public int getRowCount() {
        return vetorDados.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
}

