__config() -> {
  'commands' -> {
    '<from> <to>' -> _(from, to) -> print(volume(from, to, !air(_)) + '/' + (abs(from:0 - to:0) + 1) * (abs(from:1 - to:1) + 1) * (abs(from:2 - to:2) + 1)),
  },
  'arguments' -> {
    'from' -> {'type' -> 'pos'},
    'to' -> {'type' -> 'pos'},
  },
};

craig(from, to) -> (
  non_air = volume(from, to, !air(_));
  total = (abs(from:0 - to:0) + 1) * (abs(from:1 - to:1) + 1) * (abs(from:2 - to:2) + 1);
  density = non_air / total;
  rating = if(density < 0.3, 0, density < 0.5, 1, density < 0.7, 2, density < 0.8, 3, density < 0.9, 4, 5);
  rating_color = ['', 'm', 'r', 'd', 'y', 'l']:rating;
  stars = rating_color + ' ' + '★' * rating;
  no_stars = ' ' + '☆' * (5 - rating);
  print(format('yb Density: ', stars, no_stars + ' ', rating_color + ' ' + density + '% ' + non_air, ' /' + total));
  print(format('y [craig] ') + ['you\'re trolling', ['this might be the least dense farm known to man', 'shockingly sparse']:rand(2), 'not dense enough', 'so close, yet so far', 'almost there', 'nice']:rating)
);
