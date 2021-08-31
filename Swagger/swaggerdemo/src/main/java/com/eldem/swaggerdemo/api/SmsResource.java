package com.eldem.swaggerdemo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.eldem.swaggerdemo.models.SmsModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class SmsResource {

    ConcurrentMap<String, SmsModel>smses = new ConcurrentHashMap<String, SmsModel>();
    
    @GetMapping("/sms/{id}")
    public SmsModel getData(@PathVariable("id") String id)
    {
        return smses.get(id);
    }

    @GetMapping("/sms")
    public List<SmsModel> getData()
    {
        return new ArrayList<SmsModel>(smses.values());
    }

    @PostMapping("/sms")
    public SmsModel addData(@RequestBody SmsModel smsModel)
    {
        smses.put(Integer.toString(smsModel.getId()), smsModel);
        return smsModel;
    }

}
