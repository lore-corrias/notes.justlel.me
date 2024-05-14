---
title: 08 - Enumeratori, Generics
date: 2024-04-08
tags:
  - pr2
  - enum
  - generics
draft: false
---
> [!summary]- Lezioni Collegate
> Lezione precedente: [[07) Interfacce]]
## `enum`
Supponiamo di aver bisogno di tenere traccia di un giorno della settimana in Java. Per farlo, potremmo utilizzare una classe:
```java
public class GiornoDellaSettimana() {
	private final int weekday; // scomodo

	private boolean isFestivo() {
		// ...
	}
}
```
Il problema resta il fatto che dobbiamo tenere traccia di un "intero", per tenere conto del giorno della settimana corrente, e ciò può essere scomodo per fini id mantenibilità. Per risolvere, usiamo gli `Enum`:
```java
public enum GiornoDellaSettimana {
	LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI, VENERDI, SABATO, DOMENICA
}

GiornoDellaSettimana giorno = GiornoDellaSettimana.LUNEDI;
switch(giorno) {
	case LUNEDI:
		// ...
		break;
	case MARTEDI:
		// ...
		break;
}
```
Gli `Enum` migliorano così anche la leggibilità, poiché l'associazione `Giorno della settimana -> intero` è completamente **trasparente**.

Gli `enum` sono a tutti gli effetti delle classi, che infatti estendono `java.lang.Enum`. Per questo motivo, gli `enum` possono contenere anche **metodi**, **attributi** e altri campi. Presentano anche dei metodi comuni, come `values()`, che restituisce un array con tutti i valori dell'enumeratore:
```java
for(Planet p : Planet.values()) {
	System.out.println("Planet %s", p);
}
```
Se volessimo tenere nell'enumeratore anche altri valori relativi ai pianeti, potremmo fare:
```java
public enum Planet {
	MERCURY(3.03e+23, 2.4397e6),
	EARTH(5.976e+25, 9.37814e6);

	private final double mass;
	private final double radius;
	
	Planet(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
	}

	private double mass() {
		return mass;
	}

	private double radius() {
		return radius;
	}

	public static final double G = 6.67300E-11;

	double surfaceGravity() {
		return G * mass / (radius * radius);
	}

	double surfaceWeight(double otherMass) {
		return otherMass * surfaceGravity();
	}
}
```
Accanto ai valori dell'enumeratore inseriamo, tra parentesi tonde, i valori di tutti gli attributi che sono specificati poi all'interno del costruttore, in questo caso `mass` come primo e `radius` come secondo. Specifichiamo poi questi valori nel costruttore: in questo modo, quando usiamo il valore `MERCURY` dell'enumeratore, il costruttore setterà i valori della massa e del raggio, a cui poi potremo accedere con `MERCURY.mass()`. Inoltre, possiamo anche dichiarare altri metodi slegati dai parametri del costruttore, come `MERCURY.getSurfaceWeight(otherMass)`.

## Generics
Supponiamo di avere una `ArrayList`. Sappiamo che in Java, una lista accetta valori di un solo tipo. Quindi, per esempio, il codice seguente non compila:
```java
List nomi = new ArrayList();
List numeri = new ArrayList();

nomi.add("Marco");
nomi.add("Federica");

numeri.add(20);

String s = nomi.get(1); // non compila
```
Il codice non funziona perché `List` accetta un `Object`, mentre noi gli stiamo chiedendo di fare un cast a `String`. Per risolvere, avremmo bisogno di definire **una classe per ogni tipo di lista**:
```java
ArrayListDiStringhe list1 = new ArrayListDiStringhe();
ArrayListDiInteri list2  = new ArrayListDiInteri();
```
Ovviamente, una soluzione del genere ha una bassissima mantenibilità. Per risolvere il problema, Java mette a disposizione i `Generics`, che hanno un controllo molto più forte (a tempo di compilazione) sui tipi, permette di evitare cast e copincolla:
```java
List<String> nomi = new ArrayList<String>();
List<Integer> numeri = new ArrayList<Integer>();

nomi.add("Marco"); // accetta solo stringhe
nomi.add("Federica");

numeri.add(20); // autoboxing, accetta solo interi

String s = nomi.get(1); // compila
```
Possiamo specificare il tipo di dato "generico" che deve assumere una classe ponendolo tra `<>`. Possiamo semplificare la sintassi omettendo il tipo di dato nell'inizializzazione del dato (_diamond_ `<>`):
```java
List<String> nomi = new ArrayList<>();
List<Integer> numeri = new ArrayList<>();
```
Per definire una classe con dei generics, utilizziamo la seguente sintassi:
```java
/**
* Generic version of the Box class.
* @param <T> the type of the value being boxed
*/
public class Box<T> {
	// T stands for "Type"
	private T t;
	public void set(T t) { this.t = t; }
	public T get() { return t; }
}
```
Dove `<T>` indica che la classe `Box` utilizza un generic chiamato `T`. Al momento della compilazione, quando a `T` sarà assegnato un tipo, tutti i metodi avranno lo stesso tipo specificato.
Le convenzioni per il nome dei generics sono:
* E - Element (ad esempio in una lista)
* K - Key (chiave in una mappa o indice)
* N - Numero
* T - Tipo
* V - Valore
* S,U,V etc. - secondo, terzo, quarto tipo

