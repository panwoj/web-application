package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {

    @Mock
    private TrelloListDto trelloListDto;

    @Mock
    private TrelloList trelloList;

    @Mock
    private TrelloCard trelloCard;

    @Mock
    private TrelloCardDto trelloCardDto;

    @InjectMocks
    TrelloMapper trelloMapper;

    private List<TrelloListDto> trelloListDtoList = new ArrayList<>();
    private List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();

    private List<TrelloList> trelloLists = new ArrayList<>();
    private List<TrelloBoard> trelloBoards = new ArrayList<>();

    @Test
    public void testMapToBoards() {
        //Given
        trelloListDtoList.add(trelloListDto);
        trelloBoardDtoList.add(new TrelloBoardDto("1", "name", trelloListDtoList));
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        Assert.assertEquals(trelloBoardDtoList.get(0).getId(), trelloBoards.get(0).getId());
        Assert.assertEquals(trelloBoardDtoList.get(0).getName(), trelloBoards.get(0).getName());
        Assert.assertEquals(trelloBoardDtoList.get(0).getLists().size(), trelloBoards.get(0).getLists().size());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        trelloLists.add(trelloList);
        trelloBoards.add(new TrelloBoard("1", "name", trelloLists));
        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);
        //Then
        Assert.assertEquals(trelloBoards.get(0).getId(), trelloBoardDtos.get(0).getId());
        Assert.assertEquals(trelloBoards.get(0).getName(), trelloBoardDtos.get(0).getName());
        Assert.assertEquals(trelloBoards.get(0).getLists().size(), trelloBoardDtos.get(0).getLists().size());
    }

    @Test
    public void testMapToList() {
        //Given
        trelloListDtoList.add(trelloListDto);
        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtoList);
        //Then
        Assert.assertEquals(trelloListDtoList.get(0).getId(), trelloLists.get(0).getId());
        Assert.assertEquals(trelloListDtoList.get(0).getName(), trelloLists.get(0).getName());
        Assert.assertEquals(trelloListDtoList.get(0).isClosed(), trelloLists.get(0).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        trelloLists.add(trelloList);
        //When
        List<TrelloListDto> trelloListsDto = trelloMapper.mapToListDto(trelloLists);
        //Then
        Assert.assertEquals(trelloLists.get(0).getId(), trelloListsDto.get(0).getId());
        Assert.assertEquals(trelloLists.get(0).getName(), trelloListsDto.get(0).getName());
        Assert.assertEquals(trelloLists.get(0).isClosed(), trelloListsDto.get(0).isClosed());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        Assert.assertEquals(trelloCardDto.getDescription(), trelloCard.getDescription());
        Assert.assertEquals(trelloCardDto.getListId(), trelloCard.getListId());
        Assert.assertEquals(trelloCardDto.getName(), trelloCard.getName());
        Assert.assertEquals(trelloCardDto.getPos(), trelloCard.getPos());
    }

    @Test
    public void testMapToCard() {
        //Given
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        Assert.assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
        Assert.assertEquals(trelloCard.getName(), trelloCardDto.getName());
        Assert.assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
    }
}
