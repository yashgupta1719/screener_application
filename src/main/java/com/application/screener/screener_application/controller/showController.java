package com.application.screener.screener_application.controller;

import com.application.screener.screener_application.models.Show;
import com.application.screener.screener_application.models.ShowsResponse;
import com.application.screener.screener_application.service.CommonService;
import com.application.screener.screener_application.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/screener/api/shows")
public class showController {

    @Autowired
    ShowService showService;

    @Autowired
    CommonService commonService;

    @GetMapping("/allshows")
    public ResponseEntity<ShowsResponse> getAllshows(){
        List<Show> availableShows = showService.getAllShows();
        ShowsResponse showsResponse = new ShowsResponse();
        showsResponse.setResult(availableShows);
        return new ResponseEntity<ShowsResponse>(showsResponse, HttpStatus.OK);
    }

    @PostMapping("/create-show")
    public ResponseEntity<Show> createShow(@RequestBody Show showObj){
        Show createdShow = commonService.createShow(showObj);
        return new ResponseEntity<Show>(createdShow, HttpStatus.CREATED);
    }

}
