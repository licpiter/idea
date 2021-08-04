import org.junit.Test;
import static junit.framework.Assert.*;

public class CarritoTest {
    private static final int TOTAL_SIZE = 20; //20000;
    private static final int NUMBER_ADD = 10; //1000;

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
        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE, NUMBER_ADD);
        builder.add(-1);
        builder.multipleAdd(TOTAL_SIZE, NUMBER_ADD);
        CarritoCompra carritoCompra = builder.build();
        assertTrue(carritoCompra.detectarNegativo());
    }

    @Test
    public void DetectarErrorPrecioNegativoFindIsPresentTest(){
        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE, NUMBER_ADD);
        builder.add(-1);
        builder.multipleAdd(TOTAL_SIZE, NUMBER_ADD);
        CarritoCompra carritoCompra = builder.build();
        assertTrue(carritoCompra.detectarNegativoFindFirstIsPresent());
    }

    @Test
    public void DetectarErrorPrecioNegativoAnyMatch(){
        CarritoBuilder builder = new CarritoBuilder(TOTAL_SIZE, NUMBER_ADD);
        builder.add(-1);
        builder.multipleAdd(TOTAL_SIZE, NUMBER_ADD);
        CarritoCompra carritoCompra = builder.build();
        assertTrue(carritoCompra.detectarNegativoAnyMatch());
    }

}