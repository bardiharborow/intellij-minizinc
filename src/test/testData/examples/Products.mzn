% Decision variables
var 0..: x_a;  % Exclude negative values
var 0..: x_b;  % Exclude negative values

% Constraints
constraint 2 * x_a + 1 * x_b <= 60;  % Labor constraint
constraint 1 * x_a + 2 * x_b <= 90;  % Material constraint
constraint 2 * x_a + 1 * x_b <= 120;  % Budget constraint

% Objective function
var 0..: profit = 5 * x_a + 3 * x_b;

% Solve statement: maximize the total profit
solve maximize profit;

% Output the results
output ["Produce \(x_a) units of Product A and ",
        "\(x_b) units of Product B for \(profit) profit."];