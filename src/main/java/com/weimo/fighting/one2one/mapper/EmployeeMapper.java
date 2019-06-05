package com.weimo.fighting.one2one.mapper;

import com.weimo.fighting.one2one.model.Employee;

public interface EmployeeMapper {
    Employee selectEmployeeById(String id);
}
