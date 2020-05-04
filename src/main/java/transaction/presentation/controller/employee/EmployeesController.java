package transaction.presentation.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import transaction.application.service.employee.EmployeeService;
import transaction.domain.model.employee.Employee;
import transaction.domain.model.employee.EmployeeNumber;
import transaction.domain.model.employee.Employees;

/**
 * 従業員Controller
 */
@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    EmployeeService employeeService;


    /**
     * 従業員一覧取得
     */
    @RequestMapping(value = "/list")
    public String employees() {

        Employees employees = employeeService.findEmployees();

        return employees.toString();


    }

    /**
     * 従業員登録
     */
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public String regist(@RequestBody Employee employee) {

        EmployeeNumber employeeNumber = new EmployeeNumber(0);

        try {
            employeeNumber = employeeService.register(employee);
        } catch (Exception e) {

            System.out.println("処理エラー");
        }
        return employeeNumber.toString();


    }
}
