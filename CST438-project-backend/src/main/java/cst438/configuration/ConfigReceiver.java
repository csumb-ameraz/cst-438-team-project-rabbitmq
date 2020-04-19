package cst438.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cst438.ResultsEventHandler;

@Configuration
public class ConfigReceiver {
	@Bean
	public FanoutExchange fanout() {
		return new FanoutExchange("email-results");
	}
	@Bean
	public Queue queue1() {
		return new Queue("email-results-q1");
	}
	@Bean
	public Binding binding1(FanoutExchange fanout, Queue queue1) {
		return BindingBuilder.bind(queue1).to(fanout);
	}
	@Bean
	public ResultsEventHandler receiver() {
		return new ResultsEventHandler();
	}
}

