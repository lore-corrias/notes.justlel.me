---
title: 11 - Equazioni non Lineari
date: 2024-04-30
tags:
  - "#csmn"
  - sistemi_non_lineari
draft: true
---
## Equazioni Non Lineari
Le equazioni non lineari possono essere risolte solo **numericamente**, quindi otteniamo una approssimazione del risultato.
$$
\begin{cases}
x^2 - 2 &= 0 \\
\cos{e^{x^2}} &= 0
\end{cases}
$$
Quindi, iniziamo anche in questo caso con un guess, sperando di ottenere un risultato **convergente**. Cerchiamo quindi una **radice** dell'equazione $\alpha$ tale che $f(\alpha)=0$. Se così è vero, allora possiamo dire che, preso un $\epsilon$ arbitrariamente piccolo, il risultato sarà più corretto quanto più sarà piccola la $\epsilon$, posto:
$$
|f(x)| < \epsilon
$$
Come nel caso dei etodi iterattivi, abbiamo la stessa definizione di errore al passo $k$ e di metodo iterattivo:
$$
e_k = x_k - \alpha
$$
$$
\lim_{k \to \infty} |e_k| = 0
$$
### Ordine di Convergenza
Se un metodo iterattivo converge, allora il rapporto tra l'errore al passo $k$ e al passo $k+1$ (_elevato per una potenza $p$, che indica la "velocità" di convergenza_) si avvicina a una costante andando avanti:
> [!important] Definizione ordine di Convergenza
> $$
> \lim_{k \to \infty} \frac{|e_{k+1}|}{|e_k|^p} = C \implies \lim_{k \to \infty} |e_{k+1}| = C \cdot |e_k|^p
> $$
> Un sistema si classifica quindi come:
> * **Lineare**: $p=1$
> * **Quadratico**: $p=2$

#### Serie di Taylor - Accenno
> [!note] Nota sulle serie di Taylor
> Sia $f \in \mathbb{C}^{n+1}([a,b])$ e sia $x_0 \in [a,b]$. Allora, per ogni $n \in \mathbb{N} esiste $P_n$ di grado $n$ tale che:
> $$
> f(x) = P_n(x) + R_{n+1}(x)
> $$
> dove:
> $$
> \begin{cases}
> P_n(x) &= \sum^{n}_{k=0}\frac{f^{(k)}(x)}{k!}(x-x_0)^k \\
> R_{n+1}(x) &= \frac{f^{(n+1)}(\epsilon)}{(n+1)!}(x-x_0)^{n+1}
> \end{cases}
> $$
> _La notazione $f^{(k)}$ indica la derivata k-esima della funzione_
>
> Quindi, possiamo approssimare ogni funzione (esponenziale, potenza, ecc.) con un polinomio, a meno di un certo grado di approssimazione (che è $R_n$). Per esempio, lo sviluppo di Taylor dell'esponenziale è:
> $$
> \frac{e^0}{1}(x-0)^0 + \frac{e^0}{1}(x-0)^1 + \frac{e^0}{2}(x-0)^2 + \frac{e^0}{6}(x-0)^3 + ... = \sum^{n}_{k=0} \frac{x^k}{k!}
> $$
### Radici Multiple
Una radice $\alpha$ si dice **multipla** se si ripete $m$ volte, ed ha quindi molteplicità $m$:
> [!important] Radice Multipla
>$$
>f(x) = (x-\alpha)^m n(x),\ h(\alpha) \neq 0
>$$
> 
>In generale, una radice $\alpha$ ha molteplicità $m$ se e solo se:
>$$
>f^{(k)}(\alpha) = 0, \text{ con } k=0,...,m-1,\ f^{(m)}(\alpha) \neq 0
>$$

Supponiamo di avere una funzione $f(x)$ con una radice $\alpha$ con molteplicità 1. Possiamo sviluppare la nostra funzione con la **serie di Taylor**: in questo caso, abbiamo solo il primo termine dello sviluppo e il resto:
$$
f(x)=\cancel{f(\alpha)} + f'(\xi)(x-\alpha)
$$
sappiamo che, essendo $\alpha$ una radice, vale $|f(x)<\epsilon|$:
$$
|f(x)| = |f'(\xi)| \cdot |x-\alpha| < \epsilon \implies |x-\alpha| < \frac{\epsilon}{|f'(\xi)|}
$$
Ma sappiamo anche che il **condizionamento di un sistema** è espresso dalla disequazione:
$$
|\delta x| < k |\delta d|
$$
e quindi, il numero di condizionamento è pari a:
$$
k=\frac{1}{|f'(\xi)|}
$$
Una radice $n$-esima è peggio condizionata quindi, perché il numero di condizionamento è:
$$
k = {(\frac{n}{|f^{(n)}(\xi)|})}^{1/n}
$$