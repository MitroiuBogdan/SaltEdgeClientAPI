package com.yllu.vendor.saltedge.mapper;

import com.yllu.common.domain.entity.Account;
import com.yllu.common.domain.entity.Balance;
import com.yllu.vendor.saltedge.rest.client.response.ais.SaltedgeAccount;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SaltedgeAccountMapper implements Function<SaltedgeAccount, Account> {

    public static final SaltedgeAccountMapper SALTEDGE_ACCOUNT_MAPPER = new SaltedgeAccountMapper();

    @Override
    public Account apply(SaltedgeAccount saltedgeAccount) {
        return Account.builder()
                .providerAccountId(saltedgeAccount.getId())
                .name(saltedgeAccount.getName())
                .cashAccountType(saltedgeAccount.getNature())
                .balance(Balance.builder()
                        .content(saltedgeAccount.getBalance())
                        .currency(saltedgeAccount.getCurrency_code())
                        .build())
                .providerGrantId(saltedgeAccount.getConnection_id())
                .linkedAccount(saltedgeAccount.getExtra().getAccount_number())
                .lastRefreshTimestampProvider(saltedgeAccount.getUpdated_at())
                .availableCredit(saltedgeAccount.getExtra().getAvailable_amount())
                .accountHolderName(saltedgeAccount.getExtra().getClient_name())
                .creditLimit(saltedgeAccount.getExtra().getCredit_limit())
                .iban(saltedgeAccount.getExtra().getIban())
                .bban(saltedgeAccount.getExtra().getBban())
                .accountStatus(saltedgeAccount.getExtra().getStatus())
                .build();
    }
}