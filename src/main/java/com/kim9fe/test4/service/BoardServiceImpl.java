package com.kim9fe.test4.service;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kim9fe.test4.domain.BoardDTO;
import com.kim9fe.test4.mapper.BoardMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {
    
    @Autowired
    private BoardMapper boardMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getBoardList() {

        Gson gson = new Gson();
        JsonObject jobj = new JsonObject();
        
        List<BoardDTO> lst = boardMapper.selectBoardList();
        
        jobj.addProperty("totalCount", lst.size());
        jobj.add("list", gson.toJsonTree(lst));

        return jobj.toString();
    }

    @Override
    @Transactional
    public int registBoard(BoardDTO params){

        int result = 0;
        //System.out.println(String.format("ID >>>> %d", params.getId()));
        logger.debug("DEBUG...ID >>>> {} LOGGER 사용", params.getId());
        logger.info("INFO....ID >>>> {} LOGGER 사용", params.getId());
        logger.error("ERROR...ID >>>> {} LOGGER 사용", params.getId());

        if(params.getId() == 0) {
            result = boardMapper.insertBoard(params);
        } else {
            result = boardMapper.updateBoard(params);
        }

        logger.info("REGIST RESULT = [{}]", result);
        return result;
    }

    @Override
    public int deleteBoard(long id){
        return boardMapper.deleteBoard(id);
    }
}
