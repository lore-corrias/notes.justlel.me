function [L,U] = alu(A)
%ALU Scompozione L e U con Gauss senza pivoting
    [m,n] = size(A);

    if m ~= n
        error("La matrice deve essere quadrata");
    end

    if det(A) < 1e-14
        error("La matrice A è singolare")
    end

    L = zeros(n);
    for k = 1 : n-1
        for i = k+1:n
            m = A(i,k) / A(k,k);
            A(i,:) = A(i,:) - m* A(k,:);
            L(i,k) = m;
        end
    end

    U = A;
    L = L + eye(n);
end

