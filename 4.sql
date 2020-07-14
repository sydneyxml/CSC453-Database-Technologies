--Ximan Liu
--CSC 453
--HW4
--Q4


DROP TABLE CONTRACT CASCADE CONSTRAINTS; 
DROP TABLE TASK CASCADE CONSTRAINTS; 


CREATE TABLE TASK (
TaskID CHAR(3),
TaskName VARCHAR(20),
ContractCount NUMERIC(1,0) DEFAULT 0, 
CONSTRAINT PK_TASK PRIMARY KEY (TaskID)
);


CREATE TABLE CONTRACT (
TaskID CHAR(3),
WorkerID CHAR(7),
Payment NUMERIC(6,2),
CONSTRAINT PK_CONTRACT PRIMARY KEY (TaskID, WorkerID),
CONSTRAINT FK_CONTRACTTASK FOREIGN KEY (TaskID) REFERENCES TASK (TaskID) 
);


INSERT INTO TASK (TaskID, TaskName) VALUES ('333', 'Security' );
INSERT INTO TASK (TaskID, TaskName) VALUES ('322','Infrastructure');
INSERT INTO TASK (TaskID, TaskName) VALUES ('896', 'Compliance' );


SELECT * FROM TASK;
COMMIT; 


--NewContract Trigger
create or replace trigger NewContract
before insert on CONTRACT for each row
declare
contract_Count number;
begin
select ContractCount into contract_Count from Task
where TaskID = :new.TaskID;
if contract_Count = 3 then
raise_application_error(-20111, 'Error: The task is full');
else
update Task
set ContractCount = contract_Count+1
where TaskID = :new.TaskID;
end if;
end;
/


--EndContract Trigger
create or replace trigger EndContract
after delete on Contract
for each row
begin
update Task
set ContractCount = (select ContractCount from Task where TaskID = :old.TaskID) - 1
where TaskId = :old.TaskID;
end;
/


--NoChanges Trigger
create or replace trigger NoChanges
before update on CONTRACT
begin
raise_application_error(-20111, 'Error: No Updates are permitted to existing rows of CONTRACT');
rollback;
end;
/


insert into CONTRACT (TASKID, WORKERID, PAYMENT) values(333, 1111111, 100);
insert into CONTRACT (TASKID, WORKERID, PAYMENT) values(333, 2222222, 200);
insert into CONTRACT (TASKID, WORKERID, PAYMENT) values(333, 3333333, 300);
insert into CONTRACT (TASKID, WORKERID, PAYMENT) values(333, 4444444, 400);


delete from CONTRACT where TASKID = 333 and WORKERID = 3333333;


update CONTRACT set PAYMENT = 500 where TASKID = 333 and WORKERID = 1111111;

