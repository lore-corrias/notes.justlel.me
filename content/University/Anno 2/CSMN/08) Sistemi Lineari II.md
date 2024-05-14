---
title: 08 - Sistemi Lineari II, Risoluzioni
date: 2024-03-27
tags:
  - csmn
  - matrici
  - sistemi_lineari
draft: false
---
> [!abstract]- Lezioni Collegate
> Lezione precedente: [[07) Matrici Strutturate e Norme Matriciali]]
> 
> Lezione successiva: [[09) Algoritmo di Gauss, Fattorizzazione]]
## Sistemi Lineari
> [!warning] Attenzione
> Se ti serve un ripasso sui sistemi lineari quadrati, vedi [[06) Sistemi Lineari]]

## Perturbazione
Per dimostrare un metodo per la risoluzione dei sistemi lineari, introduciamo il concetto di **perturbazione**.
> [!abstract] Definizione
> Si definisce **perturbazione sui dati** una variazioni dei dati di un problema $\delta d$ che porta a una variazione sulla soluzione del problema $\delta x$. Questi valori sono collegati dal **numero di condizionamento assoluto $K$**:
> $$
> ||\delta x|| \leq K || \delta d ||
> $$
> Mentre è definito **numero di condizionamento relativo $\kappa$** la quantità:
> $$
> \frac{||\delta x||}{||x||} \leq \kappa \frac{||\delta d||}{||d||}
> $$
> Dove $||\cdot||$ è una norma vettoriale.

Prendendo quindi la formula generica di un sistema lineare $A\underline{x}=b$, introduciamo una perturbazione:
$$
A\underline{x}=b \implies A(\underline{x}+\delta\underline{x})=\underline{b}+\delta\underline{b} \implies \cancel{A\underline{x}} + A\delta\underline{x} = \cancel{\underline{b}}+\delta\underline{b}
$$
Questa perturbazione indica quindi un sistema in cui introduciamo una variazione sui dati, che provocano una variazione nelle soluzioni dei sistemi.
La soluzione del nostro sistema perturbato sarà quindi:
$$
\delta \underline{x} = A^{-1} \delta\underline{b}
$$
Se introduciamo una **norma matriciale consistente**, possiamo riscrivere l'equazione come:
$$
||\delta\underline{x}|| \leq ||A^{-1}|| \cdot ||\delta b||
$$
Riprendendo la definizione di perturbazione, possiamo quindi dedurre che $A^{-1}$ non è altro che il numero di condizionamento assoluto $K$. Mentre invece, se vogliamo dedurre il numero di condizionamento relativo $\kappa$ partiamo dal sistema iniziale:
$$
||b||< ||A|| \cdot ||x|| \implies \frac{1}{||x||}\leq ||A||\cdot\frac{1}{||b||}
$$
Dopodiché, possiamo moltiplicare le due disuguaglianze e otteniamo:
$$
\frac{||\delta x||}{||x||} \leq ||A||\ ||A^{-1}|| \cdot \frac{||\delta b||}{||b||}
$$
e quindi, $\kappa(A) =||A||\ ||A^{-1}||$. Questo valore è detto **numero di condizionamento di una matrice**, e misura il massimo fattore di perturbazione sulla soluzione di un sistema lineare a partire dalla perturbazione sui dati, che ovviamente dipenderà dalla norma usata, per esempio:
$$
k_{\infty}(A) = ||A||_{\infty} \cdot ||A^{-1}||_{\infty}
$$
> [!example] Esempio di utilizzo di un sistema lineare perturbato
> Prendiamo il sistema lineare $A_{\alpha}x = b$, dipendente dal parametro  reale $\alpha$:
> $$
> A_{\alpha} = \begin{bmatrix}
> \alpha & -\alpha \\ 0 & 1
> \end{bmatrix}, b = \begin{bmatrix}
>0 \\ 1
>\end{bmatrix}
> $$
> Associato al sistema perturbato di equazioni:
> $$
> \begin{cases}
> \alpha x_1 - \alpha x_2 = 0 \\
> x_2 = 1
>\end{cases} \implies \alpha x_1 + \alpha x_2 \implies x_1 = 1
> $$
> e quindi:
> $$
> \tilde{\underline{b}} = \underline{b} + \delta \underline{b} = \begin{bmatrix}
> 0 \\ 1
>\end{bmatrix} + \begin{bmatrix}\alpha \\ \alpha\end{bmatrix} = \begin{bmatrix}\alpha \\ 1 + \alpha\end{bmatrix}
> $$
> Ora abbiamo il sistema perturbato:
> $$
> A_\alpha \underline{x} = \tilde{\underline{b}}
> $$
> che corrisponde al sistema lineare:
> $$
> \begin{cases}\alpha x_1 + \alpha x_2 = \alpha \\ x_2 = 1 + \alpha\end{cases} \implies x_1 = 2+\alpha, x_2 = 2+\alpha
> $$
> Ora, per ottenere le soluzioni al sistema lineare originale è sufficiente porre $\alpha$ quantità molto piccola, tendente a $0$, così avremo che $\tilde{\underline{b}} \to \underline{b}$ e $\tilde{\underline{x}} \to \underline{x}$. Tuttavia, in questo caso i due vettori soluzioni **non corrispondono**. Nel primo caso, infatti, abbiamo le soluzioni $x_1=1, x_2=1$, mentre nel secondo caso troviamo $x_1=2,x_2=1$. Questo accade perché quando $\alpha \to 0$ è facile verificare che il parametro di condizionamento $k_{\infty}$ per la matrice $A_\alpha$ tende a $\infty$:
> $$
> k_{\infty}(A_\alpha) = ||A_\alpha||_\infty \cdot ||A_\alpha^{-1}||_\infty = 1 + \frac{1}{\alpha}
> $$

