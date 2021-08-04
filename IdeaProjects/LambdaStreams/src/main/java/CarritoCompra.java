import java.util.Collection;
import java.util.stream.Stream;

public class CarritoCompra {
    static final int NUMBER_ADD = 10; //1000;
    static final int TOTAL_SIZE = 20; //20000;
    static final int FIFTY = 50;

    private final Collection<Integer> precios;

    public CarritoCompra(Collection<Integer> precios) {
        this.precios = precios;
    }

    private static boolean menorA50(Integer pr) {
        return pr < CarritoCompra.FIFTY;
    }

    public int calcularPrecioTotal() {
        int precioTotal = 0;
        for (Integer precio : precios) {
            precioTotal += precio;
        }
        return precioTotal;
    }

    public int calcularPrecioTotalLambda() {
        int precioTotal;
/*
        precioTotal = precios.stream().map(precio -> precio).reduce(precioTotal, Integer::sum);
 */
        // .stream() convierte el Collection en un Stream
        // .map() para procesar cada elemento del stream
        // .reduce simplifica cada valor de precio, poniendo en la variable precioTotal
        // el resultado de lo que obtiene del metodo sum (Integer)

/*
        precioTotal = this.precios.stream().mapToInt(precio -> precio.intValue()).sum();
 */
        // idem... stream() recoge cada objeto de la Collection precios
        // mapToInt lleva el stream a un map de integers
        // sum() hace la suma de todos esos elementos
        // es como hacer en sql : select sum(precio) from precios
        // a su vez, precio.intValue() da un warning, porque puede pasarse a una lambda expr...
        // como tambien se ve en el ejemplo de mas arriba (.... Integer::sum)

        precioTotal = this.precios.stream().mapToInt(precio -> precio.intValue()).sum();

        return precioTotal;
    }

    public int calcularPrecioTotalRefMethod() {
        return this.precios.stream().mapToInt(Integer::intValue).sum();
    }

    public int contarNumeroProductos() {
        return precios.size();
    }

    public long calcularDescuentoTotal(int cantidadConDescuento) {
        long descuentoTotal = 0;
        for (Integer precio : precios) {
            if (precio >= cantidadConDescuento) {
                descuentoTotal += (cantidadConDescuento * 5L) / 100;
            }
        }
        return descuentoTotal;
    }

    public long calcularDescuentoTotalLambda(int cantidadConDescuento) {
        long descuentoTotal;
        long numeroDeDescuentos = this.precios.stream()
                .filter(precio -> precio.intValue() >= cantidadConDescuento)
                .count();
        descuentoTotal = (cantidadConDescuento * 5L / 100) * numeroDeDescuentos;
        return descuentoTotal;
    }

    public boolean detectarNegativo() {
        boolean negativoEncontrado = false;
        for (long precio : precios)
            if (precio < 0) negativoEncontrado = true;

        return negativoEncontrado;
    }

    public boolean detectarNegativoFindFirstIsPresent() {
        return precios.stream()
                .filter(precio -> precio < 0)
                .findFirst()
                .isPresent();
    }

    public boolean detectarNegativoAnyMatch() {
        return precios.stream().anyMatch(precio -> precio < 0);
    }

    public Stream<Integer> ordenarMenores50() {
        return precios.stream().sorted().filter(CarritoCompra::menorA50);
//        return precios.stream().sorted().filter(pr->pr<CarritoCompra.FIFTY);
    }

    public Stream<Integer> ordenarMenores50Reverse() {
        Stream<Integer> reverse = precios.stream().sorted((val1, val2) -> val2.compareTo(val1));
        return reverse.filter(CarritoCompra::menorA50);
    }
}