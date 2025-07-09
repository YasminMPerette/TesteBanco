package org.example.Pedido;

import java.sql.Date;

public class Pedido {
    private String cliente;
    private Date dataPedido;
    private double total;

    public Pedido(String cliente, Date dataPedido, double total) {
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public double getTotal() {
        return total;
    }
}
