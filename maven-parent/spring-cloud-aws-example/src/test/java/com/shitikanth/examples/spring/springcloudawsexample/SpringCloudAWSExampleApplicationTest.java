package com.shitikanth.examples.spring.springcloudawsexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;

@SpringBootTest
class SpringCloudAWSExampleApplicationTest {

	@Autowired
	S3Client s3Client;

	@Test
	void contextLoads() {
		s3Client.createBucket(builder -> {
			builder.bucket("test");
		});
		var result = s3Client.listBuckets();
		for(Bucket bucket : result.buckets()) {
			System.out.println(bucket.name());
		}
	}
}