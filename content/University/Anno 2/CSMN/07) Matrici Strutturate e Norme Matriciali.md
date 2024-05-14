---
title: 07 - Matrici Strutturate (Hermitiane, Unitarie, ...) e Norme Matriciali
date: 2024-03-26
tags:
  - csmn
  - matrici
  - norme
draft: false
---

> [!summary]- Lezioni Collegate
> Lezione precedente: [[06) Sistemi Lineari]]
> 
> Lezione successiva: [[08) Sistemi Lineari II]]
## Matrici Strutturate
### Matrice Hermitiana
> [!summary] Definizione
>Una matrice è detta _Hermitiana_ se:
>$$
>H = H^*
>$$
>ossia se la matrice è **uguale alla sua aggiunta**. Se è reale, allora deve essere uguale alla sua trasposta, ed è infatti detta **simmetrica**:
>$$
>A = A^T
>$$

Tutte le matrice _Hermitiane_ ammettono **solo autovalori reali**.

Una matrice _Hermitiana_ è detta **definita positiva** se:
$$
\underline{x}^*H\underline{x} > 0, \forall x \in \mathbb{C}^n
$$
Inoltre, una matrice _Hermitiana_ è definita positiva **se e solo se** tutti i suoi autovalori sono **positivi**.

> [!note] Nota a margine
> Il prodotto delle matrici $\underline{x}^*A\underline{x}$ è $(1 \times n)(n \times n)(n \times 1) = 1\times 1$
### Matrice Unitaria
> [!abstract] Definizione
> Una matrice è **unitaria** se la sua **aggiunta** coincide con l'inversa:
> $$
> U^* = U^{-1} \implies U^* U = I
>$$
>se la matrice è **reale**, è detta **ortogonale**:
>$$
>U^TU=I
>$$

Se una matrice è unitaria, allora:
1. Il **valore assoluto** del suo determinante è pari a $1$:
   $$
   |det(U)| = 1
   $$
2. **Non varia** la lunghezza dei vettori a cui è applicata (la sua norma $2$ è pari alla norma $2$ del vettore stesso):

$$
||U_{\underline{x}}||_2 = ||\underline{x}||_2
$$
### Matrice Triangolare
> [!abstract] Definizione
> Una matrice si dice **triangolare** superiore/inferiore se ha gli elementi sotto/sopra della diagonale tutti uguali a 0:
> $$
> \text{inferiore} = \begin{bmatrix}a & 0 & 0 \\ a & a & 0 \\ a & a & a\end{bmatrix}
> $$
> $$
> \text{superiore} = \begin{bmatrix}a & a & a \\ 0 & a & a \\ 0 & 0 & a\end{bmatrix}
> $$

E in realtà, anche questa è diagonale **superiore e inferiore**:
$$
A = \begin{bmatrix}1 & 0 & 0 \\ 0 & 0 & 0 \\ 0 &  0 & 0\end{bmatrix}
$$

Per una matrice triangolare, gli autovalori **corrispondono agli elementi sulla diagonale**. Quindi, essendo il determinante il prodotto degli autovalori, questo corrisponderà con **il prodotto degli elementi sulla diagonale**:
$$
det(T) = \prod_{i=0}^{n} t_{ii}
$$
### Matrici a Banda
> [!abstract] Definizione
>Si dice "**a banda**" una matrice che ha tutti gli elementi a $0$, **tranne quelli posti su più bande diagonali**:
>$$
>A = \begin{bmatrix}
>a_{11} & a_{12} & 0 & 0 & 0 \\
>a_{21} & a_{22} & a_{23} & 0 & 0 \\
>0 & a_{32} & a_{33} & a_{34} & 0 \\
>0 & 0 & a_{43} & a_{44} & a_{45} \\
>0 & 0 & 0 & a_{54} & a_{55} \\
>0 & 0 & 0 & 0 & a_{65} \\
>0 & 0 & 0 & 0 & 0
>\end{bmatrix}
>$$

### Matrici Sparse
> [!abstract] Definizione
> Si dice "**sparsa**" una matrice che ha quasi tutti i suoi valori **pari a $0$**.
## Norme Matriciali
> [!abstract] Definizione
> Una norma matriciale è simile a una norma vettoriale, nel senso che è anch'essa una funzione che associa uno scalare a una matrice:
>$$
>||\cdot ||: {A}^{m\times n} \to \mathbb{R}
>$$
>$$
>A \to ||A||
>$$

Le norme matriciali godono di **tutte le proprietà delle norme vettoriali**, e in aggiunta:
1. **Submoltiplicatività**:
   $$
   ||AB|| \leq ||A|| \cdot ||B||
   $$
2. **Consistenza**:
   $$
   ||A\underline{x}|| \leq ||A|| \cdot ||\underline{X}||
   $$

