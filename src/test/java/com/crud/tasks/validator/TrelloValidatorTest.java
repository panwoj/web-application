package com.crud.tasks.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTest {

    @InjectMocks
    private TrelloValidator trelloValidator;

    @Test
    public void testValidateTrelloBoards() {
        //Given
        List<TrelloList> listTrelloLists1 = new ArrayList<>();
        TrelloList trelloList1 = new TrelloList("1", "test", false);

        List<TrelloList> listTrelloLists2 = new ArrayList<>();
        TrelloList trelloList2 = new TrelloList("2", "test", false);

        TrelloBoard testBoard = new TrelloBoard("1", "test", listTrelloLists1);
        TrelloBoard normalBoard = new TrelloBoard("2", "normal", listTrelloLists2);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(testBoard);
        trelloBoards.add(normalBoard);
        //When
        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(trelloBoards);
        //Then
        Assert.assertEquals(1, filteredBoards.size());
    }
}
