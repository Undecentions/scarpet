__config() -> {
  'commands' -> {
    '<from> <to>' -> _(from, to) -> print(volume(from, to, !air(_)) + '/' + (abs(from[0] - to[0]) + 1) * (abs(from[1] - to[1]) + 1) * (abs(from[2] - to[2]) + 1)),
  },
  'arguments' -> {
    'from' -> {'type' -> 'pos'},
    'to' -> {'type' -> 'pos'},
  },
};
