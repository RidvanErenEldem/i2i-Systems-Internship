select e.employee_Id, e.manager_Id from HR.employees e join HR.employees m on e.manager_id = m.employee_id