package transaction.infrastructure.datasource.employee;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import transaction.domain.model.employee.Employee;
import transaction.domain.model.employee.EmployeeNumber;

@Mapper
public interface EmployeeMapper {

    List<Employee> selectEmployees();

    void insertEmployee(@Param("employee") Employee employee);

    void updateStatus(@Param("employeeNumber") EmployeeNumber employeeNumber);

}
