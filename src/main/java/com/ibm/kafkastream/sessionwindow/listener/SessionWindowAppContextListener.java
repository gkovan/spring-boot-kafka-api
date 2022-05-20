package com.ibm.kafkastream.sessionwindow.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.kafkastream.sessionwindow.service.SessionWindowStreamService;

public class SessionWindowAppContextListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionWindowAppContextListener.class);

	@Autowired
	SessionWindowStreamService sessionWindowStreamService;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOGGER.info("Window Stream Listener started.");
		sessionWindowStreamService.start();	
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LOGGER.info("Window Stream Listener stopped.");
		sessionWindowStreamService.stop();
	}	
    
}
