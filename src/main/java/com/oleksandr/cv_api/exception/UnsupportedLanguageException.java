package com.oleksandr.cv_api.exception;

public class UnsupportedLanguageException extends RuntimeException {
    
    private final String language;

    public UnsupportedLanguageException(String language) {
        super("Unsupported language: " + language + ". Supported languages: en, pl, uk.");
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}