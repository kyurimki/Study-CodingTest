select if(g.grade<8, "NULL", s.name), g.grade, s.marks
from students as s
join grades as g
where s.marks between min_mark and max_mark
order by g.grade desc, s.name, s.marks;