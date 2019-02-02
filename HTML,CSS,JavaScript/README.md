# HTML,CSS,JavaScript

## 概要
覚書である。順次記載予定。

### HTML
- ヘッダ宣言部  
  - テンプレートとなる宣言方法
  - cssの外部ファイル化
  - JavaScriptの外部ファイル化
```
<!doctype html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>タイトル</title>
<link href="css/{ファイル名}.css" rel="stylesheet" type="text/css">
<script src="js/{ファイル名}.js"></script>
```

- ヘッダJavaScript部
  - scriptタグの書き方
  - JavaScript関数宣言
  - HTMLへの<h2\>埋め込み
  - HTMLへのテキストボックス埋め込み
  - if文
  - maxlength
```
<script language="javascript" type="text/javascript">
  function OnButtonClick(subtitle) {
    //HTMLへの埋め込み
    target = document.getElementById("subtitle");
    target.innerHTML = "<h2>"+subtitle+"</h2>";

    //変数初期化
    target = document.getElementById("div_tx_1");
    target.innerHTML = ''

    //HTMLへの埋め込み
    if (subtitle==='引数'){
      target = document.getElementById("div_tx_1");
      target.innerHTML = '<p>ラベル: <input type=\"text\" value=\"\" id=\"tx1-1\" maxlength=\"50\">'
    }
  }
</script>
```

- bodyh1部  
  - 独自ヘッダで囲むことで、CSSで独自カスタマイズを可能とする。
```
<header1>
<h1>h1タイトル</h1>
</header1>
```

- bodyul,li部  
  - ul, liタグによる項目表示
  - idをつけることで、CSSで独自カスタマイズを可能とする。
  - JavaScript関数利用方法
```
<ul id="menu">
  <li><a href="#">表示親項目1</a>
    <ul>
      <li><a href="javascript:OnButtonClick('{引数}');">表示項目1</a></li>
    </ul>
  </li>
  <li><a href="#">表示親項目2</a>
    <ul>
      <li><a href="javascript:OnButtonClick('{引数}');">表示項目2</a></li>
    </ul>
  </li>
</ul>
```

- body独自タグ部  
  - JavaScriptによる動的なHTML埋め込み場所の用意
  - idはJavaScriptで利用
  - <header2\>は、CSSで独自カスタマイズを可能とする。
```
<header2 id="subtitle">
</header2>
```

- body改行  
```
<br />
```

- body divタグ部  
  - idはJavaScriptで利用
```
<div id="div_tx_1"></div>
<div id="div_tbl_1"></div>
```


- body フッタタグ部  
  - <footer\>で、CSSで独自カスタマイズを可能とする。
  - addressタグ
```
<footer>
<address>コピーライトなどを記載</address>
</footer>
```

- body画像部  
  - 画像の埋め込み
  - 画像の右寄せ

```
<div style="text-align:right">
<img src="image/bk.png" class="inline">
</div>

```


### JavaScript

#### JavaScript
- コンソール出力
```
console.log("hello");
```

- for文
  - JSONの扱い
```
for(var index in req_datas.items){
  req_datas.items[index].key名1
  req_datas.items[index].key名2
  JSON.stringify(req_datas.items[index].key名2.nest1.nest2.
}
```

- 型変換
```
var x = Number(index) + 1
var num_str =String(x)
input_str = "myPieDlabelsChart" + num_str
```


#### jQuery

- HTTPリクエストGET
  - グローバル変数
  - JavaScript関数宣言
  - テキストボックス入力値の変数代入   
  - ajaxによるHTTPリクエスト 
  - HTMLの生成
  - レスポンスボディのJSONの扱い

```
APIURL = 'https://xxxx'

function https_get() {
  var path_param = document.getElementById("tx1-1").value;

  $.ajax({
    type: 'GET',
    url: APIURL + '/リソース/'+ path_param,
    headers: {"独自ヘッダkey":"独自ヘッダvalue"},
    req_datas: JSON.stringify(),
    success: function(req_datas) {
      //HTMLを初期化
      $("table.div_tbl_1 tbody").html("");

      //HTMLを生成
      $('<tr><th>ヘッダ名1</th>'+
        '<th>ヘッダ名2</th></tr>'
        ).appendTo('table.div_tbl_1 tbody');
      $('<tr>'+
      '<td>'+req_datas.{レスポンスJSONのkey1}+'</td>'+
      '<td>'+req_datas.{レスポンスJSONのkey2}+'</td>'+
      '</tr>').appendTo('table.div_tbl_1 tbody');
    }
  });
}
```

