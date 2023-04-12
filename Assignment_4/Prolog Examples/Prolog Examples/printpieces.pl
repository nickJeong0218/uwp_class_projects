printpieces(L) :- append(X, Y, L),
			  write(X),
                  write(Y),
                  nl,
                  fail.