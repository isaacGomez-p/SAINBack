package com.sain.Utils;

import com.sain.Config.JasyptConfig;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class EncryptDecryptPwd {

    //encrypt the plan text
    public String encryptKey(final String plainKey) {
        SimpleStringPBEConfig pbeConfig = JasyptConfig.getSimpleStringPBEConfig();
        PooledPBEStringEncryptor pbeStringEncryptor = new PooledPBEStringEncryptor();
        pbeStringEncryptor.setConfig(pbeConfig);
            return pbeStringEncryptor.encrypt(plainKey);
    }

    //decrypt the encrypted text
    public String decryptKey(String encryptedKey) {
        SimpleStringPBEConfig pbeConfig = JasyptConfig.getSimpleStringPBEConfig();
        PooledPBEStringEncryptor pbeStringEncryptor = new PooledPBEStringEncryptor();
        pbeStringEncryptor.setConfig(pbeConfig);
        return pbeStringEncryptor.decrypt(encryptedKey);
    }

}
