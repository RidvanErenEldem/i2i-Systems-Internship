package com.eldem.swaggerdemo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.eldem.swaggerdemo.models.VoiceModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VoiceResource {

    ConcurrentMap<String, VoiceModel> voices = new ConcurrentHashMap<String, VoiceModel>();
    
    @GetMapping("/voice/{id}")
    public VoiceModel getVoice(@PathVariable String id) 
    {
        return voices.get(id);
    }
    
    @GetMapping("/voice")
    public List<VoiceModel> getAllVoices() 
    {
        return new ArrayList<VoiceModel>(voices.values());
    }

    @PostMapping("/voice")
    public VoiceModel addVoice(@RequestBody VoiceModel voiceModel)
    {
        voices.put(Integer.toString(voiceModel.getId()), voiceModel);
        return voiceModel;
    }
}
