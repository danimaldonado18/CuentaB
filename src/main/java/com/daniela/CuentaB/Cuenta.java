package com.daniela.CuentaB;

/*
 * author: Daniela Maldonado
 * fecha y version: 23/10/2025 version: 1.0
 * descripcion: implementamos una clase cuenta que va a tener los siguientes atributos:
 * saldo tipo flotante se inicia en 0
 * numero de consignaciones tipo entero
 * numero de retiros tipo entero
 * tasa anual tipo flotante
 */

public class Cuenta {
    //atributo saldo
    protected float saldo;
    //atributo numero de deposito
    protected int numeroDepositos = 0;
    //atributo numero de retiros
    protected int numeroRetiro = 0;
    //atributo tasa anual
    protected float tasaAnual;
    //atributo comision mensual
    protected float comisionMensual = 0;

    /*
     *Constructor de la clase cuenta
     * @param saldo Parametro que define el saldo de la cuenta
     * @param tasaAnual Parametro que define la tasa anual de interes de la cuenta
     */

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    /*
     * el metodo depositar recibe una cantidad de dinero a depositar
     * y actualiza el saldo
     * @para cantidad Parametro que deposita el usuario
     */

    public void depositar(float cantidad) {
        //actualizar el saldo
        saldo = cantidad + saldo;
        //actualizo el numero de depositos
        numeroDepositos += 1;
    }

    /*
    el metodo retirar actualiza el estado del saldo
    @param cantidad parametro
     */
    public void retirar(float cantidad) {
        //actualizo el saldo
        float nuevoSaldo = saldo - cantidad;
        //hago una condicion para verificar el saldo de la cuenta
        if (nuevoSaldo >= 0) {
            //actualizo el saldo
            saldo = nuevoSaldo;
            numeroRetiro += 1;
        }else{
            System.out.println("El monto a retirar es mayor a saldo");
        }
    }

    /*
     * metodo para Calcular el interés mensual de la cuenta y actualiza el saldo corres pondiente.
     * @param saldo Parametro que recibe el saldo que se va a actualizar
     * @param tasaAnual Parametro que recibe la tasa anual a dividir por meses
     */
    public void calcularInteres() {
        //tasa mensual
        float  tasaMensual =tasaAnual/12;
        //interes mensual
        float interesMensual = saldo*(tasaMensual/100);
        //actualizamos el saldo
        saldo = saldo + interesMensual;
    }

    /*
     *Extracto mensual: actualiza el saldo restándole la comisión mensual y
     * calculando el interés mensual correspondiente (invoca el metodo anterior).
     */
    public void extractoMensual() {
        saldo = saldo - comisionMensual;
        calcularInteres();

    }
}
