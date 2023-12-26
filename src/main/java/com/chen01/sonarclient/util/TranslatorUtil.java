package com.chen01.sonarclient.util;

import com.chen01.sonarclient.model.request.translator.BatchTranslatorRequestBo;
import com.chen01.sonarclient.model.request.translator.SignalTranslatorRequestBo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class TranslatorUtil {
    @Value("${translator.appId}")
    private String appKey;
    @Value("${translator.appSecret}")
    private String appSecret;
    @Value("${translator.params.domain}")
    private String domain;
    @Value("${translator.params.from}")
    private String from;
    @Value("${translator.params.to}")
    private String to;
    @Value("${translator.params.signType}")
    private String signType;
    @Value("${translator.params.strict}")
    private String strict;
    @Value("${translator.params.rejectFallback}")
    private String rejectFallback;

    private String generateSign(String sourceText, String salt, String curtime) {
        return getSHA256(appKey + getInput(sourceText) + salt + curtime + appSecret);
    }

    private String getInput(String sourceText) {
        if (sourceText == null) {
            return null;
        }
        int len = sourceText.length();
        return len <= 20 ? sourceText : (sourceText.substring(0, 10) + len + sourceText.substring(len - 10, len));
    }

    private static String getSHA256(String string) {
        if (string == null) {
            return null;
        }
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest mdInst = MessageDigest.getInstance("SHA-256");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public SignalTranslatorRequestBo generatorSignalEnglishRequestModel(String sourceText) {
        long currentTimeMillis = System.currentTimeMillis();
        String salt = String.valueOf(currentTimeMillis);
        String curtailment = String.valueOf(currentTimeMillis / 1000);
        return SignalTranslatorRequestBo.builder()
                .q(sourceText)
                .from(from)
                .to(to)
                .appKey(appKey)
                .salt(salt)
                .sign(generateSign(sourceText,salt,curtailment))
                .signType(signType)
                .curtime(curtailment)
                .strict(strict)
                .domain(domain)
                .rejectFallback(rejectFallback)
                .build();
    }

    public BatchTranslatorRequestBo generatorBatchEnglishRequestModel(List<String> sourceTextList) {
        String splicingString = getSplicingString(sourceTextList);
        long currentTimeMillis = System.currentTimeMillis();
        String salt = String.valueOf(currentTimeMillis);
        String curtailment = String.valueOf(currentTimeMillis / 1000);
        return BatchTranslatorRequestBo.builder()
                .q(sourceTextList)
                .from(from)
                .to(to)
                .appKey(appKey)
                .salt(salt)
                .sign(generateSign(splicingString,salt,curtailment))
                .signType(signType)
                .curtime(curtailment)
                .build();
    }

    private static String getSplicingString(List<String> sourceTextList) {
        Optional<String> optionalSplicing =  sourceTextList.stream().reduce((sa, sb) -> sa + sb);
        String splicingString = null;
        if (optionalSplicing.isPresent()){
            splicingString = optionalSplicing.get();
        }
        System.out.println(splicingString);
        return splicingString;
    }
}
