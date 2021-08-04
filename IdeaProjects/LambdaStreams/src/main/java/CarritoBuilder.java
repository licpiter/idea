import java.util.ArrayList;

public class CarritoBuilder {

    ArrayList<Integer> precios = new ArrayList<>();

    public CarritoBuilder(int size){
        for(int i = 0; i < size; i++){
            Double random = Math.random()*100+1;
            precios.add(random.intValue());
        }
    }

    public CarritoBuilder(int size, int value){
        for(int i = 0; i < size; i++){
            precios.add(value);
        }
    }

    public CarritoCompra build(){
        return new CarritoCompra(this.precios);
    }

    public CarritoBuilder add(Integer nuevoValor){
        precios.add(nuevoValor);
        return this;
    }

    public CarritoBuilder multipleAdd(int tamanio, int valor){
        for (int i = 0; i < tamanio; i++) this.precios.add(valor);
        return this;
    }





}