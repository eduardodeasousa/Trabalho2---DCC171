package trabalho2.dcc171;

import java.sql.Timestamp;

public class Protocolo {

    private String setor;
    private int protocolo;
    private Timestamp lastUsed;

    public Protocolo() {

    }

    public Protocolo(String setor, int protocolo) {
        this.setor = setor;
        this.protocolo = protocolo;
    }

    public Protocolo(String setor, int protocolo, Timestamp lastUsed) {
        this.setor = setor;
        this.protocolo = protocolo;
        this.lastUsed = lastUsed;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }

    public Timestamp getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Timestamp lastUsed) {
        this.lastUsed = lastUsed;
    }

}
