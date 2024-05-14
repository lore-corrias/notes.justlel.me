---
title: 06 - Sistemi Lineari, Autovalori e Autovettori
date: 2024-03-19
tags:
  - csmn
  - matrici
  - sistemi_lineari
draft: false
---
> [!summary]- Lezioni Collegate
> Lezione precedente: [[05) Matrici]]
> 
> Lezione successiva: [[07) Matrici Strutturate e Norme Matriciali]]
## Sistema lineare
> [!important] Definizione di Sistema Lineare
>Si dice "lineare" un sistema con $n$ equazioni e $n$ incognite
>$$
>\begin{cases}
>a_{11}x_1 + a_{12}x_2 + ... + a_{1n}x_n = b_1 \\
>a_{21}x_1 + a_{22}x_2 + ... + a_{2n}x_n = b_2 \\
>... \\
>a_{n1}x_1 + a_{n2}x_2 + ... + a_{nn}x_n = b_n
>\end{cases}
>$$

dove sono noti i **coefficienti del sistema** ($a_{nn}$) e i **termini noti** ($b_n$). Le **soluzioni** del sistema lineare sono i valori dell'incognita che rendono tutte le equazioni delle **identità**

Un sistema lineare ammette una **e una sola** soluzione se e solo se il determinante della **matrice dei coefficienti** è **diverso da 0**:
$$A = [A]_{ij} \in \mathbb{R}^{n\times n} \implies det(A) \neq 0$$ 

Si definisce **vettore soluzione** il vettore contenente le incognite:

$$
\underline{x} = \begin{bmatrix}
x_1 \\ x_2 \\ x_3 \\ ... \\ x_n
\end{bmatrix}
$$

e il **vettore dei termini noti**:
$$
\underline{b} = \begin{bmatrix}
b_1 \\ b_2 \\ b_3 \\ ... \\ b_n
\end{bmatrix}
$$
> [!important] Sistema come Prodotto tra Matrici
>Presi questi due vettori, l'intero sistema lineare può essere riscritto come **relazione tra $A$, $\underline{x}$ e $\underline{b}$**, in particolare:
>$$
>A\underline{x}=\underline{b} = \begin{bmatrix}
>a_{11} &a_{12} & a_{13} & ... & a_{1n} \\
>... \\
>a_{n1} & a_{n2} & ... & ... & a_{nn}
>\end{bmatrix}\begin{bmatrix}
>x_1 \\ ... \\ x_n
>\end{bmatrix} = \begin{bmatrix}
>b_1 \\ ... \\ b_n
>\end{bmatrix}
>$$

e quindi, per calcolare la soluzione del sistema, possiamo fare:
$$
x = \frac{b}{a} = b \times a^{-1} \implies \underline{x} = A^{-1}\underline{b}
$$
## Autovalori e Autovettori
Prendiamo la matrice $A$:
$$
A = \begin{bmatrix}
1 & 2 \\ 3 & 4
\end{bmatrix}\begin{bmatrix}
1 \\ 3
\end{bmatrix} = \begin{bmatrix}
1 + 6 \\
3 + 12
\end{bmatrix} = \begin{bmatrix}
7 \\ 15
\end{bmatrix}
$$
La moltiplicazione di un vettore per una matrice restituisce una sua **trasformazione lineare**.

