package com.example.takehomedemo.controller;

import com.example.takehomedemo.entities.Player;
import com.example.takehomedemo.repository.PlayerRepo;
import com.example.takehomedemo.service.PlayerService;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    // build get all employees REST API
    @GetMapping
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    // build get employee by id REST API
    // http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Player> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Player>(playerService.getPlayerById(employeeId), HttpStatus.OK);
    }

//    @Autowired
//    PlayerRepo playerRepository;

    @PostMapping("/upload")
    public String uploadData(@RequestParam("file") MultipartFile file) throws Exception {
        List<Player> playerlist = new ArrayList<>();
        InputStream inputStream = file.getInputStream();
        CsvParserSettings setting = new CsvParserSettings();
        setting. setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(setting);
        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
        parseAllRecords.forEach(record -> {
            Player play = new Player(Integer.parseInt(record.getString("playerID")));
            play.setBirthCity(record.getString("birthCity"));
            play.setBirthDay(record.getString("birthDay"));
            playerlist.add (play) ;
        });
        System.out.println(playerlist);

//        playerService.saveAll(playerlist);
        return "Upload Successfull !!!";
    }



}
