package com.transport.bus_service.util;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class SecurityConstant {

    public static final String SECRET_TOKEN = "Thespecifiedkeybytearrayis48bitswhichisnotsecureenoughforanyJWTHMACSHAalgorithm";

    public static final long expirationTime= 1000;
    public static final long passwordResetExpirationTime= 60000;
    public static final String tokenPrefix = "";
    public static final String headerString = "";
    public static final String sighUpUrl = "";
    public static final String verificationEmailUrl = "";
    public static final String passwordResetRequestUrl = "";
    public static final String passwordResetUrl = "";
    public static final String h2Console = "";

    public static Key getSignedSecretKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_TOKEN));
    }

//     expirationTime: 864000000
//  passwordResetExpirationTime: 3600000
//  tokenPrefix: Bearer
//  headerString: Authorization
//  sighUpUrl: /user
//  loginUrl: /user/login
//  verificationEmailUrl: /user/email-verification
//  passwordResetRequestUrl: /user/password-reset-request
//  passwordResetUrl: /user/password-reset
//  h2Console: /h2-console/**
//  tokenSecret: eyJhbGciOiJIUzUxMiJ9ew0KICAic3ViIjogIjEyMzQ1Njc4OTAiLA0KICAibmFtZSI6ICJBbmlzaCBOYXRoIiwNCiAgImlhdCI6IDE1MTYyMzkwMjINCn0WNOlGlNaDzMnQ1n6OpTjPYZZOwbCXI2HD8pnMZ17aUx8bYlJjhJqZ7nBzm70aO18OvIlRSK6tPHVvgYE9A

}
