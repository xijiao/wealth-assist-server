package info.derekshi.wealthassist.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountingEntry {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Long userId;
  private Double amount;
  private Timestamp occurDate;
  private Timestamp createDate;
  private Timestamp modifyDate;
  private int revision;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Timestamp getOccurDate() {
    return occurDate;
  }

  public void setOccurDate(Timestamp occurDate) {
    this.occurDate = occurDate;
  }

  public Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
    this.createDate = createDate;
  }

  public Timestamp getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Timestamp modifyDate) {
    this.modifyDate = modifyDate;
  }

  public int getRevision() {
    return revision;
  }

  public void setRevision(int revision) {
    this.revision = revision;
  }

  @Override
  public String toString() {
    return "AccountingEntry [amount=" + amount + ", createDate=" + createDate + ", id=" + id + ", modifyDate="
        + modifyDate + ", occurDate=" + occurDate + ", revision=" + revision + ", userId=" + userId + "]";
  }
}