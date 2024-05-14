package it.unica.pr2.banca;

import it.unica.pr2.banca.conti.*;

public class TestBanca{

    public static void main(String[] args){

        //nome, cognome, primo versamento
        ContoBancario conto1 = new ContoBancario("Paolo", "Rossi", 10000);

        //nome, cognome, primo versamento, percentuale rendimento annuo
        ContoCorrente conto2 = new ContoCorrente("Luisa", "Verdi", 1000, 5);

        ContoCorrente conto3 = new ContoCorrente();
        
        
        assert (conto2 instanceof ContoBancario);
        System.out.println("Hai risolto 1 problema su 10");

        assert (conto3.getNumeroConto() == 1003);
        System.out.println("Hai risolto 2 problemi su 10");

        assert (conto3.getSaldo() == 0);
        System.out.println("Hai risolto 3 problemi su 10");


        ContoBancario conto4 = new ContoBancario("Paolo", "Rossi", 10000);
        assert (!conto4.equals(conto1));
        System.out.println("Hai risolto 4 problemi su 10");
        

        ContoCorrente conto5 = new ContoCorrente(conto2);
        assert (conto5.equals(conto2));
        System.out.println("Hai risolto 5 problemi su 10");

        double dollari = 50;
        double tassoConversione = 0.92;
        double euro = ContoBancario.convertiInEuro(dollari, tassoConversione);
        double risultatoAtteso = 46.0;
        assert (euro == risultatoAtteso);
        System.out.println("Hai risolto 6 problemi su 10");

        try{
           conto2.preleva(2000); 
        }catch (InsufficientFundsException e){
            assert(e instanceof RuntimeException);
            System.out.println("Hai risolto 7 problemi su 10");
            
            assert(e.getMessage().equals("Non hai fondi sufficienti!"));
            System.out.println("Hai risolto 8 problemi su 10");
        }

        try{
           conto2.preleva(-1000); 
        }catch (IllegalArgumentException e){
            assert(e instanceof RuntimeException);
            System.out.println("Hai risolto 9 problemi su 10");
            
            assert(e.getMessage().equals("Argomento non valido"));
            System.out.println("Hai risolto 10 problemi su 10");
        }



    }
}