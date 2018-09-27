package com.ibm.translator.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.translator.model.TranslationObject;
import com.ibm.translator.service.TranslationService;
import com.ibm.translator.service.TranslationServiceIntf;
import com.ibm.watson.developer_cloud.language_translator.v3.model.Translation;

@Controller
public class TranslationController {
	
	@RequestMapping(value = "/rest/get", method = RequestMethod.GET)
	public @ResponseBody String getAllEmployees() {
		System.out.println("Get called");
		return "Retun from get request";
	}
	
	@CrossOrigin (origins = "http://9.193.210.64:4401") 
	@RequestMapping(value = "/rest/emp/translation", method = RequestMethod.POST)
	public @ResponseBody TranslationObject getTranslation(@RequestBody TranslationObject trans) {
		System.out.println("Testing Version1");
		String sourceLang = trans.getSourceLang();
		String destinationLang = trans.getDestinationLang();
		if(sourceLang.equalsIgnoreCase(destinationLang)){
			trans.setTranslatedText(trans.getInputText());
			return trans;
		}
		String[] args = {sourceLang, destinationLang, trans.getInputText()};
		TranslationServiceIntf transService =  new TranslationService();
		List<Translation> translations = transService.getTranslation(args);
		System.out.println(translations);
		for(Translation translation : translations){
			trans.setTranslatedText(translation.getTranslationOutput());
		}
		return trans;
	}

}
