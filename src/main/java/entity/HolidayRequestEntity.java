package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "holiday_request", schema = "holiday_management")
public class HolidayRequestEntity {
    private int holidayRequestId;
    private Byte noConstraintTime;
    private Timestamp requestTime;
    private Byte breakingConstraints;
    private String reason;
    private Integer totalDays;
    private Date fromDate;
    private Date toDate;
    private Integer priority;
    private EmployeeEntity employeeByEmployeeId;
    private RequestStatusEntity requestStatusByRequestStatusId;
    private Collection<RequestWithConstraintEntity> requestWithConstraintsByHolidayRequestId;

    @Id
    @Column(name = "holiday_request_id")
    public int getHolidayRequestId() {
        return holidayRequestId;
    }

    public void setHolidayRequestId(int holidayRequestId) {
        this.holidayRequestId = holidayRequestId;
    }

    @Basic
    @Column(name = "no_constraint_time")
    public Byte getNoConstraintTime() {
        return noConstraintTime;
    }

    public void setNoConstraintTime(Byte noConstraintTime) {
        this.noConstraintTime = noConstraintTime;
    }

    @Basic
    @Column(name = "request_time")
    public Timestamp getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Timestamp requestTime) {
        this.requestTime = requestTime;
    }

    @Basic
    @Column(name = "breaking_constraints")
    public Byte getBreakingConstraints() {
        return breakingConstraints;
    }

    public void setBreakingConstraints(Byte breakingConstraints) {
        this.breakingConstraints = breakingConstraints;
    }

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "total_days")
    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    @Basic
    @Column(name = "from_date")
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Basic
    @Column(name = "to_date")
    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Basic
    @Column(name = "priority")
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HolidayRequestEntity that = (HolidayRequestEntity) o;

        if (holidayRequestId != that.holidayRequestId) return false;
        if (noConstraintTime != null ? !noConstraintTime.equals(that.noConstraintTime) : that.noConstraintTime != null)
            return false;
        if (requestTime != null ? !requestTime.equals(that.requestTime) : that.requestTime != null) return false;
        if (breakingConstraints != null ? !breakingConstraints.equals(that.breakingConstraints) : that.breakingConstraints != null)
            return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (totalDays != null ? !totalDays.equals(that.totalDays) : that.totalDays != null) return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (toDate != null ? !toDate.equals(that.toDate) : that.toDate != null) return false;
        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = holidayRequestId;
        result = 31 * result + (noConstraintTime != null ? noConstraintTime.hashCode() : 0);
        result = 31 * result + (requestTime != null ? requestTime.hashCode() : 0);
        result = 31 * result + (breakingConstraints != null ? breakingConstraints.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (totalDays != null ? totalDays.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (toDate != null ? toDate.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "request_status_id", referencedColumnName = "request_status_id")
    public RequestStatusEntity getRequestStatusByRequestStatusId() {
        return requestStatusByRequestStatusId;
    }

    public void setRequestStatusByRequestStatusId(RequestStatusEntity requestStatusByRequestStatusId) {
        this.requestStatusByRequestStatusId = requestStatusByRequestStatusId;
    }

    @OneToMany(mappedBy = "holidayRequestByHolidayRequestId")
    public Collection<RequestWithConstraintEntity> getRequestWithConstraintsByHolidayRequestId() {
        return requestWithConstraintsByHolidayRequestId;
    }

    public void setRequestWithConstraintsByHolidayRequestId(Collection<RequestWithConstraintEntity> requestWithConstraintsByHolidayRequestId) {
        this.requestWithConstraintsByHolidayRequestId = requestWithConstraintsByHolidayRequestId;
    }
}
