--10. List the emps who are working under any Manager.
Select * from emp where mgr is not null

--11. List all the Clerks of Deptno 20.
select ename ,job from emp where deptno=30 and job in 'CLERK'

--12. Display the details of SMITH.
select * from emp where ename in 'SMITH'
