package br.anhembi;

public class Calculadora {

    public int soma(int n1, int n2) {
        return n1 + n2;
    }

    public int maior(int n1, int n2) {
        if(n1 > n2) {
            return n1;
        }
        return n2;
    }

    public int converte(String texto) {
        return Integer.parseInt(texto);
    }

}
