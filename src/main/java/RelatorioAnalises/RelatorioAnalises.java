package RelatorioAnalises;

public class RelatorioAnalises {

    private int idRelatorioAnalise;
    private String dadosAnalisesRelatorios;
    private int idCliente;


    public int getIdRelatorioAnalise() {
        return idRelatorioAnalise;
    }

    public void setIdRelatorioAnalise(int idRelatorioAnalise) {
        this.idRelatorioAnalise = idRelatorioAnalise;
    }

    public String getDadosAnalisesRelatorios() {
        return dadosAnalisesRelatorios;
    }

    public void setDadosAnalisesRelatorios(String dadosAnalisesRelatorios) {
        this.dadosAnalisesRelatorios = dadosAnalisesRelatorios;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "RelatoriosAnalises = " +
                "idRelatorioAnalise = " + idRelatorioAnalise +
                ", dadosAnalisesRelatorios = '" + dadosAnalisesRelatorios + '\'' +
                ", idCliente = " + idCliente;
    }
}
