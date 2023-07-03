package pe.todotic.bookstoreapi_s2.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import pe.todotic.bookstoreapi_s2.JWTProperties;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class TokenProvider {
  private final static String JWT_SECRET="7NrvMdes5ENDqFzsjbdxL94uEQKe93ZHdJgp8LN3ZbAqj8geS3J4GQNRxkPmTKdyArv8hFTNbwNhZefwhAsbr4G7dNKVWkFuKqk8Mp7hpntBGJNUmKZJhHUKkHGFk8c5ChHU2tVZJ4Aar6vMY5gj38WBCEaCTscGRzw83hSdarUmhy4PLU5qQZpRDmhgK7XdcVKTkFaMsy2vbXLW7BpeYgscbMUKTngFE6cFv2N3ZEpTTJz2GzskU5jNytb82swP";
  private final SecretKey secretKey;
  private final JwtParser jwtParser;
  private final long tokenValidityInSeconds;

  public TokenProvider() {
    byte[] secretBytes = Decoders.BASE64.decode(JWT_SECRET);
    secretKey = Keys.hmacShaKeyFor(secretBytes);
    jwtParser = Jwts.parserBuilder().setSigningKey(secretKey).build();
    tokenValidityInSeconds=2592000;
  }
  public String createToken(Authentication authentication) {

    long now = new Date().getTime();
    Date experiationDate = new Date(now + (tokenValidityInSeconds * 1000));
    String role = authentication.getAuthorities()
      .stream()
      .map(GrantedAuthority::getAuthority)
      .collect(Collectors.joining(","));
    return Jwts
      .builder()
      .setSubject(authentication.getName())
      .claim("auth", role)
      .signWith(secretKey, SignatureAlgorithm.HS512)
      .setExpiration(experiationDate)
      .compact();
  }
  public Authentication getAuthentication(String token) {
    Claims claims = jwtParser.parseClaimsJws(token).getBody();
    List<SimpleGrantedAuthority> authorities = Arrays
      .stream(claims.get("auth").toString().split(","))
      .filter(auth -> !auth.trim().isEmpty())
      .map(SimpleGrantedAuthority::new)
      .toList();
    User principal = new User(claims.getSubject(), "", authorities);
    return new UsernamePasswordAuthenticationToken(principal, token, authorities);
  }
  public boolean validateToken(String token) {
    try {
      jwtParser.parseClaimsJws(token);
      return true;
    } catch (JwtException e) {
      return false;
    }
  }
}
