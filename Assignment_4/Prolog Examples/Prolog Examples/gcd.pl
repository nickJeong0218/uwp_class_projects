gcd(U,0,U).
gcd(U,V,W) :- not(V=0), R is U mod V, gcd(V,R,W).