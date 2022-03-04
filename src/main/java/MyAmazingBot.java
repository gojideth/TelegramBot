


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyAmazingBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "firstuptcbot";
    }

    @Override
    public String getBotToken() {
        return "1556010963:AAEbuPGfdXJnEkCWOowGRfgq8hpnzjHtAU0";
    }

    @Override
    public void onUpdateReceived(Update update) {


        if (update.hasMessage() && update.getMessage().hasText()) {
            var date = update.getMessage().getDate();
            var message = SendMessage.builder()
                    .chatId(String.valueOf(update.getMessage()
                            .getChatId()))
                    .text("Tu mensaje: " + update.getMessage().getText() + ", remitente: " + update.getMessage().getFrom().getFirstName() +
                            ", fecha en formato UNIX: " + date + " \n By Gojideth.").build();
            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}