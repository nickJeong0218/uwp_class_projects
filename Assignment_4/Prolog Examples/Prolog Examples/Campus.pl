% Sample prolog code

% Facts

% Our first group of persons are students
% Each person is identified by a unique ID
person(123,john).
person(234,andrew).
person(456,megan).
person(678,jeremy).
person(990,thor).
person(505,heather).
person(135,marmaduke).
person(246,scoobydo).

% Our second group of persons are instructors
person(222,erica).
person(111,stu).
person(333,kamil).

% Classes also are identified by unique IDs
class(c333,programminglanguages).
class(c444,eventdrivenprogramming).
class(c145,cs1).
class(c331,theoryofcomputation).
class(m112,algebra).
class(m221,calculus).
class(c105,intotocomp).

% Just like any other language, the order of the parameters matters.
% You have to decide what the
enroll(123,c333).
enroll(123,c444).
enroll(123,m221).

enroll(234,c333).
enroll(234,m112).

enroll(456,c145).
enroll(456,m112).
enroll(456,c331).
enroll(456,c333).
enroll(456,c444).

enroll(678,c145).
enroll(678,m221).
enroll(678,c331).
enroll(678,c333).
enroll(678,c444).

enroll(990,c145).

enroll(505,m112).
enroll(505,c331).

enroll(135,c333).
enroll(135,c105).

enroll(246,c444).
enroll(246,c105).

% Every course has a teacher.
% Some have two teachers, as there are multiple sections.
teaches(111,c145).
teaches(111,c331).
teaches(111,c333).
teaches(222,m112).
teaches(222,m221).
teaches(135,m221).
teaches(333,c444).
teaches(505,c105).

classmates(X,Y,C):-enroll(X,C),enroll(Y,C),X\=Y.
