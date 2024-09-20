package fr.eni.cave.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    /*
     * Méthode indiquant à Spring Security où sont les informations de connexion à l'application.
     */
    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Récupère la liste des utilisateurs actifs
        userDetailsManager.setUsersByUsernameQuery("select login, password, 1 from cav_user where login=?");

        // Récupère les autorisations de chaque utilisateur
        userDetailsManager.setAuthoritiesByUsernameQuery("select login, authority from cav_user where login=?");

        return userDetailsManager;
    }

    /*
     * Méthode décrivant les rôles nécessaires pour accéder aux ressources
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
            auth
                    // Consulter le stock des bouteilles - est accessible à tout le monde
                    .requestMatchers("/caveavin/bouteilles").permitAll()

                    // Permettre aux rôles CLIENT et OWNER de manipuler :
                    .requestMatchers(HttpMethod.GET, "/caveavin/paniers/**").hasAnyRole("CLIENT", "OWNER")
                    .requestMatchers(HttpMethod.GET, "/caveavin/paniers/client/actifs/**").hasAnyRole("CLIENT", "OWNER")
                    .requestMatchers(HttpMethod.GET, "/caveavin/paniers/client/commandes/**").hasAnyRole("CLIENT", "OWNER")

                    // Restreindre au rôle CLIENT
                    .requestMatchers(HttpMethod.POST, "/caveavin/paniers").hasRole("CLIENT")
                    .requestMatchers(HttpMethod.PUT, "/caveavin/paniers").hasRole("CLIENT")

                    // Restreindre au rôle OWNER
                    .requestMatchers(HttpMethod.GET, "/caveavin/bouteilles/**").hasRole("OWNER")
                    .requestMatchers(HttpMethod.POST, "/caveavin/bouteilles").hasRole("OWNER")
                    .requestMatchers(HttpMethod.PUT, "/caveavin/bouteilles").hasRole("OWNER")
                    //.requestMatchers(HttpMethod.DELETE, "/caveavin/bouteilles").hasRole("OWNER")

                    // Toutes autres url et méthodes HTTP ne sont pas permises
                    .anyRequest().denyAll();
        });

        // Utilise l'authentification basique de HTTP
        http.httpBasic(Customizer.withDefaults());

        // Désactive le CSRF pour permettre à Postman de réaliser des requêtes autres que GET
        // A ne mettre que pour les tests !!! A enlever en production.
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}






