package com.bsyll.dev.springasynceventlifecycle.publisher;

import com.bsyll.dev.springasynceventlifecycle.event.GenericEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AsynchronousEventPublisherTest {

    private AsynchronousEventPublisher publisher;

    @Mock
    private ApplicationEventPublisher applicationEventPublisher;
    @Captor
    private ArgumentCaptor<GenericEvent> captor;

    @BeforeEach
    void setUp() {
        publisher = new AsynchronousEventPublisher(applicationEventPublisher);
    }

    @Test
    void should_successfully_publish_event() {
        GenericEvent event = new GenericEvent("message", "notification");
        publisher.publish(() -> event);

        verify(applicationEventPublisher).publishEvent(captor.capture());
        assertThat(captor.getValue()).isEqualTo(event);
    }
}