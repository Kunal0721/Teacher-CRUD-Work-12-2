package com.crud.teacher.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.teacher.dto.AccountTransfer;
import com.crud.teacher.dto.AccountsShow;
import com.crud.teacher.entity.Accounts;
import com.crud.teacher.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService {

	private AccountRepository repo;

	public List<AccountsShow> getAllAccounts() {
		List<Accounts> list = repo.findAll();
		List<AccountsShow> show = new LinkedList<AccountsShow>();
		for (Accounts a : list) {
			AccountsShow sh = new AccountsShow(a.getId(), a.getName(), a.getAccountNumber());
			show.add(sh);
		}
		return show;
	}

	public Accounts registerAccount(Accounts a) {
		return repo.save(a);
	}

	public Accounts getOne(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Account not found id : " + id));
	}

	@Transactional
	public void transfer(AccountTransfer transfer) {
		Accounts from = getOne(transfer.getFromId());
		Accounts to = getOne(transfer.getToId());

		from.setBalance(from.getBalance() - transfer.getAmount());
		to.setBalance(to.getBalance() + transfer.getAmount());

		repo.save(from);
		repo.save(to);
	}
}
