/*
    Employees Earning More Than Their Managers - Given a table Employee:
                                                        id : int        (id of the Employee)
                                                        name : varchar  (name of the Employee)
                                                        salary : int    (salary of the Employee)
                                                        managerId : int (id of the Employee's manager)
    write an sql query to find the employees who earn more than their manager.

    We look at two instances of the table at once, and any Employee is reported who's salary is bigger
    than their manager's.
*/

# Write your MySQL query statement below
SELECT e1.name as Employee from Employee as e1, Employee as e2
where e1.managerId = e2.id and e1.salary > e2.salary