package com.example.lean.proxy.handler;

import com.example.lean.user.UserService;
import com.example.lean.user.impl.UserServiceImpl;
import com.example.lean.util.ProxyUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceHandlerTest {

	@Test
	public void testProxy(){
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		ClassLoader classLoader=userServiceImpl.getClass().getClassLoader();
		Class[] interfaces=userServiceImpl.getClass().getInterfaces();
		for(Class clazz:interfaces){
			for(Method m:clazz.getDeclaredMethods()){
				System.out.println("method:"+m.getName());
			}
			System.out.println("interface:"+clazz.getName());
		}
		InvocationHandler userServiceHandler=new UserServiceHandler(userServiceImpl);
		UserService proxy= (UserService)Proxy.newProxyInstance(classLoader,interfaces,userServiceHandler);

		proxy.select();
		proxy.update();

		ProxyUtils.generatClassFile(userServiceImpl.getClass(),"UserServiceProxy");
	}
}