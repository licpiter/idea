import org.junit.Test;
import static junit.framework.Assert.*;

public class CarritoTest {

    @Test
    public void shouldReturnTheCountOfAllItems() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(30);
        CarritoCompra carritoDeLaCompra = builder.build();
        assertEquals(30, carritoDeLaCompra.contarNumeroProductos());
    }

    @Test
    public void shouldCalculateTotalPrice() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(60,5);
        CarritoCompra carritoDeLaCompra = builder.build();
        assertEquals(300, carritoDeLaCompra.calcularPrecioTotal());
    }

    @Test
    public void shouldCalculateTotalPriceLambda() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(60,5);
        CarritoCompra carritoDeLaCompra = builder.build();
        assertEquals(300, carritoDeLaCompra.calcularPrecioTotalLambda());
    }

    @Test
    public void shouldCalculateTotalPriceRefMethod() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(60,5);
        CarritoCompra carritoDeLaCompra = builder.build();
        assertEquals(300, carritoDeLaCompra.calcularPrecioTotalRefMethod());
    }

    @Test
    public void calcularDescuentoTotalTest() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(20, 100);
        CarritoCompra carritoCompra = builder.build();
        assertEquals(100, carritoCompra.calcularDescuentoTotal(100));
    }

    @Test
    public void calcularDescuentoTotalLambdaTest() throws Exception {
        CarritoBuilder builder = new CarritoBuilder(20, 100);
        CarritoCompra carritoCompra = builder.build();
        assertEquals(100, carritoCompra.calcularDescuentoTotalLambda(100));
    }

    @Test
    public void DetectarErrorPrecioNegativoTest(){
        CarritoBuilder builder = new CarritoBuilder(CarritoCompra.TOTAL_SIZE, CarritoCompra.NUMBER_ADD);
        builder.add(-1);
        builder.multipleAdd(CarritoCompra.TOTAL_SIZE, CarritoCompra.NUMBER_ADD);
        CarritoCompra carritoCompra = builder.build();
        assertTrue(carritoCompra.detectarNegativo());
    }

    @Test
    public void DetectarErrorPrecioNegativoFindIsPresentTest(){
        CarritoBuilder builder = new CarritoBuilder(CarritoCompra.TOTAL_SIZE, CarritoCompra.NUMBER_ADD);
        builder.add(-1);
        builder.multipleAdd(CarritoCompra.TOTAL_SIZE, CarritoCompra.NUMBER_ADD);
        CarritoCompra carritoCompra = builder.build();
        assertTrue(carritoCompra.detectarNegativoFindFirstIsPresent());
    }

    @Test
    public void DetectarErrorPrecioNegativoAnyMatch(){
        CarritoBuilder builder = new CarritoBuilder(CarritoCompra.TOTAL_SIZE, CarritoCompra.NUMBER_ADD);
        builder.add(-1);
        builder.multipleAdd(CarritoCompra.TOTAL_SIZE, CarritoCompra.NUMBER_ADD);
        CarritoCompra carritoCompra = builder.build();
        assertTrue(carritoCompra.detectarNegativoAnyMatch());
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Test
    public void OrdenarMenores50Test(){
        CarritoBuilder builder = new CarritoBuilder(CarritoCompra.TOTAL_SIZE);
        CarritoCompra carritoCompra = builder.build();
        assertTrue(carritoCompra.ordenarMenores50().reduce(Integer::max).get() < CarritoCompra.FIFTY);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Test
    public void OrdenarMenores50ReverseTest(){
        CarritoBuilder builder = new CarritoBuilder(CarritoCompra.TOTAL_SIZE);
        CarritoCompra carritoCompra = builder.build();
        assertTrue(carritoCompra.ordenarMenores50Reverse().findFirst().get() < CarritoCompra.FIFTY);
    }

}