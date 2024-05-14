---
title: 09 - Risoluzione di Sistemi Lineari con Algoritmo di Gauss e Fattorizzazione
date: 2024-04-03
tags:
  - csmn
  - matrici
  - sistemi_lineari
  - gauss
  - fattorizzazione
draft: false
---
> [!abstract]- Lezioni Collegate
> Lezione Precedente: [[08) Sistemi Lineari II]]
## Algoritmo di Gauss
Permette di trasformare una matrice **lineare** in una matrice **lineare triangolare superiore**.
> [!warning] **ATTENZIONE** le due matrici **non sono uguali**.

L'algoritmo di Gauss si bassa su 3 prinicipi dei sistemi lineari:
1. Possiamo **sempre** sostituire l'equazione di un sistema lineare nella stessa equazione, moltiplicata per uno scalare $\alpha$.
   $$
   EQ_i = \alpha EQ_i 
   $$
2. Posso **sempre** sostituire un'equazione con la **somma di due equazioni**.
   $$
   EQ_i \implies EQ_i +EQ_j
   $$
3. Posso **sempre** scambiare tra loro due equazioni.
   $$
   EQ_i \iff EQ_j
   $$
Prendiamo un generico sistema lineare di equazioni:
$$
\begin{cases}
a_{11}x_1 + a_{12}x_2 + ... = b_1 \\
a_{21}x_1 + a_{22}x_2 + ... = b_2 \\
... \\
a_{n1}x_1 + a_{n2}x_2 + ... = b_n
\end{cases}
$$
Se voglio trasformare il sistema in una matrice triangolare, devo **eliminare il primo termine di ogni equazione**, a partire dalla seconda. Se voglio farlo sulla seconda riga, per esempio, dovrò effettuare questa operazione:
$$
riga_2 \leftarrow riga_2 - riga_1 \cdot \frac{a_{21}}{a_{11}}
$$
e per la terza:
$$
riga_3 \leftarrow riga_3 - riga_1 \cdot \frac{a_{31}}{a_{11}}
$$
Quindi, in generale, la prima operazione che dobbiamo effettuare per ogni riga è:
$$
riga_i = riga_i - riga_1 \cdot \frac{a_{i1}}{a_{11}}
$$
L'elemento $m_{i1} = \frac{a_{i1}}{a_{11}}$ è detto **moltiplicatore**.

Adesso, il nostro sistema ha questa forma:
$$
\begin{cases}
a_{11}x_1 + a_{12}x_2 + ... = b_1 \\
0 + (a_{22}x_2 + ... = b_2)_2 \\
... \\
0 + (a_{n2}x_2 + ... = b_n)_2
\end{cases}
$$
Dove $(\text{riga})_2$ indica che la riga è il risultato del primo passaggio sulla riga.
Il secondo passaggio è simile, ma è fatto sugli elementi della seconda colonna:
$$
riga_i = riga_i - riga_2 \cdot \frac{a_{i2}}{a_{22}}
$$

Iteriamo quindi questo procedimento **per ogni colonna**:
```
for k=1:n-1
	for i=k+1:n
		riga_i = riga_i - riga_k * m_ik
```
Dove:
$$
m_{ik} = \frac{a_{ik}}{a_{kk}}, \text{ con }a_{kk} \neq 0
$$
Questo è proprio **l'algoritmo di Gauss**. L'elemento $a_{kk}$ è detto **elemento pivot**.

