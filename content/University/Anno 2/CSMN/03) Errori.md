---
title: 03 - Errori Assoluti e Relativi
date: 2024-03-06
tags:
  - csmn
  - errori
draft:
---
> [!summary]- Lezioni Collegate
> Lezione precedente: [[02) Notazione Posizionale]]
> 
> Lezione successiva: [[04) Algebra Lineare]]
## Errore Assoluto
> [!important] Definizione di Errore Assoluto
> Considerando
> * $a$ il dato **esatto**
> * $a^*$ il dato **approssimato** (dato da qualsiasi tipo di errore possibile)
>
> L'errore assoluto $\epsilon$ è definito come la differenza, in valore assoluto, tra il dato esatto e il dato approssimato.
>$$
>\epsilon = |a-a^*|
>$$
## Errore Relativo
> [!important] Definizione di Errore Relativo
> L'errore relativo $\rho$, invece, è il rapporto tra l'errore assoluto e il valore assoluto del dato.
> $$
> \rho = \frac{|a-a^*|}{|a|} = \frac{\epsilon}{|a|}
>$$

Esempio:
* $a = 17.275$
* $a^* = 17.285$

Avremo che $\epsilon = |17.275 - 17.285| = 0.01$, mentre $\rho = \frac{0.01}{17.275} \approx 10^{-3}$. Valori dell'errore relativo vicini al $10^{-3}, 10^{-4}$ sono considerati **accettabili**.
## Errori di Memorizzazione
Abbiamo visto la scorsa lezione che:
$$
\mathbb{F}(\beta, t, L, U) = \set{0} \cup \set{x = sign(x) \times m \times \beta^p}
$$
Possiamo pensare a una funzione $fl$ che, preso un numero **reale**, ne restituisce la rappresentazione in virgola fissa:
$$
fl: \mathbb{R} \to \mathbb{F}, x \to fl(x)
$$
Nell'applicazione di questa funzione possono avvenire tre situazioni diverse:
### Rappresentazione Esatta
$$
x \in \mathbb{F}
$$
abbiamo una rappresentazione **esatta**, senza bisogno di approssimazioni.
_Per esempio: con $x=12.34$ e $\mathbb{F}(10,7,-10,10)$, il numero è rappresentabile senza alcuna approssimazione._
### Underflow
$$
|x| < \beta^{L-1}
$$
ossia $x$ è inferiore al più piccolo numero rappresentabile dal nostro insieme. In questo caso si ha **underflow**, e il numero viene visto come $0$.
### Overflow
$$
|x| \geq \beta^U
$$
ossia $x$ è superiore o uguale al più grande numero rappresentabile del nostro insieme. Qui si ha **overflow**, e i casi sono diversi. Mathlab, per esempio, assegna un valore $\inf$.
### Precisione non sufficiente
$$
x \in [B^{L-1}, \beta^U)\text{, ma }x \not\in \mathbb{F}
$$
ossia $x$ è rappresentabile in $\mathbb{F}$, ma ha troppe cifre significative.
_Per esempio: con $x=1749.98, \mathbb{F}(10,4,-10,10)$ l'insieme ha 4 cifre significative, ma $x$ 6._

Per rappresentare un numero con precisione troppo elevata esistono tre soluzioni:
#### Troncamento
Ossia, scarto tutte le cifre che eccedono il numero massimo di cifre significative.
Quindi $x=1749.98$ diventa $fl(x) = 1749 = 0.1749 \times 10^4$
In generale, se ho 
$$
|x| = m \times \beta^p = (0.d_1d_2d_3...d_td_{t+1}d_{t+2}...)_\beta\ \beta^p
$$
allora:
$$
fl(x)=trunc(x)=(0.d_1d_2d_3...d_t)_\beta\ \beta^p
$$
Il troncamento, quindi, genera un errore assoluto pari a:
$$
\epsilon=|x-fl(x)|=|(0.d_1...d_{t+1}...)_\beta\ \beta^p-(0.d_1...d_t)_\beta\ \beta^p| = |(0.0...0d_{t+1}...)_\beta\ \beta^p
$$
Sappiamo quindi che:
$$
\epsilon \leq |(0.00000...1_t0_{t+1}0...)_\beta\ \beta^p = \beta^{p-t}
$$
dove l'$1$ si trova nella posizione $t$. Questo significa che l'errore assoluto massimo ottenibile nell'azione di troncamento è $\beta^{p-t}$.
Nel caso d'esempio, $\epsilon = |0.1749-0.174998| \times 10^4 = 0.000098 \times 10^4$
			
