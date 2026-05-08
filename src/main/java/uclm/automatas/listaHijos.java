package uclm.automatas;

public class listaHijos {
    public infoHijo hijoActual;
    public listaHijos resto;

    public listaHijos(infoHijo hijoActual) {
        this.hijoActual = hijoActual;
        this.resto = null;
    }

    public listaHijos(listaHijos resto, infoHijo hijoActual) {
        this.hijoActual = hijoActual;
        this.resto = resto;
    }
}