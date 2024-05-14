---
title: OpenECSC 2024 - Perfect Shop
categories:
  - ctf
tags:
  - challenge
  - openecsc
  - xss
started: 2024-03-18T11:10:00
finished: 2024-03-18T15:20:00
draft: true
---
## Writeup
The challenge consists of a website resembling an e-commerce service:
![](https://i.imgur.com/UCmIOXx.png)

Inside the source, we can see a `bot.js` file, meaning we likely have to achieve `XSS`. Apparently, if we managed to login as `admin`, we can access the `/admin` endpoint and edit a page's product,