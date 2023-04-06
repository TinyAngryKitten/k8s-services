package tiny.angry.kitten

import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.paho.mqttv5.client.IMqttClient
import org.eclipse.paho.mqttv5.client.MqttClient
import org.eclipse.paho.mqttv5.client.MqttConnectionOptions
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces

@ApplicationScoped
class MqttClientFactory(
    @ConfigProperty(name = "mqtt-username") val mqttUsername: String,
    @ConfigProperty(name = "mqtt-password") val mqttPassword: String,
    @ConfigProperty(name = "mqtt-url") val broker: String
) {
    private val clientId: String = "http-mqtt"

    @get:Produces
    val client: IMqttClient = MqttClient(broker, clientId).apply {
        connect(
            MqttConnectionOptions().apply {
                userName = mqttUsername
                password = mqttPassword.toByteArray()
            }
        )
    }
}