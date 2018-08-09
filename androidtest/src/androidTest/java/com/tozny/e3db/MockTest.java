package com.tozny.e3db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

  @Mock
  private Client client;

  @Test
  public void testMockPass() {
    UUID authorizer = UUID.randomUUID();
    String recordType = "";
    ResultHandler<Void> voidResultHandler = new ResultHandler<Void>() {
      @Override
      public void handle(Result<Void> r) {

      }
    };
    client.createWriterKey("", new ResultHandler<LocalEAKInfo>() {
      @Override
      public void handle(Result<LocalEAKInfo> r) {

      }
    });

    verify(client).createWriterKey(anyString(), ArgumentMatchers.<ResultHandler<LocalEAKInfo>>any());
  }

  @Test
  public void testMockFail() {
    client.createWriterKey("", new ResultHandler<LocalEAKInfo>() {
      @Override
      public void handle(Result<LocalEAKInfo> r) {

      }
    });

    verify(client).createWriterKey(anyString(), ArgumentMatchers.<ResultHandler<LocalEAKInfo>>any());

    client.createWriterKey("", new ResultHandler<LocalEAKInfo>() {
      @Override
      public void handle(Result<LocalEAKInfo> r) {

      }
    });
  }
}
