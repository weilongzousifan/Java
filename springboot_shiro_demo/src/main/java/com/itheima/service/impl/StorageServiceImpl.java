package com.itheima.service.impl;


import com.itheima.mapper.StorageMapper;
import com.itheima.pojo.Storage;
import com.itheima.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    public List<Storage> findAll(){
        return storageMapper.selectList(null);
    }
}
