package com.example.demo.config;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DynamoShogunConfigTest {

    private DynamoShogunConfig dynamoShogunConfig;

    @Mock
    private AWSCredentials mockCredentials;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dynamoShogunConfig = new DynamoShogunConfig();

        ReflectionTestUtils.setField(dynamoShogunConfig, "amazonAWSAccessKey", "testAccessKey");
        ReflectionTestUtils.setField(dynamoShogunConfig, "amazonAWSSecretKey", "testSecretKey");
    }

    @Test
    void testAmazonAWSCredentials() {

        AWSCredentials credentials = dynamoShogunConfig.amazonAWSCredentials();

        assertNotNull(credentials);
        assertNotNull(credentials.getAWSAccessKeyId());
        assertNotNull(credentials.getAWSSecretKey());
    }

    @Test
    void testAmazonAWSCredentialsProvider() {
        AWSCredentialsProvider credentialsProvider = dynamoShogunConfig.amazonAWSCredentialsProvider();

        AWSCredentials credentials = credentialsProvider.getCredentials();

        assertNotNull(credentials);
    }

    @Test
    void testAmazonDynamoDB() {

        AmazonDynamoDB amazonDynamoDB = dynamoShogunConfig.amazonDynamoDB();

        assertNotNull(amazonDynamoDB);
    }
}
