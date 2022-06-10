/*
    Combine Two Tables - Given two tables, Person:
                                            personId : int      (Id of a Person)
                                            lastName : varchar  (A Person's last name)
                                            firstName : varchar (A Person's first name)

                                           and Address:
                                            addressId : int     (Id of a Person's address)
                                            personId : int      (Id a of Person)
                                            city : varchar      (The city a Person lives in)
                                            state : varchar     (The state a Person lives in)
    write an sql query that gives the first name, last name, city, and state of each Person
    in the Person table. If the address of a personId does not exist of the Address table,
    report null instead.

    We do a left join to ensure that all rows in the Person table are including, no matter
    if a personId does not exist in the Address table.
*/

# Write your MySQL query statement below
SELECT firstName, lastName, city, state from Person
left join Address on Person.personId = Address.personId