### Proprietà delle Perturbazioni
Le perturbazioni soddisfano le seguenti proprietà:
> [!important] Proprietà delle perturbazioni
>1. 
>   $$
> K(A) \geq 1
> $$
>2. 
>   $$
> K(I) =  ||I|| \cdot ||I^{-1}|| = ||I|| \cdot ||I|| = 1
> $$
> 3. 
>  $$
> K_2(Q) = 1  
> $$
>  4.
>  $$
> K_2(A) = \sqrt{\frac{\lambda_{\max}(A^T A)}{\lambda_{\min}(A^T A)}}  
> $$
>  5. se $A$ è simmetrica   
>  $$
> K_2(A) = {\frac{\lambda_{\max}(A)}{\lambda_{\min}(A)}}
> $$
>  6. 
>  $$
> K(AB) = K(A) \cdot K(B)  
> $$

> [!info] Vedi un esempio di esercizio con le proprietà dalle [slide del corso](https://elearning.unica.it/pluginfile.php/1009465/mod_resource/content/1/27_03_2024.pdf)

## Sistemi Lineari Facili
### Sistema Diagonale
Un esempio di sistema lineare diagonale:
$$
D = \begin{bmatrix}
d_1 & 0 & 0 & 0 \\
0 & d_2 & 0 & 0 \\
0 & 0 & d_3 & 0 \\
0 & 0 & 0 & d_4
\end{bmatrix}\begin{bmatrix}
x_1 \\ x_2 \\ x_3 \\ x_4
\end{bmatrix} = \begin{bmatrix}
b_1 \\ b_2 \\ b_3 \\ b_4
\end{bmatrix}
$$
che è associato al sistema di equazioni:
$$
D\underline{x} = \underline{b} \implies \begin{cases}
d_1 x_1 = b_1 \\ d_2x_2 = b_2 \\ ... \\ d_nx_n = b_n
\end{cases}
$$
le cui soluzioni sono:
> [!important] Soluzioni di un Sistema di Equazioni Lineare Diagonale
> $$
> \begin{cases}x_1=\frac{b_1}{d_1}\\x_2=\frac{b_2}{d_2}\\ ...\\ x_n=\frac{b_n}{d_n}\end{cases}
> $$
> Il calcolo delle soluzioni lineari di un sistema diagonale è quindi `O(n)`

### Sistema Ortogonale
Un sistema ortogonale gode della proprietà:
$$
Q^TQ = QQ^T = I, Q^T = Q^{-1}
$$
e quindi, per la soluzione:
> [!important] Soluzioni di un Sistema di Equazioni Lineare Ortogonale
> $$
> Q\underline{x}=\underline{b} \implies \underline{x} = Q^{-1}b = Q^T b
> $$
> E la complessità computazionale associata è `O(n^2)`
#### Superiore
In generale, un sistema lineare triangolare superiore è della forma:
$$
D = \begin{bmatrix}
l_{11} & l_{12} & l_{13} & l_{14} \\
0 & l_{22} & l_{23} & l_{24} \\
0 & 0 & l_{33} & l_{34} \\
0 & 0 & 0 & l_{44}
\end{bmatrix}\begin{bmatrix}
x_1 \\ x_2 \\ x_3 \\ x_4
\end{bmatrix} = \begin{bmatrix}
b_1 \\ b_2 \\ b_3 \\ b_4
\end{bmatrix}
$$
e corrisponde al sistema di equazioni:
$$
\begin{cases}
l_{11} x_1 = b_1 & \to x_1 = \frac{b_1}{l_{11}} \\
l_{21} x_1 + l_{22} x_2 = b_2 & \to l_{21} \cdot \frac{b_1}{l_{11}} + l_{22}x_2 = b_2 \implies x_2 = \frac{(b_2-l_{21}\frac{b_1}{l_{11}})}{l_{22}} \\
...
\end{cases}
$$
> [!important] Soluzioni di un Sistema di Equazioni Lineare Triangolare Inferiore
> $$
> x_n = \frac{b_n - \sum^{j=1}_{n-1}l_{nj}\frac{b_j}{e_jj}}{e_{nn}}
> $$
> E la complessità computazionale è `O(n^2/2)`

#### Inferiore
In generale, un sistema lineare triangolare inferiore è della forma:
$$
D = \begin{bmatrix}
l_{11} & 0 & 0 & 0 \\
l_{21} & l_{22} & 0 & 0 \\
l_{31} & l_{32} & l_{33} & 0 \\
l_{41} & l_{42} & l_{43} & l_{44}
\end{bmatrix}\begin{bmatrix}
x_1 \\ x_2 \\ x_3 \\ x_4
\end{bmatrix} = \begin{bmatrix}
b_1 \\ b_2 \\ b_3 \\ b_4
\end{bmatrix}
$$
e corrisponde al sistema di equazioni:
$$
\begin{cases}
u_{11}x_1 + u_{12} x_2 + ... + u_{1n}x_n = b_1 \\
u_{22}x_2 + ... + u_{2n}x_n = b_2 \\
...
\end{cases}
$$
> [!important] Soluzioni di un Sistema di Equazioni Lineare Triangolare Inferiore
> $$
> x_n = \frac{1}{u_{ii}}(b_i - \sum^{n}_{j=i+1}u_{ij}x_j)
> $$
> E la complessità computazionale è `O(n^2/2)`