package com.bsyll.dev.springasynceventlifecycle.publisher;

import com.bsyll.dev.springasynceventlifecycle.event.GenericEvent;
import com.bsyll.dev.springasynceventlifecycle.metadatas.EventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.function.Supplier;

@EventPublisher
@Slf4j
public class AsynchronousEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public AsynchronousEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(Supplier<? extends GenericEvent> supplier) {
        GenericEvent event = supplier.get();
        log.debug("publishing event with uuid {}", event.getUuid());
        applicationEventPublisher.publishEvent(event);
    }

    @Configuration
    public static class AsynchronousEventConfiguration {

        @Bean("applicationEventMulticaster")
        public ApplicationEventMulticaster simpleApplicationEventMulticaster(Executor threadPoolExecutor) {
            SimpleApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();
            applicationEventMulticaster.setTaskExecutor(threadPoolExecutor);
            return applicationEventMulticaster;
        }

        @Bean
        public Executor threadPoolExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(4);
            executor.setMaxPoolSize(10);
            executor.setThreadNamePrefix("Task-Async-");
            executor.initialize();
            return executor;
        }

    }
}
