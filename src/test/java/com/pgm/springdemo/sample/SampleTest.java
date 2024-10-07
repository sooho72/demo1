package com.pgm.springdemo.sample;


import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;

@Log4j
public class SampleTest {
    @Test
    public void tsetSample() {
        SampleDTO dto = new SampleDTO();
        dto.setAge(20);
        dto.setName("박경미");
        String[] hobbys = {"수영", "영화감상"};
        dto.setHobby(hobbys);

    }



}