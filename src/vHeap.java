import java.util.Vector;


public class vHeap<E extends Asimiliar<E>> implements PriorityQue<E> {
    private Vector<E> dvalue;
    int i;
    
    
        public vHeap(Vector<E> v) {
            
            dvalue = new Vector<>(v.size()); 
            for (i = 0; i < v.size(); i++) { 
                agregar(v.get(i));
            }
        }
        private void down(int k) {
            int ss = dvalue.size();
            E value = dvalue.get(k);
            while (k < ss) {
                int po = left(k);
                if (po < ss) {
                    if ((right(k) < ss) && ((dvalue.get(right(k))).cc(dvalue.get(po)) < 0)) {
                        po++;
                    }
                   
                    if ((dvalue.get(po)).cc(value) < 0) {
                        dvalue.set(k, dvalue.get(po));
                        k = po;
                    } else {
                        dvalue.set(k, value);
                        return;
                    }
                } else { 
                    dvalue.set(k, value);
                    return;
                }
            }
        }
    
        public vHeap() {
            dvalue = new Vector<>();
        }
        private static int nt(int a) {
            int k=( a - 1) / 2;
            return k;
        }
    
        private static int left(int a) {
            int k=  2 * a + 1;
            return k;
        }
    
        private static int right(int a) {
            int k= (a + 1) * 2;
            return k;
        }
    
        private void up(int k) {
            int nt = nt(k);
           E value = dvalue.get(k);
            while (k > 0 && (value.cc(dvalue.get(nt)) < 0)) {
                dvalue.set(k, dvalue.get(nt));
                k = nt;
                nt = nt(k);
            }
            dvalue.set(k, value);
        }
    
      
    
  

        @Override
        public E remove() {
            E minVal = dvalue.get(0);
            if (dvalue.isEmpty()) {
                return null;
            }
          
            if (dvalue.size() == 1) {
                dvalue.remove(0);
                return minVal;
            }
            E lastVal = dvalue.remove(dvalue.size() - 1);
            dvalue.set(0, lastVal);
            down(0);
            return lastVal;  
        }

        @Override
        public E peek() {
            if (dvalue.isEmpty()) {
                return null;
            }
            return dvalue.get(0);
        } 

        @Override
        public int tamaño() {
     
            return dvalue.size();
        }

        @Override
        public void limpiar() {
           dvalue.clear();
        }

        @Override
        public boolean isEmpty() {
            return dvalue.isEmpty();
         }

        @Override
        public boolean agregar(E element) {
            dvalue.add(element);
            up(dvalue.size() - 1);
            return true; }
}