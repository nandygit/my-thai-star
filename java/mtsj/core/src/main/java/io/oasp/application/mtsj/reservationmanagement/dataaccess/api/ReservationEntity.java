package io.oasp.application.mtsj.reservationmanagement.dataaccess.api;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import io.oasp.application.mtsj.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.application.mtsj.reservationmanagement.common.api.Reservation;

/**
 * @author rudiazma
 */
@Entity
@Table(name = "Reservation")
public class ReservationEntity extends ApplicationPersistenceEntity implements Reservation {

  @NotNull
  private String name;

  private String reservationToken;

  private String comment;

  @NotNull
  @Future
  private Timestamp bookingDate;

  @NotNull
  @Future
  private Timestamp expirationDate;

  @NotNull
  @Future
  private Timestamp creationDate;

  private boolean canceled;

  private ReservationTypeEntity reservationType;

  private TableEntity table;

  private static final long serialVersionUID = 1L;

  public ReservationEntity() {
    super();
  }

  /**
   * @return name
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getName}.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return reservationToken
   */
  @Override
  public String getReservationToken() {

    return this.reservationToken;
  }

  /**
   * @param reservationToken new value of {@link #getReservationToken}.
   */
  @Override
  public void setReservationToken(String reservationToken) {

    this.reservationToken = reservationToken;
  }

  /**
   * @return comment
   */
  @Override
  public String getComment() {

    return this.comment;
  }

  /**
   * @param comment new value of {@link #getComment}.
   */
  @Override
  public void setComment(String comment) {

    this.comment = comment;
  }

  /**
   * @return bookingDate
   */
  @Override
  public Timestamp getBookingDate() {

    return this.bookingDate;
  }

  /**
   * @param bookingDate new value of {@link #getBookingDate}.
   */
  @Override
  public void setBookingDate(Timestamp bookingDate) {

    this.bookingDate = bookingDate;
  }

  /**
   * @return expirationDate
   */
  @Override
  public Timestamp getExpirationDate() {

    return this.expirationDate;
  }

  /**
   * @param expirationDate new value of {@link #getExpirationDate}.
   */
  @Override
  public void setExpirationDate(Timestamp expirationDate) {

    this.expirationDate = expirationDate;
  }

  /**
   * @return creationDate
   */
  @Override
  public Timestamp getCreationDate() {

    return this.creationDate;
  }

  /**
   * @param creationDate new value of {@link #getCreationDate}.
   */
  @Override
  public void setCreationDate(Timestamp creationDate) {

    this.creationDate = creationDate;
  }

  /**
   * @return canceled
   */
  @Override
  public boolean isCanceled() {

    return this.canceled;
  }

  /**
   * @param canceled new value of {@link #isCanceled}.
   */
  @Override
  public void setCanceled(boolean canceled) {

    this.canceled = canceled;
  }

  @Override
  @Transient
  public Long getReservationTypeId() {

    if (this.reservationType == null) {
      return null;
    }
    return this.reservationType.getId();
  }

  @Override
  public void setReservationTypeId(Long reservationTypeId) {

    if (reservationTypeId == null) {
      this.reservationType = null;
    } else {
      ReservationTypeEntity reservationTypeEntity = new ReservationTypeEntity();
      reservationTypeEntity.setId(reservationTypeId);
      this.reservationType = reservationTypeEntity;
    }
  }

  @Override
  @Transient
  public Long getTableId() {

    if (this.table == null) {
      return null;
    }
    return this.table.getId();
  }

  @Override
  public void setTableId(Long tableId) {

    if (tableId == null) {
      this.table = null;
    } else {
      TableEntity tableEntity = new TableEntity();
      tableEntity.setId(tableId);
      this.table = tableEntity;
    }
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idTable")
  public TableEntity getTable() {

    return this.table;
  }

  public void setTable(TableEntity table) {

    this.table = table;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "reservationType")
  public ReservationTypeEntity getReservationType() {

    return this.reservationType;
  }

  public void setReservationType(ReservationTypeEntity reservationType) {

    this.reservationType = reservationType;
  }

}
