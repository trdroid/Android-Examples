# SQLite

SQLite can be used to manage Android's application state. 


## SQLiteDatabase class

<http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html>

Categorizing the methods of SQLiteDatabase class


* Querying the database
* create, manage or delete the database file (although a convenient class to handle this is SQLiteOpenHelper)

**Querying the database**

The following table shows the possible arguments to the *query()* methods (including overloaded ones) on an instance of *SQLiteDatabase* class.

| Arguments        | Description |
| ------------- |:-------------|
| cursorFactory | allows to plugin custom implementations of the cursor |
| distinct |  on distinct, a query selects the rows that match the selection criteria and returns only distinct row instances, distinct on the values of the specified columns eg. SELECT DISTINCT  |
| table     | name of the table being queried, in FROM clause |
| columns      | names of the columns that need to be included in the result eg. SELECT COLUMNS | 
| selection, selectionArgs | conditions on which data has to be filtered eg. WHERE column1=x AND column2=y |
| groupBy |  GROUP BY clause | 
| having | HAVING clause |
| orderBy | ORDER BY clause |
| limit | LIMIT |
| cancellationSignal | a CancellationSignal instance provides the ability to cancel the query in progress to which it is passed |

The following SQL statement 

```sql
	SELECT name, address
		FROM publisher
		WHERE country = "USA"
		HAVING max(book.price) > 100
		ORDER BY id ASC
		LIMIT 10
```

is equivalent to calling the following *query()* method on an instance of *SQLiteDatabase* class.

```java
	SQLiteDatabase db = ..
	
	Cursor cursor = db.query(
						"publisher",
						new String[] {"name", "address"},
						"country = ?",
						new String[] {"USA"},
						null, //groupBy
						null, //having
						"id ASC");
```



The following SQL statement

```sql
	SELECT publisher.name, max(book.price)
		FROM publisher, book
		WHERE publisher.id = book.publisher_id AND publisher.country = "USA"
		GROUP BY publisher.name
		HAVING max(book.price) > 100
		ORDER BY publisher.name ASC
		LIMIT 10
```

is equivalent to calling the following *query()* method on an instance of *SQLiteDatabase* class.


**Foreign Keys**

On >= API 7 & < API 16, a foreign key constraint can be created by executing the pragma, "PRAGMA foreign_keys=true"

On >= API 16, SQLite's foreign key constraints are disabled by default, however they can be enabled by using the *setForeignKeyConstraintsEnabled()* method

**Transactions**

Transactions can be programmed in the following way using an instance of *SQLiteDatabase* class

```java
SQLiteDatabase db = ..

db.beginTransaction();

try {
	// call methods on db to execute SQL against the local database
	
	//Explicitly set the transaction as successful, else it is rolled back
	db.setTransactionSuccessful();
} finally {
	db.endTransaction();
}
```




