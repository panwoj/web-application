package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() throws BoardsNotFoundException {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards().orElseThrow(BoardsNotFoundException::new);

        trelloBoards.stream()
                .filter(b -> b.getName().contains("Kodilla") && b.getId() != null)
                .forEach(trelloBoardDto ->
                System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
    }
}