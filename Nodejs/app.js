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
  
  for (var i = 0; i < 3; i++ ){
    // 繰り返し処理
    console.log('loop' + i + '---start');
    async_request()
    console.log('loop' + i + '---end');
  }

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


function main() {

  o = basic_async('input')
  console.log(o);
  // loop_request()
  loop_list()

}

main()
