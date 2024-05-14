% Sintassi del ciclo for
for i = 0 : 100
    disp(i)
end

% Ciclo for con uno step
for i = 0 : 3 : 100
    disp(i)
end

for i = -1 : -1 : -20

    x = 10^i;

    % Definizione di due funzioni
    f1 = (1-cos(x))/x^2
    f2 = 1/2*((sin(x/2))/(x/2))^2

    pause;
end