package transaction.domain.model.employee;

import lombok.Data;

/**
 * 従業員件数
 */
@Data
public class EmployeeNumber {

    Integer value;

    public EmployeeNumber(int value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
