package com.mss.loginserver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.mss.loginserver.domain.Channel;
import com.mss.loginserver.domain.Customer;
import com.mss.loginserver.domain.Password;
import com.mss.loginserver.repository.ChannelRepository;
import com.mss.loginserver.repository.CustomerRepository;
import com.mss.loginserver.repository.PasswordRepository;

import reactor.core.publisher.Flux;

/**
 * 
 * @author sametsafkan
 *
 */
@Service
public class DataLoader implements CommandLineRunner{

	private CustomerRepository customer;
	private PasswordRepository password;
	private ChannelRepository channel;

	public DataLoader(CustomerRepository customer, PasswordRepository password, ChannelRepository channel) {
		this.customer = customer;
		this.password = password;
		this.channel = channel;
	}

	private void loadData() {
		Password password1 = new Password("123456", LocalDateTime.now());
		Password password2 = new Password("123457", LocalDateTime.now());
		Password password3 = new Password("123458", LocalDateTime.now());
		Password password4 = new Password("123459", LocalDateTime.now());
		Password password5 = new Password("123450", LocalDateTime.now());
		Password password6 = new Password("123451", LocalDateTime.now());
		Password password7 = new Password("123452", LocalDateTime.now());
		password.deleteAll().block();
		password1 = password.save(password1).block();
		password2 = password.save(password2).block();
		password3 = password.save(password3).block();
		password4 = password.save(password4).block();
		password5 = password.save(password5).block();
		password6 = password.save(password6).block();
		password7 = password.save(password7).block();

		Customer customer1 = new Customer(123, "Samet", "Safkan", password1.getId());
		Customer customer2 = new Customer(124, "Semih", "Safkan", password2.getId());
		Customer customer3 = new Customer(125, "Erdem", "Safkan", password3.getId());
		Customer customer4 = new Customer(126, "Hasan", "Safkan", password4.getId());
		Customer customer5 = new Customer(127, "Mehmet", "Safkan", password5.getId());
		Customer customer6 = new Customer(128, "Muhammet", "Safkan", password6.getId());
		Customer customer7 = new Customer(129, "Can", "Safkan", password7.getId());
		customer.deleteAll().block();
		customer.save(customer1).block();
		customer.save(customer2).block();
		customer.save(customer3).block();
		customer.save(customer4).block();
		customer.save(customer5).block();
		customer.save(customer6).block();
		customer.save(customer7).block();

		Channel channel1 = new Channel(123, "INT");
		Channel channel2 = new Channel(124, "INT");
		Channel channel3 = new Channel(125, "INT");
		Channel channel4 = new Channel(126, "INT");
		Channel channel5 = new Channel(127, "INT");
		Channel channel6 = new Channel(128, "INT");
		Channel channel7 = new Channel(129, "INT");
		channel.deleteAll().block();
		channel.save(channel1).block();
		channel.save(channel2).block();
		channel.save(channel3).block();
		channel.save(channel4).block();
		channel.save(channel5).block();
		channel.save(channel6).block();
		channel.save(channel7).block();
	}

	@Override
	public void run(String... args) throws Exception {
		loadData();		
	}
}
