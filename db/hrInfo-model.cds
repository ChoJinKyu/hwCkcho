namespace hr;

entity Dept {
    key id : Integer;
    name : String;
    create_date : Date;
    employees : Association to many Employee on employees.dept = $self;
}


entity Employee {
    key id : Integer;
    name : String;
    salary : Integer64;
    dept : Association to Dept;
}
