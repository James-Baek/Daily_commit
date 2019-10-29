var console = require('console');
var http = require('http');

var http = require('http');
var db = require('tool/getDB.js');

module.exports.function = function base (bookName) {
  var book = db.getBookByNum();
  var name = bookName;
  var chapter;
  var verse;
  var content;
  console.log(name);
  if(name == "창세기"){
    chapter = 1;
    verse = 1;
    content = book[0].content;
  }else{
    chapter = 2;
    verse = 2;
    content = book[1].content;
  }

  console.log(book[0]);
  return {
    book : bookName,
    chapter : chapter,
    verse : verse,
    content : content    
  }
}
