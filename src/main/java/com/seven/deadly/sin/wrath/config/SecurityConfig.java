package com.seven.deadly.sin.wrath.config;


/*
    SecurityContextPersistenceFilter
            ↓
    BasicAuthenticationFilter
            ↓
    AuthorizationFilter
            ↓
    DispatcherServlet
*/

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.csrf(csrf -> csrf.disable()) // disable csrf
//                .authorizeHttpRequests(auth ->
//                        auth.anyRequest().authenticated() //add authorizationFilter — require authentication in security context
//                )
//                .httpBasic(Customizer.withDefaults()); // add BasicAuthenticationFilter — reads Authorization: Basic xxx
//
//        return http.build();
//    }
//
}
