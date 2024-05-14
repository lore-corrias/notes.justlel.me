---
title: 01 - Java, introduzione
date: 2024-02-29
tags:
  - pr2
draft:
---
> [!summary]- Lezioni Collegate
> Lezione successiva: [[02) Oggetti]]
## I Tipi
In Java i tipi sono divisi in **primitivi** e **non primitivi**: se iniziano in maiuscolo, come String, sono **non primitivi**.

Ogni tipo ha delle operazioni associate: per esempio, `int` ha quelle aritmetiche, `String` quella di concatenazione, eccetera.
```java
// tipi non primitivi
String greeting = "Hello, World!";
PrintStream printer = System.out;

// tipo primitivo
int width = 25;
```

I tipi primitivi di Java sono:

| Nome      | Dimensione       | Esempio/Range         | Categoria                  |
| --------- | ---------------- | --------------------- | -------------------------- |
| `Boolean` | $1 \text{ bit}$  | $false$               | _booleani_                 |
| `Char`    | $16 \text{ bit}$ | `'a'`                 | _char_                     |
| `Byte`    | $8 \text{ bit}$  | $[-128, 127]$         | _tipi aritmetici interi_   |
| `Short`   | $16 \text{ bit}$ | $[-32.768, 32.767]$   | _tipi aritmetici interi_   |
| `Int`     | $32 \text{ bit}$ | $[2^{-31},2^{-31}-1]$ | _tipi aritmetici interi_   |
| `Long`    | $64 \text{ bit}$ | $[2^{-63},2^{-63}-1]$ | _tipi aritmetici interi_   |
| `Float`   | $32 \text{ bit}$ | $0.0f$                | _tipi aritmetici decimali_ |
| `Double`  | $64 \text{ bit}$ | $0.0d$                | _tipi aritmetici decimali_ |
_Nota: la differenza tra `float` e `double` sta nella precisione delle cifre decimali, e quindi nel numero totale di cifre significative che la variabile può contenere, che per `double` è doppio rispetto a quello di float_

## Variabili
In Java, le variabili devono essere definite specificandone il **tipo** obbligatoriamente:
```
[tipo] [identificatore] (= valore);
```
La definizione di una variabile può avvenire contemporaneamente o meno alla sua definizione. Per l'assegnazione, si usa l`=`:
```java
int i; // dichiarazione
i = 5; // definizione
int i = 5; // definizione e dichiarazione
```
Le regole per il nome dell'identificatore di una variabile sono:
* Non iniziare con un numero
* Non contenere caratteri speciali o spazi (eccetto il \_)
* Non possono essere parole riservate (e.s.: `class`)
Generalmente si usa lo stile **camelCase**, niente $\$$.
## Compilazione
Per compilare un programma in Java, è sufficiente scrivere su linea di comando:
```bash
javac Programma.java
```
e per eseguire
```bash
java Programma
```
dove "`Libro`" è il nome della classe contenente il main.
## Visibilità: `public`, `protected` e `private`
Nel codice di esempio, dato che l'attributo `paginaCorrente` è modificabile liberamente da qualunque classe, non è possibile implementare un controllo per verificare, per esempio, che il numero di pagina corrente non sia negativo, o non sia superiore al numero di pagine del libro.
Per evitare questi problemi, possiamo limitare la visibilità dell'attributo `paginaCorrente` in `private`: in questo modo, l'attributo è modificabile solo all'interno della stessa classe in cui è definito.
## Incapsulamento
Il concetto di visibilità permette di introdurre quello di `incapsulamento`: "incapsulare" una variabile significa limitarne la visibilità per fare in modo che non sia modificabile **direttamente**, ma solo attraverso la chiamata a un altro metodo che, prima di procedere alla modifica, permette di effettuare delle verifiche sul valore fornito, per evitare bug o altri problemi. Nell'esempio di `paginaCorrente`, aggiungiamo un metodo alla classe `Libro` per evitare che la pagina corrente assuma un valore insensato:
```java
public void cambiaPaginaCorrente(int paginaCorrente) {
	// verifica che la pagina sia valida
	if(paginaCorrente < 0 || paginaCorrente > nPagine) {
		System.out.println("La pagina corrente non è valida!");
	} else {
		this.paginaCorrente = paginaCorrente;
	}
}
```
Ovviamente, dato che ora l'attributo è privato, abbiamo bisogno di un metodo anche per accedervi:
```java
// Metodo che restituisce la pagina corrente
public int prendiPaginaCorrente() {
	return this.paginaCorrente;
}
```