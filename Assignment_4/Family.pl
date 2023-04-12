% Completed by: <YunHwan Jeong>

% Here are some men
man(stuart).
man(kurt).
man(mark).
man(rayond).
man(august).
man(hans).
man(ryan).
man(adam).
man(max).

% Here are some women.
woman(erica).
woman(susan).
woman(elaine).
woman(viola).
woman(ida).
woman(florence).
woman(marissa).
woman(annika).
woman(kaita).

% For our purposes, we will always put the woman's name first in the
% marriage facts.
married(erica, stuart).
married(susan, mark).
married(elaine, raymond).
married(viola, august).
married(ida, hans).
married(marissa, ryan).
married(annika, adam).

% For our purposes, the parent's name always comes first
parent(susan, marissa).
parent(mark, marissa).
parent(susan, annika).
parent(mark, annika).
parent(elaine, mark).
parent(raymond, mark).
parent(elaine, stuart).
parent(raymond, stuart).
parent(elaine, kurt).
parent(raymond, kurt).
parent(viola, elaine).
parent(august, elaine).
parent(ida, raymond).
parent(hans, raymond).


% motherInLaw(X,Y): X is Y's mother in law.
motherInLaw(X,Y) :- woman(X), % Check whether X is woman or not.
    parent(X,Z), % Check whether X is Z's parent.
    (married(Z,Y); married(Y,Z)). % Check whether Z has got married with Y.

% grandParent(X,Y): X is Y's grand parent.
grandParent(X,Y) :- parent(X,Z), % Check whether X is Z's parent.
    parent(Z,Y). % Check whether Z is Y's parent.

% grandMother(X,Y): X is Y's grand mother.
grandMother(X,Y) :- woman(x), % Check whether X is woman.
    parent(X,Z), % Check whether X is Z's parent.
    parent(Z,Y). % Check whether Z is Y's parent.