Quindi, la nostra classe `Box` può essere utilizzata in questo modo:
```java
Box<Integer> box = new Box<>();
box.set(10);
box.set("ciao"); // non compila
Integer i = box.get(); // restituisce 10
```

I generics possono anche essere applicate a un metodo, oltre che ad una classe. Assumiamo di aver bisogno di un metodo che confronti due coppie di oggetti. Dato che non ha senso confrontare coppie di oggetti diversi, possiamo fare:
```java
public class Util {
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getFirst().equals(p2.getFirst()) && p1.getSecond().equals(p2.getSecond());
	}
}
```
e chiamiamo poi il metodo in questo modo:
```java
boolean same = Util.<Integer, String>compare(p1, p2);
```

Un tipo generico può anche essere **vincolato**, cioè possiamo specificare che un `Generic` deve soddisfare specifiche condizioni. Per esempio, supponiamo di aver bisogno di un `Generic` per implementare una funzione che calcoli l'elemento **minimo** all'interno di una lista. Il `Generic` quindi deve necessariamente essere **iterabile**, cioè utilizzabile in un ciclo `foreach`:
```java
public static int min(int[] a) {
	int result = a[0];
	for(int i = 0; i < a.length; i++) {
		if(a[i] < result)
			result = a[i];
	}
	return result;
}
```
Se volessimo implementare questo metodo anche per i `String` e `Double`, possiamo risparmiare di fare copincolla usando i `generics`, però a quel punto non possiamo più usare il `<` per il confronto. Quindi, potremmo invece creare un metodo `piuPiccolo` per confrontare due elementi:
```java
public static ClasseGenerica min(ClasseGenerica[] a) {
	int result = a[0];
	for(int i = 0; i < a.length; i++) {
		if(a[i].piuPiccolo(result))
			result = a[i];
	}
	return result;
}
```
dobbiamo però assicurarci che `ClasseGenerica` abbia effettivamente un metodo `piuPiccolo`, o simili (perché dobbiamo poter fare `piuPiccolo`). Per farlo, possiamo sostituire `ClasseGenerica` con un `Generic`, specificando che questo debba estendere la classe `Comparable`. Se non lo specificassimo, il compilatore ci restituisce un errore, perché non può sapere in anticipo se il metodo che chiamiamo esiste per il `Generic` dato:
```java
public static <E extends Comparable> min(E[] a) {
	int result = a[0];
	for(int i = 0; i < a.length; i++) {
		// la classe Comparable ha il metodo 'compareTo', che si
		// usa esattamente per comparare due oggetti.
		if(a[i].compareTo(result) < 0)
			result = a[i];
	}
	return result;
}
```
per specificare più interfacce da estendere/implementare, usiamo `&`:
```java
public static <E extends Comparable & Clonable> min(E[] a) {
	int result = a[0];
	for(int i = 0; i < a.length; i++) {
		// la classe Comparable ha il metodo 'compareTo', che si
		// usa esattamente per comparare due oggetti.
		if(a[i].compareTo(result) < 0)
			result = a[i];
	}
	return result;
}
```
Possiamo anche avere delle `Generics` che però non vengono poi riutilizzate nel nome. In questo caso, possiamo chiamarle con il simbolo `?`:
```java
public void addAll(List<? extends E> other) {
	while()
}
```