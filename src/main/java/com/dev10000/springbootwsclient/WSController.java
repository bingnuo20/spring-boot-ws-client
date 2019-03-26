package com.dev10000.springbootwsclient;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping()
public class WSController {

    @ResponseBody
    @RequestMapping("getResult")
    public Map<String,Object> getResult(int a,int b) throws Exception{
        Map<String,Object> obj=new HashMap<>();
        JaxWsDynamicClientFactory jaxWsDynamicClientFactory=JaxWsDynamicClientFactory.newInstance();
         Client client=jaxWsDynamicClientFactory.createClient("http://localhost:8080/cxf/calc?wsdl");
         Object[] objects=new Object[0];
         objects=client.invoke("add",a,b);
         obj.put("result",objects[0]);
         return obj;
    }
}
