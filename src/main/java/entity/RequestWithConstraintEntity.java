package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "request_with_constraint", schema = "holiday_management")
public class RequestWithConstraintEntity {
    private int requestWithConstraintId;
    private HolidayRequestEntity holidayRequestByHolidayRequestId;
    private ConstraintsEntity constraintsByContraintId;

    @Id
    @Column(name = "request_with_constraint_id")
    public int getRequestWithConstraintId() {
        return requestWithConstraintId;
    }

    public void setRequestWithConstraintId(int requestWithConstraintId) {
        this.requestWithConstraintId = requestWithConstraintId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestWithConstraintEntity that = (RequestWithConstraintEntity) o;

        if (requestWithConstraintId != that.requestWithConstraintId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return requestWithConstraintId;
    }

    @ManyToOne
    @JoinColumn(name = "holiday_request_id", referencedColumnName = "holiday_request_id")
    public HolidayRequestEntity getHolidayRequestByHolidayRequestId() {
        return holidayRequestByHolidayRequestId;
    }

    public void setHolidayRequestByHolidayRequestId(HolidayRequestEntity holidayRequestByHolidayRequestId) {
        this.holidayRequestByHolidayRequestId = holidayRequestByHolidayRequestId;
    }

    @ManyToOne
    @JoinColumn(name = "contraint_id", referencedColumnName = "constraint_id")
    public ConstraintsEntity getConstraintsByContraintId() {
        return constraintsByContraintId;
    }

    public void setConstraintsByContraintId(ConstraintsEntity constraintsByContraintId) {
        this.constraintsByContraintId = constraintsByContraintId;
    }
}
