package com.ibm.translator.service;

import java.util.List;

import com.ibm.watson.developer_cloud.language_translator.v3.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v3.model.Translation;
import com.ibm.watson.developer_cloud.language_translator.v3.model.TranslationResult;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

public class TranslationService implements TranslationServiceIntf {
	public List<Translation>  getTranslation(String[] args) {	  
		  
  		IamOptions iamOptions = new IamOptions.Builder()
		    .apiKey("T-UQJZqaqbJ2SyXMJrWwftmpLFDWPh2KD9P7OysPn79z")
		    .build();

		  LanguageTranslator languageTranslator = new LanguageTranslator("2018-05-01", iamOptions);
		  
		  TranslateOptions translateOptions = new TranslateOptions.Builder()
				    .addText(args[2])
				    .source(args[0])
				    .target(args[1])
				    .build();
		  TranslationResult translationResult = languageTranslator.translate(translateOptions).execute();

		  return translationResult.getTranslations();
		 
	} 
	
}
