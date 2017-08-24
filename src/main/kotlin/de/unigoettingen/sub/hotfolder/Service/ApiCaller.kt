package de.unigoettingen.sub.hotfolder.Service

import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.HttpClients
import org.apache.http.message.BasicNameValuePair
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*

@Component
class ApiCaller {

    fun informAboutNewWork(id: String): String {
        val client = HttpClients.createDefault()
        val httpPost = HttpPost("http://www.example.com")

        val params = ArrayList<BasicNameValuePair>()
        params.add(BasicNameValuePair("id", id))
        httpPost.entity = UrlEncodedFormEntity(params)

        val response = client.execute(httpPost)
        client.close()

        if (response.statusLine.statusCode == 200) {
            LoggerFactory.getLogger("ApiCaller").info("Informed the API about ${id}")
        } else {
            LoggerFactory.getLogger("ApiCaller").info("Error informing the API about ${id}")
        }

        return id
    }

}
