import psycopg2
from base_model import BaseModel


def main():
    model = BaseModel()

    print('select----start')
    res = model.select('SELECT * FROM weather;')
    print(res)

    model.execute('INSERT INTO weather (city, temp_lo, temp_hi, prcp, date) VALUES (\'a\', 1, 1, 3.5, \'1961-06-16\');')
    model.execute('INSERT INTO weather (city, temp_lo, temp_hi, prcp, date) VALUES (\'b\', 2, 2, 3.5, \'1961-06-16\');')
    model.execute('UPDATE weather SET temp_lo=20 WHERE temp_hi=2;')
    model.execute('DELETE FROM weather WHERE temp_lo=20;')

    print('select----end')
    res = model.select('SELECT * FROM weather;')
    print(res)

    model.close()

if __name__ == "__main__":
    main()