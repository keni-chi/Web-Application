# Postgre

## 概要
覚書である。順次記載予定。

## docker
docker run -it --entrypoint "/bin/bash" ubuntu:latest


## Ubuntu 20.04　へのインストール

ステップ1— PostgreSQLのインストール
    sudo apt update
    sudo apt install postgresql


ステップ2 — postgresユーザでログインできるようにパスワードを設定
    sudo passwd postgres

ステップ3 — postgresユーザーになり、 createdb コマンドでデータベースを作る
    su postgres
    /etc/init.d/postgresql restart
    createdb mydb

ステップ4 — psqlコマンドでmydbに接続する
    psql mydb

ステップ5 — CREATE ROLE SQLコマンドで新規ユーザを作成し、データベースを操作できるようにする
    CREATE ROLE myname WITH LOGIN;

ステップ6 — PostgreSQLを切断し、さきほど設定した新規ユーザで再度PostgreSQLに接続
    mydb=# \q
    $ exit
        adduser myname
        gpasswd -a myname sudo
        su myname
    psql mydb


ステップ7 ー テーブル作成
CREATE TABLE weather (
    city            varchar(80),
    temp_lo         int,           -- 最低気温
    temp_hi         int,           -- 最高気温
    prcp            real,          -- 降水量
    date            date
);
INSERT INTO weather (city, temp_lo, temp_hi, prcp, date) VALUES ('a', 1, 2, 3.5, '1961-06-16');
select * from weather;

ステップ8 ー テーブル一覧確認
    ¥dt

ステップ9 Pythonインストール
    rootユーザに戻る
    sudo apt update
    sudo apt -y upgrade
    sudo apt install build-essential libbz2-dev libdb-dev \
        #ビルド環境の準備
        libreadline-dev libffi-dev libgdbm-dev liblzma-dev \
        libncursesw5-dev libsqlite3-dev libssl-dev \
        zlib1g-dev uuid-dev tk-dev
        # wgetをインストール
        apt-get update && apt-get install -y wget
    wget https://www.python.org/ftp/python/3.8.10/Python-3.8.10.tar.xz
    tar xJf Python-3.8.10.tar.xz
        # ビルド
        cd Python-3.8.10
        ./configure
        make
        sudo make install
    python3 -V
    python3 -m venv .venv
    source ./.venv/bin/activate
    sudo apt install libpq-dev
    pip install psycopg2

ステップ10 コーディング
    rootになる
    apt-get install vim
    su myname
    source ./.venv/bin/activate
    python pg.py
        ※OS側のユーザー名とPostgreSQL側のユーザー名が一致していないと発生するエラー
        https://command-f.tech/postgresql/1



## 参考
[Ubuntu 20.04にPostgreSQLをインストールする方法 ](https://www.digitalocean.com/community/tutorials/how-to-install-postgresql-on-ubuntu-20-04-quickstart-ja)
[Windows 10 HomeへのDocker Desktop](https://qiita.com/zaki-lknr/items/db99909ba1eb27803456)
[ubuntuでPostgreSQLの初期設定まで](https://chanyoshi.hatenablog.com/entry/2018/10/13/072244)
