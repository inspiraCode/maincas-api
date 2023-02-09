package com.maincas.maincasapi.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.maincas.maincasapi.model.Attachment;

@Service
public class S3DocumentServiceImpl implements S3DocumentService {
  private static Logger logger = LoggerFactory.getLogger(S3DocumentServiceImpl.class);
  private final AmazonS3 s3client;

  @Value("${s3.key}")
  private String s3Key;

  @Value("${s3.secret}")
  private String s3SecretKey;

  @Value("${s3.bucket}")
  private String s3Bucket;

  @Autowired
  public S3DocumentServiceImpl(@Value("${s3.key}") String s3Key, @Value("${s3.secret}") String s3SecretKey,
      @Value("${s3.bucket}") String s3Bucket) {
    logger.debug("S3DocumentService constructor with bucket {}, and key {}", s3Bucket, s3Key);
    // set-up the client
    AWSCredentials credentials = new BasicAWSCredentials(s3Key, s3SecretKey);
    AmazonS3 s3client = AmazonS3ClientBuilder
        .standard()
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .withRegion(Regions.US_EAST_2)
        .build();

    this.s3client = s3client;
  }

  public S3DocumentServiceImpl(AmazonS3 s3client) {
    logger.debug("S3DocumentService client constructor with value: {}", s3client);
    this.s3client = s3client;
  }

  public Boolean doesBucketExist(String bucketName) {
    logger.debug("Searching for bucket to exist {}", bucketName);
    boolean result = s3client.doesBucketExistV2(bucketName);
    logger.debug("Search result ({}) for bucket to exist {}", result, bucketName);
    return result;
  }

  public Bucket createBucket(String bucketName) {
    logger.debug("Requested to create bucket {}", bucketName);
    return s3client.createBucket(bucketName);
  }

  public List<Bucket> listBuckets() {
    logger.debug("Getting buckets list");
    return s3client.listBuckets();
  }

  public void deleteBucket(String bucketName) {
    logger.debug("Delete bucket with name {}", bucketName);
    s3client.deleteBucket(bucketName);
  }

  public PutObjectResult putObject(Attachment attachment) {
    byte[] bI = java.util.Base64.getDecoder().decode(attachment.getBase64());
    InputStream fis = new ByteArrayInputStream(bI);
    ObjectMetadata metadata = new ObjectMetadata();
    metadata.setContentLength(bI.length);
    metadata.setContentType(attachment.getFileType());
    metadata.setCacheControl("public, max-age=31536000");
    String objectKey = String.format("%s%s_%d", FK_PREFIX, attachment.getClass().getTypeName(), attachment.getId());
    logger.debug("Uploading object with key: {}", objectKey);
    return s3client.putObject(s3Bucket, objectKey, fis, metadata);
  }

  public ObjectListing listObjects(String bucketName) {
    return s3client.listObjects(bucketName);
  }

  public S3Object getObject(String objectKey) {
    return s3client.getObject(s3Bucket, objectKey);
  }

  public CopyObjectResult copyObject(String sourceBucketName, String sourceKey, String destinationBucketName,
      String destinationKey) {
    return s3client.copyObject(sourceBucketName, sourceKey, destinationBucketName, destinationKey);
  }

  public void deleteObject(String objectKey) {
    s3client.deleteObject(s3Bucket, objectKey);
  }

  public DeleteObjectsResult deleteObjects(DeleteObjectsRequest delObjReq) {
    return s3client.deleteObjects(delObjReq);
  }
}
