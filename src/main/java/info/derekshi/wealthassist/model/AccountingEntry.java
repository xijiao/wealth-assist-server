package info.derekshi.wealthassist.model;

import java.math.BigDecimal;
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
  private String currency;
  private BigDecimal amount;
  private String category;
  private String note;
  private String accountIn;
  private String accountOut;
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

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getAccountIn() {
    return accountIn;
  }

  public void setAccountIn(String accountIn) {
    this.accountIn = accountIn;
  }

  public String getAccountOut() {
    return accountOut;
  }

  public void setAccountOut(String accountOut) {
    this.accountOut = accountOut;
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
}