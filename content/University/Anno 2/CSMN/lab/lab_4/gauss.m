function [C,d] = gauss(A,b)
%Funzione che presi in ingresso la matrice A e il vettore di termini noti b
% restituisce la riduzione di Gauss.
    if size(A,1) ~= size(A,2)
        error("A deve essere quadrata")
    end

    n = size(A,2);

    for k = 1 : n-1
        for i = k + 1: n
            m = A(i,k)/A(k,k);

            % for j = k:n
            %     A(i,j) = A(i,j) - m * A(k,j);
            % end
            A(i,:) = A(i,:) - m * A(k,:);
            b(i) = b(i) - m*b(k);
        end
    end
    C = A;
    d = b;
end