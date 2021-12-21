select w.id, p.age, c.coins_needed, w.power
from (select code, min(coins_needed) as coins_needed, power from wands group by code, power) as c
join wands as w on c.code = w.code and c.power = w.power and c.coins_needed = w.coins_needed
join wands_property as p on p.code = w.code
where p.is_evil = 0
order by w.power desc, p.age desc;