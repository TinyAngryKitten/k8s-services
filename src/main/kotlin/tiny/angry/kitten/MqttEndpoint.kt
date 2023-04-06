package tiny.angry.kitten

import org.eclipse.paho.mqttv5.client.IMqttClient
import javax.ws.rs.HeaderParam
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/mqtt")
class MqttEndpoint(private val mqttClient: IMqttClient) {

    @POST
    fun sendMessage(
        @HeaderParam("topic") topic: String,
        @HeaderParam("qos") qos: Int,
        @HeaderParam("retained") retained: Boolean = false,
        message: String?,
    ) = mqttClient.publish(topic, message!!.encodeToByteArray(), qos, retained)
}