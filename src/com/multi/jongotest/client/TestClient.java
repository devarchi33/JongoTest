package com.multi.jongotest.client;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.Mongo;
import com.multi.jongotest.entity.Address;
import com.multi.jongotest.entity.Friend;

public class TestClient {

	public static void main(String[] args) throws UnknownHostException {
		Mongo mongo = new Mongo("localhost");
		Jongo jongo = new Jongo(mongo.getDB("test"));
		MongoCollection friends = jongo.getCollection("friend");

		//������ �߰�
		for (int i=0; i < 10; i++) {
			Address address = new Address("����", 333111, "����");
			List<String> phones = new ArrayList<String>();
			phones.add("011-222-333" + i);
			phones.add("011-333-555" + i);

			Friend f = new Friend("gdhong" + i, 20+i, phones, address);
			friends.save(f);
		}
		System.out.println("�Ϸ�");

	}

}