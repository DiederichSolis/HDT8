public interface PriorityQue <E extends Asimiliar <E>>{
    void limpiar();
    E peek();
    E remove();
    int tamaño();
    boolean isEmpty();
    boolean agregar(E element);
} 