package com.itheima.controller;


import com.itheima.pojo.Storage;
import com.itheima.service.StorageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;


    @RequestMapping("all")
    public List<Storage> findAll(){
        return storageService.findAll();
    }
}
