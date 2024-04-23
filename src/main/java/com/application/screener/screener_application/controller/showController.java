package com.application.screener.screener_application.controller;

import com.application.screener.screener_application.models.Show;
import com.application.screener.screener_application.models.ShowsResponse;
import com.application.screener.screener_application.models.Subscriber;
import com.application.screener.screener_application.service.CommonService;
import com.application.screener.screener_application.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/subscribe-show", method = RequestMethod.PUT)
    public ResponseEntity<Long> subscribeShow(@RequestBody Subscriber subscriber){
        Long user_id = commonService.subscribeShow(subscriber);
        return new ResponseEntity<Long>(user_id, HttpStatus.OK);
    }

    @RequestMapping(value = "/unsubscribe-show", method = RequestMethod.PUT)
    public ResponseEntity<Long> unsubscribeShow(@RequestBody Subscriber subscriber){
        Long user_id = commonService.unsubscribeShow(subscriber);
        return new ResponseEntity<Long>(user_id, HttpStatus.OK);
    }

}
