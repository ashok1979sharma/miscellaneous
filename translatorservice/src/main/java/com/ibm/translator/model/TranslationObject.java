package com.ibm.translator.model;

public class TranslationObject {
	private String sourceLang;
	private String destinationLang;
	private String inputText;
	private String translatedText;
	
	public String getSourceLang() {
		return sourceLang;
	}
	public void setSourceLang(String sourceLang) {
		this.sourceLang = sourceLang;
	}
	public String getDestinationLang() {
		return destinationLang;
	}
	public void setDestinationLang(String destinationLang) {
		this.destinationLang = destinationLang;
	}
	public String getInputText() {
		return inputText;
	}
	public void setInputText(String inputText) {
		this.inputText = inputText;
	}
	public String getTranslatedText() {
		return translatedText;
	}
	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}

}
