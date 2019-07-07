function basic_async(input){
  console.log('basic_async---------------start');
  console.log(input);
  //コールバック関数を別に定義
  var logresult = function(){
    console.log(5);
  }
  console.log(4);
  setTimeout(logresult, 1000);
  console.log(6);
  console.log('basic_async---------------end');
  o = 'output'
  return o
}

function async_request(){
  console.log('async_request---------------start');

  //requestをrequire
  var request = require('request');
  //ヘッダーを定義
  var headers = {
    'Content-Type':'application/json'
  }
  //オプションを定義
  var options = {
    url: 'http://weather.livedoor.com/forecast/webservice/json/v1?city=400040',
    method: 'GET'
  }

  //リクエスト送信
  console.log('request_bodyよりこちらが先に実行される----------start');
  x = request(options, function (error, response, body) {
    //コールバックで色々な処理
    console.log('request_body-------------start');
    console.log(body);
    console.log('request_body-------------end');
  })
  console.log('request_bodyよりこちらが先に実行される----------end');
  // console.log(x);

  console.log('async_request---------------end');
}


function loop_request(){
  console.log('loop_request---------------start');
  
  for (var i = 0; i < 3; i++ ){
    // 繰り返し処理
    console.log('loop' + i + '---start');
    async_request()
    console.log('loop' + i + '---end');
  }

  console.log('loop_request---------------end');
}


function loop_list(){
  console.log('loop_list---------------start');
  
  let ar = [10, 20, 30];

  for(let i = 0; i < ar.length; i++) {
    console.log(ar[i])
  }

  for(let i in ar) {
    console.log(ar[i]);
  }

  for(let v of ar) {
    console.log(v);
  }

  console.log('loop_list---------------end');
}


function read_json(){
  console.log('read_json---------------start');
  
  var data = require( "./file/input.json" );
  console.log(data);
  console.log(data[0].name);
  console.log(data[0].exam.math);
  
  console.log('抽出');
  var matchData = data.filter(function(item, index){
    if (item.name == "jiro") return true;
  });
  console.log(matchData[0].exam.lang); // =>50
  
  console.log('追加');
  var addData = { "name" : "shiro", "exam" : { "math" : 10, "lang" : 100 }, "grade" : "b" }
  data.push(addData);
  console.log(data);

  console.log('削除');
  var newData = data.filter(function(item, index){
    if (item.name != "jiro") return true;
  });
  data = newData;
  console.log(data);
  //「更新は削除」への「抽出の書き換え」の追加
  
  // ファイル出力
  var fs = require('fs');
  fs.writeFileSync('./file/output.json', JSON.stringify(data));

  console.log('read_json---------------end');
}

function if_sample(){
  console.log('if_sample---------------start');
  
  const conditions = 'B'
  if (conditions === 'A') {
      console.log('a')
  } else if (conditions === 'B') {
      console.log('b')
  } else {
      console.log('else')
  }

  console.log('if_sample---------------end');
}



function main() {

  console.log('ファイル操作=========================');
  read_json()

  console.log('基本=========================');
  if_sample()
  o = basic_async('input')
  // console.log(o);
  loop_list()

  console.log('HTTPリクエスト=========================');
  // loop_request()


}

main()
