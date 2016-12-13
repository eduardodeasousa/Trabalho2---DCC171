package trabalho2.dcc171;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class ProtocoloTableModel extends AbstractTableModel {

    private List<Protocolo> protocolos;
    private final ProtocoloDAOJDBC dao;

    public ProtocoloTableModel() throws Exception {
        dao = new ProtocoloDAOJDBC();
    }

    @Override
    public int getRowCount() {
        try {
            refreshData();
        } catch (Exception ex) {
            Logger.getLogger(ProtocoloTableModel.class.getName()).log(Level.SEVERE, null, ex);

        }
        if (protocolos != null) {
            return protocolos.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            refreshData();
        } catch (Exception ex) {
            Logger.getLogger(ProtocoloTableModel.class.getName()).log(Level.SEVERE, null, ex);

        }
        switch (columnIndex) {
            case 0:
                return protocolos.get(rowIndex).getProtocolo();
            case 1:
                return protocolos.get(rowIndex).getSetor();
            case 2:
                return protocolos.get(rowIndex).getLastUsed();
            default:
                return "?";
        }

    }

    private void refreshData() {
        protocolos = new ArrayList<>();
        try {
            protocolos = dao.listaTodos();
        } catch (Exception ex) {
            Logger.getLogger(ProtocoloTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Protocolo";
            case 1:
                return "Setor";
            case 2:
                return "Ultimo uso";
            default:
                return "?";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (protocolos.isEmpty()) {
            return Object.class;
        } else {
            switch (columnIndex) {
                case 0:
                    return int.class;
                case 1:
                    return String.class;
                case 2:
                    return Timestamp.class;
                default:
                    return Object.class;

            }
        }

    }

}
