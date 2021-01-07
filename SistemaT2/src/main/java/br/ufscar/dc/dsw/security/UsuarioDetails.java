package br.ufscar.dc.dsw.security;

import java.util.Arrays;
import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.ufscar.dc.dsw.domain.Usuario;
 
@SuppressWarnings("serial")
public class UsuarioDetails implements UserDetails {
 
    private Usuario user;
     
    public UsuarioDetails(Usuario user) {
        this.user = user;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

    	String[] dominio = user.getLogin().split("@"); //para definir o papel do usuario pelo dominio do email

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + dominio[1]);
        return Arrays.asList(authority);
    }
 
    @Override
    public String getPassword() {
        return user.getSenha();
    }
 
    @Override
    public String getUsername() {
        return user.getLogin();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
}