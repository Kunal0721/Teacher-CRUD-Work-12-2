package com.crud.teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransfer {
	private Long fromId;
	private Long toId;
	private Double amount;
}
