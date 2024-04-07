package com.application.screener.screener_application.dao;

import com.application.screener.screener_application.models.Show;
import com.application.screener.screener_application.models.User;

import java.util.List;

public interface ShowDAO {
    List<Show> getAllShows();

    List<Show> getUserShows(User Id);

    Show createShow(Show show);

    Show updateShow(Show show);

    Long deleteShow(Long showId);

}
