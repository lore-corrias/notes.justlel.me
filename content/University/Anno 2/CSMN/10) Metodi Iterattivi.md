---
title: 10 - Metodi Iterattivi per la risoluzione di Sistemi Lineari
date: 2024-04-16
tags:
  - cmsn
  - metodi
  - iterattivi
draft: true
---
## Metodi Iterattivi
I metodi iterattivi hanno due vantaggi:
1. Semplificano la risoluzione di alcuni sistemi lineari per cui Gauss non è efficiente
2. Ci permettono di avere, per ogni passo, un'approssimazione sempre più precisa della soluzione finale.
Ogni metodo iterattivo comincia a partire da un valore, chiamato **guess iniziale**, e ha poi bisogno di un **requisito di arresto**.
Il **guess iniziale** varia a seconda del problema che deve essere risolto, ma è sempre il valore che viene aggiornato dall'algoritmo ad ogni passo:
$$
\underline{x}^{(o)} \text{, guess iniziale} 
$$
$$
\underline{x}^{(k)} \text{, approssimazione al passo k}
$$
In generale, un metodo iterattivo si dice **globalmente convergente** se:
$$
\lim_{k \to \infty} ||x^{(k)} - \underline{x}|| = 0
$$
I metodi iterattivi sono **di prim ordine** se:
$$
x^{(k+1)} = \Phi(\underline{x}^{(k)})
$$
ossia, se il passo iterattivo $k+1$ dipende esclusivamente dal passo $k$. Sono **lineari** se $\Phi$ è **lineare** e **stazionaria**:
$$
x^{(k+1)} = B\underline{x}^{(k)} + \underline{f}
$$
dove $B$ è una **matrice di iterazione**, e $f$ un **vettore di iterazione**. $B$ ed $f$ sono quindi uguali per ogni passo.
Un metodo si dice **consistente** se:
$$
\underline{x}^{(k)} = \underline{x} \implies \underline{x}^{(k+1)} = \underline{x}
$$
ossia, una volta trovata la soluzione, applicare di nuovo il metodo non varia il risultato. Teorema:
$$
\underline{f} = (I-B)A^{-1}\underline{b}
$$
Definiamo $\underline{e}^{(k)}$ l'errore al passo $k$, esso sarà pari a:
$$
\underline{e}^{(k)} = \underline{x}^{(k)} - \underline{x} \implies \lim_{k\to\infty} ||\underline{e}^{(k)}|| = 0
$$
Oltre all'approssimazione, anche l'errore dipende dal passo precedente:
$$
e^{(k)} = Be^{(k-1)} = B^2e^{(k-2)} =\ ...\ = B^k\underline{e}^{(0)}
$$
Quindi, un metodo LS1° ordine è convergente se esiste una norma tale che:
$$
||B|| < 1
$$
Questo perché:
$$
\lim_{k\to\infty} ||\underline{e}^{(k)}|| = 0 \implies ||e^{(k)}|| = ||B^k\underline{e}^{(0)}|| \leq ||B^k|| \cdot ||\underline{e}^{(0)}|| \leq ||B||^k \cdot ||\underline{e}^{(0)}||
$$
e perché ciò sia vero, deve essere $||B|| < 1$. Quindi condizione necessaria e sufficiente affinché sia convergente è che
$$
\rho(B) < 1
$$
Dimostrazione:
$$
\rho(B) < 1 \implies \text{metodo convergente}
$$
sappiamo che, per il raggio spettrale:
$$
||A|| < \rho(A) + e \text{ (cambia qui)}
$$
Posso quindi prendere un $\epsilon$ tale che $||B|| < \rho(B) + \epsilon < 1$, e ciò implica $||B|| < 1$

## Lezione 2
### Metodo di Gauss-Seidel
Prendo:
$$
\begin{cases}
P = D - E \\
N = F
\end{cases}
$$
E quindi ho:
$$
(D-E)\underline{x}^{(k+1)} = F\underline{x}^{(k)}+\underline{b} \implies \underline{x}^{(k+1)} = (D-E)^{-1}(F\underline{x}^{(k)}+\underline{b})
$$
