import java.util.Vector;

/**
 * Implementación de una pila (Stack) utilizando Vector
 * @param <E> Elementos almacenados en el stack
 */
public class StackVector<E> implements Stack<E>{
	protected Vector<E> data;

	/**
     * Constructor que inicializa una pila vacía.
     */
	public StackVector() {
		data = new Vector<E>();
	}

	/**
     * Agrega un elemento a la pila
     * @param item Elemento a agregar.
     */
	public void push(E item) {
		data.add(item);
	}

	/**
     * Elimina y devuelve el último elemento ingresado.
     * @return Elemento eliminado.
     * @throws IndexOutOfBoundsException si la pila está vacía.
     */
	public E pop() {
		return data.remove(size()-1);
	}

	/**
     * Devuelve el elemento de la pila sin eliminarlo
     * @return Elemento en la cima de la pila.
     * @throws IndexOutOfBoundsException si la pila está vacía.
     */
	public E peek() {
		return data.get(size() - 1);
	}
	
	/**
     * Devuelve el número de elementos
     * @return Cantidad de elementos en el stack
     */
	public int size() {
		return data.size();
	}
  
	/**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, @return false en caso contrario
     */
	public boolean empty() {
		return size() == 0;
	}
}