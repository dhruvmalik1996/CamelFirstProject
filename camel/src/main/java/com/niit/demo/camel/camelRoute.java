package com.niit.demo.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class camelRoute {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

System.out.println("Initializing the camel context...");
CamelContext camelContext = new DefaultCamelContext();
System.out.println("Implementing Routes......");
camelContext.addRoutes(new RouteBuilder(){
@Override
public void configure(){
from("file:D:\\New folder\\input").
choice()
.when(xpath("/Order/Country='USA'")).to("file:D:\\New folder\\a")
.otherwise().to("file:D:\\New folder\\b")
.end();
}
});
System.out.println("Starting Camel Context......");
camelContext.start();
      Thread.sleep(3000);
      camelContext.stop();
	}

}
