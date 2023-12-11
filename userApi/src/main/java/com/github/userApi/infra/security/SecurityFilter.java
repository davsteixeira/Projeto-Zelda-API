package com.github.userApi.infra.security;

import com.github.userApi.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
//extends no oncepeerrequestfilter pra ativar o filtro uma vez por requisição
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;
    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //esse método faz um filtro interno antes de ele ser chamado lá na outra classe
        var token = this.recuperarToken(request);
        if(token != null){
            var login = tokenService.validarToken(token);
            UserDetails user = userRepository.findByNome(login);

            var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        //se o token não for null, ele vai ser verificado, depois disso, esse comando passa para o próximo filtro
        filterChain.doFilter(request, response);
    }
    private String recuperarToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
            //retornando aqui uma string vazia pra dar um espaço e retornar só o token la no final
            return authHeader.replace("Bearer ", " ");
    }
}
