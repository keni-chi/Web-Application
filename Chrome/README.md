# Chrome

## 概要
覚書である。順次記載予定。

### ブラウザのセキュリティ回避
1. chromeのショートカット作成
1. 右クリックし、ショートカットタブのリンク先について、「～～chrome.exe"」の後に以下を追記。  

※以下例だとmychromeフォルダを事前に作成しておくこと。

```  
chrome.exe" --user-data-dir=c:\mychrome --disable-web-security
```  
  
- 備考：　昔は --disable-web-securityの追記だけでよかったみたいだが、最近は駄目。