package com.application.screener.screener_application.service;


import com.application.screener.screener_application.models.Show;
import com.application.screener.screener_application.models.Subscriber;

public interface CommonService {

    Show createShow(Show show);

    Long subscribeShow(Subscriber info);

    Long unsubscribeShow(Subscriber info);

}
