function [U,b2] = gauss_p(A,b)
%GAUSS_P calcola gauss con pivoting parziale
    [m,n] = size(A);

    if m ~= n
        error("La matrice deve essere quadrata");
    end

    if size(b,1) ~= m || size(b,2) ~= 1
        error ("La dimensione di b non è corretta");
    end

    if det(A) < 1e-14
        error("LA matrice A è singolare")
    end

    for k = 1 : n-1
        [~ , pos] = max(abs(A(k:n,k)));
        l = pos + k - 1;
        
        A([k l],:) = A([l k],:);
        b([k l]) = b([l k]);

        for i = k+1 : n
            m = A(i,k) / A(k,k);
            A(i,:) = A(i,:) - m * A(k,:);
            b(i) = b(i) - m* b(k);
        end
    end

    U = A;
    b2 = b;
end

