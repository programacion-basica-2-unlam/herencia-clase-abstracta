package ar.edu.unlam.herencia;

import java.math.BigDecimal;

public abstract class Cuenta {

    protected String numeroCuenta;
    protected Double saldo;
    protected Persona titular;

    public Cuenta(String numeroCuenta, Double saldo, Persona titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
        this.titular.agregarCuenta(this);
    }

    public Cuenta(){}

    public abstract void extraer(Double monto);

    public void depositar(Double monto){
        //logica para depositar

        if(monto > 0){
            this.saldo += monto;
        }
    }

    protected boolean puedoExtaer(Double monto) {

        return this.saldo > monto  && monto > 0;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Persona getTitular() {
        return titular;
    }
}
