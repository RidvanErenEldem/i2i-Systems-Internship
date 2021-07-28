select SUBSTR(PHONE_NUMBER, 1, 3) AS "Operator", Count(*) as "Total" from HR.employees GROUP BY Substr(phone_number,1 ,3)

select * from
(
    select SUBSTR(PHONE_NUMBER, 1, 3) AS "Operator" from HR.employees
)
pivot
(
    count(*)
    for "Operator" in (515, 590, 603, '011' as "011", 650)
)
