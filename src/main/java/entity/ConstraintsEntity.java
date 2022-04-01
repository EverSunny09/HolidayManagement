package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "constraints", schema = "holiday_management")
public class ConstraintsEntity {
    private int constraintId;
    private String constraint;
    private Collection<RequestWithConstraintEntity> requestWithConstraintsByConstraintId;

    @Id
    @Column(name = "constraint_id")
    public int getConstraintId() {
        return constraintId;
    }

    public void setConstraintId(int constraintId) {
        this.constraintId = constraintId;
    }

    @Basic
    @Column(name = "constraint")
    public String getConstraint() {
        return constraint;
    }

    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConstraintsEntity that = (ConstraintsEntity) o;

        if (constraintId != that.constraintId) return false;
        if (constraint != null ? !constraint.equals(that.constraint) : that.constraint != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = constraintId;
        result = 31 * result + (constraint != null ? constraint.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "constraintsByContraintId")
    public Collection<RequestWithConstraintEntity> getRequestWithConstraintsByConstraintId() {
        return requestWithConstraintsByConstraintId;
    }

    public void setRequestWithConstraintsByConstraintId(Collection<RequestWithConstraintEntity> requestWithConstraintsByConstraintId) {
        this.requestWithConstraintsByConstraintId = requestWithConstraintsByConstraintId;
    }
}
