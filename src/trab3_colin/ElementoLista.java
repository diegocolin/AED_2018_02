/**
  * @authors Diego Arndt, Diego Colin Soares e Felipe de Jesus Vieira
 */
public class ElementoLista<T> {

    private T elemento;
    private ElementoLista proxElemento;
    private ElementoLista elementoAnt;

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
