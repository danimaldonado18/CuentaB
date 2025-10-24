package com.daniela.CuentaB;

/*
Autor:Daniela Maldonado
*Fecha: 23/10/2025 version: 1.0
*Descripcion : Esta clase denominada CuentaCorriente modela una cuenta bancaria que es una
*subclase de cuenta. Tiene un nuevo atributo: sobregiro
**/

public class CuentaCorriente extends Cuenta {
    float sobregiro;
    /*
     * Constructor de la clase CuentaCorriente
     * @param saldo Indica el monto inicial disponible en la cuenta corriente
     * @param tasa Indica el porcentaje de interés anual aplicado a la cuenta
     */
    public CuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa);
        sobregiro = 0;
    }
    /*
     * Metodo que toma una cantidad para retirar y modifica el saldo respectivamente.
     * @param cantidad Monto que se desea extraer de la cuenta.
     */
    public void retirar (float cantidad){
        float resultado = saldo - cantidad;
        if(resultado <= 0){
            sobregiro = sobregiro-resultado;
            saldo=0;
        }else{
            super.retirar (cantidad);
        }
    }
    /*
     * Metodo que recibe una suma de dinero para ingresar a la cuenta y ajusta el saldo.
     * @param cantidad Monto que se va a ingresar en la cuenta.
     */
    public void depositar (float cantidad){
        float residuo= sobregiro - cantidad;
        if(sobregiro>0){
            if (residuo>0){
                sobregiro=0;
                saldo=residuo;
            }else{
                sobregiro=-residuo;
                saldo=0;
            }
        }else{
            super.depositar (cantidad);
        }
    }
    /*
     * Metodo que imprime en pantalla la información de la cuenta corriente
     */
    public void imprimir (){
        System.out.println ("Saldo: $" + saldo);
        System.out.println ("Cargo Mensual: $" + comisionMensual);
        System.out.println ("Número de movimientos: " + (numeroDepositos+numeroRetiro));
        System.out.println ("Total Sobregiros: $" + sobregiro);
        System.out.println ();
    }

}

