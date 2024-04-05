package me.telegram.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.Optional;

public class TelegramBotApplication extends TelegramBot {
   @lombok.Builder
    public TelegramBotApplication(String botToken) {
        super(botToken);
    }
    public void run(){
       this.setUpdatesListener(updates ->{
           updates.forEach(this::process)
           return UpdatesListener.CONFIRMED_UPDATES_ALL;
       });
    }

    private void process(Update update) {
       Message message= update.message();
      if (message != null){
          String text= ((Message) message).text();
          Optional.ofNullable(text)
                  .ifPresent(commandName -> this.execute(commandName,message.chat().id()));

      }

    }

    private void execute(String commandName, Long id) {
       switch (commandName){
           case "/start":{
               SendMessage responce = new
           }
       }
    }


}

