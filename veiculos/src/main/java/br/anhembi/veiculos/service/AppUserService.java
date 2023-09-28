package br.anhembi.veiculos.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.anhembi.veiculos.repository.AppUserRepo;
import br.anhembi.veiculos.security.AppUser;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public Optional<AppUser> getByUsername(String username) {
        return userRepo.findByEmail(username);
    }

    public AppUser createUser(String username, String password) {
        AppUser user = AppUser.builder()
            .email(username)
            .role("USER")
            .password(passwordEncoder.encode(password))
            .build();
        return userRepo.save(user);
    }
}
