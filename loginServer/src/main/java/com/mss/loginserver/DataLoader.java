package com.mss.loginserver;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.loginserver.entity.ChannelEntity;
import com.mss.loginserver.entity.CustomerEntity;
import com.mss.loginserver.entity.PasswordEntity;
import com.mss.loginserver.repository.ChannelRepository;
import com.mss.loginserver.repository.CustomerRepository;
import com.mss.loginserver.repository.PasswordRepository;

/**
 * 
 * @author sametsafkan
 *
 */
@Service
public class DataLoader {

	private CustomerRepository customer;
	private PasswordRepository password;
	private ChannelRepository channel;

	@Autowired
	public DataLoader(CustomerRepository customer, PasswordRepository password, ChannelRepository channel) {
		this.customer = customer;
		this.password = password;
		this.channel = channel;
	}

	@PostConstruct
	private void loadData() {
		PasswordEntity password1 = new PasswordEntity("123456", Calendar.getInstance().getTime());
		PasswordEntity password2 = new PasswordEntity("123457", Calendar.getInstance().getTime());
		PasswordEntity password3 = new PasswordEntity("123458", Calendar.getInstance().getTime());
		PasswordEntity password4 = new PasswordEntity("123459", Calendar.getInstance().getTime());
		PasswordEntity password5 = new PasswordEntity("123450", Calendar.getInstance().getTime());
		PasswordEntity password6 = new PasswordEntity("123451", Calendar.getInstance().getTime());
		PasswordEntity password7 = new PasswordEntity("123452", Calendar.getInstance().getTime());

		password.save(password1);
		password.save(password2);
		password.save(password3);
		password.save(password4);
		password.save(password5);
		password.save(password6);
		password.save(password7);

		CustomerEntity customer1 = new CustomerEntity(123, "Samet", "Safkan", password1);
		CustomerEntity customer2 = new CustomerEntity(124, "Semih", "Safkan", password2);
		CustomerEntity customer3 = new CustomerEntity(125, "Erdem", "Safkan", password3);
		CustomerEntity customer4 = new CustomerEntity(126, "Hasan", "Safkan", password4);
		CustomerEntity customer5 = new CustomerEntity(127, "Mehmet", "Safkan", password5);
		CustomerEntity customer6 = new CustomerEntity(128, "Muhammet", "Safkan", password6);
		CustomerEntity customer7 = new CustomerEntity(129, "Can", "Safkan", password7);

		customer.save(customer1);
		customer.save(customer2);
		customer.save(customer3);
		customer.save(customer4);
		customer.save(customer5);
		customer.save(customer6);
		customer.save(customer7);

		ChannelEntity channel1 = new ChannelEntity(123, "INT");
		ChannelEntity channel2 = new ChannelEntity(124, "INT");
		ChannelEntity channel3 = new ChannelEntity(125, "INT");
		ChannelEntity channel4 = new ChannelEntity(126, "INT");
		ChannelEntity channel5 = new ChannelEntity(127, "INT");
		ChannelEntity channel6 = new ChannelEntity(128, "INT");
		ChannelEntity channel7 = new ChannelEntity(129, "INT");

		channel.save(channel1);
		channel.save(channel2);
		channel.save(channel3);
		channel.save(channel4);
		channel.save(channel5);
		channel.save(channel6);
		channel.save(channel7);
	}
}
