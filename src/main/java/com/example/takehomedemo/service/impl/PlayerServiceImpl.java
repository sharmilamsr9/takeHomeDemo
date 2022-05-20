package com.example.takehomedemo.service.impl;

import com.example.takehomedemo.entities.Player;
import com.example.takehomedemo.repository.PlayerRepo;
import com.example.takehomedemo.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
//    private PlayerRepo playerRepository;

//    public PlayerServiceImpl(PlayerRepo playerRepository) {
//        super();
//        this.playerRepository = playerRepository;
//    }

    @Override
    public List<Player> getAllPlayers() {
        return new ArrayList<>();
//        return playerRepository.findAll();
    }
    @Override
    public Player getPlayerById(long id) {
        return new Player(id);
//        return playerRepository.findById(id).orElse(new Player(id));

    }






}
