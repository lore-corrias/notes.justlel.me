---
title: 03 - Ereditarietà e Gerarchie
date: 2024-03-04
tags:
  - pr2
  - classi
  - ereditarietà
draft:
---
> [!summary]- Lezioni Collegate
> Lezione precedente: [[02) Oggetti]]
> 
> Lezione successiva: [[04) Packages e Modificatori]]
## Ereditarietà
Assumiamo di avere un codice che implementa una classe `Rettangolo`, come questa:
```java
public class Rettangolo {
  // Implemento correttamente l'incapsulamento
  private double x,  y;
  private double altezza;
  private double altezza;

  public Rettanglo(double x, double y, double larghezza, double altezza) {
    this.x = x;
    this.y = y;
    this.larghezza = larghezza;
    this.altezza = altezza;
  }

  public double area() {
    return base * altezza;
  }

  public void raddoppia() {
    x -= larghezza;
    y -= altezza;
    larghezza *= 2;
    altezza *= 2;
  }
}
```
Immaginiamo ora di voler implementare una classe `Quadrato`, che presumibilmente condividerà degli elementi comuni a `Rettangolo`, come `area()` o `raddoppia()`. Quindi sorge spontanea una domanda: è davvero necessario implementare da capo questi metodi, sebbene siano già stati scritti? La risposta è che Java mette a disposizione il concetto di **Ereditarietà**, che risponde proprio a questa domanda e rende il compito degli sviluppatori più semplice.

L'ereditarietà ci permette sostanzialmente di _riutilizzare_ il codice di una classe in un altro contesto, e il suo scopo è proprio quello di **scoraggiare il copia-incolla del codice**, che fa insorgere numerosi problemi di natura _manutentiva_ (per esempio, se il codice copiato da `Rettangolo` è sbagliato, allora dovrò modificarlo in tutti i casi in cui l'ho implementato erroneamente).
### Riutilizzo  tramite inclusione
La riutilizzazione può avvenire, per esempio, tramite _inclusione_. Nel nostro esempio, sappiamo che di fatto un `Quadrato` è un tipo particolare di `Rettangolo`. Possiamo quindi implementare una classe `Quadrato` usando un attributo `Rettangolo`:
```java
public class Quadrato {
  // Utilizzo un attributo di tipo 'Rettangolo'
  // per rappresentare questo quadrato
  private Rettangolo rettangolo;

  public Quadrato(double x, double y, double lato) {
    // Creo il mio quadrato come se fosse un rettangolo con i due lati uguali
    rettangolo = new Rettangolo(x, y, lato, lato);
  }

  // L'area di questo quadrato è esattamente uguale all'area dell'attributo
  // 'rettangolo'
  public double area() {
    return rettangolo.area();
  }

  // Per raddoppiare l'area di questo quadrato raddoppio l'area dell'attributo
  // 'rettangolo'
  public void raddoppia() {
    rettangolo.raddoppia();
  }
}
```
Tuttavia, non abbiamo risolto in maniera efficiente tutti i nostri problemi, dato che per i metodi `area()` e `raddoppia()` dobbiamo comunque copincollare la _firma del metodo_ (il tipo di ritorno e i parametri), e $\text{copincollare} = \text{bad!!!}$
<div style="page-break-after: always;"></div>

