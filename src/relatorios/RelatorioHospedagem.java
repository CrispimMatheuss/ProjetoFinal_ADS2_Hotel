package relatorios;
import model.Hospedagem;
import model.Hospede;
import model.Pessoa;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class RelatorioHospedagem extends AbstractTableModel{

    private static final long serialVersionUID = 1L;

    public static final int INDEX_NOME = 0;
    public static final int INDEX_CLASSIFICACAO = 1;
    public static final int INDEX_DOCUMENTO = 2;
    public static final int INDEX_ESCONDIDO = 3;

    protected String[] nomeColunas;
    protected Vector<Hospedagem> vetorDados;

    public RelatorioHospedagem(String[] columnNames, Vector<Hospedagem> vetorDados) {
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
        Hospedagem registroHospedagem = (Hospedagem) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_NOME:
                return registroHospedagem.getCodigo();
            case INDEX_CLASSIFICACAO:
                return registroHospedagem.getHospede();
            case INDEX_DOCUMENTO:
                return registroHospedagem.getQuantidadeDiarias();
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

