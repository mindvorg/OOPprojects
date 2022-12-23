
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement


class TelegramBot : TelegramLongPollingBot() {
    override fun getBotToken(): String = "*************************************"
    override fun getBotUsername(): String = "*************************"
    private val connection: Connection

    init {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
        val connectionUrl =
            "jdbc:sqlserver://localhost:1433;encrypt=true;database=PhotoStore;trustServerCertificate=true;"
        connection = DriverManager.getConnection(connectionUrl, "password", "admin")
    }

    override fun onUpdateReceived(update: Update?) {
        if (update != null) {
            if (update.hasMessage()) {
                val message = update!!.message
                val chatId = message.chatId
                val responseText = if (message.hasText()) {
                    var messageText = message.text
                    when (messageText) {
                        "/start" -> {
                            "Добро пожаловать дружище!"
                        }
                        "пленка" -> {
                            getFilm(chatId)
                            return
                        }
                        "ремни"->{
                            getBelt(chatId)
                            return
                        }
                        "купить" -> {
                            makeOrder(chatId, update)
                        }
                        "регистрация" -> {
                            registrationUser(chatId)
                        }
                        else -> "Вы написали: $messageText"

                    }
                } else {
                    "Я понимаю только текст"
                }
                sendNotification(chatId, responseText)
            }
        }
    }

    private fun makeOrder(chatId: Long,update: Update): String {
        val statement: Statement = connection.createStatement()
        sendNotification(chatId,"купить")
        execute(SendMessage(chatId.toString(), "выберите какую пленку хотите купить"))
        val resultSetFilm: ResultSet = statement.executeQuery("SELECT NAME,ISO,Color,cost FROM camera.FILM")
        var outputFilm: String = ""
        var i =1
        while (resultSetFilm.next()) {
            outputFilm += i.toString()+") "+ resultSetFilm.getString(1) + ' ' + resultSetFilm.getInt(2) + ' ' + resultSetFilm.getString(3) + " cost:" + resultSetFilm.getInt(
                4) + '\n'
            i++
        }
        execute(SendMessage(chatId.toString(), outputFilm))
        val list:List<String> =outputFilm.split("\n").toList()
        sendNotification(chatId,"выберите номер пленки")
        val message = update.getMessage();
         var messageText = message.text
        val OrderFilm: ResultSet = statement.executeQuery("Insert into tgOrders values($chatId,\'$list[${messageText.toInt()}]\')" )
        return "s"/*тепреь надо считать число добавиьть через бд из одного в другое */
    }

    private fun registrationUser(chatId: Long): String {
        val statement: Statement = connection.createStatement()
        val resultSet: ResultSet = statement.executeQuery(/*"IF EXISTS(\n" +*/
            "      SELECT * FROM dbo.tgID \n" +
                    "      WHERE id=\'$chatId\'\n" +
                    ")\n"/* +
                "SELECT 1\n"*/)
        println(resultSet.wasNull())
        if (resultSet.next()) println("sa")
        println("chatid is $chatId")
        return "loh"
    }

    private fun sendNotification(chatId: Long, responseText: String) {
        val responseMessage = SendMessage(chatId.toString(), responseText)

        responseMessage.enableMarkdown(true)
        responseMessage.replyMarkup =
            when (responseText) {
                "купить"->                 getReplyMarkup(
                    listOf(
                        listOf("пленка", "камера"),
                        listOf("объектив", "шаттив")
                    )
                )
            else -> getReplyMarkup(
               listOf(
                    listOf("Кнопка 1", "купить"),
            listOf("Кнопка 3", "пленка")
                )
                    )
            }
        execute(responseMessage)
    }

    private fun getReplyMarkup(allButtons: List<List<String>>): ReplyKeyboardMarkup {
        val markup = ReplyKeyboardMarkup()
        markup.keyboard = allButtons.map { rowButtons ->
            val row = KeyboardRow()
            rowButtons.forEach { rowButton -> row.add(rowButton) }
            row
        }
        return markup
    }

    private fun getFilm(chatId: Long) {
        val statement: Statement = connection.createStatement()
        val resultSet: ResultSet = statement.executeQuery("SELECT NAME,ISO,Color,cost FROM camera.FILM")
        var output: String = ""
        var i:Int=1
        while (resultSet.next()) {
            output += i.toString()+") "+ resultSet.getString(1) + ' ' + resultSet.getInt(2) + ' ' + resultSet.getString(3) + " cost:" + resultSet.getInt(
                4) + '\n'
            i++
        }
        println(output)
        execute(SendMessage(chatId.toString(), output))
    }
    private fun getBelt(chatId: Long) {
        val statement: Statement = connection.createStatement()
        val resultSet: ResultSet = statement.executeQuery("SELECT idBelt,Length,Color,cost FROM acc.Belt")
        var output: String = "ч "
        var i:Int=1
        while (resultSet.next()) {
            output += i.toString()+") "+ resultSet.getInt(1) + ' ' + resultSet.getInt(2) + ' ' + resultSet.getString(3) + " cost:" + resultSet.getInt(
                4) + '\n'
            i++
        }
        println(output)
        execute(SendMessage(chatId.toString(), output))
    }
}