> [!important] Definizione di Autovettore e Autovalore
>Un **autovettore** $\underline{v}$ della matrice $A$ è un **vettore lineare** tale che, quando moltiplicato per la matrice $A$, **non** restituisce un vettore spostato, dal punto di vista del piano cartesiano, ma semplicemente **ruotato**, **"allungato" o "accorciato"**.
>
>![](https://i.imgur.com/S3MHjFO.png)
>
>In questo esempio, i due vettori appartengono entrambi alla stessa retta e hanno la stessa direzione
>
>Una coppia autovalore-autovettore soddisfa questa equazione:
>$$
>A\underline{v}=\lambda\underline{V}
>$$

Generalmente, l'autovalore $\lambda$ è un **numero complesso**, anche se la matrice ha **entrate reali**.

### Determinare gli Autovalori di $A$
Per trovare tutte le coppie autovalore-autovettore di una matrice $A$ dobbiamo quindi risolvere l'equazione:

$$
A\underline{v} = \lambda\underline{v} \implies A\underline{v}-\lambda\underline{v} = 0 \implies (A - \lambda)\underline{v} = 0
$$
Sappiamo che $A\underline{v}$ è un vettore colonna (la moltiplicazione tra una matrice e un vettore restituisce sempre un vettore). Tuttavia, $A-\lambda$ non è un'operazione concessa (matrice meno scalare), quindi moltiplichiamo $\lambda$ per il vettore identità:
$$
(A-\lambda I)\underline{v}=\underline{0} \implies \text{(poniamo } A-\lambda I = \beta) \implies \beta\underline{v} = \underline{0}
$$

In questo modo, ci siamo ricondotti al caso del **sistema lineare**, in particolare al caso specifico del **sistema lineare omogeneo** (tutti i termini noti sono $0$, e quindi ammette sempre la soluzione **nulla** $\underline{x}=\underline{0}$). Un sistema lineare di questo tipo ammette sempre la soluzione banale $\underline{x} = 0$

Dato che abbiamo scritto che $\beta\underline{v}=\underline{0}$, possiamo porre $det(B)=0$, e quindi:
$$
det(B) = 0 \implies det(A - \lambda I)=0 \implies det(\begin{bmatrix}
a_{11}-\lambda & a_{12} & a_{13} & ... & a_{1n} \\
a_{21} & a_{22}-\lambda & a_{23} & ... & a_{2n} \\
... \\
a_{n1} & ... & ... & ... & a_{nn}-\lambda
\end{bmatrix})
$$
Il determinante sarà quindi un **polinomio di grado $n$**, dunque abbiamo:
$$
P_n(\lambda) = 0
$$
e dato che siamo nei **complessi**, abbiamo esattamente $n$ soluzioni, che sono anche gli **autovalori** di $A$
$$
\lambda_1, \lambda_2, ..., \lambda_n
$$

> [!example] Calcoliamo gli autovalori della matrice:
>$$
>A = \begin{bmatrix}
>1 & 2 \\ 3 & 4
>\end{bmatrix}
>$$
>quindi
>$$
>det(A-\lambda I) = 0 \implies det(\begin{bmatrix}
>1 - \lambda & 2 \\ 3 & 4 - \lambda
>\end{bmatrix}) = 0 \implies (1-\lambda)(4-\lambda)-6=0 \implies \lambda^2-5\lambda-2 = 0
>$$
>e quindi otteniamo:
>$$
>\lambda_{1,2} = \frac{5 \pm \sqrt{33}}{2}
>$$
>che sono soluzioni **reali**. Dopo aver trovato gli **autovalori**, possiamo scrivere:
>$$
>\begin{cases}(A-\lambda_1 I)\underline{v} = \begin{bmatrix}
>1-\frac{5+\sqrt{33}}{2} & 2 \\
>3 & 4 - \frac{5+\sqrt{33}}{2}
>\end{bmatrix}\begin{bmatrix}
>v_1 \\ v_2
>\end{bmatrix} = \begin{bmatrix}
>0 \\ 0
>\end{bmatrix} \implies (1-\frac{5+\sqrt{33}}{2})v_1 + 2v_2 = 0 \\
>(A-\lambda_2 I)\underline{v} = \begin{bmatrix}
>1-\frac{5-\sqrt{33}}{2} & 2 \\
>3 & 4 - \frac{5-\sqrt{33}}{2}
>\end{bmatrix}\begin{bmatrix}
>v_1 \\ v_2
>\end{bmatrix} = \begin{bmatrix}
>0 \\ 0
>\end{bmatrix} \implies 3v_1 + 4 - \frac{5-\sqrt{33}}{2}v_2 = 0
>\end{cases}
>$$
>sostituendo a $\lambda$ gli autovalori trovati, e calcolando il prodotto tra le matrici e gli autovettori. Considerando la prima equazione, possiamo riscrivere $v_1$ in funzione di $v_2$, e  otteniamo:
>$$
>v_1 = -\frac{2}{1-\frac{5+\sqrt{33}}{2}}v_2
>$$
>allo stesso modo, usiamo la seconda sostituendo a $v_1$ il valore appena calcolato otteniamo:
>$$
>-\frac{6}{(1-\frac{5+\sqrt{33}}{2})} v_2 + 4 - \frac{5+\sqrt{33}}{1}v_2=0
>$$
>Quindi, possiamo dire che il nostro autovettore è:
>$$
>\underline{v} = \begin{bmatrix}
>-\frac{2}{1+\frac{5+\sqrt{33}}{2}} x \\
>x
>\end{bmatrix}
>$$
>dove $x$ è un numero qualsiasi. Facciamo questo perché un **sistema lineare** come quello di sopra, con incognite $v_1$ e $v_2$ può avere **infinite soluzioni**. Se vogliamo un autovettore specifico, quindi, possiamo fissare la $x$ a un valore qualsiasi, come $x=1$, e quindi avremo:
>$$
>\underline{v} =\begin{bmatrix}-\frac{2}{1+\frac{5+\sqrt{33}}{2}}\end{bmatrix}
>$$
>Possiamo anche, ovviamente, ricavare $v_2$ in funzione di $v_1$, e quindi scambiare la posizione della $x$, ma il concetto è lo stesso.

### Rotazione di $90°$
La matrice:
$$
A = \begin{bmatrix}0 & -1 \\ 1 & 0\end{bmatrix}
$$
Rappresenta, sul piano cartesiano, una trasformazione lineare equivalente a una **rotazione di $90°$ in senso antiorario**, rispetto all'origine degli assi. I suoi **autovalori** sono:
$$
det(A-\lambda I) = 0 \implies det(\begin{bmatrix}-\lambda & -1 \\ 1 & -\lambda\end{bmatrix}) = 0 \implies \lambda^2+1 = 0 \implies \lambda_{1,2} = \pm i
$$
### Trasformazione Difettiva
Prendiamo in esempio la matrice:
$$
A = \begin{bmatrix}1 & 1 \\ 0 & 1\end{bmatrix}
$$
Calcoliamo i suoi autovalori:
$$
det(\begin{bmatrix}1-\lambda & 1 \\ 0 & 1-\lambda\end{bmatrix}) = 0 \implies (1-\lambda)(1-\lambda) = 0 \implies \lambda_{1,2} = 1
$$
Quindi, se calcoliamo gli autovettori:
$$
\begin{bmatrix}0 & 1 \\ 0 & 0\end{bmatrix}\begin{bmatrix}v_1 \\ v_2\end{bmatrix} = \begin{bmatrix}0 \\ 0\end{bmatrix}
$$
Calcolando il prodotto, otteniamo:
$$v_1 = 1, v_2 =0, \underline{v}=\begin{bmatrix}x \\ 0\end{bmatrix}$$
Con $x$ un parametro non vincolato. Dal punto di vista spaziale, il fatto che $v_2=0$ significa che stiamo prendendo un vettore generico nel piano cartesiano e lo **allunghiamo** sull'asse $x$, lasciando però **invariata** l'asse $y$. Una matrice che ha questo tipo di _autovettore_ è detta **difettiva**:
![](https://i.imgur.com/r2UKvK6.png)

### Spettro della Matrice
> [!important] Spettro della Matrice e Raggio Spettrale
> Si definisce **spettro della matrice** l'insieme dei suoi autovalori:
>$$
>\sigma(A) = \set{\lambda_1, \lambda_2, ..., \lambda_n}
>$$
>Il **raggio spettrale** è invece il valore **massimo** dello **spettro della matrice**
>$$
>\rho(A) = \max_{i=1,...,n} |\lambda_i|
>$$

Le **proprietà** dello spettro di una matrice sono:
1. Lo spettro della matrice A è uguale allo spettro della sua trasposta
	$$
	\rho(A^T) = \rho(A)
	$$
2. Lo spettro della matrice inversa $A^{-1}$ è uguale agli inversi degli autovalori della matrice di partenza
   $$
	\rho(A^{-1}) = \set{\lambda_1^{-1}, \lambda_2^{-1}, ...}
   $$
3. Lo spettro della matrice potenza $A^p$ è uguale alle potenze degli autovalori
   $$
   \rho(A^p) = \set{\lambda_1^p, \lambda_2^p, ...}
   $$
4. Il determinante di una matrice è sempre il prodotto dei suoi autovalori
	$$
    det(A) = \prod^{n}_{i=1} \lambda_i
    $$

> [!example] Esempio del calcolo del raggio spettrale di una matrice
>$$
>A = \begin{bmatrix}
>2 & 1 & 0 \\
>1 & 2 & -1 \\
>0 & -1 & 2
>\end{bmatrix}
>$$
>
>$$
>det(A-\lambda I) = det(\begin{bmatrix}
>2 - \lambda & 1 & 0 \\
>1 & 2 - \lambda & -1 \\
>0 & -1 & 2 - \lambda
>\end{bmatrix}) = (2-\lambda)\cdot[(2-\lambda)^2 - 1] - 1 \cdot(2-\lambda) = (2-\lambda)[(2-\lambda)^-2]
>$$
>quindi:
>$$
>\lambda_1 = 0, \lambda_{2,3} = 2\pm\sqrt{2}
>$$
>
>Lo spettro di A è:
>$$
>(A) = \set{2,2-\sqrt{2},2+\sqrt{2}}
>$$
>e quindi il raggio spettrale è $2+\sqrt{2}$.

#### Quoziente di Rayleigh
Se ho un autovettore $\underline{v}$, vale la proprietà:
$$
\frac{\underline{v}^TA\underline{v}}{\underline{v}^T\underline{v}} = \lambda
$$