### Norma di Frobenius
La **norma di Frobenius** è definita come:
> [!important] Norma di Frobenius
> $$
> ||A||_F = \sqrt{\sum^{i=1}_{m}\sum^{j=1}_{n}|a_{ij}|^2}
> $$

### Norme Indotte
Le **norme indotte** sono norme matriciali che sono indotte **a partire dalle norme vettoriali**:
$$
||A|| = \sup_{x \neq \underline{0}} \frac{||A\underline{x}||}{||\underline{x}||} = \max_{||x||=1} ||A\underline{x}||
$$
#### Norma indotta dalla norma $\infty$
La **norma matriciale indotta dalla norma $\infty$** è definita come quella funzione che restituisce **la somma più grande degli elementi di una riga della matrice**:
> [!important] Norma Indotta Infinito
> $$
>\max_{i=1,...,m} \sum^{n}_{j=1}|a_{ij}| = ||A||_{\infty}
>$$

#### Norma indotta dalla norma $1$
La **norma matriciale indotta dalla norma $1$** è definita come quella funzione che restituisce **la somma più grande degli elementi di una colonna della matrice**:
> [!important] Norma Indotta 1
>$$
>\max_{j=1,...,m} \sum^{n}_{i=1}|a_{ij}| = ||A||_1
>$$

#### Norma indotta dalla norma $2$
La **norma matriciale indotta dalla norma $2$** è anche detta **norma spettrale**:
> [!abstract] Norma Indotta 2
>$$
>||A||_2 = \sqrt{\sigma(A^*A)}
>$$

Quindi, se $A$ è Hermitiana:
$$
||A||_2 = \sqrt{\sigma(AA)} = \sqrt{\sigma(A^2)} = \sqrt{[\sigma(A)]^2} = \sigma(A)
$$

> [!question]- Esempio: calcolare le norme $1$ e infinito della matrice:
> $$
> A = \begin{bmatrix}
> 2 & 1 & -7 \\ 4 & -3 & 2
> \end{bmatrix}
> $$
> 
>* Norma $1$: $9$
>	* Somma dei valori della colonna $1$: $6$
>	* Somma dei valori della colonna $2$: $4$
>	* Somma dei valori della colonna $3$: $9$, _valore massimo_
>* Norma $\infty$: $10$
>	* Somma dei valori della riga $1$: $10$, _valore massimo_
>	* Somma dei valori della riga $2$: $9$

> [!question]- Esempio: calcolare la norma $2$ della matrice:
> $$
> A = \begin{bmatrix}
> 2 & 1 \\ 1 & 3 \\ -1 & -1
> \end{bmatrix}
> $$
> Innanzitutto, calcoliamo la matrice $A^*A$, che è uguale a $A^TA$:
> $$
> A^TA = \begin{bmatrix}
> 2 & 1 & -1 \\ 1 & 3 & -1
> \end{bmatrix} \begin{bmatrix}
> 2 & 1 \\ 1 & 3 \\ -1 & -1
> \end{bmatrix} = \begin{bmatrix}
> 6 & 6 \\ 6 & 11
> \end{bmatrix}
> $$
> Quindi, calcoliamo gli **autovalori**:
> $$
> det(A^TA - \lambda I) = det(\begin{bmatrix}
>6-\lambda & 6 \\ 6 & 11-\lambda
>\end{bmatrix}) \implies
> $$
> $$
> \implies (6-\lambda)(11-\lambda)-36 = 0 \implies \lambda^2 - 17\lambda +30 = 0 \implies \lambda_1 = 15, \lambda_2 = 2
> $$
> Dato che $15$ è l'autovalore maggiore, il raggio spettrale $\sigma(A^*A)$ sarà pari a $15$, e quindi:
> $$
> ||A||_2 = \sqrt{15}
> $$

> [!question]- Esempio: quanto vale la norma indotta della matrice identità?
> $$
> ||I|| = \sup_{||\underline{x}||\neq 0} \frac{||I\underline{x}||}{||\underline{x}||} = \sup \frac{||\underline{x}||}{||\underline{x}||} = \sup 1 = 1
> $$

> [!question]- Esempio: e la norma di Frobenius della matrice identità?
> $$
> ||I||_F = \sqrt{n}
> $$
## Teorema di Localizzazione dei Valori
> [!important] Primo Teorema di Localizzazione dei Valori
> Sia $||\cdot||$ una qualunque norma consistente:
> $$
> ||\cdot|| \implies \sigma(A) \leq ||A||
> $$

Questo significa che la **norma di una matrice** è sempre **inferiore, o uguale** al suo **raggio spettrale**.
> [!important] Secondo Teorema
> $$
> \forall A^{n\times n},\  \exists\  ||\cdot|| \implies ||A|| \leq \sigma(A) + \epsilon, \text{ con } \epsilon > 0
> $$