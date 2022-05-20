package com.example.takehomedemo.service;

import com.example.takehomedemo.entities.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();
    Player getPlayerById(long id);
}
