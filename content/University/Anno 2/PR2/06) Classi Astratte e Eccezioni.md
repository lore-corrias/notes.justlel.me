---
title: 06 - Classi Astratte e Eccezioni
date: 2024-03-21
tags:
  - pr2
  - abstract
  - try-except
draft: false
---
> [!summary]- Lezioni Collegate
> Lezione precedente: [[05) Wrapper e Primitivi]]
> Lezione successiva: [[07) Interfacce]]
## Classi Astratte
Una classe `abstract` è una classe che **non può essere istanziata**. Essa può **definire dei metodi**, ma questi **non possono avere un corpo**. La sintassi è:
```java
public abstract class FiguraGeometricaChiusa {
	public abstract double area();
}
```
Le classi `abstract`:
* **NON** consentono di richiamare i loro costruttori, anche se li hanno
* Può essere `abstract` anche se tutti i metodi hanno un corpo
* Qualsiasi classe a cui manca l'implementazione anche di un solo metodo **deve** essere `abstract`.

## Eccezione
Un eccezione in Java è un errore che si genera da una situazione non prevista dallo sviluppatore. Le eccezioni sono per questo anche chiamate **errori a Runtime**: a differenza degli errori sintattici, che vengono rilevati dal compilatore in fase di compilazione del programma, le eccezioni sono **lanciata** solo durante l'esecuzione.

Un eccezione può anche essere **lanciata volontariamente da un programmatore**, onde evitare situazioni non previste e bug nel codice. Per esempio, se un `assert` non viene validato correttamente, l'applicazione lancia un **`AssertionException`**, e questo è a tutti gli effetti un comportamento voluto per evitare errori. Esistono quindi due tipi di eccezioni:
* Quelle che rappresentano condizioni eccezionali, ma che l'applicazione dovrebbe saper gestire: sono chiamate **eccezioni checked**. Per esempio, `FileNotFoundException`.
* Quelle che rappresentano condizioni eccezionali, però lanciate per via di errori nella scrittura del codice, come errori logici o bug di programmazione: sono chiamate **eccezioni a runtime (o unchecked)**. Per esempio, `NullPointerException` (chiamare un metodo di un oggetto `null`)
### Checked Exceptions
Quando è lanciata una **checked exception**, Java segue il principio del "_Catch or Specify_". Quindi, un eccezione deve o:
1. Essere **catturata** tramite `try/catch`
2. Altrimenti, il metodo che lancia l'eccezione deve **specificare che può lanciare tale eccezione**.

Il metodo `try/catch` funziona in questo modo:
```java
try {
	// codice che può lanciare un eccezione
} catch (ExceptionTypeA eccezioneA) {
	// codice che gestisce le eccezioni di tipo A
} catch (ExceptionTypeB eccezioneB) {
	// codice che gestisce le eccezioni di tipo B
} finally {
}
```
Quindi, quando un metodo all'interno di un `try/catch` solleva un eccezione, se questa è di uno dei tipi presenti all'interno di uno dei `catch`, allora viene eseguito il codice relativo a quel tipo di eccezione, e le informazioni relative sono inserite nella variabile `eccezioneA/eccezioneB`:
1. Il `try` tira un eccezione
2. L'eccezione è di tipo `ExceptionTypeA`? Se sì, allora esegui il codice del catch inserendo le informazioni dell'eccezione in `eccezioneA`, altrimenti vai avanti.
3. L'eccezione è di tipo `ExceptionTypeB`? Se sì, allora esegui il codice del catch inserendo le informazioni dell'eccezione in `eccezioneB`, altrimenti vai avanti.
4. Se l'eccezione non è stata catturata, allora è da considerarsi come `non catchata`, e quindi il metodo deve specificare che può lanciare quel tipo di eccezione.
5. Se presente, a prescindere che sia lanciata o meno un eccezione, si entra nel codice del `finally`, che è solitamente di **cleanup** (per esempio, per la chiusura dei file aperti in precedenza).

Ad ogni `try` deve corrispondere **almeno un `catch` o un `finally`**.

Ogni volta che Java controlla il tipo di un eccezione, lo fa in maniera **sequenziale** e usando `instanceof`. Questo significa che, per esempio, se facciamo:
```java
try {

} catch (Throwable e) {

} catch (LarghezzaNegativa e) {}
```
viene sempre preso `Throwable`, perché anche `LarghezzaNegativa` estende `Throwable`, quindi `e instanceof Throwable` restituisce **sempre** `true`, perché ogni eccezione estende `Throwable`, e si rientra quindi nel primo caso. Se invece facciamo:
```java
try {

} catch (LarghezzaNegativa e) {

} catch (Throwable e) {}
```
allora stiamo dicendo che, se l'eccezione non è stata catturata da qualche altro `catch`, allora `Throwable` deve catturarla necessariamente. Se invece vogliamo catturare più eccezioni allo stesso modo:
```java
try {
} catch (EccezioneA | EccezioneB e) {
//
}
```

Se un metodo deve invece **specificare** che può lanciare un eccezione, usiamo **`throws`**:
```java
public static void metodoCheLanciaEccezione() throws EccezioneA {
	throw new EccezioneA();
}
```

Un tipo speciale di `try` è il `try-with-resources`, che è molto usato quando si ha a che fare con delle **risorse**, ossia oggetti "speciali" che devono essere "chiusi" una volta che il loro compito si è concluso (un esempio di risorsa è un oggetto che rappresenta un **file**: se in scrittura, la chiusura incorretta del file può provocare errori imprevisti o corruzione del contenuto del file stesso). Il `try-with-resources` chiude automaticamente il file specificato al termine del codice:
```java
static String readFirstLineFromFile(String path) throws IOException {
	// try/finally (può lanciare eccezione nel close)
	BufferedReader br = new BufferedReader(new FileReader(path));
	try {
		return br.readLine();
	} finally {
		if (br != null) br.close();
	}

	// try-with-resources (lancia solo eccezione dentro il try)
	try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		return br.readLine();
	}
}
```