package com.transport.bus_service.util;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class SecurityConstant {

    public static final String SECRET_TOKEN = "Thespecifiedkeybytearrayis48bitswhichisnotsecureenoughforanyJWTHMACSHAalgorithm";

    public static final long expirationTime= 1000;
    public static final long passwordResetExpirationTime= 60000;
    public static final String tokenPrefix = "";
    public static final String sighUpUrl = "";
    public static final String verificationEmailUrl = "";
    public static final String passwordResetRequestUrl = "";
    public static final String passwordResetUrl = "";

    public static Key getSignedSecretKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_TOKEN));
    }
}
