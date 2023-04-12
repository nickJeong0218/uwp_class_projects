%append(X,Y,Z) :- X=[], Y=Z.
%append(X,Y,Z) :- X = [A|B], Z=[A|W], append(B, Y, W).

append([],Y,Y).
append([A|B], Y, [A|W]) :- append(B, Y, W).