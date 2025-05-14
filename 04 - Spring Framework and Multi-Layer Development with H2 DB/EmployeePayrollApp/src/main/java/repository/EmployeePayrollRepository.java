package repository;

import model.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll, Long> {
}