Class Employee {

string name;

 int age;

 float salary;

public : string getName();

void setName(string name);

 int getAge();

void setAge(int age);

float getSalary();

void setSalary(float salary);

 };

Employee employee;

 //Is 'employee' an object or a data structure? Why?
 /***
    * Employee class is a blueprint for creating objects.
    *The class Employee contains attributes (name, age, salary) and methods (getters and setters for these attributes).
    *employee is an object of the Employee class.
    *An object is an instance of a class, created by declaring a variable of the class type (Employee employee;).
    *Objects can hold both data (attributes) and behavior (methods).
    *A data structure typically refers to an organization of data, but without associated methods (functions).
    *Since employee has both data and methods, it is an object, not just a data structure.
  */