package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "role", schema = "holiday_management")
public class RoleEntity {
    private int roleId;
    private String name;
    private Collection<EmployeeEntity> employeesByRoleId;

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (roleId != that.roleId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<EmployeeEntity> getEmployeesByRoleId() {
        return employeesByRoleId;
    }

    public void setEmployeesByRoleId(Collection<EmployeeEntity> employeesByRoleId) {
        this.employeesByRoleId = employeesByRoleId;
    }
}
