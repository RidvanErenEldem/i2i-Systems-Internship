package com.eldem.swaggerdemo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.eldem.swaggerdemo.models.DataModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DataResource {

    ConcurrentMap<String, DataModel> datas = new ConcurrentHashMap<String, DataModel>();
    
    @GetMapping("/data/{id}")
    public DataModel getData(@PathVariable("id") String id)
    {
        return datas.get(id);
    }

    @GetMapping("/data")
    public List<DataModel> getData()
    {
        return new ArrayList<DataModel>(datas.values());
    }

    @PostMapping("/data")
    public DataModel addData(@RequestBody DataModel dataModel)
    {
        datas.put(Integer.toString(dataModel.getId()), dataModel);
        return dataModel;
    }

}
