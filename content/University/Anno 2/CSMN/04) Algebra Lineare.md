---
title: 04 - Algebra Lineare
date: 2024-03-12
tags:
  - csmn
  - vettori
draft:
---
> [!summary]- Lezioni Collegate
> Lezione precedente: [[03) Errori]]
> 
> Lezione successiva: [[05) Matrici]]
## Spazi Vettoriali
> [!important] Definizione di Spazio Vettoriale
> Un insieme $V$ è detto spazio _lineare_ o _vettoriale_ se sono definite due operazioni:
> *  Operazione _somma_, prende due elementi e restituisce un altro elemento dello spazio
>   $$
>   +: V \times V \to V
>   $$
>    $$
>	(\underline{v},\underline{w}) \to \underline{v} + \underline{w}
>  $$
>   
> * Operazione _prodotto_, prende un numero reale e due elementi dello spazio, restituisce un elemento dello spazio:
>  $$
>   \cdot: \mathbb{R} \times V \to V
>  $$
>  $$
>  (\alpha,\underline{v}) \to \alpha \cdot \underline{v}
>  $$
### Proprietà degli Spazi Vettoriali
> [!important] Proprietà
> Le proprietà soddisfatte da queste operazioni sono:
>1. **Chiusura**: entrambe le operazioni restituiscono un altro elemento dello spazio:
>   
>   $$
>   \underline{x}, \underline{y} \in V \implies \underline{x} + \underline{y} \in V
>   $$
>  
> $$
>   \alpha \in \mathbb{R}, \underline{v} \in V \implies \alpha \underline{v} \in V
>   $$
>2. **Commutabilità**: l'ordine delle operazioni non è rilevante per il risultato:
>   $$
>   \underline{x}, \underline{y} \in V \implies \underline{x}+\underline{y} = \underline{y}+\underline{x}
>   $$
>3. **Esistenza dell'elemento neutro**:
>   $$
>   \exists 0 \text{ t.c. } 0+\underline{x}=\underline{x}+0=\underline{x}
>   $$
>   
>   $$
>   \exists \ \text{ t.c } 1\cdot \underline{x} = \underline{x} \cdot 1 = \underline{x}
>   $$
> 4. **Associatività**:
>   $$
>   (\underline{x}+\underline{y})+\underline{z}=\underline{x}+(\underline{y}+\underline{z})
>   $$
>   
>   $$
>   \alpha(\beta \underline{x}) = (\alpha\beta)\underline{x}
>   $$
>5. **Distributività**:
>   $$
>   \alpha(\underline{x}+\underline{y}) = \alpha\underline{x} + \alpha\underline{y}
>   $$
>  
> $$
>   (\alpha+\beta)(\underline{x}) = \alpha\underline{x} + \beta\underline{x}
>   $$
>   
>6. **Inverso Additivo**:
>   $$
>    \exists (-\underline{x}) \text{ t.c. } (-\underline{x})+\underline{x} = 0
>   $$

Quindi, se abbiamo $\underline{x} \in \mathbb{R}^n, y \in \mathbb{C}^n$, avremo che:
$$
\underline{x} + y = \begin{bmatrix} x1 \\ x2 \\ x3 \\ ... \\ x_n \end{bmatrix} + \begin{bmatrix} y_1 \\ y_2 \\ y_3 \\ ... \\ y_n \end{bmatrix} \rightarrow \begin{bmatrix} x_1+y_1 \\ x_2 + y_2 \\ ... \\ x_n + y_n \end{bmatrix}
$$
$$
\underline{x} \cdot y = \alpha \cdot \begin{bmatrix} x1 \\ x2 \\ ... \\ x_n \end{bmatrix} \rightarrow \begin{bmatrix} \alpha x_1 \\ \alpha x_2 \\ ... \\ \alpha x_n \end{bmatrix}
$$

Se abbiamo $W \subset V$, dove $V$ è uno spazio vettoriale, allora $W$ è detto **sottospazio vettoriale**.
### Combinazioni Lineari
> [!important] Definizione di Combinazione Lineare
>Una **combinazione lineare** di vettori $\set{v_1,v_2,v_3,...,v_n}$ è una forma del tipo:
>$$
>v = \alpha_1v_1 + \alpha_2v_2 + ... + \alpha_nv_n = \sum^{n}_{i=1}{\alpha_iv_1}
>$$

Quindi, se per esempio abbiamo i vettori $v_1,v_2,v_3$:
$$
v_1=\begin{bmatrix}1\\1\\-1\end{bmatrix},v_2=\begin{bmatrix}0\\0\\-1\end{bmatrix},v_3=\begin{bmatrix}4\\1\\0\end{bmatrix}
$$
La loro combinazione lineare sarà definita come:
$$
v=\alpha_1\begin{bmatrix}1\\1\\-1\end{bmatrix}+\alpha_2\begin{bmatrix}0\\0\\-1\end{bmatrix}+\alpha_3\begin{bmatrix}4\\1\\0\end{bmatrix} = \begin{bmatrix}\alpha_1+0+4\alpha_3\\\alpha_1+0+\alpha_3\\-\alpha_1-\alpha_2+0\end{bmatrix}
$$
Quindi, ponendo per esempio $\alpha_1=3, \alpha_2=2,\alpha_3=1$, abbiamo che
$$
v=\begin{bmatrix}3\\2\\1\end{bmatrix}
$$

