package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "request_status", schema = "holiday_management")
public class RequestStatusEntity {
    private int requestStatusId;
    private String status;
    private Collection<HolidayRequestEntity> holidayRequestsByRequestStatusId;

    @Id
    @Column(name = "request_status_id")
    public int getRequestStatusId() {
        return requestStatusId;
    }

    public void setRequestStatusId(int requestStatusId) {
        this.requestStatusId = requestStatusId;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestStatusEntity that = (RequestStatusEntity) o;

        if (requestStatusId != that.requestStatusId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = requestStatusId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "requestStatusByRequestStatusId")
    public Collection<HolidayRequestEntity> getHolidayRequestsByRequestStatusId() {
        return holidayRequestsByRequestStatusId;
    }

    public void setHolidayRequestsByRequestStatusId(Collection<HolidayRequestEntity> holidayRequestsByRequestStatusId) {
        this.holidayRequestsByRequestStatusId = holidayRequestsByRequestStatusId;
    }
}
