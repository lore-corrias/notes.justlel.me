---
title: 04 - Packages e Modificatori di Accesso
date: 2024-03-07
tags:
  - pr2
  - package
  - private
  - public
  - protected
draft:
---
> [!summary]- Lezioni Collegate
> Lezione precedente: [[03) Inheritance]]
> 
> Lezione successiva: [[05) Wrapper e Primitivi]]
## Packages
Nei programmi professionali di Java è solitamente necessario l'utilizzo di _più file_ per poter scrivere e utilizzare più di una classe. Per evitare confusioni relative alla path e alla locazione di questi file, Java mette a disposizione i `Package`, ossia un tipo di struttura che, lato JVM, permette al compilatore di "raggruppare" i file che possono essere utili l'uno per l'altro. Fondamentalmente, a livello di elaboratore, a un package corrisponde una **directory** del filesystem. Ogni package è convenzionalmente indicato da un `URL` scritto all'incontrario, per esempio: `package it.unica.pr2`.

## Modificatori di Accesso
Abbiamo già visto come limitare in Java l'accesso ad un metodo o attributo attraverso il modifier `private`. Java, tuttavia, mette a disposizione un totale di $4$ identificatori, per venire incontro ad ogni possibile combinazione ed esigenza. Questi sono:
> [!summary] 
> |Modifier|Class Visibility|Package Visibility|Subclass Visibility|Visible everywhere|
> |--|--|--|--|--|
> |`public`|YES|YES|YES|YES|
> |`protected`|YES|YES|YES|NO|
> |`no modifier`|YES|YES|NO|NO|
> |`private`|YES|NO|NO|NO|
