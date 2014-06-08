package provas.s20141.p320141.q1;

public class Lista<T> {

    private No primeiro;
    private No ultimo;

    public void incluir(T objeto) {
        No<T> no;
        if (ultimo == null) {
            no = new No(null, null, objeto);
            primeiro = no;
            ultimo = no;
        } else {
            no = new No(ultimo, null, objeto);
            ultimo.proximo = no;
            ultimo = no;
        }
    }

    public void intercalarCom(Lista<T> l) {
        if (l != null)
            if (this.estaVazia())
                receber(l);
            else {
                No<T> lCorrente = l.primeiro;
                No<T> thisCorrente = this.primeiro;
                No<T> thisProximo = null;
                No<T> novoNo = null;
                while (lCorrente != null) {

                    thisProximo = thisCorrente.proximo;
                    novoNo = new No(thisCorrente, thisProximo, lCorrente.objeto);
                    thisCorrente.proximo = novoNo;
                    if (thisProximo != null)
                        thisProximo.anterior = novoNo;
                    // andar
                    if (novoNo.proximo != null)
                        thisCorrente = novoNo.proximo;
                    else
                        thisCorrente = novoNo;
                    lCorrente = lCorrente.proximo;

                }
            }
    }

    public void receber(Lista<T> l) {
        if (l != null) {
            No<T> lCorrente = l.primeiro;
            while (lCorrente != null) {
                incluir(lCorrente.objeto);
                lCorrente = lCorrente.proximo;
            }
        }
    }

    public boolean estaVazia() {
        return ultimo == null;
    }

    void imprimir() {
        No<T> thisCorrente = this.primeiro;
        System.out.print("{");
        while (thisCorrente != null) {
            if (thisCorrente.proximo != null)
                System.out.print(thisCorrente.objeto + ",");
            else
                System.out.print(thisCorrente.objeto + "");
            thisCorrente = thisCorrente.proximo;
        }
        System.out.println("}");
    }

}
