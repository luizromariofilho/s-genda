package sgenda;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PhoneTableModel extends AbstractTableModel {

    private final List<PhoneBookEntry> linhas;

    private final String[] colunas = new String[]{
        "Nome", "Sobrenome", "Telefone"};

    public PhoneTableModel() {
        linhas = new ArrayList<>();
    }

    public PhoneTableModel(List<PhoneBookEntry> listaDePhoneBookEntrys) {
        linhas = new ArrayList<>(listaDePhoneBookEntrys);
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {

            case 0: 
                return String.class;
            case 1: 
                return String.class;
            case 2: 
                return String.class;
            default:
//                    INFORMATIVO("O índice informado não existe!");
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PhoneBookEntry func = linhas.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return func.getNome();
            case 1: 
                return func.getSobrenome();
            case 2: 
                return func.getTelefone();
            default:
//                    MsgBox.INFORMATIVO("O índice informado não existe!");    
                return null;
        }

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public PhoneBookEntry getPhoneBookEntry(int indiceLinha) {
        if (indiceLinha < linhas.size()) {
            return linhas.get(indiceLinha);
        }
        return null;
    }

    public void addPhoneBookEntry(PhoneBookEntry func) {
        linhas.add(func);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removePhoneBookEntry(int indiceLinha) {
        if (indiceLinha < linhas.size()) {
            linhas.remove(indiceLinha);
            fireTableRowsDeleted(indiceLinha, indiceLinha);
        }

    }

    public void addListaDePhoneBookEntrys(List<PhoneBookEntry> funcs) {
        int tamanhoAntigo = getRowCount();
        linhas.addAll(funcs);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return linhas.isEmpty();
    }

    public Object getObject(int index) {
        return linhas.get(index);
    }

}
