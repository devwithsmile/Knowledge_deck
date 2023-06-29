package com.KDGroup.Knowledge_Deck.config;



import javax.sql.DataSource;

//@Configuration
public class SecurityConfiguration {

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/knowledge_deck");
//        dataSource.setUsername("root");
//        dataSource.setPassword("devonsql");
//        return dataSource;
//    }
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        userDetailsManager.setUsersByUsernameQuery("SELECT email_id, password, CASE WHEN student_type = 1 THEN 'ROLE_STUDENT' WHEN school_type = 1 THEN 'ROLE_SCHOOL' WHEN PA_type = 1 THEN 'ROLE_PARTNER' ELSE '' END as authorities FROM user_login_table WHERE email_id = ?");
//        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT email_id, CASE WHEN student_type = 1 THEN 'ROLE_STUDENT' WHEN school_type = 1 THEN 'ROLE_SCHOOL' WHEN PA_type = 1 THEN 'ROLE_PARTNER' ELSE '' END as authorities FROM user_login_table WHERE email_id = ?");
//        return userDetailsManager;
//    }
}
