package com.starkindustries.config;


import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static com.amazonaws.retry.PredefinedRetryPolicies.DEFAULT_BACKOFF_STRATEGY;
import static com.amazonaws.retry.PredefinedRetryPolicies.DEFAULT_MAX_ERROR_RETRY;

@Configuration
public class Ceph {

    @Value("${object.storage.endpoint}")
    private String objectStorageEndpoint;

    @Value("${object.storage.user.access.key}")
    private String objectStorageUserAccessKey;

    @Value("${object.storage.user.secret.key}")
    private String objectStorageUserSecretKey;
    
   
	@Bean
	public AmazonS3 s3client() {
        AWSCredentials credentials = new BasicAWSCredentials(objectStorageUserAccessKey, objectStorageUserSecretKey);
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setProtocol(Protocol.HTTP);
        clientConfig.setMaxErrorRetry(DEFAULT_MAX_ERROR_RETRY);
        clientConfig.setRetryPolicy(new RetryPolicy(PredefinedRetryPolicies.DEFAULT_RETRY_CONDITION,
                DEFAULT_BACKOFF_STRATEGY, DEFAULT_MAX_ERROR_RETRY, false));
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(objectStorageEndpoint, "");
        AmazonS3ClientBuilder builder = AmazonS3ClientBuilder.standard();
        builder.setEndpointConfiguration(endpointConfiguration);
        builder.withPathStyleAccessEnabled(true);
        builder.setClientConfiguration(clientConfig);
        builder.setCredentials(new AWSStaticCredentialsProvider(credentials));
        AmazonS3 conn = builder.build();
        return conn;
	}
    

}
