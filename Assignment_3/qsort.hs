-- The 'qsort' function sorts a given list of Int in descending order.
-- It will use quick sort algorithm.
-- It takes one argument which is a list of Int.
qsort    :: [Int] -> [Int]
qsort [] = [] -- base case of qsort.
qsort(x:xs) =
   qsort larger ++ [x] ++ qsort smaller -- Make recursive calls exculding pivot.
   where
    larger = [a | a <- xs, a >= x] -- make a list called larger with entries that have larger value than pivot, x.
    smaller = [b | b <- xs, b <= x] -- make a list called smaller with entries that have smaller value than pivot, x.