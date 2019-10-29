var http = require('http');

module.exports.getBookByNum = function () {
  let books = http.getUrl('https://api.sheety.co/af4872df-9aff-478a-a6e1-7eead1ac74fe', {format : "json"});
  return books;
}
