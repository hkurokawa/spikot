package jp.co.fablic.spikot

import com.github.kittinunf.fuel.Fuel
import java.util.logging.Logger

class SlackNotifier {
    private val logger = Logger.getLogger(SlackNotifier::javaClass.name)
    private val url = "https://slack.com/api/chat.postMessage"

    fun postMessage(text: String, color: String = "#cccccc") {
        postMessage(listOf(
                "token" to BuildConfig.SLACK_TOKEN,
                "channel" to BuildConfig.SLACK_CHANNEL_NAME,
                "attachments" to String.format("[{\"text\": \"%s\", \"color\": \"%s\"}]", text, color)
        ))
    }

    private fun postMessage(parameters: List<Pair<String, Any>>) {
        val (_, _, result) = Fuel.post(url, parameters).responseString()
        logger.info("[spikot] Posted a message to Slack. result: " + result)
    }
}
