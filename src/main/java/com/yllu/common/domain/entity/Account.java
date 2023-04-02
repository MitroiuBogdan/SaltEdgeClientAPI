package com.yllu.common.domain.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class Account {
//These are all the fields consumed from Yolt and sent by YoltAdapter to CasyAPI

    private String providerAccountId;
    private String providerGrantId;
    private String name;
    private String accountHolderName;
    private String accountStatus;
    private String cashAccountType;
    private Balance balance;
    private String lastRefreshTimestampProvider;
    private Double availableCredit;
    private Double creditLimit;
    private String iban;
    private String bban;
    private String bic;
    private String usage;
    private String linkedAccount;
    private String product;
    private String maskedPan;
}
