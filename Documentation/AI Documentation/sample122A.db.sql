SELECT DISTINCT r.name, b.branch_number, city, state, count(DISTINCT oc.order_id), round(avg(order_total),3)
    FROM Branch b
    INNER JOIN Occupies oc ON oc.branch_number=b.branch_number
    INNER JOIN "order" o ON o.order_id=oc.order_id
    INNER JOIN Restaurant r ON r.restaurant_id=b.restaurant_id
    GROUP BY b.branch_number, r.restaurant_id
    having avg(order_total)>60