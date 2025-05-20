package bstreeInterface;

import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;

public interface BinarySearchTree<E> {
    void insertar(E data) throws ItemDuplicated;   //INSERTAR UN ELEMENTO SI EXISTE LANZA LA EXCEPCIÓN
    E search(E data) throws ItemNoFound;           //BUSCA UN ELEMENTO SI NO LO ENCUENTRA SE LANZA LA EXCEPCIÓN
    void delete(E data) throws ExceptionIsEmpty;   //ELIMINA UN ELEMENTO SI ESTA VACIO SE LANZA LA EXCEPCIÓN
    boolean isEmpty();                             
}
