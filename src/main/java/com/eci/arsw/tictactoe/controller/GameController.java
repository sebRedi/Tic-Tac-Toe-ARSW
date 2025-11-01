package com.eci.arsw.tictactoe.controller;

import com.eci.arsw.tictactoe.model.GameState;
import com.eci.arsw.tictactoe.model.Move;
import com.eci.arsw.tictactoe.service.GameService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tictactoe")
public class GameController {
    private final GameService service;
    public GameController(GameService service){ this.service = service; }

    @GetMapping(value = "/state", produces = MediaType.APPLICATION_JSON_VALUE)
    public GameState state(){ return service.state(); }

    @PostMapping(value = "/move", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public GameState move(@RequestBody Move move){ return service.move(move); }

    @PostMapping(value = "/reset", produces = MediaType.APPLICATION_JSON_VALUE)
    public GameState reset(){ return service.reset(); }
}