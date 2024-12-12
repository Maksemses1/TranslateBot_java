package com.maksemses.translatebot.Services;

import com.maksemses.translatebot.enums.LANG;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.deepl.api.*;

@Component
public class TranslatorDiscord {
    Translator translator;
    TranslatorDiscord(){
        String authKey = "APIkey";
        translator = new Translator(authKey);
    }


    public String TranslateMessageTo(String message, LANG lang) throws Exception {
        TextResult result =
                translator.translateText(message, null, lang.getLang());
        return result.getText();
    }
}
