public interface Stack<E> 
{

   /**
    * Agrega un elemento a la pila o stack
    * @param item Elemento a agregar.
    */
   public void push(E item);
   
   /**
    * Elimina y devuelve el último elemento
    * @return Elemento eliminado.
    * @throws IndexOutOfBoundsException si la pila está vacía.
    */
   public E pop();
   
   /**
    * Devuelve el últomo elemento ingresado en el stack.
    * @return el último elemento.
    * @throws IndexOutOfBoundsException si la pila está vacía.
    */
   public E peek();
   
   /**
    * Verifica si la pila está vacía.
    * @return true si la pila está vacía, @return false en caso contrario.
    */
   public boolean empty();
   
   /**
    * Devuelve el número de elementos en el stack o pila.
    * @return Cantidad de elementos en stack.
    */
   public int size();
}