### Riutilizzo tramite ereditarietà
Per ottimizzare il riutilizzo del codice possiamo pensare a un livello più alto. Nel nostro caso, un quadrato non è altro che un particolare tipo di rettangolo, come abbiamo visto sopra, quindi la classe `Quadrato` rappresenta un sottoinsieme di oggetti della classe `Rettangolo`, ossia quegli oggetti con gli attributi "_base_" e "_altezza_" uguali. Possiamo quindi creare una sorta di "_gerarchia_", in cui la classe `Quadrato` è "_subordinata_" alla classe `Rettangolo` (in inglese, diremmo che un `Quadrato` **is a** `Rettangolo`). Possiamo ideare una _gerarchia_ per moltissimi tipi di classi, non solo per le figure geometriche:
![](https://i.imgur.com/faGzPuH.png)

Possiamo quindi visualizzare questa gerarchia di classi come un **albero**, dove, per esempio `Rettangolo` è la classe **padre**, o **superclasse**, e `Quadrato` la classe **figlio**, o **sottoclasse**. Quando tra due classi vale la relazione **is a** detta sopra, possiamo applicare l'ereditarietà.

Per implementare l'ereditarietà, usiamo in Java questa sintassi:
```java
class Quadrato extends Rettangolo { ... }
```
l'ereditarietà può anche essere multipla:
```java
class Quadrato extends Rettangolo { ... }
class Rettangolo extends Quadrilatero { ... }
```
Quindi `Quadrato` è una sottoclasse di `Quadrilatero`, anche se non direttamente. Condizione necessaria e sufficiente per realizzare l'ereditarietà tra due classi è che la classe figlia soddisfi la relazione **is-a** con la classe padre.

La sottoclasse che implementa questa relazione **eredita** tutto dalla classe padre, tranne:
* I **costruttori**, anche se questi possono essere _riutilizzati_
* I metodi/attributi privati **non sono visibili**, ma esistono (_questa tecnica è detta **shadowing**_)
Questo significa che gli oggetti della classe `Quadrato` assumono **anche** il tipo `Rettangolo` (un oggetto può quindi avere più tipi):
```java
// questa scrittura è perfettamente legale
Rettangolo quadrato = new Quadrato(0, 0, 100);

// ma quesa no!
Quadrato rettangolo = new Rettangolo(0, 0, 100, 100);
```

La classe quadrato reimplementata è quindi:
```java
public class Quadrato extends Rettangolo {
	public Quadrato(double x, double y, double lato) {
		super(x, y, lato, lato);
	}
}
```
la keyword `super()` ci permette di chiamare il **costruttore della superclasse**.

L'ereditarietà ci permette di chiamare i metodi `area()` e `raddoppia()` senza bisogno di ridefinirli:
```java
public class Quadrato extends Rettangolo {
	public Quadrato(double x, double y, double lato) {
		super(x, y, lato, lato);
	}

	public static void main(String[] args) {
		Quadrato quadrato = new Quadrato(0, 0, 100);

		System.out.println("Area del quadrato: " + quadrato.area());
		quadrato.raddoppia();
		System.out.println("Area del quadrato con il lato raddoppiato: " + quadrato.area());
	}
}
```
Se non implementiamo alcun costruttore, viene automaticamente chiamato il costruttore `super()` della superclasse. Ma **attenzione!** Se specifichiamo in `Rettangolo` un costruttore con dei parametri, quello di default viene cancellato, e quindi una scrittura del genere:
```java
public class Quadrato extends Rettangolo {
	public Quadrato(double x, double y, double lato) {
		//super(); scriverlo o no è indifferente
	}
}
```
genera errore, perché non esiste un costruttore senza parametri in `Rettangolo`! Stessa cosa se usiamo una classe vuota:
```java
public class Quadrato extends Rettangolo {}
```
questo perché il compilatore aggiunge in automatico un costruttore vuoto, che però in questo caso non esiste.
Quando viene istanziata una sottoclasse, la **prima istruzione** è **sempre** la chiamata al costruttore della superclasse.

> [!hint] 
> _Domande di esempio dell'esame_: presa la classe `Quadrato`, che eredita da `Rettangolo`:
>```java
>public class Quadrato extends Rettangolo {
>	public Quadrato(double x, double y, double lato) {
>		super(x, y, lato, lato);
>	}
>}
>```
> 1. Quanti _costruttori_ ha la classe `Quadrato`?
>		* _Risposta_: solo $1$, ossia quello che abbiamo definito
> 1. Quanti _metodi_ ha la classe `Quadrato`?
> 		* *Risposta*: tutti quelli della classe `Rettangolo`, eventualmente "shadowed", ossia non visibili se privati
> 1. Quanti _attributi_ ha la classe `Quadrato`?
> 		* *Risposta*: uguale a sopra
<div style="page-break-after: always;"></div>

#### La superclasse `Object`
Si nota che tutte le classi, anche quando non specificato, estendono automaticamente una classe `Object`, che è quindi l'unica a non avere alcuna superclasse. Dunque, in caso di _ereditarietà multipla_, vengono chiamati i costruttori di tutte le superclassi, fino a quello di `Object`.

> [!note] 
>`Object` è una classe speciale appartenente al `JDK` (Java Development Kit), che sono le _librerie standard di Java_.
### Cast
Con "**cast**" ci si riferisce all'operazione utilizzata per "forzare" il tipo di un oggetto. Esistono due tipi di casting:
* *Upcasting*: viene effettuato automaticamente dal compilatore, ed avviene quando a una *sottoclasse* è dato il tipo della *superclasse*:
  ```java
	Object myobject = new Quadrato(0,0,10);
	```
* *Downcasting*: va esplicitato dal programmatore, e l'operazione non è sempre possibile:
	```java
	Quadrato q = (Quadrato) myobject;
	```
	se, per esempio, `myobject` fosse stato inizialmente definito come una `String`, allora il programma si sarebbe interrotto con un errore.

<div style="page-break-after: always;"></div>

### Override
Fare **override** di un metodo significa ridefinire un metodo che è già stato definito in una **superclasse**.
> [!example] 
> ```java
> public class Quadrato extends Rettangolo {
> 	public Quadrato(double x, double y, double lato) {
>		super(x, y, lato, lato);
>	}
> 
> 	@Override
> 	// il metodo toString() fa parte della classe Object
> 	public String toString() {
> 		return "Quadrato in posizione (" + x + "," + y + ") e di lato " + lato; 
> 	}
> }

Per indicare che stiamo facendo `Override` di un metodo lo segnaliamo con l'**annotazione** `@Override`.

L'annotazione **non è obbligatoria**, ma serve per segnalare al compilatore che il nostro obiettivo è proprio quello di effettuare un override. Se quindi definissi, per esempio, un metodo `tostring()`, allora il compilatore segnalerebbe l'errore, perché il metodo `tostring` è segnato come `Override`, anche se non esiste nessun metodo con questo nome nelle superclassi di `Quadrato`.