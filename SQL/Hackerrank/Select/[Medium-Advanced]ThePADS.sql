select concat(Name, '(', substr(Occupation, 1, 1), ')')
from occupations
order by name;

select concat('There are a total of ', count(Occupation), ' ', lower(Occupation), 's.')
from occupations
group by Occupation
order by count(Occupation), Occupation;