include "globals.mzn";

any: board = [|
   5,  3, <>,  <>,  7, <>,  <>, <>, <> |
   6, <>, <>,   1,  9,  5,  <>, <>, <> |
  <>,  9,  8,  <>, <>, <>,  <>,  6, <> |

   8, <>, <>,  <>,  6, <>,  <>, <>,  3 |
   4, <>, <>,   8, <>,  3,  <>, <>,  1 |
   7, <>, <>,  <>,  2, <>,  <>, <>,  6 |

  <>,  6, <>,  <>, <>, <>,   2,  8, <> |
  <>, <>, <>,   4,  1,  9,  <>, <>,  5 |
  <>, <>, <>,  <>,  8, <>,  <>,  7,  9
|];

array [1..9, 1..9] of var 1..9: solution;

% Given numbers are fixed
constraint forall (i, j in 1..9) (solution[i, j] ~= board[i, j]);

% Rows are all different
constraint forall (i in 1..9) (all_different(solution[i, ..]));
% Columns are all different
constraint forall (j in 1..9) (all_different(solution[.., j]));

% Subgrids are all different
constraint forall (i, j in 1..3) (
  all_different(solution[
    3 * (i - 1) + 1 .. 3 * i,
    3 * (j - 1) + 1 .. 3 * j
  ])
);

include "visualise.mzn";