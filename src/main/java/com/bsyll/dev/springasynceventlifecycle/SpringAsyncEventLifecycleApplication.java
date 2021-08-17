package com.bsyll.dev.springasynceventlifecycle;

import com.bsyll.dev.springasynceventlifecycle.event.ChatChannelMessageEvent;
import com.bsyll.dev.springasynceventlifecycle.event.GenericEvent;
import com.bsyll.dev.springasynceventlifecycle.event.MailChannelMessageEvent;
import com.bsyll.dev.springasynceventlifecycle.event.PhoneChannelMessageEvent;
import com.bsyll.dev.springasynceventlifecycle.publisher.AsynchronousEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class SpringAsyncEventLifecycleApplication implements ApplicationRunner {

	@Autowired
	private AsynchronousEventPublisher publisher;

	public static void main(String[] args) {
		SpringApplication.run(SpringAsyncEventLifecycleApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for (int i = 0; i < 4; i++) {
			int random = new Random().ints(1, (3+1)).limit(1).findFirst().getAsInt();
			switch (random) {
				case 1: publish(new MailChannelMessageEvent("mail message", "foo@toto.com")); break;
				case 2: publish(new PhoneChannelMessageEvent("sms message", "0601010101")); break;
				case 3: publish(new ChatChannelMessageEvent("chat message", "toto75")); break;
				default:
					throw new IllegalStateException("Unexpected value: " + random);
			}
		}
	}

	private void publish(GenericEvent event) {
		publisher.publish(() -> event);
	}
}
