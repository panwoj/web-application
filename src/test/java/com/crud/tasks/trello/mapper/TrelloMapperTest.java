package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {

    @Mock
    private TrelloListDto trelloListDto;

    @Autowired
    TrelloMapper trelloMapper;

    private List<TrelloListDto> trelloListDtoList = new ArrayList<>();
    private List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();


    @Before
    public void setup() {
        trelloListDtoList.add(trelloListDto);
        trelloBoardDtoList.add(new TrelloBoardDto("1", "name", trelloListDtoList));
    }

    @Test
    public void testmapToBoards() {
        //Given
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        Assert.assertEquals(trelloBoardDtoList.get(0).getId(), trelloBoards.get(0).getId());
        Assert.assertEquals(trelloBoardDtoList.get(0).getName(), trelloBoards.get(0).getName());
        Assert.assertEquals(trelloBoardDtoList.get(0).getLists().size(), trelloBoards.get(0).getLists().size());
    }

//    @Test
//    public void test() {
//        //Given
//        //When
//        //Then
//    }
//
//    @Test
//    public void test() {
//        //Given
//        //When
//        //Then
//    }
//
//    @Test
//    public void test() {
//        //Given
//        //When
//        //Then
//    }
//
//    @Test
//    public void test() {
//        //Given
//        //When
//        //Then
//    }
//
//    @Test
//    public void test() {
//        //Given
//        //When
//        //Then
//    }
}
