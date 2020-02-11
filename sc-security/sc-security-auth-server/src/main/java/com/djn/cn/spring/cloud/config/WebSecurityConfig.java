/**
 * Copyright (c) 2020-2025. op-platform.cn All Rights Reserved.
 * 项目名称：开放开发平台
 * 类名称：WebSecurityConfig.java
 * 创建人：op.nie-dongjia
 * 联系方式：niedongjiamail@qq.com
 * 开源地址: https://github.com/nie-dongjia
 * 项目官网:
 */
package com.djn.cn.spring.cloud.config;

import com.djn.cn.spring.cloud.service.security.OAuthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <b>类  名：</b>com.djn.cn.spring.cloud.config.WebSecurityConfig<br/>
 * <b>类描述：</b>TODO<br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2020/2/10 22:50<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2020/2/10 22:50<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0 <br/>
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private OAuthUserDetailsService oAuthUsoerDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(oAuthUsoerDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
