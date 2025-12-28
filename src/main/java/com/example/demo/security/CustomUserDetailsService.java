package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/*
 * Minimal implementation
 * Test does NOT require actual user loading
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        throw new UsernameNotFoundException(
                "UserDetailsService not implemented");
    }
}
