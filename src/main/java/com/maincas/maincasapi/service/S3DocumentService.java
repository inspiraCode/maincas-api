package com.maincas.maincasapi.service;

import java.util.List;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.maincas.maincasapi.model.Attachment;

public interface S3DocumentService {
  static final String FK_PREFIX = "maincas_";
  Boolean doesBucketExist(String bucketName);

  Bucket createBucket(String bucketName);

  List<Bucket> listBuckets();

  void deleteBucket(String bucketName);

  PutObjectResult putObject(Attachment attachment);

  ObjectListing listObjects(String bucketName);

  S3Object getObject(String objectKey);

  CopyObjectResult copyObject(String sourceBucketName, String sourceKey, String destinationBucketName,
      String destinationKey);

  void deleteObject(String objectKey);

  DeleteObjectsResult deleteObjects(DeleteObjectsRequest delObjReq);
}
