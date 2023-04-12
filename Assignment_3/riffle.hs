-- This 'riffle' function riffles two lists only if 2 lists have same length.
-- It takes 2 arguments which are list.
riffle   :: [a] -> [a] -> [a]
riffle [][] = [] -- base case of riffle.
riffle (x:xs) (y:ys) =
   -- Check whether 2 arguments have same length.
   -- If so, concatenate first entries of 2 lists and make recursive calls to each left lists.
   -- If not, return a list without any entry.
   if length xs == length ys then [x] ++ [y] ++ riffle xs ys else []
  