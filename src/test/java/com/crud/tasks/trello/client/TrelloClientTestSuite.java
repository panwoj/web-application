package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloClientTestSuite {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private TrelloClient trelloClient;

    @Test(expected = NullPointerException.class)
    public void getTrelloBoards() throws Exception {

        //given
        ReflectionTestUtils.setField(trelloClient, "trelloApiEndpoint", "http://random.com");
        ReflectionTestUtils.setField(trelloClient, "trelloAppKey", "key");
        ReflectionTestUtils.setField(trelloClient, "trelloToken", "token");
        ReflectionTestUtils.setField(trelloClient, "username", "?");
        when(restTemplate.getForObject(any(), any())).thenReturn(null);

        //when
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
    }
}
