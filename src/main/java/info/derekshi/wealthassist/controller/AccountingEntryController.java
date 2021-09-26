package info.derekshi.wealthassist.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    return entryRepository.save(entry);
  }
}
