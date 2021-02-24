package com.example.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Override
    public Map<String, String> dictionary() {
        Map<String, String> map = new TreeMap<>();
        map.put( "home", "Nha" );
        map.put( "dog", "Con Cho" );
        map.put( "cat", "Con Meo" );
        map.put( "book", "Sach" );
        map.put( "hello", "Xin Chao" );
        return map;
    }

    @Override
    public String search(String search){
        String result;
        if (dictionary().get( search ) != null){
            result = dictionary().get( search );
        }else {
            result = "Khong Tim Thay";
        }
        return result;
    }
}
