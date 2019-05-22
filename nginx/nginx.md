
### 基本
コンテナを立ち上げます
  $ docker run -d -p 8080:80 --name webserver nginx
コンテナ内に入ります。
  $ docker exec -it webserver /bin/bash
http://localhost:8080


### 独自のページを表示してみる
├── Dockerfile
└── html
    ├── index.html
    └── piyo.html

まずは、イメージの作成
docker build --tag simple-nginx .

イメージの確認
docker images -a simple-nginx

docker ps -a
docker stop {コンテナ}
docker rm {コンテナ}
docker images
docker rmi {イメージ}

docker build --tag simple-nginx .
docker run -d --name simple-nginx-container -p 8080:80 simple-nginx

http://localhost:8080/piyo.html

### docker-compose
docker-compose up -d


## 参考
[docker の nginx イメージの設定ファイルを眺めながら、独自ページを表示します。](https://qiita.com/mochizukikotaro/items/1d28888b78f401227ed6)  
[Docker入門 Nginxを動かしてみる](https://qiita.com/mtakehara21/items/d7be42cf12772f3ada25)
