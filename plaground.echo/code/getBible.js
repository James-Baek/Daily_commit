var console = require('console');
var http = require('http');

var http = require('http');
var db = require('tool/getDB.js');

module.exports.function = function getBible(book, chapter_from, verse_from, chapter_to, verse_to) {
  var name = book;
  var chapter;
  var verse;
  var content;

  if (typeof chapter_to == "undefined" || chapter_to == null || chapter_to == "") {
    chapter_to = chapter_from
  }
  if (typeof verse_to == "undefined" || verse_to == null || verse_to == "") {
    verse_to = verse_from;
  }
  var books = db.searchBook(book);

  var bookList = [];
  // 책이 없는 경우 없다고 리턴
  if (books == -1) {
    return {
      bible: "",
      isfind: false
    }
  } else { // 있으면 범위 탐색
    var isFind = false;
    var start = -1;
    var end = -1;


    if (typeof chapter_from != "undefined" || chapter_from != null || chapter_from != "") {
      if (typeof verse_from == "undefined" || verse_from == null || verse_from == "") {
        for (var i = 0; i < books.length; i++) {
          if (books[i].chapter == chapter_from) {
            var temp_book = {
              book: book,
              chapter: books[i].chapter,
              verse: books[i].verse,
              content: books[i].content
            }
            bookList.push(temp_book);
          }
        }
        return {
          bible: bookList,
          isfind: true
        }
      }
    }
    for (var i = 0; i < books.length; i++) {
      if (books[i].chapter == chapter_from && books[i].verse == verse_from) {
        start = i;
        // isFind = true;
        continue;
      }
      if (books[i].chapter == chapter_to && books[i].verse == verse_to) {
        end = i;
        // is
        continue;
      }
    }
    console.log(start);
    console.log(end);
    if (start >= 0 && end == -1) {
      var temp_book = {
        book: book,
        chapter: books[start].chapter,
        verse: books[start].verse,
        content: books[start].content
      }
      return {
        bible: temp_book,
        isfind: true
      }
    }
    if (start == -1 || end == -1) {
      return {
        bible: "",
        isfind: false
      }
    }
    for (var i = start; i <= end; i++) {
      var temp_book = {
        book: book,
        chapter: books[i].chapter,
        verse: books[i].verse,
        content: books[i].content
      }
      bookList.push(temp_book);
    }
  }

  console.log(bookList);

  return {
    bible: bookList,
    isfind: true
  }
}