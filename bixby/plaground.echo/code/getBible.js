var console = require('console');
var http = require('http');

var http = require('http');
var db = require('tool/getDB.js');

module.exports.function = function getBible (book, chapter, verse) {
  var chapter;
  var verse;
  var content;

  if(typeof book == "undefined" || book == null || book == ""){
    book = "창세기"
  }
  if(typeof chapter == "undefined" || chapter == null || chapter == ""){
    chapter = 1
  }
  if(typeof verse == "undefined" || verse == null || verse == ""){
    verse = 1
  }
  var books = db.getBookByNum(book);

  var isFind = false;
  for(var i = 0; i < books.length; i++){
    if(books[i].chapter == chapter && books[i].verse == verse){
      content = books[i].content;
      isFind = true;
      break;
    }
  }
  if(!isFind){
    content = "없는 구절 입니다."
  }
  console.log(books);
  // console.log(books[0]);
  return {
    book : book,
    chapter : chapter,
    verse : verse,
    content : content    
  }
}
