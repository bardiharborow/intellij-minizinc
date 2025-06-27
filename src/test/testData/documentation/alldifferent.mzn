/** @group globals.alldifferent
  Constrain the elements in the array \a x to be pairwise different.
*/
predicate all_different(array [$X] of var $$E: x) =
  analyse_all_different(array1d(x)) /\ fzn_all_different_int(enum2int(array1d(x)));

constraint all_different<caret>();