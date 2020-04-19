package cst438;


import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


@RabbitListener(queues = "email-results-q1")
public class ResultsEventHandler {

	private static final org.slf4j.Logger log = 
          LoggerFactory.getLogger(ResultsEventHandler.class);

	@RabbitHandler
	public void receive(String in) {
		System.out.println(in);
		log.info(" [ResultEventHandler] Received '" + 
                    in + "'");
	}
}

