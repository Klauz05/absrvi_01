package pe.todotic.bookstoreapi_s2.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
public class JWTFilter extends GenericFilterBean {
  private TokenProvider tokenProvider;
  public JWTFilter(TokenProvider tokenProvider){
    this.tokenProvider=tokenProvider;
  }
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest=(HttpServletRequest) request;
    String bearerToken=httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
    String token;
    if(StringUtils.hasText(bearerToken)&&bearerToken.startsWith("Bearer ")){
      token=bearerToken.substring(7);
      if (tokenProvider.validateToken(token)){
        Authentication authentication= tokenProvider.getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }

    }
    chain.doFilter(request,response);
  }
}
