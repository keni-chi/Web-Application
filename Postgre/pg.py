import psycopg2


# connect postgreSQL
users = 'myname'
dbnames = 'mydb'
passwords = '設定'
conn = psycopg2.connect(" user=" + users +" dbname=" + dbnames +" password=" + passwords)

# excexute sql
cur = conn.cursor()
cur.execute('SELECT * FROM weather;')
results = cur.fetchall()

#output result
print(results)

cur.close()
conn.close()
