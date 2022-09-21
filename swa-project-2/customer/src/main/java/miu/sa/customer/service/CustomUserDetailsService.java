package miu.sa.customer.service;

import miu.sa.customer.model.Customer;
import miu.sa.customer.repo.CustomerRepository;
import miu.sa.customer.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    CustomerRepository jwtUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = jwtUserRepository.findUserByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("User with the email Not found : " + email);
        }
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add((GrantedAuthority) () -> String.valueOf(customer.getId()));
        return new User(customer.getEmail(), customer.getPassword(), authorities);
    }
}
