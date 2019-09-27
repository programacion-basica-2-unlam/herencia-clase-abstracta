package ar.edu.unlam.herencia;

import java.math.BigDecimal;

public class CajaAhorro extends Cuenta {

    public static final int MONTO_EN_PESOS_QUE_SE_COBRA_POR_EXTRACCIONES_EXCEDIDAS = 6;
    private Integer cantidadMaximaExtracciones;
    private Integer cantidadExtracciones;

    public CajaAhorro(String numeroCuenta, Double saldo, Persona titular, Integer cantidadMaximaExtracciones, Integer cantidadExtracciones) {

        super(numeroCuenta, saldo, titular);
        this.cantidadMaximaExtracciones = cantidadMaximaExtracciones;
        this.cantidadExtracciones = cantidadExtracciones;
    }

    @Override
    public void extraer(Double monto) {

        cantidadExtracciones++;
        Double montoRealAExtraer;

        if(cantidadExtracciones >= cantidadMaximaExtracciones){
            montoRealAExtraer = monto + MONTO_EN_PESOS_QUE_SE_COBRA_POR_EXTRACCIONES_EXCEDIDAS;
        }else{
            montoRealAExtraer = monto;
        }

        if(puedoExtaer(montoRealAExtraer)){

            this.saldo -= montoRealAExtraer;
        }else{
            cantidadExtracciones--;
        }
    }


}
