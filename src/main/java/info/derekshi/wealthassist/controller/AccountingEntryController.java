package info.derekshi.wealthassist.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import info.derekshi.wealthassist.WealthAssistApplication;
import info.derekshi.wealthassist.model.AccountingEntry;
import info.derekshi.wealthassist.repository.AccountingEntryRepository;

@RestController
public class AccountingEntryController {
  private static final Logger log = LoggerFactory.getLogger(WealthAssistApplication.class);

  @Autowired
  private AccountingEntryRepository entryRepository;

  @GetMapping("{userId}/entry")
  public List<AccountingEntry> getEntries(@PathVariable Long userId) {
    log.info(String.format("userId: %d", userId));
    List<AccountingEntry> res = new ArrayList<AccountingEntry>();
    entryRepository.findByUserId(userId).forEach(entry -> {
      log.info(entry.toString());
      res.add(entry);
    });
    return res;
  }

  @PutMapping("{userId}/entry")
  public AccountingEntry putEntry(@RequestBody AccountingEntry entry, @PathVariable Long userId) {
    log.info(entry.toString());
    if (entry.getId() == null) {
      entry.setCreateDate(new Timestamp(new Date().getTime()));
      entry.setModifyDate(new Timestamp(new Date().getTime()));
      entry.setUserId(userId);
      return entryRepository.save(entry);
    } else {
      Optional<AccountingEntry> dbEntry = entryRepository.findById(entry.getId());
      if (dbEntry.isPresent()) {
        if (entry.getUserId() != dbEntry.get().getUserId()) {
          throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Not your Entry!");
        }
        entry.setCreateDate(dbEntry.get().getCreateDate());
        entry.setRevision(dbEntry.get().getRevision() + 1);
      }
      entry.setModifyDate(new Timestamp(new Date().getTime()));
      return entryRepository.save(entry);
    }
  }
}
