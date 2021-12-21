select co.continent, floor(avg(ci.population))
from country as co
join city as ci on co.code = ci.countrycode
group by co.continent;