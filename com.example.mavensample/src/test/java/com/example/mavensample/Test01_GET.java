package com.example.mavensample;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test01_GET {
	
	@BeforeTest
	boolean test_before()
	{
		final boolean flag = true;
		return true;
	}

	@Test
	void test_01()
	{
		if(test_before())
		{
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int responsecode = response.getStatusCode();
		Assert.assertEquals(responsecode, 200);
		}
		else
		{
			throw new SkipException("Skipping Test 1 as flag is false.");
		}
		
	}
	
	@Test
	void test_02()
	{
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(7));
	}
}
