package com.kim9fe.test4.mapper;

import com.kim9fe.test4.domain.BoardDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    public int insertBoard(BoardDTO params);
    public BoardDTO selectBoardDetail(long id);
    public int updateBoard(BoardDTO params);
    public int deleteBoard(long id);
    public List<BoardDTO> selectBoardList();
    public int selectBoardTotalCount();
}
