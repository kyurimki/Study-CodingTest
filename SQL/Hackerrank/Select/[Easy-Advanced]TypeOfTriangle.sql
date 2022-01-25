select if(a+b > c and a+c > b and b+c > a, if(a=b and b=c, 'Equilateral', if(a=b or b=c or c=a, 'Isosceles', 'Scalene')), 'Not A Triangle')
from triangles;