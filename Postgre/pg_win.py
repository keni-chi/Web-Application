#!/usr/bin/python
import psycopg2
import sys


def main():
    #Define our connection string
    conn_string = "host='localhost' dbname='mydb' user='postgres' password='設定'"

    # print the connection string we will use to connect
    print ("Connecting to database\n ->%s" % (conn_string))

    # get a connection, if a connect cannot be made an exception will be raised here
    conn = psycopg2.connect(conn_string)

    # conn.cursor will return a cursor object, you can use this cursor to perform queries
    print ("Connected!\n")

    # excexute sql
    cur = conn.cursor()

    print('select----start')
    cur.execute('SELECT * FROM weather;')
    results = cur.fetchall()
    print(results)

    cur.execute('INSERT INTO weather (city, temp_lo, temp_hi, prcp, date) VALUES (\'a\', 1, 1, 3.5, \'1961-06-16\');')
    cur.execute('INSERT INTO weather (city, temp_lo, temp_hi, prcp, date) VALUES (\'b\', 2, 2, 3.5, \'1961-06-16\');')
    cur.execute('UPDATE weather SET temp_lo=20 WHERE temp_hi=2;')
    cur.execute('DELETE FROM weather WHERE temp_lo=20;')

    print('select----end')
    cur.execute('SELECT * FROM weather;')
    results = cur.fetchall()
    print(results)

    cur.close()
    conn.commit()
    conn.close()


if __name__ == "__main__":
    main()