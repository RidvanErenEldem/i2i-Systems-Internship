Create table HR.EMP AS (Select * from HR.employees where 3=5);

select * from HR.EMP

INSERT INTO HR.EMP (employee_Id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
values (100, 'Rýdvan', 'Eldem', 'ridvaneren2012', '507.867.3368', TO_DATE('27/07/2021', 'dd/mm/yyyy'), 'IT_PROG', 24000, 0.9, 100, 60)

select * from HR.EMP

UPDATE HR.EMP set phone_number = '543.867.1999', salary = 100000 where employee_Id = 100

select * from HR.EMP

DELETE FROM HR.EMP WHERE employee_Id = 100

Drop table HR.EMP