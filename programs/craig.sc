__config() -> {
  'commands' -> {
    '<from> <to>' -> ['craig'],
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
  rating = if(density < 0.2, 0, density < 0.4, 1, density < 0.6, 2, density < 0.8, 3, density < 0.9, 4, 5);
  rating_color = ['', 'm', 'r', 'd', 'y', 'l']:rating;
  stars = rating_color + ' ' + '★' * rating;
  no_stars = ' ' + '☆' * (5 - rating);
  print(format('yb Density: ', stars, no_stars + ' ', rating_color + ' ' + density * 100 + '% ' + non_air, ' /' + total));
  print(format('y [craig] ') + ['you\'re trolling', ['this might be the least dense farm known to man', 'shockingly sparse']:rand(2), 'not dense enough', 'so close, yet so far', 'almost there', 'nice']:rating)
);
