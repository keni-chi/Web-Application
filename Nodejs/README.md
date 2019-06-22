## Nodejs

## 概要
覚書である。順次記載予定。

### 環境構築
npm ls -g
npm install -g request

- Node.js実行時にモジュールを探すパス①にグローバルインストールしたモジュールが格納されるディレクトリ②が追加されていない場合にこうなるらしいことがわかった。
  - 1  
  node -e "console.log(global.module.paths)"
  - 2  
  npm root -g

- ホームディレクトリにある~/.bash_profileにグローバルなパスを追加する  
echo export NODE_PATH=$(npm root -g) >> ~/.bash_profile  
source ~/.bash_profile  



## 参考
[JavaScriptの同期、非同期、コールバック、プロミス辺りを整理してみる](https://qiita.com/YoshikiNakamura/items/732ded26c85a7f771a27)
[npm install -gでグローバルインストールしたのに見つけてくれない](https://qiita.com/chkk525@github/items/ea1c2a110bf74efd843c)
