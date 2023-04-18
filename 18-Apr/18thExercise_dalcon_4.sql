--To write a  Cursor to display the list of employees who are Working as a Managers or Analyst.
set serveroutput on;
declare
    emprec emp%rowtype;
    cursor mycur is select * from emp where JOB IN ('MANAGER','ANALYST');
begin
    open mycur;
    loop
    fetch mycur into emprec;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(emprec.empno || '     ' || emprec.ename || '    ' || emprec.deptno || emprec.job); 
    end loop;
    close mycur;
end;
/

--Write PL/SQL code in Cursor to display employee names and aalary

set serveroutput on;
declare
    emprec emp%rowtype;
    cursor mycur is select * from emp;
begin
    open mycur;
    loop
    fetch mycur into emprec;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(emprec.empno || '     ' || emprec.sal ); 
    end loop;
    close mycur;
end;
/

--Write PL/SQL code in Procedure to find the Reverse of the  number
set serveroutput on;
declare
getnum number := &number;
revnum varchar2(20);
begin
    for i in reverse 1..length(getnum) loop
        revnum := revnum || to_char(i);
    end loop;
   dbms_output.put_line(' reverse num is ' || revnum);   
end;
/



set serveroutput on;

declare
    no1 varchar(64):=&number1;
    len1 int;
    result1 varchar2(64);
begin
    len1:=length(no1);
    dbms_output.put_line(len1);

    for i in reverse 1..len1 loop
        result1 := result1 || substr(no1,i,1);
    end loop;
    dbms_output.put_line(result1);
end;
/



--Parameter list
set serveroutput on;
declare
emprec emp%rowtype;
cursor mycur(role varchar) is select * from emp where job in(role);
begin
    open mycur('MANAGER');
    loop
    fetch mycur into emprec;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(emprec.ename || '    ' || emprec.sal); 
    end loop;
    close mycur;
    open mycur('ANALYST');
    loop
    fetch mycur into emprec;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(emprec.ename || '    ' || emprec.sal); 
    end loop;
    close mycur;
end;
/



    