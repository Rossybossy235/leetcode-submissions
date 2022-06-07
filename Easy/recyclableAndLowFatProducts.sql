/*
 * Recyclable and Low Fat Products - given a table Products consisting of:
                                                product_id: int
                                                low_fats: enum
                                                recyclable: enum
    where low_fats and recycle are either 'Y' or 'N' for yes and no,
    write an sql query to find the ids of products that are both low fat
    and recyclable.

    This query is about as simple as it gets. Good sql refresher.
*/

# Write your MySQL query statement below
SELECT product_id from Products
where low_fats = 'Y' and recyclable = 'Y'