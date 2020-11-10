using hr from '../db/hrInfo-model';

service HrInfoService {
    entity Depts as projection on hr.Dept;
    entity Employees as projection on hr.Employee;
}