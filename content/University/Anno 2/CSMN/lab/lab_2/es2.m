for i = -1:-1:-20

    x = 10^i;
    
    f1 = (1-cos(x))/x^2;
    f2 = 1/2*((sin(x/2))/(x/2))^2;

    pause

end

disp(f1);
disp(f2);