import psycopg2


class BaseModel(object):
    def __init__(self):
        conn_string = "host='localhost' dbname='mydb' user='postgres' password='設定'"
        print ("Connecting to database\n ->%s" % (conn_string))

        self.conn = psycopg2.connect(conn_string)
        self.cur = self.conn.cursor()

    def execute(self, script):
        self.cur.execute(script)

    def select(self, script):
        self.cur.execute(script)
        results = self.cur.fetchall()
        return results

    def close(self):
        self.cur.close()
        self.conn.commit()
        self.conn.close()
