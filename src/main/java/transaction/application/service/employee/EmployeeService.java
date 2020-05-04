package transaction.application.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transaction.application.repository.EmployeeRepository;
import transaction.domain.model.employee.Employee;
import transaction.domain.model.employee.EmployeeNumber;
import transaction.domain.model.employee.Employees;

/**
 * 従業員サービス
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    /**
     * 従業員一覧取得
     */
    public Employees findEmployees() {
        return employeeRepository.findEmployees();
    }



    /**
     * 従業員登録
     */
    @Transactional
    public EmployeeNumber register(Employee employee) {

        employeeRepository.registerEmployee(employee);
        Employees employees = employeeRepository.findEmployees();

        EmployeeNumber employeeNumber = employees.number();
        employeeRepository.registerNumber(employeeNumber);

        return employeeNumber;

    }

}
