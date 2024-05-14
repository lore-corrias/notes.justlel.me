---
title: 05 - Tipi Wrapper e Primitivi
date: 2024-03-11
tags:
  - pr2
  - tipi
draft:
---
> [!summary]- Lezioni Collegate
> Lezione precedente: [[04) Packages e Modificatori]]
> Lezione successiva: [[06) Classi Astratte e Eccezioni]]
## Differenza tra tipi `Wrapper` e `Primitive`
Java presenta generalmente due tipi di dati:
* Tipi **primitivi**: cominciano con una lettera _minuscola_ e sono i tipi classici di tutti i linguaggi di programmazione (`int`, `char`, `byte` eccetera)
* Tipi **wrapper**: sono degli **Oggetti**, cominciano con la lettera maiuscola e funzionano come degli "_involucri_" per i tipi primitivi. Esempi sono `String`, `Integer`, `Long`, eccetera. Ad ogni tipo primitivo è associato un tipo **wrapper**.

Essendo che i tipi **wrapper** sono degli **Oggetti**, accettano, per essere istanziati, un costruttore, che prende come parametro il **tipo primitivo associato al tipo wrapper**. Per esempio:
```java
int i = 5;
Integer j = new Integer(i);
```
Oppure, possiamo lasciare la creazione dei tipi **wrapper** al compilatore di Java, attraverso l'**autoboxing**:
```java
Integer j = 5; // autoboxing
int i = k; // autounboxing
```

| **Tipo Primitivo** | **Tipo Wrapper** | Argomenti del Costruttore |
| ------------------ | ---------------- | ------------------------- |
| `byte`             | `Byte`           | `byte / String`           |
| `short`            | `Short`          | `short / String`          |
| `int`              | `Integer`        | `int / String`            |
| `long`             | `Long`           | `long / String`           |
| `float`            | `Float`          | `float / double / String` |
| `double`           | `Double`         | `double / String`         |
| `char`             | `Character`      | `char`                    |
| `boolean`          | `Boolean`        | `boolean / String`        |
L'utilità dei tipi **wrapper** sta nel fatto che le classi implementano dei metodi che possono essere molto utili a seconda del dato.