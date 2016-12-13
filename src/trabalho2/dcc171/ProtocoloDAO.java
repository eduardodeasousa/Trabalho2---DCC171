package trabalho2.dcc171;

import java.util.List;

/**
 *
 * @author Dudu
 */
public interface ProtocoloDAO {

    List<Protocolo> listaTodos() throws Exception;

    void removeProtocol(Protocolo protocolToBeRemoved) throws Exception;

    void insertProtocol(Protocolo protocolToBeInserted) throws Exception;

    void updateProtocol(Protocolo protocolToBeUpdated) throws Exception;
    
    void insertProtocolVazio(Protocolo protocolToBeInserted) throws Exception;

}
