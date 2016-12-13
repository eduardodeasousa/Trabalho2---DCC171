package trabalho2.dcc171;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProtocoloDAOJDBC implements ProtocoloDAO {

    private PreparedStatement opInsert;
    private PreparedStatement opExclude;
    private PreparedStatement opList;
    private PreparedStatement opUpdate;

    public ProtocoloDAOJDBC() throws Exception {
        opInsert = Conexao.getInstance().prepareStatement("INSERT INTO protocolo(setor, protocolo, utilizado) VALUES (?, ?, ?)");
        opExclude = Conexao.getInstance().prepareStatement("DELETE FROM protocolo WHERE setor=? AND protocolo = ?");
        opList = Conexao.getInstance().prepareStatement("SELECT setor,protocolo,utilizado FROM protocolo ORDER BY setor ASC, utilizado ASC");
        opUpdate = Conexao.getInstance().prepareStatement("UPDATE protocolo SET utilizado=? WHERE protocolo=?");
    }

    @Override
    public List<Protocolo> listaTodos() throws Exception {
        List<Protocolo> allProtocols = new ArrayList<>();
        ResultSet result = opList.executeQuery();
        while (result.next()) {
            String setor = result.getString(1);
            int protocolo = result.getInt(2);
            Timestamp lastUsed = result.getTimestamp(3);
            allProtocols.add(new Protocolo(setor, protocolo, lastUsed));
        }
        return allProtocols;
    }

    @Override
    public void removeProtocol(Protocolo protocolToBeRemoved) throws Exception {
        opExclude.clearParameters();
        opExclude.setString(1, protocolToBeRemoved.getSetor());
        opExclude.setInt(2, protocolToBeRemoved.getProtocolo());
        opExclude.executeUpdate();
    }

    @Override
    public void insertProtocol(Protocolo protocolToBeInserted) throws Exception {
        opInsert.clearParameters();
        opInsert.setString(1, protocolToBeInserted.getSetor());
        opInsert.setInt(2, protocolToBeInserted.getProtocolo());
        opInsert.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        opInsert.executeUpdate();
    }

    @Override
    public void updateProtocol(Protocolo protocolToBeUpdated) throws Exception {
        opUpdate.clearParameters();
        opUpdate.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        opUpdate.setInt(2, protocolToBeUpdated.getProtocolo());
        opUpdate.executeUpdate();
    }
    
    public void insertProtocolVazio(Protocolo protocolToBeInserted) throws Exception {
        opInsert.clearParameters();
        opInsert.setString(1, protocolToBeInserted.getSetor());
        opInsert.setInt(2, protocolToBeInserted.getProtocolo());
        opInsert.setTimestamp(3, null);
        opInsert.executeUpdate();
    }

}
