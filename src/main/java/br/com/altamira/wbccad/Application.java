package br.com.altamira.wbccad;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJms
@EnableTransactionManagement
@ComponentScan("br.com.altamira.wbccad")
@EntityScan(basePackages = "br.com.altamira.wbccad.model")
@EnableJpaRepositories(transactionManagerRef = "TransactionManager", entityManagerFactoryRef = "EntityManagerFactory", basePackages = "br.com.altamira.wbccad.repository")
public class Application {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(Application.class, args); }
	 */

	static String mailboxDestination = "wbccad-orcmat";

	/*@Bean // Strictly speaking this bean is not necessary as boot creates a default
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }*/
	
	@Bean
	ConnectionFactory connectionFactory() {
		return new CachingConnectionFactory(new ActiveMQConnectionFactory(
				"tcp://localhost:61616"));
	}

	/*@Bean
	MessageListenerAdapter receiver() {
		return new MessageListenerAdapter(new Receiver()) {
			{
				setDefaultListenerMethod("receiveMessage");
			}
		};
	}*/

	/*@Bean
	SimpleMessageListenerContainer containerFactory(
			final MessageListenerAdapter messageListener,
			final ConnectionFactory connectionFactory) {
		return new SimpleMessageListenerContainer() {
			{
				setMessageListener(messageListener);
				setConnectionFactory(connectionFactory);
				setDestinationName(mailboxDestination);
			}
		};
	}*/

	/*@Bean
	JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
		return new JmsTemplate(connectionFactory);
	}*/

	public static void main(String args[]) throws Throwable {
		SpringApplication.run(Application.class, args);
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				Application.class);

		MessageCreator messageCreator = new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("ping!");
			}
		};
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		System.out.println("Sending a new mesage.");
		jmsTemplate.send(mailboxDestination, messageCreator);

		context.close();*/
	}

}
