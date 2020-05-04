package transaction.infrastructure.datasource.employee;

import org.springframework.stereotype.Repository;
import transaction.application.repository.EmployeeRepository;
import transaction.domain.model.employee.Employee;
import transaction.domain.model.employee.EmployeeNumber;
import transaction.domain.model.employee.Employees;

@Repository
public class EmployeeDataSource implements EmployeeRepository {
    EmployeeMapper mapper;

    public EmployeeDataSource(EmployeeMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Employees findEmployees() {

        return new Employees(mapper.selectEmployees());
    }


    @Override
    public void registerEmployee(Employee employee) {

        mapper.insertEmployee(employee);
    }
    @Override
    public void registerNumber(EmployeeNumber employeeNumber) {

        mapper.updateStatus(employeeNumber);
    }


}
