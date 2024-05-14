package it.unica.pr2.banca.conti;

public class InsufficientFundsException extends RuntimeException {
    
    @Override
    public String getMessage() {
        return "Non hai fondi sufficienti!";
    }
}
