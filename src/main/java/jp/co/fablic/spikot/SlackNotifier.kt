package jp.co.fablic.spikot

import com.github.kittinunf.fuel.Fuel
import jp.co.fablic.spikot.system.slackChannelName
import jp.co.fablic.spikot.system.slackToken
import jp.co.fablic.spikot.system.envVars
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import java.util.logging.Logger

class SlackNotifier {
    private val logger = Logger.getLogger(SlackNotifier::javaClass.name)
    private val url = "https://slack.com/api/chat.postMessage"
    private val token by lazy {
        envVars[slackToken]
    }
    private val channelName by lazy {
        envVars[slackChannelName]
    }

    fun postMessage(text: String, color: String? = null) {
        if (color == null) {
            postMessage(listOf(
                    "token" to token,
                    "channel" to channelName,
                    "text" to text
            ))
        } else {
            postMessage(listOf(
                    "token" to token,
                    "channel" to channelName,
                    "attachments" to String.format("[{\"text\": \"%s\", \"color\": \"%s\"}]", text, color)
            ))
        }
    }

    private fun postMessage(parameters: List<Pair<String, Any>>) {
        launch(CommonPool) {
            val (_, _, result) = Fuel.post(url, parameters).responseString()
            logger.info("[spikot] Posted a message to Slack. result: " + result)
        }
    }
}
