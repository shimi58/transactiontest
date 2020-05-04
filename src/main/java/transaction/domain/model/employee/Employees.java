package transaction.domain.model.employee;

import java.util.List;

/**
 * 従業員一覧
 */
public class Employees {
    List<Employee> list;

    public Employees(List<Employee> list) {
        this.list = list;
    }

    public List<Employee> list() {
        return list;
    }

    public String toString() {
        return list.toString();
    }

    public EmployeeNumber number() {
        return new EmployeeNumber(list.size());
    }


}