Nelle combinazioni lineari, gli scalari $\alpha_n$ sono le **coordinate dei vettori**.
Inoltre, dei vettori sono detti **linearmente indipendenti** se la loro combinazione lineare $v$  si **annulla** ($v=0$) se e solo se $\forall i,\alpha_i = 0$
Per esempio, se io ho i vettori:
$$
v_1=\alpha_1\cdot\begin{bmatrix}1 \\ 0 \\ 0\end{bmatrix}, v_2=\alpha_2\cdot\begin{bmatrix}0\\1\\0\end{bmatrix}, v_3 = \alpha_3\cdot\begin{bmatrix}0 \\ 0 \\ 1\end{bmatrix}
$$
L'unico modo per ottenere $v = v_1+v_2+v_3=0$ è ponendo $\alpha_1+\alpha_2+\alpha_3=0$, poiché in tutti gli altri casi avrei almeno un termine diverso da $0$.
Dunque, se abbiamo tre vettori $v_1,v_2,v_3$ linearmente indipendenti, allora:
$$
\alpha_1v_1+\alpha_2v_2+\alpha_3v_3 = 0 \implies v_1 = \frac{-\alpha_2v_2-\alpha_3v_3}{\alpha_1} = -\frac{\alpha_2}{\alpha_1}v_2-\frac{\alpha_3}{\alpha_1}v_3
$$
#### Vettori Base
Nel nostro esempio, i nostri vettori possono essere rappresentati per indicare **tutti i punti nello spazio tridimensionale**, poiché è sufficiente modificare $\alpha_n$ ($v_1$ rappresenta la coordinata $x$, $v_2$ la $y$ e $v_3$ la $z$). Questi tipi di vettori che ci permettono di rappresentare tutti i punti dello spazio sono detti **base**. 
Una **base** è quindi un insieme di vettori **linearmente indipendenti** che **generano lo spazio**, cioè:
> [!important] Definizione di Vettore Base
>$$
>\forall \underline{x} \in V \implies \underline{x} = \sum^{n}_{i=1}{\alpha_iv_i}
>$$

quindi _tutti i punti dello spazio_ possono essere rappresentati come **combinazioni vettoriali** degli $n$ vettori. L'insieme di tutti questi punti è detto **span**:
$$
span(v_1,v_2,...,v_n) = \set{x \in V : x = \sum^{n}_{i=1}{\alpha_iv_i}}
$$

