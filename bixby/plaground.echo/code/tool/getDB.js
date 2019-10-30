var http = require('http');
var console = require('console');

module.exports.getBookByNum = function (book) {
  var bookList = [ "창세기",
              "출애굽기",
              "레위기",
              "민수기",
              "신명기",
              "여호수아",
              "사사기",
              "룻기",
              "사무엘상",
              "사무엘하",
              "열왕기상",
              "열왕기하",
              "역대상",
              "역대하",
              "에스라",
              "느헤미야",
              "에스더",
              "욥기",
              "시편",
              "잠언",
              "전도서",
              "아가서",
              "이사야",
              "예레미야",
              "예레미야애가",
              "에스겔",
              "다니엘",
              "호세아",
              "요엘",
              "아모스",
              "오바댜",
              "요나",
              "미가",
              "나훔",
              "하박국",
              "스바냐",
              "학개",
              "스가랴",
              "말라기",
              "마태복음",
              "마가복음",
              "누가복음",
              "요한복음",
              "사도행전",
              "로마서",
              "고린도전서",
              "고린도후서",
              "갈라디아서",
              "에베소서",
              "빌립보서",
              "골로새서",
              "데살로니가전서",
              "데살로니가후서",
              "디모데전서",
              "디모데후서",
              "디도서",
              "빌레몬서",
              "히브리서",
              "야고보서",
              "베드로전서",
              "베드로후서",
              "요한일서",
              "요한이서",
              "요한삼서",
              "유다서",
              "요한계시록"];

  var urlList = [
    "https://api.sheety.co/af4872df-9aff-478a-a6e1-7eead1ac74fe", // 0. 창세기
    "https://api.sheety.co/23fea8b5-ee0c-4ace-a679-06dce4be2640", // 1. 출애굽기
    "https://api.sheety.co/f264821e-cd4c-4a89-ac70-e56fe0eeb00d", // 2. 레위기
    "https://api.sheety.co/c3c0d2ec-3a3c-4b21-8646-0265238f7dfb", // 3. 민수기
    "https://api.sheety.co/b452b022-9e7d-424b-a0d8-128a8053c8ea", // 4. 신명기
    "https://api.sheety.co/ca385cbc-27b1-4512-9455-682779c06532", // 5. 여호수아
    "https://api.sheety.co/87eb9f5a-d57a-4f64-9e08-1743a1ac97cd", // 6. 사사기
    "https://api.sheety.co/318ccbb8-8146-4a3a-a474-3a79de4c0ebc", // 7. 룻기
    "https://api.sheety.co/fc30699c-2545-4c31-b61c-9fc55ce65cef", // 8. 사무엘상
    "https://api.sheety.co/6a861bff-1e2a-4b2e-8b2d-e84e7b82d8b5", // 9. 사무엘하
    "https://api.sheety.co/4ea5cb9d-cec9-4610-89f7-3596d83f6e81", // 10. 열왕기상
    "https://api.sheety.co/a6442480-afc9-42fb-bc88-11f0543b67bb", // 11. 열왕기하
    "https://api.sheety.co/279ab716-9dec-40e9-9865-cb0ac21f7ca9", // 12. 역대상
    "https://api.sheety.co/5af5aa97-45b0-430f-a41f-6220e2fd2ae7", // 13. 역대하
    "https://api.sheety.co/abda0c7c-ef2c-4f19-9796-bd65e424cef2", // 14. 에스라
    "https://api.sheety.co/c93be8bd-41f7-4565-96f5-155e17128f36", // 15. 느헤미야
    "https://api.sheety.co/691704fa-528a-4a3e-8c32-09b1680339be", // 16. 에스더
    "https://api.sheety.co/34aa51e7-af26-4986-9e50-07d095ae20a9", // 17. 욥기
    "https://api.sheety.co/2174e737-82a4-4376-b82c-8ae2936e730b", // 18. 시편
    "https://api.sheety.co/0d66add3-d89c-4d58-890d-c66623e406fd", // 19. 잠언
    "https://api.sheety.co/0359a6f9-4798-488d-971d-5a6be519d6e6", // 20. 전도서
    "https://api.sheety.co/f296b0fe-b6ca-43d9-8526-0254de37f62e", // 21. 아가서
    "https://api.sheety.co/bca6cad3-cdc8-4915-87b1-bed0d10dfea6", // 22. 이사야
    "https://api.sheety.co/8a7deb04-9efa-4126-9776-e159b5344bef", // 23. 예레미야
    "https://api.sheety.co/170ac496-df3e-40d7-ae04-5899d8ba47da", // 24. 예레미야애가
    "https://api.sheety.co/74472d06-b558-4913-a58d-d8e6cf4c0422", // 25. 에스겔
    "https://api.sheety.co/589598da-f15c-421b-bfe9-29a1f3a4be98", // 26. 다니엘
    "https://api.sheety.co/9a00db85-1da8-43f2-95b8-9c4fd937936d", // 27. 호세아
    "https://api.sheety.co/8dab5115-9a16-4bcf-b122-7cd418c839db", // 28. 요엘
    "https://api.sheety.co/aa5f19aa-52ec-4e69-9fd2-011933524ca7", // 29. 아모스
    "https://api.sheety.co/8c5587e1-daec-4219-a30c-59058cb59a21", // 30. 오바댜
    "https://api.sheety.co/a98e348f-3cde-47b8-b452-e6dbd3b9c12a", // 31. 요나
    "https://api.sheety.co/ac32a7fb-661e-4b6a-b1f2-35c37f484d9d", // 32. 미가
    "https://api.sheety.co/39f9e064-8f8a-4cce-b99b-453469768c4c", // 33. 나훔
    "https://api.sheety.co/d594e507-67be-4215-893e-a3663361a9d2", // 34. 하박국
    "https://api.sheety.co/e1cc4651-6ef5-44c1-b5dc-b6faf34d299e", // 35. 스바냐
    "https://api.sheety.co/c67cb3a7-a01c-455d-b807-43670afd9edf", // 36. 학개
    "https://api.sheety.co/af3cd825-2113-464d-a8f6-eb56c1adc1c5", // 37. 스가랴
    "https://api.sheety.co/ead2ef31-5d8c-4ecd-ab2a-7eeed6660674", // 38. 말라기
    "https://api.sheety.co/ad2fbe83-3230-4793-ad0d-02d2bd264ee4", // 39. 마태복음
    "https://api.sheety.co/992fc6d7-c652-4aa4-9dfb-ea6902bcbff4", // 40. 마가복음
    "https://api.sheety.co/7cc5b94c-27e2-4ad9-9019-f4b570a1ed3b", // 41. 누가복음
    "https://api.sheety.co/644e99df-f466-4817-a38d-0b8b14f94aca", // 42. 요한복음
    "https://api.sheety.co/fc990406-5c8d-4f56-8077-90d05862e947", // 43. 사도행전
    "https://api.sheety.co/16a693a8-6403-478c-8b7e-d99f024d3ab1", // 44. 로마서
    "https://api.sheety.co/9020edc4-4861-405d-93e6-b51974530eaa", // 45. 고린도전서
    "https://api.sheety.co/122a1ae6-dcb0-4e57-aaed-8664dffecd82", // 46. 고린도후서
    "https://api.sheety.co/44406d07-f4f8-46c5-b255-d1044d2f00f8", // 47. 갈라디아서
    "https://api.sheety.co/d39c9c2f-b241-4619-8feb-c4522fd62fa5", // 48. 에베소서
    "https://api.sheety.co/37b302c6-cfe2-4a33-9ecb-208d7952e55e", // 49. 빌립보서
    "https://api.sheety.co/db465e2d-a758-49de-b7a6-995a328ffaf8", // 50. 골로새서
    "https://api.sheety.co/5574e918-12f8-4647-9dcd-a0a85dcc266f", // 51. 데살로니가전서
    "https://api.sheety.co/ebb6356e-9007-4a7e-aa78-ace459e6420a", // 52. 데살로니가후서
    "https://api.sheety.co/880dae84-0d1a-4863-940e-4c8a433dabdc", // 53. 디모데전서
    "https://api.sheety.co/f8f75c46-30e2-4813-88c3-bb367cb03a03", // 54. 디모데후서
    "https://api.sheety.co/894e5469-37df-41d2-9d71-7a21443f893b", // 55. 디도서
    "https://api.sheety.co/146bc667-ebcb-40d2-b4d3-345a2e690f7f", // 56. 빌레몬서
    "https://api.sheety.co/11a0bc47-64fb-46ea-8eb8-ce8bdeceef8b", // 57. 히브리서
    "https://api.sheety.co/2814959b-7dbd-49dd-8f3b-bcc879ef2205", // 58. 야고보서
    "https://api.sheety.co/da9d56cf-94f1-4758-8ee7-13ad296c6788", // 59. 베드로전서
    "https://api.sheety.co/3c1d776a-e334-4b10-ac08-8eb540225579", // 60. 베드로후서
    "https://api.sheety.co/def7d66a-1718-4137-8f63-c815957b239b", // 61. 요한일서
    "https://api.sheety.co/d8cc5959-88d3-4e85-a970-41455114b08c", // 62. 요한이서
    "https://api.sheety.co/54e9152f-d267-476d-b187-c2091b732aaf", // 63. 요한삼서
    "https://api.sheety.co/f9122824-c51b-4e38-8d20-b1e263302611", // 64. 유다서
    "https://api.sheety.co/07cae82b-495b-46ae-a52e-f922b11e1110"  // 65. 요한계시록
  ]
  console.log(book);
  var index;

  if(typeof book == "undefined" || book == null || book == ""){
    index = 0;
  }else{
    index = bookList.indexOf(book.trim());
  }

  console.log(index);
  let books = http.getUrl(urlList[index], {format : "json"});
  return books;
}
