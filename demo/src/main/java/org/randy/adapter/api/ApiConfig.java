package org.randy.adapter.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * 
 * @author x00418543
 * @since 2019年11月27日
 */
@Configuration
@ComponentScan(basePackages = { "org.randy.adapter.api" })
@EnableWebMvc // 启用spring mvc
@EnableSpringDataWebSupport // 启用springmvc对spring data的支持
public class ApiConfig {

}