> [!info] Esempio: _l'insieme di tutti i polinomi di $3°$ grado $p(x) = ax^3+bx^2+cx+d$ è uno spazio vettoriale?_
> * Operazioni di base: **sono rispettate**
> * Proprietà di base: **sono rispettate**
> * Elemento neutro: esiste? **NO**, dato che $x^3$ non può **mai essere $0$**.
>
>Tuttavia, se allarghiamo l'insieme per contenere tutti i polinomi **al più** di grado $3$ (quindi anche i polinomi di grado $2,1,0$), allora **sì**, questo è uno spazio vettoriale:
>$$
>p(x) = a\underline{x^3}+b\underline{x^2}+c\underline{x^1}+d\underline{x^0}
>$$
>$$
>bx^2+cx+d
>$$
>$$
>cx+d
>$$
>Qual è allora la **base**? Sarà la **combinazione dei monomi di base**, ossa l'insieme di:
>$$
>\set{x^0,x^1,x^2,x^3}
>$$
## Spazio Normato
> [!important] Definizioni e Proprietà di uno Spazio Normato
> Uno spazio normato $V$ è uno spazio dotato di una **norma**, cioè una funzione:
>$$
>||\cdot||:V \rightarrow \mathbb{R}
>$$
>$$
>v \rightarrow ||v||
>$$
>Le proprietà della norma sono:
>1. $||v|| \geq 0$ e $||v||=0 \iff v=0$, **positività**.
>2. $||\alpha v|| = |\alpha| \cdot ||v||$, **omogeneità**
>3. $||v + y|| \leq ||v|| + ||y||$, **disuguaglianza triangolare**.
### Norma nel piano cartesiano.
![](https://i.imgur.com/wOMlV9D.png)
Il punto del piano è rappresentabile tramite i vettori:
$$
\underline{v}=(3,2)=3\begin{bmatrix}1\\0\end{bmatrix}+2\begin{bmatrix}0\\1\end{bmatrix}
$$
Sappiamo che, tramite il teorema di Pitagora, possiamo calcolare la lunghezza del segmento che va dall'origine del piano al nostro punto. Possiamo usare questa funzione, ossia quella che, prese le coordinate di un punto, calcola la lunghezza del segmento detto sopra, come **norma euclidea**. Sarà quindi:
$$
||v|| = \sqrt{3^2+2^2}
$$
o, in generale:

$$
||v||_2 = \sqrt{\sum^{n}_{i=1}(v_i)^2} = (\sum^{n}_{i=1}(v_i)^2)^\frac{1}{2}
$$


Possiamo quindi definire, per un qualsiasi piano, una somma $n$-esima:
$$
||v||_p = (\sum^{n}_{i=1}(v_i)^p)^{\frac{1}{p}}
$$
Insieme alla **norma euclidea**, le altre due norme più utilizzate sono:
$$
||v||_1 = \sum^{n}_{i=1}|x_i|
$$

$$
||x||_{\infty} = \max_{i=1,...,n}|x_i|
$$
**Esempio**: supponiamo di avere il vettore 
$$
v=\begin{bmatrix}
-2 \\ -1 \\ 0 \\ 1 \\ \frac{2}{5}
\end{bmatrix} \in \mathbb{R}^5
$$
allora possiamo calcolare le norme:
$$
||v||_2=\sqrt{(-2)^2+(-1)^2+0^2+1^2+\frac{2}{5}^2} \approx 2,48
$$

$$
||v_1||=|-2|+|-1|+|0|+|1|+|\frac{2}{5}| = 4,4
$$

$$
||v||_\infty = \max\set{|-2|+|-1|+|0|+|1|+|\frac{2}{5}|} = 2
$$
> [!important] Vettore Normalizzato
> Un vettore si dice **normalizzato** rispetto a una norma $||v||$ se il valore della sua norma è pari a $1$.
## Convergenza di Vettori
Una successione di vettori $\set{\underline{x}_n}$ è **convergente** se 
$$
\exists \underline{x} \text{ t.c } \lim_{n \to \infty} \underline{x}_n = \underline{x}
$$

oppure

$$
\lim_{n\to\infty} ||\underline{x}_n-\underline{x}|| = 0
$$

Il **criterio di Cauchy** dice infatti che se $\set{\underline{x}_n}$ è convergente, allora:
$$
\lim_{n,m \to \infty} ||\underline{x}_n-\underline{x}_m|| = 0
$$
## Prodotto scalare
Il **prodotto scalare** è un'operazione definita come:
$$
\langle\cdot,\cdot\rangle : V \times V \to \mathbb{R}
$$
E rispetta le seguenti proprietà:
1. **Simmetria**: $\langle\underline{x}, \underline{y}\rangle = \langle\underline{y}, \underline{x}\rangle$
2. **Bilinearità**:
   $$
   \langle\underline{x} + \underline{y}, \underline{z}\rangle = \langle\underline{x}, \underline{z}\rangle + \langle\underline{y}, \underline{z}\rangle
   $$
	$$
	\langle\alpha\underline{x}, \underline{y}\rangle = \alpha\langle\underline{x}, \underline{y}\rangle
	$$
3. $$
   \langle\underline{x}, \underline{x}\rangle \geq 0
   $$ 
   e
   $$
   \langle\underline{x}, \underline{x}\rangle = 0 \iff \underline{x} = 0
   $$
**Esempio**:
$$
\underline{v} = \begin{bmatrix}
v_1 \\ v_2 \\ ... \\ v_n
\end{bmatrix}, \underline{y} = \begin{bmatrix}
y_1 \\ y_2 \\ ... \\ y_n
\end{bmatrix}
$$
Il prodotto scalare dei due vettori è definito come:
$$
\langle\underline{v},\underline{y}\rangle = v_1y_2+v_2y_2+v_3y_3+...+v_ny_n = \sum^{n}_{i=1}v_iy_i
$$
Mentre il prodotto di $v$ con sé stesso è:
$$
\langle\underline{v},\underline{v}\rangle = \sum^{n}_{i=1}(v_i)^2
$$
E la _norma indotta_ è pari a:
$$
||v||_2 = \sqrt{\langle\underline{v},\underline{v}\rangle}
$$
## Vettori Ortogonali
Un insieme di vettori $\set{\underline{x}_1,\underline{x}_2,...,\underline{x}_n}$ è detto **ortogonale** se
$$
\langle\underline{x}_i,\underline{x}_j\rangle=0, \forall i,j \text{ con } i \neq j
$$

Per esempio, questo insieme di vettori è detto **ortogonale**:
$$
\begin{bmatrix}
1 \\ 0 \\ 0
\end{bmatrix}, \begin{bmatrix}
0 \\ 1 \\ 0
\end{bmatrix}\begin{bmatrix}
0 \\ 0 \\ 1
\end{bmatrix}
$$