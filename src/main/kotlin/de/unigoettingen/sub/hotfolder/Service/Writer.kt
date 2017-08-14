package de.unigoettingen.sub.hotfolder.Service

import com.amazonaws.ClientConfiguration
import com.amazonaws.Protocol
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import de.unigoettingen.sub.hotfolder.Configuration.AwsConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Writer() {

    @Autowired
    lateinit var awsConfiguration:AwsConfiguration

    fun writeFile(name: String, content: String) {
        val clientConfig = ClientConfiguration()
        clientConfig.protocol = Protocol.HTTP
        clientConfig.setSignerOverride("S3SignerType")

        val endpointConfiguration = AwsClientBuilder.EndpointConfiguration(awsConfiguration.url, "")
        val awsCredentials = BasicAWSCredentials(awsConfiguration.access, awsConfiguration.secret)
        val client = AmazonS3ClientBuilder
                .standard()
                .withClientConfiguration(clientConfig)
                .withCredentials(AWSStaticCredentialsProvider(awsCredentials))
                .withEndpointConfiguration(endpointConfiguration)
                .build()

        client.putObject(awsConfiguration.bucket, "hotfolder/${name}.xml", content)
    }

}
