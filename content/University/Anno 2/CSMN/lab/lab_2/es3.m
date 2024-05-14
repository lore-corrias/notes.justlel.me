ep = 1;
x = 1 + ep;
k = 0;

while(x > 1) 
    ep = ep/2;
    x = 1 + ep;
    k = k +1;
end

ep = ep*2;
disp(ep);