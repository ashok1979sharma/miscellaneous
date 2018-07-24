package com.ibm.translation;

import java.util.List;

import com.ibm.watson.developer_cloud.language_translator.v3.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v3.model.IdentifiableLanguages;
import com.ibm.watson.developer_cloud.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v3.model.Translation;
import com.ibm.watson.developer_cloud.language_translator.v3.model.TranslationResult;
import com.ibm.watson.developer_cloud.language_translator.v3.util.Language;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

public class TranslationService implements TranslationServiceIntf {
	
	 /* (non-Javadoc)
	 * @see com.ibm.translation.TranslationServiceIntf#getTranslation(java.lang.String[])
	 */
	@Override
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
			 // IdentifiableLanguages languages = languageTranslator.listIdentifiableLanguages().execute();
			  return translationResult.getTranslations();
			  
			 // IdentifiableLanguages languages = languageTranslator.listIdentifiableLanguages() .execute();

			 // System.out.println(translationResult);
			  /*service.setApiKey("0fdgJhLL_Vp0IGzuQT1jPYnoZKSl4Z-gujTi5oAugAYj");
			  service.setEndPoint("https://gateway.watsonplatform.net/language-translator/api");
			  service.setSkipAuthentication(false);
			 // service.set
			  
			 // Map<String, String> headers = new HashMap<String, String>();
			  //headers.put("X-Watson-Learning-Opt-Out", "false");

			  //service.setDefaultHeaders(headers);
			  
			  TranslateOptions translateOptions = new TranslateOptions.Builder()
			    .addText("hello")
			    .source(Language.ENGLISH)
			    .target(Language.SPANISH)
			    .build();
			  TranslationResult translationResult = service.translate(translateOptions).execute();

			  System.out.println(translationResult);*/
} 

}
