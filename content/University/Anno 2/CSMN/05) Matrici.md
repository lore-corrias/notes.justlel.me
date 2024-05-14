---
title: 05 - Matrici
date: 2024-03-13
tags:
  - vettori
  - matrici
  - csmn
draft: false
---
> [!summary]- Lezioni Collegate
> Lezione precedente: [[04) Algebra Lineare]]
> 
> Lezione successiva: [[06) Sistemi Lineari]]
## Le matrici
Una matrice si indica con una **lettera maiuscola**, tipo $A,B,C$. I loro elementi, invece, sono identificati dalla **lettera minuscola** della matrice, aventi come pedice il numero di _riga_ e di _colonna_. Per esempio:
$$
A = \begin{bmatrix}
a_{11} & a_{12} & ... & a_{1n} \\
a_{21} & ...  \\
... \\
a_{m1} & ... & ... & a_{mn}
\end{bmatrix}
$$
Una matrice con stesso numero di righe e colonne è detta **quadrata**.
Se gli elementi della matrice sono numeri reali, indichiamo $A \in \mathbb{R}^{m \times n}$. Se sono invece complessi, sarà $A \in \mathbb{C}^{m \times n}$.
### Operazioni tra Matrici
La somma delle matrici $A,B$ è definita come:
$$
A+B = \begin{bmatrix}
a_{11}+b_{11} & a_{12} + b_{12} & ... \\
... \\
 & ... \\
 & & ...
\end{bmatrix}
$$
La somma è **commutativa**, ma il prodotto no: $A \cdot B \implies A \cdot B \neq B \cdot A$

> [!important] Condizione necessaria per il prodotto tra due Matrici
> Il prodotto tra due matrici è fattibile a condizione che il numero delle colonne di $A$ sia uguale al numero di righe di $B$:
>$$
>\exists C \in \mathbb{R}^{m \times q} \text{ t.c } C = A \in \mathbb{R}^{m \times n} \times B \in \mathbb{R}^{p \times q} \iff n=p
>$$

Il risultato sarà quindi una matrice con $m$ righe e $q$ colonne, dove ogni elemento $c_{ij}$ della matrice è pari al **prodotto tra la riga $i$ della matrice $A$ e la colonna $j$ della matrice B**. In formule:
> [!important] Prodotto tra due Matrici
>$$
>c_{11} = a_{11} \cdot b_{11} + a_{12} \cdot b_{21} + ... + a_{1n} \cdot b_{n1} = \sum^{n}_{k=1}a_{1k}b_{k1}
>$$
>Quindi, generalizzando:
>$$
>c_{ij} = \sum^{n}_{k=1}a_{ik}b_{kj}
>$$
### Elemento Neutro
La matrice è uno **spazio vettoriale**. Presenta quindi un elemento neutro, che, rispetto alla somma, è la matrice:
$$
0 = \begin{bmatrix}
0 & 0 & 0 & 0 \\
0 & 0 & ... & ... \\
... & ... & ... & ...
\end{bmatrix}
$$
e rispetto al prodotto è una matrice con tutti gli elementi a $0$, tranne quelli della diagonale, che sono pari a $1$:
$$
I = \begin{bmatrix}
1 & 0 & 0 & ... \\
0 & 1 & 0 & ... \\
0 & 0 & 1 & ...
\end{bmatrix}
$$
Quindi:
$$
A \cdot I = I \cdot A = I
$$
### Potenze tra Matrici
> [!important] Potenza di una Matrice
>La potenza di una matrice $A^p$ è definita come:
>$$
>A^p = A \cdot A \cdot A \cdot ...\text{, per p volte}
>$$

La potenza è quindi possibile **solo con le matrici quadrati**, dato che se $A \in \mathbb{R}^{m\times n}$, $m=n$.
Esempio:
$$
A=\begin{bmatrix}
1 & 1 \\ 1 & 1
\end{bmatrix}, A^2=\begin{bmatrix}
1 & 1 \\ 1 & 1
\end{bmatrix} \cdot \begin{bmatrix}
1 & 1 \\ 1 & 1
\end{bmatrix} = \begin{bmatrix}
2 & 2 \\ 2 & 2
\end{bmatrix}
$$
> [!warning] Attenzione!
> La potenza di una matrice **non è data dall'elevazione a potenza dei singoli elementi della matrice**!

