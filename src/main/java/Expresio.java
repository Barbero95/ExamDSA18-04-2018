public class Expresio {
    /*
    private Object expresio;

    public Expresio() {
    }
    public Expresio(Object expresio) {
        this.expresio=expresio;
    }

    */

    //public abstract boolean isSymbol();

    private int numero =0;
    private String operacio = null;
    public Expresio() {
    }
    public Expresio(int x) {
        this.numero=x;
    }
    public Expresio(String ope) {
        this.operacio=ope;
    }

    public int getNumero() {
        return numero;
    }

    public boolean verQueEs (){
        if (this.operacio==null){
            return true;
        }else{
            return false;
        }
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getOperacio() {
        return operacio;
    }

    public void setOperacio(String operacio) {
        this.operacio = operacio;
    }

}
