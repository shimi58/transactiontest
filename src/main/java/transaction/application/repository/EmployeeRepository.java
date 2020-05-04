package transaction.application.repository;

import transaction.domain.model.employee.Employee;
import transaction.domain.model.employee.EmployeeNumber;
import transaction.domain.model.employee.Employees;

/**
 * 従業員リポジトリ
 */
public interface EmployeeRepository {

    Employees findEmployees();

    void registerEmployee(Employee employee);

    void registerNumber(EmployeeNumber employeeNumber);

}
