package org.gdelattre.jsf.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.ProjectStage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

@ManagedBean(eager=true)
@ApplicationScoped
public class InitController {
	
	private static Logger logger = Logger.getLogger(InitController.class);
	
    @PostConstruct
    public void startup() {
    	FacesContext facesContext = FacesContext.getCurrentInstance();
    	
		if (facesContext.isProjectStage(ProjectStage.Development)) {
			
			final String DEV_MODE = "/***** YOU ARE UNDER THE DEVELOPPEMENT MODE *****/";
			
			logger.info(DEV_MODE);
		}
		if(facesContext.isProjectStage(ProjectStage.Production)) {
			
			final String DEV_MODE = "/***** YOU ARE UNDER THE PRODUCTION MODE *****/";
			
			logger.info(DEV_MODE);
		}
    }

    @PreDestroy
    public void shutdown() {
        
    }

}
