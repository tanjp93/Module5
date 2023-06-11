package ra.security.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ra.security.userPrincipal.UserPrincipal;

import java.util.Date;

@Component
public class JWTProvider {
    private static final long TOKEN_EXPIRED=86400000;
    private static String SECRET_KEY="buitan";
    public  static Logger logger= LoggerFactory.getLogger(JWTProvider.class);
    public String generateToken(Authentication authentication){
        UserPrincipal userPrincipal= (UserPrincipal) authentication.getPrincipal();
                return Jwts.builder()
                        .setSubject(userPrincipal.getUsername())
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(new Date().getTime()+TOKEN_EXPIRED))
                        .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                        .compact();
    }
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        }catch(ExpiredJwtException e){
            logger.error("Failed--> ExpiredJwtException {}",e.getMessage());
        }catch(UnsupportedJwtException e){
            logger.error("Failed--> UnsupportedJwtException {}",e.getMessage());
        }catch(MalformedJwtException e){
            logger.error("Failed--> MalformedJwtException {}",e.getMessage());
        } catch(SignatureException e){
            logger.error("Failed--> SignatureException {}",e.getMessage());
        } catch( IllegalArgumentException e){
            logger.error("Failed--> IllegalArgumentException {}",e.getMessage());
        }
        return false;
    }
    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(token).getBody().getSubject();
    }
}
