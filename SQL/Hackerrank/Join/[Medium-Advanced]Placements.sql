select s.name from students as s
join (select x.id, y.salary from (select f1.id, f1.friend_id, p1.salary from friends as f1
join packages as p1 on f1.id = p1.id) as x
join (select f2.friend_id, p2.salary from friends as f2
     join packages as p2 on f2.friend_id = p2.id) as y
on x.friend_id = y.friend_id where x.salary < y.salary) as z
on s.id = z.id order by z.salary;