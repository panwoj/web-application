package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCard.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService service;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;

    @Mock
    private AdminConfig adminConfig;

    @Test
    public void shouldFetchTrelloBoards() {
        //Given
        List<TrelloListDto> list = new ArrayList<>();
        TrelloListDto trelloListDto = new TrelloListDto("1", "test", false);
        list.add(trelloListDto);

        List<TrelloBoardDto> boardDtos = new ArrayList<>();
        TrelloBoardDto boardDto = new TrelloBoardDto("1", "kodilla", list);
        boardDtos.add(boardDto);

        when(trelloClient.getTrelloBoards()).thenReturn(boardDtos);
        //When
        List<TrelloBoardDto> fetchedList = service.fetchTrelloBoards();
        //Then
        Assert.assertEquals(1, fetchedList.size());
    }

    @Test
    public void testCreatedTrelloCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("test", "test", "top", "1");
        CreatedTrelloCardDto createdTrelloCardDto =
                new CreatedTrelloCardDto("1", "test", "http://test.com");

        when(trelloClient.createNewCard(any(TrelloCardDto.class))).thenReturn(createdTrelloCardDto);
        //When
        CreatedTrelloCardDto newCard = service.createdTrelloCard(cardDto);
        //Then
        Assert.assertEquals("1", newCard.getId());
    }
}