### Matrice Aggiunta e Trasposta
> [!important] Definizione Matrice Aggiunta
>La matrice aggiunta è definita come quella matrice $A^*$ tale che:
>$$
>A \in \mathbb{R}^{m \times n} \rightarrow (A^*)_{ij} = \bar{a_{ji}}
>$$
>Ossia, una **matrice aggiunta** è la **trasposta** della matrice che si ottiene da $A$ sostituendo ad ogni elemento di $A$ il suo [[#Complesso Coniugato]].

Se la matrice è composta di numeri reali, la matrice aggiunta è equivalente alla **matrice trasposta**, ossia la matrice che si ottiene scambiando le righe con le colonne:
$$
A \in \mathbb{R}^{m\times n} \to A^* = A^T
$$
La matrice trasposta gode anche di queste due proprietà:
$$
(A\cdot B)^T = B^T\cdot A^T
$$
e:
$$
(\underline{x}\underline{y}^T)^T = \underline{y}\underline{x}^T
$$
### Matrice Inversa
>[!important] Definizione di Matrice Inversa
>L'inversa di una matrice $A$ è quella matrice che, moltiplicata per $A$, restituisce la **matrice identità**:
>
>$$
>A \cdot A^{-1} = I
>$$

La matrice inversa gode anche della seguente proprietà:
$$
(A^{-1})^T = (A^T)^{-1} = A^{-T}
$$
### Prodotto Scalare tra Matrici
> [!important] Definizione prodotto scalare tra Matrici
>Il prodotto scalare $\langle \underline{x},\underline{y}\rangle$ tra due matrici è definito come il prodotto tra la matrice trasposta $x^t$ e $y$:
>$$
>\langle \underline{x},\underline{y}\rangle = x^T \cdot y = x_1y_2 + x_2y_2 + ... + x_ny_n
>$$

### Determinante di una Matrice
> [!important] Definizione di Determinante di una Matrice
> Il determinante di una matrice $det(a)$ è definito come:
> $$
> \sum^{n}_{j=1}{(-1)^{i+j} \cdot a_{ij} \cdot det(A_{ij})}
> $$ 
Alcune proprietà utili sul determinante:
+ $det(A^{-1}) = \frac{1}{det(A)}$
> [!warning] Da qui si deduce che una matrice è invertibile **SE** il suo determinante non è nullo.
* $det(A^T)=det(A)$
* $det(AB) = det(A) \cdot det(B)$
* $det(\alpha A) = \alpha^n \cdot A$, dove $n$ è la dimensione di $A$.
* La matrice $A$ è **non singolare** se e solo se le sue colonne **sono linearmente indipendenti** e se e solo se $det(A) \neq 0$.

> [!info] Calcolo del determinante
> > [!important] Se la matrice è **quadrata**, allora il suo determinante sarà semplicemente:
> >   
>>$$
>>det(\begin{bmatrix}
>>a & b \\ c & d
>>\end{bmatrix}) = ad - cb
>>$$
>
> Consideriamo la matrice:
>  $$
> A = det(\begin{bmatrix} -7 & 2 & 4 \\ 1 & -2 & 0 \\ 2 & 0 & 1 \end{bmatrix})
> $$
> Un metodo pratico per il calcolo del determinante è il seguente:
>
>1. **Fissiamo una riga della matrice**. Nel caso di esempio, prendiamo la riga $i=3$
>2. Ad uno ad uno, prendiamo gli elementi **della riga di quella matrice**. Prendiamo per esempio $2$:
>	1. **Sommiamo** la riga e la colonna di $2$, in questo caso $1+1=2$, e siccome $2$ è pari sappiamo che dobbiamo prendere l'elemento selezionato senza cambiarlo di segno. Se prendiamo $0$, invece, abbiamo $1+2=3$, quindi scriviamo $-0$
>	2. **Moltiplichiamo** il numero ottenuto dal passaggio $1$ per il determinante della matrice che risulta **cancellando la riga e la colonna dell'elemento preso**. Per due, per esempio, avremmo:
>	   $$
>	   \begin{bmatrix}-\cancel7 & 2 & 4 \\ \cancel1 & -2 & 0 \\ \cancel2 & \cancel0 & \cancel1\end{bmatrix}
>		$$
>	3. Otteniamo quindi $2 \cdot det(\begin{bmatrix} 2 & 4 \\ -1 & 0 \end{bmatrix})$, iteriamo sugli altri termini
>3. Dopo che abbiamo finito con tutti i termini della riga, li uniamo e calcoliamo il risultato:
>$$
>det(A) = 2 \cdot det(\begin{bmatrix} 2 & 4 \\ -1 & 0 \end{bmatrix}) - 0 \cdot det(\begin{bmatrix} -7 & 4 \\ 1 & 0 \end{bmatrix} + 1 \cdot det(\begin{bmatrix} -7 & 2 \\ 1 & -1\end{bmatrix}) = 13
>$$

$$

$$
## Richiamo sui Numeri Complessi
I numeri complessi sono numeri della forma:
$$
z = a +bi
$$
dove $i$ è detta **unità immaginaria**, definita come:
$$
i = \sqrt{-1} \implies i^2 = -1
$$
Un numero complesso è composto di:
* Una **parte reale**, ossia $a$
* Una **parte immaginaria**, ossia $b$.
### Operazioni tra Numeri Complessi
Se ho due numeri complessi $z, w$, la somma è definita come:
$$
z=a+ib, w=c+id \implies z+w = a+ib+c+id = a + c + (b+d)i
$$
In questo caso, il numero complesso risultato ha come parte reale la **somma delle parti reali** e come parte immaginaria la **somma delle parti immaginarie**. La stessa cosa vale per la differenza

Il prodotto invece varrà:
$$
z \cdot w = (a+ib)(c+id)=ac+ibc+aid+i^2bd = ac + ibc + aid - bd = (ac-bd) + (bc+ad)i
$$
### Complesso Coniugato
Dato un numero complesso $z = a + ib$, il **complesso coniugato $\bar{z}$** di $z$ è definito come:
$$
\bar{z}=a-ib \implies z + \bar{z} = 2a
$$
### Numeri Complessi nel Piano cartesiano
![](https://i.imgur.com/3dvhEoS.png)

Un numero complesso $z$ può essere rappresentato come un punto sul _piano cartesiano_, avente coordinate $z=(a,b)$.
Il suo complesso coniugato sarà quindi $z=(a,-b)$.

Il **modulo** dei numeri complessi è pari a:

$$
|z| = \sqrt{a^2+b^2} = ||z||_2
$$
Quindi se ho $b=0$ (ossia se il numero è reale), ottengo che $||z|| = |z|$, ciò significa che il modulo dei numeri complessi è la funzione _valore assoluto_.