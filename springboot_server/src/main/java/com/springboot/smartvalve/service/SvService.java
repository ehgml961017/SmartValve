package com.springboot.smartvalve.service;

import com.springboot.smartvalve.dto.SvDTO;
import com.springboot.smartvalve.mapper.SvMapper;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SvService {
    @Setter(onMethod_ = @Autowired)
    SvMapper svMapper;

    /**
     * @return 데이터 수집값
     * @throws Exception
     */
    public List<SvDTO> getValue() throws Exception {
        return svMapper.getValue();
    }

    /**
     * 새로운 데이터를 삽입시키는 쿼리를 실행시키는 로직
     *
     * @param svDTO
     * @throws Exception
     */
    public void insertValue(SvDTO svDTO) throws Exception {
        // sw 1 sw2가 둘다 0일때만 인서트 되게
        int valveS = svDTO.getSw1();
        int corkS = svDTO.getSw2();
        log.info("가스밸브상태");
        log.info(String.valueOf(valveS));
        log.info("가스콕크 상태");
        log.info(String.valueOf(corkS));
        svMapper.insertValue(svDTO);
    }

    /**
     * 가스밸브를 여는 기능 . 가스밸브 상태를 on상태로
     * 갱신시키는 쿼리를 실행시키는 메소드
     *
     * @param svDTO
     * @throws Exception
     */
    public void onSw1(SvDTO svDTO) throws Exception {
        svMapper.sw1_on(svDTO);
    }

    /**
     * 가스밸브를 끄는 기능. 가스밸브를 오프상태로 갱신시키는 쿼리를 실행시키는 메소드이면서
     * 껏을때 콕크와 밸브가 둘다 꺼진상태면 자동으로 다음회차의 쿼리를 삽입시키는 메소드
     *
     * @param svDTO
     * @throws Exception
     */

    public void offSw1(SvDTO svDTO) throws Exception {
        log.debug("스위치 상태:");
        log.debug(svDTO.toString());
        svMapper.sw1_off(svDTO);
        svDTO.setSw1(0);
        if ((svDTO.getSw1() == 0) && (svDTO.getSw2() == 0)) {
            insertValue(svDTO);
        }
    }

    /**
     * 가스콕크를 여는 기능 . 가스콕크 상태를 on상태로
     * 갱신시키는 쿼리를 실행시키는 메소드
     *
     * @param svDTO
     * @throws Exception
     */
    public void onSw2(SvDTO svDTO) throws Exception {
        int cork_time = svDTO.getCork_time();
        int corkS = svDTO.getSw2();
        log.debug("가스콕크 상태:");
        log.debug(String.valueOf(corkS));
        log.debug("가스콕크 사용시간:");
        log.debug(String.valueOf(cork_time));
        svMapper.sw2_on(svDTO);
    }

    /**
     * 가스 콕크를 끄는 기능을 하는 메소드.
     * 동시에 가스콕크와 가스밸브가 모두 꺼진상태라면 다음회차의 쿼리를 삽입하는 메소드
     * @param svDTO
     * @throws Exception
     */
    public void offSw2(SvDTO svDTO) throws Exception {
        log.debug("스위치 상태:");
        log.debug(svDTO.toString());
        svMapper.sw2_off(svDTO);
        svDTO.setSw2(0);
        if ((svDTO.getSw1() == 0) && (svDTO.getSw2() == 0)) {
            insertValue(svDTO);
        }
    }

    /**
     * 
     * @param num
     * @return 가스밸브의 사용시간
     * @throws Exception
     */
    public Integer time_sw1(int num) throws Exception {
        return svMapper.time_sw1(num);
    }

    /**
     * 
     * @param num
     * @return  가스콕크의 사용시간
     * @throws Exception
     */
    public Integer time_sw2(int num) throws Exception {
        return svMapper.time_sw2(num);
    }


}
