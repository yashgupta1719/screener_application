package com.application.screener.screener_application.service;

import com.application.screener.screener_application.models.Show;
import com.application.screener.screener_application.models.User;

import java.util.List;
import java.util.Set;

public interface ShowService {
    List<Show> getAllShows();

    Show updateShow(Show show);

    Long deleteShow(Long showId);
}
