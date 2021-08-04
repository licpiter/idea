public class Generica<T> {
    T objetoGen;

    Generica(T objG) {
        this.objetoGen = objG;
    }

    public T getObjetoGen() {
        return this.objetoGen;
    }

    void mostrarTipoObjGen() {
        System.out.println("El tipo es " + this.objetoGen.getClass().getSimpleName());
    }
}
