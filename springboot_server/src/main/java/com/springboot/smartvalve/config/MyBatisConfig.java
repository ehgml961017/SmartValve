package com.springboot.smartvalve.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * DB 커넥션 설정을 위한 패키지 - config
 * */
@Configuration
@MapperScan("com.springboot.smartvalve.mapper")
@EnableTransactionManagement
public class MyBatisConfig {
    /**
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory =
                new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver =
                new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources
                ("classpath:mapper/*.xml")); //Mybatis mapper 파일의 위치를 설정
        return sessionFactory.getObject();
    }

    /**
     *
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        final SqlSessionTemplate sqlSessionTemplate =
                new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }


}

/*
@Configuration :
    클래스가 하나 이상의 @Bean 메소드를 제공하고
    스프링 컨테이너가 Bean정의를 생성하고
    런타임시 그 Bean들이 요청들을 처리할 것을 선언하게 된다.

@MapperScan :
    mapper.xml 파일들이 파라볼 기본 패키지 위치를 지정해주는 어노테이션입니다.

@EnableTransactionManagement :
    DataSourceTransactionManage 빈을 찾아 Transaction Manager로 사용합니다.

SqlSessionFactory :
    Mysql Server와 MyBatis를 연결해주는 객체
    데이터베이스와의 연결과 SQL의 실행에 대한 모든 것을 가진 중요한 객체

DataSource :
    Connection pool에는 여러 개의 Connection 객체가 존재, 각각을 Application에서 직접 이용하면
    체계적인 관리가 힘드므로 pool을 관리하는 목적으로 사용되는 객체이다.

SqlSessionTemplate :
    SqlSession을 구현하고 코드에서 SqlSession을 대체하는 역할

*/