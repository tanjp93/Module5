package ra.security.jwt;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import ra.security.userPrincipal.UserDetailService;
import ra.service.IUserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTTokenFilter extends OncePerRequestFilter {
    public static Logger logger= LoggerFactory.getLogger(JWTTokenFilter.class);
    @Autowired
    private JWTProvider jwtProvider;
    @Autowired
    private UserDetailService userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        try{
        String jwtToken=getTokenFromRequest(request);
        if (jwtToken!=null && jwtProvider.validateToken(jwtToken)){
            String userName=jwtProvider.getUserNameFromToken(jwtToken);
            UserDetails userDetails=userDetailService.loadUserByUsername(userName);
            if (userDetails!=null){
                UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken( userDetails,null,userDetails.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        }catch (Exception e){
            logger.error("Failed -> UnAuthenticated Message {}",e.getMessage());
        }
        filterChain.doFilter(request,response);
    }
    private String getTokenFromRequest(HttpServletRequest request){
        String header=request.getHeader("Authorization");
        if (header!=null &&header.startsWith("Bearer ")){
            return header.substring(7);
        }
        return  null;
    }
}