Un metodo più alto prevede di utilizzare l'**elemento pivot**: ad ogni passaggio, prima di effettuare la sostituzione della riga $i$, **scambiamo** la riga $i$ con quella contenente il primo termine **più alto (in valore assoluto)** all'interno della matrice:
```
for k=1:n-1
	for i=k+1:n
		cerca |a_kk| = max{|a_ik|}
		riga_i = riga_i - riga_k * m_ik
```
La complessità computazionale è `O(n^3/3)`
> [!example] Esempio di utilizzo dell'algoritmo di Gauss
> Prendiamo un sistema lineare di esempio con la matrice associata:
> $$
> A = \begin{bmatrix}
> 3 & 2 & 1 & | 2 \\ 1 & 2 & 4 & | 3 \\ 4 & 1 & 2 & | 5
> \end{bmatrix}
> $$
> Il primo passaggio consiste nell'individuazione del moltiplicatore per la prima riga e per la seconda:
> $$
> m_{21} = \frac{a_{21}}{a_{11}} = \frac{1}{3}, m_{31} = \frac{a_{31}}{a_{11}} = \frac{4}{3}
> $$
> Quindi applichiamo il primo passaggio alla seconda e alla terza riga:
> $$
> \text{riga}_2 = \begin{bmatrix} 1 & 2 & 4 & | 3\end{bmatrix} - \frac{1}{3}\begin{bmatrix}3 & 2 & 1 & |2\end{bmatrix} = \begin{bmatrix} 0 & \frac{4}{3} & \frac{11}{3} & | \frac{7}{3}\end{bmatrix}
> $$
> $$
> \text{riga}_3 = \begin{bmatrix}4 & 1 & 2 & |5\end{bmatrix} - \frac{4}{3} \begin{bmatrix}3 & 2 & 1 & |2\end{bmatrix} = \begin{bmatrix}0 & -\frac{5}{3} & \frac{2}{3} & |\frac{7}{3}\end{bmatrix}
> $$
> Quindi la matrice al secondo passo dell'algoritmo di Gauss è:
> $$
> \begin{bmatrix}
> 3 & 2 & 1 & |2 \\
> 0 & \frac{4}{3} & \frac{11}{3} & | \frac{7}{3}\\
> 0 & -\frac{5}{3} & \frac{2}{3} & | \frac{7}{3}\\
>\end{bmatrix}
> $$
> Dopodiché, cerchiamo l'elemento moltiplicatore per il secondo passaggio:
> $$
> m_{32} = \frac{a_{32}}{a_{22}} = \frac{5}{3} \cdot \frac{3}{4} = \frac{5}{4}
> $$
> Quindi ripetiamo il passaggio precedente sulla riga $3$ con il moltiplicatore $m_{32}$, e otteniamo la matrice:
> $$
> \begin{bmatrix}
> 0 & -\frac{5}{3} & \frac{2}{3} & |\frac{7}{3} \\
> 0 & \frac{4}{3} & \frac{11}{3} & |\frac{7}{3} \\
> 0 & 0 & \frac{63}{12} & | \frac{63}{12}
>\end{bmatrix}
> $$
> Ora che abbiamo una matrice triangolare, possiamo facilmente risolvere il sistema iniziale:
> $$
> \begin{cases}
> 3x_1 + 2x_2 + x_3 = 2 & \implies 3x_1 = 2 + 1 &\implies x_1 = 1\\
> \frac{4}{3}x_2 + \frac{11}{3}x_3 = \frac{7}{3} & \implies \frac{4}{3}x_2 = \frac{7}{3} - \frac{11}{3} & \implies x_2 = -1 \\
> \frac{63}{12}x_3 = \frac{63}{12} && \implies x_3 = 1
>\end{cases}
> $$
> $$
> \underline{x} = \begin{bmatrix}1 \\ -1 \\ 1\end{bmatrix}
> $$
> 
> Se invece volessimo utilizzare l'algoritmo di Gauss **con pivoting**, è sufficiente scambiare, ad ogni passaggio, la riga considerata con quella con il primo termine più grande. Per il primo passaggio, quindi, scambiamo la riga $1$ con la riga $3$:
> $$
> A = \begin{bmatrix} 3 & 2 & 1 & |2 \\ 1 & 2 & 4 & |3 \\ 4 & 1 & 2 & |5\end{bmatrix} \to \begin{bmatrix}4 & 1 & 2 & |5 \\ 1 & 2 & 4 & |3 \\ 3 & 2 & 1 & |2\end{bmatrix}
> $$
> e procediamo allo stesso modo.

### Condizioni per poter usare l'algoritmo di Gauss
Abbiamo visto che, per l'applicazione dell'algoritmo di Gauss, deve essere $a_{nn} \neq 0$ per ogni passaggio. Le matrici che presentano questa proprietà sono:
1. Matrici simmetriche definite positive
2. Matrici strettamente diagonalmente dominanti
	* **Per righe**, quindi vale la proprietà
	  $$
	   |a_{ii}| > \sum^{n}_{j=1,j\neq i} |a_{ij}|
	   $$
	* **Per colonne**, quindi vale la proprietà
	  $$
	   |a_{jj}| > \sum^{n}_{i=1,i\neq j} |a_{ij}|
	   $$
## Fattorizzazione della matrice $A$
Per semplificare la risoluzione di un sistema lineare, possiamo cercare di fattorizzare la matrice $A$ nel prodotto di due matrici $L, U$, dove la matrice $L$ presenta le seguenti condizioni:
$$
l_{ij} = \begin{cases} m_{ij} & i > j \\
1 & i = j \\
0 & j > i
\end{cases}
$$
> [!warning] Attenzione: con "`m`" si intende il moltiplicatore calcolato mediante algoritmo di Gauss!

