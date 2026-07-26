package com.auditService.service;


import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

import com.auditService.DTO.SslAuditResult;

@Service
public class SslAuditService {

    public SslAuditResult getSslAuditResponse(String url) throws Exception {

        URL target = new URL(url);

        if (!"https".equalsIgnoreCase(target.getProtocol())) {
            return new SslAuditResult(
                    false,
                    false,
                    null,
                    null,
                    null,
                    0
            );
        }

        HttpsURLConnection connection = (HttpsURLConnection) target.openConnection();

        connection.connect();

        Certificate[] certificates = connection.getServerCertificates();

        X509Certificate certificate = (X509Certificate) certificates[0];

        Instant expiryInstant = certificate.getNotAfter().toInstant();
        LocalDate expiryDate = expiryInstant.atZone(ZoneId.systemDefault()).toLocalDate();

        long daysRemaining =  ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);

        return new SslAuditResult(
                true,
                true,
                certificate.getIssuerX500Principal().getName(),
                certificate.getSubjectX500Principal().getName(),
                expiryDate,
                daysRemaining
        );
    }
}