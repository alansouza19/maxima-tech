package tech.solutio.teste.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tech.solutio.teste.model.UserModel;

@Service
@Profile("production")
public class TokenService {
	
	
	@Value("${api.jwt.expiration}")
	private String expiration ;
	@Value("${api.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		UserModel usuario = (UserModel) authentication.getPrincipal();
		Date present = new Date();
		return Jwts.builder()
				.setIssuer("ASI-WS")
				.setSubject(usuario.getUserId().toString())
				.setIssuedAt(present)
				.setExpiration(new Date(present.getTime() +  Long.valueOf(expiration)))
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public Boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
		
	}

	public Long getIdUsuario(String token) {
		Claims clains = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(clains.getSubject());
	}

}
