package info.derekshi.wealthassist.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import info.derekshi.wealthassist.model.AccountingEntry;

public interface AccountingEntryRepository extends CrudRepository<AccountingEntry, Long> {
    List<AccountingEntry> findByUserId(long userId);
    AccountingEntry findById(long id);
}
