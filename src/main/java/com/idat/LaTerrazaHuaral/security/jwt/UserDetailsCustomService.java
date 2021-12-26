package com.idat.LaTerrazaHuaral.security.jwt;

import java.util.ArrayList;

import com.idat.LaTerrazaHuaral.model.User;
import com.idat.LaTerrazaHuaral.repository.crud.IUserCR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Sobreescribe el metodo registro de Usuario

@Service("userDetailsService")
public class UserDetailsCustomService implements UserDetailsService{

    //Usuario en memoria
    @Autowired
    private IUserCR crud;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // retorna null si no encuentra al cliente
        User findUser = crud.findByUsername(username).map(user -> {
            return user;
        }).orElse(null);

        if (findUser == null) {
            throw new UsernameNotFoundException(username);
        }
        /* creo array de roles */
        var roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("PADMIN"));

        // obligatoriamente los roles se tiene que llamar|
        return new org.springframework.security.core.userdetails.User(findUser.getUsername(), "{bcrypt}" + findUser.getPassword(), roles);
    }
}

