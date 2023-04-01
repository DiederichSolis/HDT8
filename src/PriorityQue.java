public interface PriorityQue <E extends Comparable <E>>{
    void limpiar();
    E peek();
    E remove();
    int tamaño();
    boolean isEmpty();
    boolean agregar(E element);
} 