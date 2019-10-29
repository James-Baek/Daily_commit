module.exports.function = function makeLotto(gamename) {
  var console = require('console');
  var randomMenu = new Array(6);
  var cnt = 0;
  var flag = true;
  var result = {
    round: undefined,
    lottoNum: []
  };
  result.round = "832회";

  for (var j = 0; j < 5; j++) {
    randomMenu = new Array(6);

    while (cnt < 6) {
      var num;
      num = parseInt(Math.random() * 45)+1;
      for (var i = 0; i < cnt; i++) {
        if (randomMenu[i] == num) flag = false;
      }
      if (flag) {
        randomMenu[cnt] = num;
        cnt++;
      }
      flag = true;
    }
    cnt = 0;
    var aJson = new Object();
    aJson.number = randomMenu;
    result.lottoNum.push(aJson);
  }

  console.log(result);
  return result
}
