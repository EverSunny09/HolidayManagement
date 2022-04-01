package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin", schema = "holiday_management")
public class AdminEntity {
    private int adminId;
    private Integer outstandingRequest;
    private Byte isActive;
    private EmployeeEntity employeeByEmployeeId;

    @Id
    @Column(name = "admin_id")
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "outstanding_request")
    public Integer getOutstandingRequest() {
        return outstandingRequest;
    }

    public void setOutstandingRequest(Integer outstandingRequest) {
        this.outstandingRequest = outstandingRequest;
    }

    @Basic
    @Column(name = "is_active")
    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminEntity that = (AdminEntity) o;

        if (adminId != that.adminId) return false;
        if (outstandingRequest != null ? !outstandingRequest.equals(that.outstandingRequest) : that.outstandingRequest != null)
            return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adminId;
        result = 31 * result + (outstandingRequest != null ? outstandingRequest.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    public EmployeeEntity getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(EmployeeEntity employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }
}