L'errore relativo invece è pari a:
$$
\rho = \frac{|x-fl(x)|}{|x|} = \frac{\epsilon}{|x|}
$$
Tuttavia, abbiamo detto che l'errore assoluto massimo ottenibile è $\beta^{p-t}$, e sappiamo che il numero $|x$ minore possibile è $\beta^{p-1}$. Quindi, possiamo dedurre che l'errore relativo $\rho$ è sicuramente minore di:
$$
\rho = \frac{\epsilon}{|x|} \leq \frac{\beta^{p-t}}{\beta^{p-1}} = \beta^{\cancel{p}-t\cancel{-p}+1} = \beta^{1-t}
$$
#### Arrotondamento
Ossia si approssima la parte delle cifre significative sulla base di quelle in eccesso. In formule:
$$
fl(x)=(0.d_1d_2d_3...\bar{d_t})_\beta\ \beta^p
$$
   dove:
	$$
   \bar{d_t} = 
	    \begin{cases}
	    d_t && \text{se } d_{t+1} < \frac{1}{2}\beta \\
	    d_{t}+1 && \text{se } d_{t+1} \geq \frac{1}{2}\beta
	    \end{cases}
	$$
L'**epsilon di macchina** è il numero più piccolo diverso da 0 rappresentabile da un calcolatore. Matematicamente:
$$
\epsilon_m = \min\set{x \in \mathbb{R} : trunc(1+\epsilon) > 1}
$$
Ossia il più piccolo numero rappresentabile a cui, sommando $1$, ottengo un numero diverso da $1$.

Prendendo un caso d'esempio con $x = \frac{1}{5}$, facendo $1+\frac{1}{5}$ otteniamo $\frac{6}{5}$, ossia **sempre 1**, per via del troncamento. Quindi abbiamo bisogno di una $x$ tale che, con il troncamento, otteniamo un numero maggiore di 1.

> [!note] Nota su MatLab
>Quando si parla di numeri decimali, è quasi impossibile ottenere 0 in un dato, se questo è stato ricavato tramite operazioni aritmetiche, la differenza in particolare. Quindi, bisogna usare una scrittura del tipo:
>```matlab
>if | det(A) < 10^-14 |:
>```
>_e non_
>```matlab
>if | det(A) == 0 |:
>```

## Esercizi
> [!question]- Esercizio 1
>Sia $\beta = 10, t = 4$. Si calcoli $c=a-b$, con $a=0.12345$ e $b=0.12344$. *Nota, se non meglio specificato, si applica sempre arrotondamento*
>1. Faccio la trasformazione dei dati in **floating point**:
>   $$
>   fl(a) = 0.1235 \text{ (si effettua approssimazione)}\ 
> $$
>$$
>   fl(b)= 0.1234 \text{ (sempre approssimato)}
> $$
>1. Effettuo il calcolo:
>   $$
>   \bar{c} = a-b = 0.0001
>   $$
>2. Si rappresenta il risultato in virgola mobile:
>   $$
>   \bar{c} = 0.1 \times 10^{-3}
>   $$
>3. Calcoliamo l'errore relativo:
>   $$
>   \rho = \frac{|c-fl(\bar{c})|}{|c|} = \frac{0.00001-0.1\times10^{-3}}{0.00001} \approx 9
>   $$

> [!question]- Esercizio 2
> Calcolare $c = a-b$ in $\mathbb{F}(10,4,-10,10)$, con $a=979.312$ e $b=0.1234\times10^2$
>1. Rappresentazione floating point:
>   $$
>   a=0.979312 \times 10^3 \rightarrow fl(a) = 0.9793 \times 10^2
>   $$
>   $$
>   b=0.1234\times10^2 = fl(b)
>   $$
>2. Calcolo (_trasformiamo entrambi i numeri in modo che abbiano lo stesso esponente alla base_):
>   $$
>   fl(a)-fl(b) = 0.9793 \times 10^3 - 0.01234 \times 10^3 = 0.96696 \times 10^3 \rightarrow fl \rightarrow0.9670 \times 10^3
>   $$
   
