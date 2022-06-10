/*
 * Find Total Time Spent By Each Employee - Given a database Employees:
                                                emp_id : int        (Employee id)
                                                event_day : date    (Date of work day)
                                                in_time : int       (Arrival time)
                                                out_time : int      (Departure time)
    write an sql query to determine the total time spent by each employee on each
    day at the office. Employees can have more than one entry and exit on a given day.
*/

# Write your MySQL query statement below
SELECT event_day as day, emp_id, sum(out_time - in_time) as total_time from Employees
group by event_day, emp_id