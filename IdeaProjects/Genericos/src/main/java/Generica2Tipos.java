public class Generica2Tipos<T, V> {
    private T objetoUno;
    private V objetoDos;

    public Generica2Tipos(T objetoUno, V objetoDos) {
        this.objetoUno = objetoUno;
        this.objetoDos = objetoDos;
    }

    public T getObjetoUno() {
        return objetoUno;
    }

    public V getObjetoDos() {
        return objetoDos;
    }

    public void mostrarTiposObjeto2Tipos() {
        System.out.println("Tipo objetoUno = " + objetoUno.getClass().getSimpleName() +
                         ", Tipo objetoDos = " + objetoDos.getClass().getSimpleName());
    }

}
