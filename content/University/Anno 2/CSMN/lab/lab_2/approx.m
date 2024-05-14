%input dei valori
a = input("inserire valore di a");
b = input("inserire valore di b");
c = input("inserire valore di c");

%(a+b)-c
x1 = (a+b)-c;
fla = round(a,3,"significant");
flb = round(b,3,"significant");
flc = round(c,3,"significant");

tmp = fla+flb;
tmp = round(tmp,3,"significant");

d1 = tmp-flc;
d1 = round(d1,3,"significant");

%a+(b-c)
x2 = a+(b-c);
tmp2 = flb -flc;
tmp2 = round(tmp2,3,"significant");

d2 = round(fla + tmp2, 3, "significant");

%calcolo degli errori
rho1 = abs(x1-d1)/abs(x1);
rho2 = abs(x2-d2)/abs(x2);

%stampa degli errori
disp(rho1);
disp(rho2);



