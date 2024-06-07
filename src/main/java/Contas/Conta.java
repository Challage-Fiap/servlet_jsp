package Contas;

public class Conta {
    private String nrConta;
    private String tpConta;
    private double saldo;
    private int idCliente;

    public String getNrConta() {
        return nrConta;
    }

    public void setNrConta(String nrConta) {
        this.nrConta = nrConta;
    }

    public String getTpConta() {
        return tpConta;
    }

    public void setTpConta(String tpConta) {
        this.tpConta = tpConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    // arrumar o override

    @Override
    public String toString() {
        return "Número da Conta: " + this.nrConta + ", Tipo de Conta: " + this.tpConta + ", Saldo: " + this.saldo;
    }
}
