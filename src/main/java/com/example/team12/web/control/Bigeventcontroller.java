package com.example.team12.web.control;

import com.example.team12.bean.Bigevent;
import com.example.team12.service.Impl.BigeventmapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bigevent")
public class Bigeventcontroller {
    @Autowired
    private BigeventmapperImpl bigeventmapper;

    @GetMapping("/query")
    public List<Bigevent> query(){
        return bigeventmapper.query();
    }
}
