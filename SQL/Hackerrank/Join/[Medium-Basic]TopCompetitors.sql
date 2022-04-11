select H.hacker_id, H.name
from submissions S
join challenges C on S.challenge_id = C.challenge_id
join difficulty D on C.difficulty_level = D.difficulty_level
join hackers H on S.hacker_id=H.hacker_id
where D.score=S.score and D.difficulty_level=C.difficulty_level
group by H.hacker_id, H.name
having count(H.hacker_id) > 1
order by count(H.hacker_id) desc, H.hacker_id asc;