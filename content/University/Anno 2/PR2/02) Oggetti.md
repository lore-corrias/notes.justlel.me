---
title: 02 - Oggetti
date: 2024-03-01
tags:
  - pr2
  - oggetti
  - classi
draft:
---
> [!summary]- Lezioni Collegate
> Lezione precedente: [[01) Introduzione a Java]]
> 
> Lezione successiva: [[03) Inheritance]]
## Oggetti
Gli oggetti sono le istanze delle classi. Per fare un paragone con il mondo reale, considerando la classe di animali "_Cane_", l'oggetto della classe cane è un cane specifico, con tutte le sue caratteristiche individuali (tipo colore del pelo, età, ecc.)
Ogni classe possiede delle _proprietà_, che sono anche dette attributi (per mantenere l'analogia, sono il colore del pelo e le caratteristiche elencate sopra). Sono come delle variabili, ma sono specifici all'istanza di un classe, quindi di un oggetto.
Un oggetto è istanziato attraverso la keyword `new`:
```java
Rectangle rettangoloPiccolo = new Rectangle(0,0,10,20);

rettangoloPiccolo.calcolaArea();
```
### Metodi
I metodi sono come delle funzioni, ma sono specifiche di una classe.
```java
String greeting = "Hello"
greeting.length(); // metodo della classe string
greeting.println(); // errore: la classe string non ha un metodo println
```
Java permette l'**overloading di un metodo**, ossia di avere due metodi con lo stesso nome, ma con diversi parametri:
```java
public class Cane {
	public void mangiaCrocchette() {
		// corpo del metodo
	}
	
	public void mangiaCrocchette(int numeroCrocchette) {
		// corpo del metodo
	}
}
```
Il **costruttore** è un metodo particolare di una classe. Esso viene chiamato quando l'oggetto viene istanziato, e il suo scopo è quello di effettuare delle azioni alla sua creazione, solitamente impostare degli attributi. La sintassi per chiamare un costruttore fa uso di `new`:
```java
Rettangolo r = new Rettangolo(0, 0, 10, 20);
```
Mentre viene definito all'interno della classe come un metodo normale, ma che ha **lo stesso nome della classe stessa**:
```java
public class Rettangolo {
	int x;
	int y;
	int base;
	int altezza;
	
	Rettangolo(int x, int y, int base, int altezza) {
		// x = x genera un errore, dobbiamo usare la keyword
		// "this" per dire che ci stiamo riferendo
		// all'attributo dell'oggetto e non al parametro
		this.x = x;
		this.y = y;
		this.base = base;
		this.altezza = altezza;
	}
}
```
In questo modo, usiamo il costruttore per fornire al nostro oggetto `r` della classe `Rettangolo` dei valori per la base, l'altezza e la sua posizione.
_Nota: esiste sempre un costruttore di default che viene aggiunto dal compilatore in automatico, che non prende nessun parametro e non esegue alcuna azione. Quindi, quando assegniamo un oggetto a una variabile, stiamo sempre chiamando un costruttore. Senza aver prima eseguito il costruttore, infatti, è impossibile accedere agli attributi o ai metodi di una variabile:_
```java
Rettangolo r;
System.out.println(r.x); // genera una NullPointerException, r vale "Null"
```
### Garbage Collector
Nell'esempio seguente:
```java
Rectangle r1 = new Rectangle(0,0,10,20);
Rectangle r2 = new Rectangle(0,0,100,400);
r2 = r1;
r2.calcolaArea(); //calcola area di r1
```
stiamo istanziando $2$ oggetti della classe `Rectangle`, tuttavia tramite l'assegnamento `r2=r1` il riferimento all'oggetto `Rectangle(0,0,100,400)` è perso, quindi non possiamo più accedervi. Quando ciò succede, per evitare che l'oggetto resti inutilmente in memoria, Java attiva il suo **Garbage Collector**, che elimina dalla memoria i riferimenti agli oggetti che non sono più utilizzabili.