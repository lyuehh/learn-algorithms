// Generated by CoffeeScript 1.6.3
(function() {
  var check14, check15;

  check14 = function(str1, str2) {
    var c, k, obj1, obj2, v, _i, _j, _len, _len1;
    if (str1.length !== str2.length) {
      return false;
    }
    obj1 = {};
    obj2 = {};
    for (_i = 0, _len = str1.length; _i < _len; _i++) {
      c = str1[_i];
      if (obj1[c]) {
        obj1[c] = obj1[c] + 1;
      } else {
        obj1[c] = 1;
      }
    }
    for (_j = 0, _len1 = str2.length; _j < _len1; _j++) {
      c = str2[_j];
      if (obj2[c]) {
        obj2[c] = obj2[c] + 1;
      } else {
        obj2[c] = 1;
      }
    }
    for (k in obj1) {
      v = obj1[k];
      if (obj2[k] && obj2[k] === v) {
        return true;
      } else {
        return false;
      }
    }
  };

  console.log("\n===1.4===");

  console.log(check14("asdasd", "aassdd"));

  console.log(check14("asdasd", "aassd222d"));

  console.log("");

  check15 = function(str) {
    var c, i, newLength, sArray, spaceCount, _i, _j, _len, _ref;
    sArray = str.split('');
    spaceCount = 0;
    for (_i = 0, _len = sArray.length; _i < _len; _i++) {
      c = sArray[_i];
      if (c === ' ') {
        spaceCount++;
      }
    }
    newLength = sArray.length + spaceCount * 2;
    console.log(str.length);
    console.log(newLength);
    console.log(sArray);
    for (i = _j = _ref = sArray.length - 1; _ref <= 0 ? _j <= 0 : _j >= 0; i = _ref <= 0 ? ++_j : --_j) {
      if (sArray[i] === ' ') {
        sArray[newLength - 1] = '0';
        sArray[newLength - 2] = '2';
        sArray[newLength - 3] = '%';
        newLength = newLength - 3;
      } else {
        sArray[newLength - 1] = str[i];
        newLength = newLength - 1;
        console.log(sArray);
      }
    }
    return sArray.join('');
  };

  console.log(check15('a b c'));

}).call(this);
