package jp.co.fablic.spikot.system

val envVars = Variables(SystemEnvKeyVals())

val slackToken = StrVar("SLACK_TOKEN")
val slackChannelName = StrVar("SLACK_CHANNEL_NAME")

private class SystemEnvKeyVals : KeyVals {
    override fun get(key: String): String? = System.getenv(key)
}