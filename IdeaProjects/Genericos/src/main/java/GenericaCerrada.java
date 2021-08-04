public class GenericaCerrada <T extends Number> {
    // Bounded (Cerrada) porque acota el tipo de la clase generica a (en este caso) el tipo Numbers
    private final T objCerrNumero;

    public GenericaCerrada(T objCerrNumero) {
        this.objCerrNumero = objCerrNumero;
    }

    public T getObjCerrNumero() {
        return this.objCerrNumero;
    }

    public void mostrarObjetoBounded() {
        System.out.println("Tipo objeto bounded : " + objCerrNumero.getClass().getSimpleName());
    }

    public Double inverso() {
        return 1/ objCerrNumero.doubleValue();
    }

    public Double parteDecimal() {
        return objCerrNumero.doubleValue() - objCerrNumero.intValue();
    }
}
