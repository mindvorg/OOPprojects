import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

// Example taken from https://github.com/rubenlagus/TelegramBotsExample



fun main() {
    try {
        val botsApi = TelegramBotsApi(DefaultBotSession::class.java)
        botsApi.registerBot(TelegramBot())
    } catch (e: TelegramApiException) {
        e.printStackTrace()
    }
}