e la matrice $U$:
$$
U_{ij}=  (U^{n-1})_{ij}
$$
> [!important] Fattorizzazione di $A = LU$
> Fattorizzando $A$ in questo modo, avremo:
> $$
> A \underline{x} = \underline{b} \implies L \cdot U \underline{x} = b
> $$
> Chiamando $\underline{y}$ la quantità $U\underline{x}$, avremo:
> $$
> \begin{cases}
> L\underline{y} = \underline{b} \\
> U\underline{x} = \underline{y}
> \end{cases}
> $$

Osserviamo che, se $A = L \cdot U$, allora:
$$
det(A) = det(L) \cdot det(U) = det(U)
$$
perché $det(L) = 1$. Ma ricordiamo che il determinante di una matrice triangolare è soltanto il prodotto degli elementi sulla diagonale:
$$
det(U) = \prod^{n}_{i=1}u_{ii}
$$

Un metodo alternativo di fattorizzazione consiste nel moltiplicare entrambi i lati dell'equazione $A\underline{x} = \underline{b}$ per una matrice $P$, che è definita in questo modo:
$$
I = \begin{bmatrix}1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & 0 & 1\end{bmatrix} \to \text{scambio la prima e la terza riga} \to P = \begin{bmatrix} 0 & 0 & 0 \\ 0 & 1 & 0 \\ 1 & 0 & 0\end{bmatrix}
$$
> [!important] Fattorizzazione $PA$
> Fattorizzando $A$ in questo modo, abbiamo:
> $$
> A\underline{x} = \underline{b} \implies PA\underline{x} = P\underline{b} \implies LU\underline{x} = P\underline{b}
> $$
> Quindi, definendo sempre $\underline{y} = U\underline{x}$, otteniamo il sistema:
> $$
> \begin{cases}
>L\underline{y} = P\underline{b} \\
>U\underline{x} = \underline{y}
>\end{cases}
> $$

