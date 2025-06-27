enum REGION = { WA, NT, SA, Q, NSW, V, T };
enum COLOR = Color(1..card(REGION));

% Neighboring regions
array [_] of tuple(REGION, REGION): neighbors = [
  (WA,  NT),
  (WA,  SA),
  (NT,  SA),
  (NT,  Q),
  (SA,  Q),
  (SA,  NSW),
  (SA,  V),
  (Q,   NSW),
  (NSW, V)
];

% Color of each Region
array [REGION] of var COLOR: color;
% Number of colors used
include "nvalue_fn.mzn";
var 1..card(COLOR): n_colors :: output = nvalue(color);

% Neighboring regions have different colours
constraint forall (pair in neighbors) (color[pair.1] != color[pair.2]);

% Use as few colors as possible
solve minimize n_colors;

include "visualise.mzn";