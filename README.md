# nosql-razorpay
This is low level design interview problem asked by RazorPay.

The objective is to design and implement an in-memory SQL-like database, which should support the following set of operations/functionality:
    1. It should be possible to create or delete tables in a database.
    2. A table definition comprises of columns which have types. They can also have constraints.
    3. The supported column types are string and int.
    4. The string type can have a maximum length of 20 characters.
    5. The int type can have a minimum value of -1024 and a maximum value of 1024.
    6. It should be possible to insert records in a table.
    7. Support for NOT_NULL attribute against a column
    8. It should be possible to print all records in a table.
It should be possible to filter and display records whose column values match a given value.