Perché usare la fattorizzazione? Supponiamo di dover risolvere $m$ sistemi lineari con le stesse equazioni, ma diversi termini noti, tutti della forma:
$$
A\underline{x}_i = \underline{b}_1
$$
Se usassimo l'algoritmo di Gauss, avremmo una complessità di
$$
m \times O(\frac{n^3}{3}) + m\times O(\frac{n^2}{2})
$$
(applicazione dell'algoritmo e risoluzione del sistema lineare). Applicando la fattorizzazione, invece, che è $O(\frac{n^3}{3})$, avremmo:
$$
O(\frac{n^3}{3}) + m \times O(n^2)
$$
> [!example] Esempio, calcolare la soluzione e il determinante del seguente sistema lineare:
> $$
> A = \begin{bmatrix}1 & -2 & 1 & 2 \\ 2 & 1 & 1 & -1 \\ 1 & 8 & -2 & 3 \\ 3 & -3 & 2 & -1\end{bmatrix}, b = \begin{bmatrix}-1 \\ 2 \\ 6 \\ -1\end{bmatrix}
> $$
> Applichiamo l'algoritmo di Gauss per calcolare la matrice $U$ (attenzione, non includiamo anche i termini noti):
> $$
> \begin{bmatrix}1 & -2 & 1 & 2 \\ 2 & 1 & 1 & -1 \\ 1 & 8 & -2 & 3 \\ 3 & -3 & 2 & -1\end{bmatrix} \to \begin{bmatrix}1 & -2 & 1 & 2 \\ 0 & 5 & -1 & -5 \\ 0 & 10 & -3 & 1 \\ 0 & 3 & -1 & 7\end{bmatrix} \to \begin{bmatrix}1 & -2 & 1 & 2 \\ 0 & 5 & -1 & -5 \\ 0 & 0 & -1 & 11 \\ 0 & 0 & -\frac{2}{5} & -4\end{bmatrix} \to \begin{bmatrix}1 & -2 & 1 & 2 \\ 0 & 5 & -1 & -5 \\ 0 & 0 & -1 & 11 \\ 0 & 0 & 0 & -\frac{42}{5}\end{bmatrix}
> $$
> mentre la matrice $L$ sarà, per definizione:
> $$
> L = \begin{bmatrix}1 & 0 & 0 & 0 \\ 2 & 1 & 0 & 0 \\ 1 & 2 & 1 & 0 \\ 3 & \frac{3}{5} & \frac{2}{5} & 1\end{bmatrix}
> $$
> Per risolvere il sistema lineare, dobbiamo risolvere il sistema:
> $$
> \begin{cases}
>L\underline{y} = P\underline{b} \\
>U\underline{x} = \underline{y}
>\end{cases}
> $$
> prendiamo la prima equazione: essa rappresenta il sistema lineare:
> $$
> \begin{cases}
> y_1 &= -1\\
> 2y_1 + y_2 &= 2\\
> y_1 + 2y_2 + y_3 &= 6\\
> 3y_1 + \frac{3}{5}y_2 + \frac{2}{5}y_3 + y_4 &= -1
>\end{cases}
> $$
> risolviamo sostituendo a cascata e otteniamo:
> $$
> \underline{y} = \begin{bmatrix}1 \\ 4 \\ -1 \\ 0\end{bmatrix}
> $$
> Adesso che abbiamo $\underline{y}$ possiamo passare al secondo sistema:
> $$
> \begin{cases}
> x_1 - 2x_2 + x_3  + 2x_4 &= 1\\
> 5x_2 - x_3 - 5x_4 &= 4 \\
> -x_3 + 11x_4 &= -1 \\
> -\frac{42}{5} x_4 &= 0
>\end{cases}
> $$
> risolvendo, otteniamo le nostre soluzioni:
> $$
> \underline{x} = \begin{bmatrix} 0 \\ 1 \\ 1 \\ 0\end{bmatrix}
> $$
> Per calcolare il determinante, risolviamo:
> $$
> det(U) = \prod^{4}_{i=1} u_{ii} = 1 \cdot 5 \cdot (-1) \cdot (-\frac{42}{5}) = 42
> $$
### Calcolo dell'Inversa
Sappiamo che una matrice $X$, per essere l'inversa di $A$, deve rispettare la condizione:
$$
AX = I
$$
dato che la dimensione della matrice è necessariamente uguale a quella di $A$, possiamo scrivere il prodotto tra $A$ e $X$ come prodotto tra $A$ e le colonne di $X$:
$$
A \begin{bmatrix} \underline{x_1} & \underline{x_2} & \underline{x_3} & ... & \underline{x_n}\end{bmatrix} = \begin{bmatrix}\underline{e_1} & \underline{e_2} & \underline{e_3} & ... & \underline{e_n}\end{bmatrix}
$$
dove:
$$
\underline{e_i} = \begin{bmatrix} 0 \\ 0 \\ 0 \\ ... \\ 1 \\ ... \\ 0 \end{bmatrix}
$$
e l'$1$ è in posizione $i$.

Effettuando il prodotto, avremo il seguente sistema lineare:
> [!important] Sistema lineare per le righe di una matrice identità
> $$
>\begin{cases}
>A \underline{x_1} &= \underline{e_1} \\
>A \underline{x_2} &= \underline{e_2} \\
>... \\
>A \underline{x_n} &= \underline{e_n}
>\end{cases}
>$$
dove $\underline{x_n}$ è la riga $n$ della matrice identità. Quindi, se necessitiamo solo di una riga, possiamo risolvere la corrispettiva equazione.

> [!example] Stesso esempio di prima, calcolare anche l'inversa
> $$
> A = \begin{bmatrix}1 & -2 & 1 & 2 \\ 2 & 1 & 1 & -1 \\ 1 & 8 & -2 & 3 \\ 3 & -3 & 2 & -1\end{bmatrix}
> $$
> Il sistema lineare corrispondente alle righe della matrice inversa sarà:
>$$
>\begin{cases}
>A \underline{x_1} &= \underline{e_1} \\
>A \underline{x_2} &= \underline{e_2} \\
>... \\
>A \underline{x_n} &= \underline{e_n}
>\end{cases}
>$$
>Per semplicità, affrontiamo il calcolo solo della prima riga:
>$$
>\begin{cases}
> L\underline{y} = \underline{e}_1 \\
> U\underline{x} = \underline{y}
>\end{cases} \implies \begin{cases}
>y_1 &= 1 \\
>2y_1 + y_2 &= 0 \\
>y_1 + 2y_2 + y_3 &= 0 \\
>3y_1 + \frac{3}{5}y_2 + \frac{2}{5}y_3 + y_4 &= 0
>\end{cases}
>$$
>quindi il vettore $\underline{y}$ è:
>$$
>\underline{y} = \begin{bmatrix}1 \\ -2 \\ 3 \\ -3 \end{bmatrix}
>$$
>risolviamo il sistema lineare della seconda equazione:
>$$
>\begin{cases}
> x_1 -2x_2+x_3+2x_4 &= 1 \\
> 5x_2 -x_3-5x_4 &=-2 \\
> -x_3 +11x_4 &=3 \\
> -\frac{42}{5}x_4 &= -3
>\end{cases}
>$$
>e avremo:
>$$
>\underline{x} = \begin{bmatrix} -\frac{5}{14} \\ \frac{1}{7} \\ \frac{13}{14} \\ \frac{5}{14}\end{bmatrix}
>$$
>che corrisponde anche alla prima colonna della matrice inversa.