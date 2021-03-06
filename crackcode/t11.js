// Generated by CoffeeScript 1.6.3
(function() {
  "Implement an algorithm to determine if a string has all unique characters What if you can not use additional data structures?";
  var main, main2, main3;

  main = function(str) {
    var char_set, i, str_length, _i, _ref;
    str_length = str.length;
    char_set = new Array(256);
    for (i = _i = 0, _ref = str_length - 1; 0 <= _ref ? _i <= _ref : _i >= _ref; i = 0 <= _ref ? ++_i : --_i) {
      if (char_set[str.charCodeAt(i)]) {
        return false;
      } else {
        char_set[str.charCodeAt(i)] = true;
      }
    }
    return true;
  };

  console.log(main("aa"));

  console.log(main("ab"));

  main2 = function(str) {
    var checker, i, str_length, val, _i, _ref;
    checker = 0;
    str_length = str.length;
    for (i = _i = 0, _ref = str_length - 1; 0 <= _ref ? _i <= _ref : _i >= _ref; i = 0 <= _ref ? ++_i : --_i) {
      val = str.charCodeAt(i) - 'a'.charCodeAt(0);
      if ((checker & (1 << val)) > 0) {
        return false;
      }
      checker |= 1 << val;
    }
    return true;
  };

  console.log(main2("aa"));

  console.log(main2("ab"));

  main3 = function(str) {
    var i, j, str_length, _i, _j, _ref;
    str_length = str.length;
    console.log(str_length);
    for (i = _i = 0; 0 <= str_length ? _i < str_length : _i > str_length; i = 0 <= str_length ? ++_i : --_i) {
      for (j = _j = _ref = i + 1; _ref <= str_length ? _j < str_length : _j > str_length; j = _ref <= str_length ? ++_j : --_j) {
        if (str[i] === str[j]) {
          return false;
        }
      }
    }
    return true;
  };

  console.log(main3("aa"));

  console.log(main3("ab"));

}).call(this);