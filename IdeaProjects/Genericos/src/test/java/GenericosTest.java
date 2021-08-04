public class GenericosTest {

    public static void main(String[] args) {

        Generica<Integer> integerGenerica = new Generica<>(80);
        System.out.println("Valor integerGenerica : " + integerGenerica.getObjetoGen());
        integerGenerica.mostrarTipoObjGen();

        Generica<String> stringGenerica = new Generica<>("Palabra");
        System.out.println("Valor stringGenerica : " + stringGenerica.getObjetoGen());
        stringGenerica.mostrarTipoObjGen();

        Generica2Tipos<Integer, String> generica2Tipos= new Generica2Tipos<>(1, "Mauro");
        System.out.println("Valor T (1) " +  generica2Tipos.getObjetoUno());
        System.out.println("Valor V (2) " +  generica2Tipos.getObjetoDos());
        generica2Tipos.mostrarTiposObjeto2Tipos();

        GenericaCerrada<Double> doubleGenericaCerrada = new GenericaCerrada<>(123.45);
        System.out.println("Valor doubleGenericaCerrada : " + doubleGenericaCerrada.getObjCerrNumero());
        doubleGenericaCerrada.mostrarObjetoBounded();
        System.out.println("Valor inverso : " + doubleGenericaCerrada.inverso());
        System.out.println("Parte decimal : " + doubleGenericaCerrada.parteDecimal());

    }

}
