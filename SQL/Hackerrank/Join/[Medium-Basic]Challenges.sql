select h.hacker_id, h.name, count(*) as challenges_created
from hackers as h
join
challenges as c
on h.hacker_id = c.hacker_id
group by h.hacker_id, h.name
having challenges_created = (select count(*) from challenges group by hacker_id order by count(*) desc limit 1)
or challenges_created in (select challenges_created from (
    select count(*) as challenges_created from challenges group by hacker_id
    ) as cc group by challenges_created having count(challenges_created) = 1)
order by challenges_created desc, h.hacker_id;