package ar.edu.unlam.herencia;

import java.math.BigDecimal;

public class CuentaCorriente extends Cuenta{

    private Double montoEnDescubierto;
    public static final Float INTERES_COBRADO_POR_DESCUBIERTO = 0.05f;

    public CuentaCorriente(String numeroCuenta, Double saldo, Persona titular, Double montoEnDescubierto) {
        super(numeroCuenta, saldo, titular);
        this.montoEnDescubierto = montoEnDescubierto;
    }

    @Override
    public void extraer(Double monto) {

        if(puedoExtaer(monto)){
            this.saldo -= monto;
        }else{

            Double descubierto = this.saldo - monto;
            descubierto *=  INTERES_COBRADO_POR_DESCUBIERTO;

            if (puedoGirarEnDescubierto(monto, descubierto)) {

                this.saldo -= monto + descubierto;
            }
        }


    }

    private boolean puedoGirarEnDescubierto(Double monto, Double descubierto) {

        return this.saldo + descubierto > montoEnDescubierto;
    }
}
