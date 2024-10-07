package com.pgm.springdemo.sample;

import com.pgm.springdemo.config.AppConfig;


import lombok.extern.log4j.Log4j;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"/test-context.xml"})
public class SampleTest {
    @Autowired
    @Qualifier("sample1")
    private SampleDTO sampleDTO;

    @Test
    public void testSample() {
        SampleDTO dto = new SampleDTO();
        dto.setAge(20);
        dto.setName("박경미");
        String[] hobbys = {"수영", "영화감상"};
        dto.setHobby(hobbys);
        log.info(dto);
    }

    @Test
    public void testSample2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/test-context.xml");
        SampleDTO dto1 = (SampleDTO) context.getBean("sample1");
        log.info(dto1);
        SampleDTO dto2 = (SampleDTO) context.getBean("sample2");
        log.info(dto2);
    }

    @Test
    public void testSample3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SampleDTO dto1 = (SampleDTO) context.getBean("myDto1");
        log.info(dto1);
        SampleDTO dto2 = (SampleDTO) context.getBean("myDto2");
        log.info(dto2);
    }
}
