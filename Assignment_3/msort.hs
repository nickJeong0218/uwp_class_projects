-- This 'msort' function sorts a given list in ascending order.
-- It will use merge sort algorithm.
-- It takes one argument which is a list.
msort   :: Ord a => [a] -> [a]
msort [] = [] -- first base case of msort.
msort [x] = [x] -- second base case of msort.
msort xs = 
   merge (msort firstHalf) (msort secondHalf) -- use merge sort algorithm by using recursive calls.
   where
    firstHalf = fst (halve xs) -- make a list using halve function.
    secondHalf = snd (halve xs) -- make a list using halve function.
   

-- This 'halve' function split a lis in 2 lists.
-- It takes a list as an argument.
halve   :: [a] -> ([a], [a])
halve xs = splitAt (length xs `div` 2) xs -- use function splitAt to split a list into half and half.


-- This 'merge' function merges 2 lists in ascending order.
-- It takes 2 lists as arguments.
merge [] ys = ys -- first base case of merge.
merge xs [] = xs -- second base case of merge.
merge (x:xs) (y:ys) =
   -- After comparing first entries of each list, and make recursive calls properly to merge in ascending order.
   if x <= y then x : merge xs (y:ys) else y : merge (x:xs) ys