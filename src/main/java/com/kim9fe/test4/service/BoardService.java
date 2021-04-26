package com.kim9fe.test4.service;

import com.kim9fe.test4.domain.BoardDTO;

public interface BoardService {
    public String getBoardList();
    public int registBoard(BoardDTO params);
    public int deleteBoard(long id);
}
