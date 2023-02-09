package com.maincas.maincasapi.service;

import static com.maincas.maincasapi.service.S3DocumentService.FK_PREFIX;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.maincas.maincasapi.model.Attachment;

public abstract class AbstractAttachmentServiceImpl<T extends Attachment, U extends PagingAndSortingRepository<T, Long>>
    extends AbstractMaincasBaseServiceImpl<T, U> implements IMaincasItemService<T> {

  private static final Logger logger = LoggerFactory.getLogger(AbstractAttachmentServiceImpl.class);

  @Autowired
  S3DocumentService s3ds;

  @Override
  public T create(T entity) {
    T savedEntity = repo.save(entity);
    PutObjectResult por = s3ds.putObject(savedEntity);
    savedEntity.setETag(por.getETag());
    return repo.save(savedEntity);
  }

  @Override
  public void deleteById(Long id) {
    String objectKey = String.format("%s%s_%d", FK_PREFIX, getType().getClass().getTypeName(), id);
    s3ds.deleteObject(objectKey);
    super.deleteById(id);
  }

  @Override
  public T fetchById(Long id) {
    T dbEntity = super.fetchById(id);

    String objectKey = String.format("%s%s_%d", FK_PREFIX, getType().getClass().getTypeName(), id);
    dbEntity.setBase64(s3Base64(objectKey));;

    return dbEntity;
  }

  private String s3Base64(String objectKey) {
    S3Object s3o = s3ds.getObject(objectKey);
    try {
      InputStream reader = new BufferedInputStream(s3o.getObjectContent());
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      OutputStream writer = new BufferedOutputStream(bos);

      int read = -1;

      while ((read = reader.read()) != -1) {
        writer.write(read);
      }

      writer.flush();
      writer.close();
      reader.close();
      logger.debug("Attachment downloaded and converted to base64");
      return java.util.Base64.getEncoder().encodeToString(bos.toByteArray());
    } catch (IOException e) {
      logger.error("Unable to download content from s3", e);
      throw new IllegalArgumentException("Unable to download content from S3");
    }
  }

}
