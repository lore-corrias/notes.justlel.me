clc
clear

% Richiedo gli input all'utente
a = input("Inserisci a: ");
b = input("Inserisci b: ");
c = input("Inserisci c: ");

% Arrotondo i valori
fla = round(a, 3, "significant");
flb = round(b, 3, "significant");
flc = round(c, 3, "significant");

% Calcolo di (a+b)-c, arrotondando i valori
tmp = fla + flb;
tmp = round(tmp, 3, "significant");
d_1 = tmp - flc;
d_1 = round(d_1, 3, "significant");

% Calcolo di a+(b-c), arrotondando i valori
tmp = flb - flc;
tmp = round(tmp, 3, "significant");
d_2 = fla + tmp;
d_2 = round(d_2, 3, "significant");

% Calcolo degli errori relativi
calc_1 = (a + b) - c;
calc_2 = a + (b - c);

rho_1 = abs(calc_1 - d_1) / abs(calc_1);
rho_2 = abs(calc_2 - d_2) / abs(calc_2);

disp("Valore di (a + b) + c: " + d_1)
disp("Valore di a + (b + c): " + d_2)

disp("Errore relativo d_1: " + rho_1)
disp("Errore relativo d_2: " + rho_2)