- HTTPリクエストPOST
  - ajaxによるHTTPリクエスト 
```
function https_post() {
  $.ajax({
    type: 'POST',
    url: APIURL + '/リソース/',
    headers: {"独自ヘッダkey":"独自ヘッダvalue"},
    req_datas: JSON.stringify(),
    success: function(req_datas) {
      //処理内容
    }
  });
}
```

- HTTPリクエストDELETE
  - グローバル変数
  - JavaScript関数宣言
  - テキストボックス入力値の変数代入   
  - ajaxによるHTTPリクエスト 
  - HTMLの生成
  - レスポンスボディのJSONの扱い
```
function https_delete() {
  $.ajax({
    type: 'DELETE',
    url: APIURL + '/リソース/'+ path_param,
    headers: {"独自ヘッダkey":"独自ヘッダvalue", "Content-Type":"application/json"},
    data: JSON.stringify({"key": value}),
    req_datas: JSON.stringify(),
    success: function(req_datas) {
      //処理内容
    }
  });
}
```


#### Chart.js

- HTMLヘッダ部  
```
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js"></script>
<script src="js/labeling-plugin.js"></script>
```

- HTMLbody部グラフ1  
  - classはcssで利用
  - idはnew Chartの引数に利用

```
<div class="parent" style="position: relative; width:20vw; height:30vh">
    <canvas id="id名ctx1" class="child"></canvas>
</div>
```

- js呼び出し部

```
var ctx = document.getElementById(input_str); 
var chart=new Chart(ctx,{
  type:'doughnut',
  data:{
       labels:["水準1","水準2","水準3"],
       datasets:[{label:"Sample",
       backgroundColor:["#66FF66","#F44336","#3F51B5"],
       data:[0,0,1]  //リスト部を変数にする
     }]
  },
  options:{
     title:{display:true,text: "タイトル文字列",position:"top",fontSize:20},
     responsive: true,            //*レスポンシブ
     maintainAspectRatio: false,  //*レスポンシブ trueまたはfalse
     pointLabelFontSize: 1,
     animation: {
         duration: 1000,  // アニメーションにかかる秒数(ミリ秒)
         //easing: 'easeOutBounce',  // アニメーションの種類
     },
  },
     plugins:[DataLabelPluginW],  //プラグイン起動
});

```

### CSS

- body
```
body{
	width:1200px;
	margin-right: auto;
	margin-left : auto;
	//margin: 20px;					/* bodyの外側の余白を指定する */
	padding: 50px 10px 50px 10px;	/* bodyの内側の余白を指定する */
  //background: linear-gradient(#05FBFF, #1D62F0 ) fixed;
	background-color: #ffffff;	/* ヘッダーの背景色を指定する */
  font-family: 'Lato', 'Noto Sans Japanese', '游ゴシック Medium', '游ゴシック体', 'Yu Gothic Medium', YuGothic, 'ヒラギノ角ゴ ProN', 'Hiragino Kaku Gothic ProN', 'メイリオ', Meiryo, 'ＭＳ Ｐゴシック', 'MS PGothic', sans-serif;
}
```

- 独自タグ
```
header1 {
	font-size: 130%;
	position: fixed;	/* ヘッダーを固定する */
	top: 0;				/* 上部から配置の基準位置を決める */
	//left: 0;			/* 左から配置の基準位置を決める */
	//width: 100%;		/* ヘッダーの横幅を指定する */
	height: 30px;		/* ヘッダーの高さを指定する */
	padding: 10px;		/* ヘッダー内側の余白を指定する(上下左右) */
	background-color: #000000;	/* ヘッダーの背景色を指定する */
	color: #ffffff;		/* ヘッダーのフォントの色を指定する */
	width:1200px;
	margin-right: auto;
	margin-left : auto;
}
```

- class指定
```
.button02{
     display:block;
     width: 120px;
     height:35px;
     line-height: 35px;
     color: #FFF;
     text-decoration: none;
     text-align: center;
     background-color: #000080; /*ボタン色*/
     border-radius: 5px; /*角丸*/
     -webkit-transition: all 0.5s;
     transition: all 0.5s;
}
.button02:hover{
     background-color: skyblue; /*ボタン色*/
}
```

- id指定(menu)
```
#menu, #menu ul {
	        margin: 0;
	        padding: 0;
	        list-style: none;
	}
```