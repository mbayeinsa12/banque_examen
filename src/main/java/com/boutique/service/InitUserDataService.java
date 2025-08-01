package com.boutique.service;

import com.boutique.entity.Role;
import com.boutique.entity.Utilisateur;
import com.boutique.repository.RoleRepository;
import com.boutique.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class InitUserDataService implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Création des rôles
        Role clientRole = roleRepository.findByNom("CLIENT");
        if (clientRole == null) {
            clientRole = new Role();
            clientRole.setNom("CLIENT");
            roleRepository.save(clientRole);
        }
        Role managerRole = roleRepository.findByNom("MANAGER");
        if (managerRole == null) {
            managerRole = new Role();
            managerRole.setNom("MANAGER");
            roleRepository.save(managerRole);
        }
        // Création des utilisateurs
        if (utilisateurRepository.findAll().isEmpty()) {
            for (int i = 1; i <= 4; i++) {
                Utilisateur user = new Utilisateur();
                user.setUsername("client" + i);
                user.setPassword(passwordEncoder.encode("password"));
                Set<Role> roles = new HashSet<>();
                roles.add(clientRole);
                user.setRoles(roles);
                utilisateurRepository.save(user);
            }
            Utilisateur manager = new Utilisateur();
            manager.setUsername("manager");
            manager.setPassword(passwordEncoder.encode("password"));
            Set<Role> roles = new HashSet<>();
            roles.add(managerRole);
            manager.setRoles(roles);
            utilisateurRepository.save(manager);
        }
    }
}
