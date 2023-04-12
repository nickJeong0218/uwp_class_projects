-- The 'remove' function removes an entry in a list.
-- It takes 2 arguments, one is a Int and the other one is list.
-- Int argument indicates the index of the list which is the other argument.
remove   :: Int -> [a] -> [a]
remove x xs = 
   -- concatenate two partial lists of the given list using the Int argument as the standard to break down the list.
   take x xs ++ drop (x + 1) xs