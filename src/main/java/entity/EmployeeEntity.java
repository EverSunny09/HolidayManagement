package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "employee", schema = "holiday_management")
public class EmployeeEntity {
    private int employeeId;
    private String firstName;
    private String lastName;
    private Date dob;
    private Date dateOfJoining;
    private Long phoneNo;
    private String email;
    private Integer holidaysRemaining;
    private String password;
    private Collection<AdminEntity> adminsByEmployeeId;
    private DepartmentEntity departmentByDepartmentId;
    private RoleEntity roleByRoleId;
    private Collection<HolidayRequestEntity> holidayRequestsByEmployeeId;

    @Id
    @Column(name = "employee_id")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "dob")
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "date_of_joining")
    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Basic
    @Column(name = "phone_no")
    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "holidays_remaining")
    public Integer getHolidaysRemaining() {
        return holidaysRemaining;
    }

    public void setHolidaysRemaining(Integer holidaysRemaining) {
        this.holidaysRemaining = holidaysRemaining;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (employeeId != that.employeeId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (dob != null ? !dob.equals(that.dob) : that.dob != null) return false;
        if (dateOfJoining != null ? !dateOfJoining.equals(that.dateOfJoining) : that.dateOfJoining != null)
            return false;
        if (phoneNo != null ? !phoneNo.equals(that.phoneNo) : that.phoneNo != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (holidaysRemaining != null ? !holidaysRemaining.equals(that.holidaysRemaining) : that.holidaysRemaining != null)
            return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (dateOfJoining != null ? dateOfJoining.hashCode() : 0);
        result = 31 * result + (phoneNo != null ? phoneNo.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (holidaysRemaining != null ? holidaysRemaining.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId")
    public Collection<AdminEntity> getAdminsByEmployeeId() {
        return adminsByEmployeeId;
    }

    public void setAdminsByEmployeeId(Collection<AdminEntity> adminsByEmployeeId) {
        this.adminsByEmployeeId = adminsByEmployeeId;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    public DepartmentEntity getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(DepartmentEntity departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId")
    public Collection<HolidayRequestEntity> getHolidayRequestsByEmployeeId() {
        return holidayRequestsByEmployeeId;
    }

    public void setHolidayRequestsByEmployeeId(Collection<HolidayRequestEntity> holidayRequestsByEmployeeId) {
        this.holidayRequestsByEmployeeId = holidayRequestsByEmployeeId;
    }
}
