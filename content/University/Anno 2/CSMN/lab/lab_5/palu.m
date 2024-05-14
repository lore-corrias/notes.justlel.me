function [L,U,P] = palu(A)
    [m,n] = size(A);

    if m ~= n
        error("La matrice deve essere quadrata");
    end

    if det(A) < 1e-14
        error("La matrice A è singolare")
    end

    L = zeros(n);
    P = eye(n);
    for k = 1 : n-1        
        [~ , pos] = max(abs(A(k:n,k)));
        l = pos + k -1;
        A([k l],:) = A([l k], :);
        P([k l],:) = P([l k], :);
        L([k l],:) = L([l k], :);

        for i = k+1:n
            m = A(i,k) / A(k,k);
            A(i,:) = A(i,:) - m* A(k,:);
            L(i,k) = m;
        end
    end

    U = A;
    L = L + eye(n);
end

