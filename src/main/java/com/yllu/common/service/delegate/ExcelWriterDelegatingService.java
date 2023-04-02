package com.yllu.common.service.delegate;

import com.yllu.common.domain.Vendor;
import com.yllu.common.domain.entity.Account;
import com.yllu.common.domain.entity.Transaction;
import com.yllu.common.properties.CommonProperties;
import com.yllu.common.utils.ObjectToExcelWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExcelWriterDelegatingService {

    CommonProperties commonProperties;

    public void writeAccountForVendor(Account account, Vendor vendor) {
        if (vendor == Vendor.SALTEDGE) {
            ObjectToExcelWriter.writeObjectToExcelFile(account, commonProperties.getSaltedgeAccountsPath());
        }
        if (vendor == Vendor.TINK) {
            ObjectToExcelWriter.writeObjectToExcelFile(account, commonProperties.getTinkAccountPath());
        }
    }

    public void writeTransactionForVendor(Transaction transaction, Vendor vendor) {
        if (vendor == Vendor.SALTEDGE) {
            ObjectToExcelWriter.writeObjectToExcelFile(transaction, commonProperties.getSaltedgeTrxPath());
        }
        if (vendor == Vendor.TINK) {
            ObjectToExcelWriter.writeObjectToExcelFile(transaction, commonProperties.getTinkTrxPath());
        }
    }
}
