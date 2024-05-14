---
title: 07 - Interfacce
date: 2024-04-05
tags:
  - pr2
  - interface
draft: false
---
> [!summary]- Lezioni Collegate
> Lezione precedente: [[06) Classi Astratte e Eccezioni]]
> Lezione successiva: [[08) Enumerabili e Generics]]
## Le Interfacce
Supponiamo di voler costruire un'audio radiocomandata, e di avere diversi team preposti ad ogni funzione. Queste saranno le mansioni per ogni team:
1. Costruire il driver per il motore
2. Costruire il modulo che sterza
3. Costruire il ricevitore Wireless
4. Costruire il telecomando

Quanto tempo impiegheremmo, supponendo un mese per team, per costruire tutto il software?
Dato che ogni mansione è dipendente dalla precedente, avremmo bisogno di mantenere i team successivi in stand-by (e contemporaneamente, pagati) fino al termine del compito del team precedente. Infatti:
* Team 1 e 2 lavorano in contemporanea (1 mese e $20k)
* Team 3 attende Team 1 (1 mese e $10k)
* Team 4 attende Team 3 (1 mese e $10k)

Quindi in totale 3 mesi e $40k.

Per velocizzare il processo, potremmo chiedere ad ogni team di stilare, prima di cominciare un lavoro, una sorta di "_contratto_", dove vengono specificate le funzioni che saranno scritte da ogni team. In questo modo:
* Team 1 e 2 lavorano in contemporanea, specificando **prima** le funzioni che serviranno per accedere al motore e allo sterzo, **senza ancora definire il corpo del codice**
* Team 3 può lavorare in contemporanea a Team 1 e Team 2: tramite il contratto, il Team sa infatti che, se ha bisogno di accedere al motore dell'automobile, può rifarsi alle funzioni e alle classi definite nel contratto, che saranno poi completate al termine del lavoro di team 1 e 2.
* Stesso ragionamento per Team 4, che deve collaborare con Team 3

Le **interfacce** in Java funzionano esattamente come dei **contratti**. Le interfacce sono delle classi in Java che descrivono come utilizzare uno specifico pezzo di codice:
```java
Sterzo:
	sterza(); // chiama il metodo sterza() per far sterzare l'auto
```

Quindi, perché non usare le classi astratte, che permettono di definire dei metodi senza corpo? Due ragioni:
1. Le classi `abstract` obbligano il programmatore a **estendere la classe astratta** e **solo e soltanto quella**, quindi diventa molto complesso creare un sistema di gerarchie delle classi.
2. L'ereditarietà in Java è **singola**: non è possibile ereditare più di una classe. Se quindi volessimo implementare un sistema ESC per la frenatura automatica della ruota durante lo sterzo, avremmo bisogno di un'altra interfaccia o classe astratta, che non possiamo estendere.

Java mette quindi a disposizione le **interfacce**, con questa sintassi:
```java
public interface ComandiMotorePerUtente {
	void avanti();
	void stop();
	void retromarcia;
}
```
Un interfaccia è solitamente pubblica, e può contenere al suo interno:
* **Metodi** (sono sempre dichiarati come `public`)
	* `abstract`: fanno parte dell'istanza dell'oggetto, ma non hanno il corpo
	* `default`: fanno parte dell'istanza dell'oggetto e hanno un corpo, su cui può essere fatto `Override`
	* `statici`: fanno parte della classe e hanno il corpo
* **Costanti** (sono sempre dichiarate `public`, `static`, `final`)
```java
public interface Numero {
	double PI = 3.1415; // public, static e final
	Numero somma(Numero addendo); // public
}
```
> [!note]- Le keywork `static` e `final`
> * La keyword `final` permette di definire un attributo come **non riassegnabile**: nei tipi **primitivi** e negli oggetti immutabili, li rende essenzialmente delle **costanti** (non possono essere riassegnati, e quindi modificati, sono indicati con nomi in maiuscolo); nei **metodi**, indica che su questi non è possibile fare `Override`; nelle classi, indica che queste non possono essere estese 
> * La keyword `static`, invece, associa un metodo o un attributo non all'oggetto, ma alla **classe stessa**, dunque non è possibile farne `Override`. Un esempio è il metod o`System.out.println`, che può infatti essere chiamato senza bisogno di istanziare una classe `System.out`

Le interfacce possono anche essere estendere **altre interfacce**:
```java
public interface InterfacciaA extends InterfacciaB, InterfacciaC, InterfacciaD {
	// ...
}
```
> [!important] Nota: l'ereditarietà tra interfacce è **multipla**

e, una volta definite, devono essere **implementate** da una classe:
```java
public interface ComandiMotorePerUtente{
	void avanti();
	void stop();
	void retromarcia();
}

public interface ComandiMotorePerESC {
	/* funziona solo se in avanti */
	void frenaRuotaDestra();
	/* funziona solo se in avanti */
	void frenaRuotaSinistra();
}

public class MotoreElettrico extends Motore implements ComandiMotorePerUtente, ComandiMotorePerESC {
	// implementazione dei metodi delle interfacce
}
```
Dopo che una classe implementa un'interfaccia, **deve necessariamente** definire i corpi per tutti i metodi dell'interfaccia dichiarati `abstract`, oppure dichiararsi `abstract` a sua volta.