package trab3.ewe;

/**
 *
 * @author ejust
 * @param <T> - Tipo de dado genérico
 */
public class ElementoLista<T> {

    private T elemento;
    private ElementoLista proxElemento = null;
    private ElementoLista elementoAnt = null;

    public ElementoLista() {
    }

    public ElementoLista(T elemento, ElementoLista proxElemento) {
        this.setElemento(elemento);
        this.setProxElemento(proxElemento);
        this.setElementoAnt(elementoAnt);
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public ElementoLista getProxElemento() {
        return proxElemento;
    }

    public void setProxElemento(ElementoLista proxElemento) {
        this.proxElemento = proxElemento;
    }

    public ElementoLista getElementoAnt() {
        return elementoAnt;
    }

    public void setElementoAnt(ElementoLista elementoAnt) {
        this.elementoAnt = elementoAnt;
    }

}
