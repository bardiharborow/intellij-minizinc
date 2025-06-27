include "all_different.mzn";

int: n = 8;
array [1..n] of var 1..n: q; % queen in column i is in row q[i]

constraint all_different(q);                      % distinct rows
constraint all_different([q[i] + i | i in 1..n]); % distinct diagonals
constraint all_different([q[i] - i | i in 1..n]); % upwards+downwards

include "visualise.mzn";