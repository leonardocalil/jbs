package br.com.increaseit.backend.service.impl;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.increaseit.backend.service.Engine;
import br.com.increaseit.backend.service.GroupActionService;
import br.com.increaseit.internal.data.entity.Action;
import br.com.increaseit.internal.data.entity.GroupAction;
import br.com.increaseit.internal.data.entity.Wait;

@Service("threadEngine")
public class ThreadEngineImpl implements Engine {
	@Autowired(required=false)
	private GroupActionService service;
	

	@PostConstruct
	public void init() {
		System.setProperty(
                "webdriver.chrome.driver",
                "D:/environment/workspace_mars/primefaces/src/main/resources/webdriver/chromedriver.exe");
        
	}
	@Async
	public void execute() {
		
		WebDriver driver = new ChromeDriver();
		
        try {
			GroupAction dto = service.getGroupAction();
			
			if (dto != null) {
				
				driver.manage().window().maximize();
		
		        driver.get(dto.getUrl());
		        
		        for (Action action : dto.getActions()) {
		        	wait(driver, action.getPreAction());
		        	WebElement element = getElement(driver, action);
		        	doAction(element,action);
		        	wait(driver, action.getPosAction());
		        }
		        
		        
			}
        } finally {
        	driver.quit();
        }

	}

	private void wait(WebDriver driver, Wait waitDto) {
		if (waitDto != null) {
			if( waitDto.getFieldName() == null 
					|| waitDto.getFieldName().trim().length() == 0) {
				try {
					Thread.sleep(waitDto.getTimeOut()*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				WebDriverWait wait = new WebDriverWait(driver, waitDto.getTimeOut());
				
				switch(waitDto.getFieldType()) {
					case ID: {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(waitDto.getFieldName())));
					}; break;
					case NAME: {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(waitDto.getFieldName())));
					}; break;
					case CLASS: {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(waitDto.getFieldName())));
					}
				}
				
					
			}
		}
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.id<locator>));
	}
	
	private void doAction(WebElement element, Action action) {
		switch(action.getDoAction()) {
			 case WRITE: {
				 //TODO: ajustar escrita bom base nos parametros
//				 element.sendKeys(action.getText());
			 } break;
			 case CLICK: {
				 element.click();
			 } break;
				
		}
	}
	private WebElement getElement(WebDriver driver, Action action) {
		switch(action.getFieldType()) {
			case ID: {
				return driver.findElement(By.id(action.getFieldName()));
			}
			case NAME: {
				return driver.findElement(By.name(action.getFieldName()));
			}
			case CLASS: {
				return driver.findElement(By.className(action.getFieldName()));
			}
		}
		return null;
	}

}
