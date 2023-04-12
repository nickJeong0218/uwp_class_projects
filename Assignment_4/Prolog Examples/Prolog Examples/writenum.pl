
num(0).
num(X) :- num(Y), X is Y + 1

writenum(I,J) :- num(X),
			 I =< X,
                  X =< x,
                  write(X),
                  nl,
                  fail.