package com.ibm.translation;

import java.util.List;

import com.ibm.watson.developer_cloud.language_translator.v3.model.Translation;

public interface TranslationServiceIntf {

	List<Translation> getTranslation(String[] args);

}