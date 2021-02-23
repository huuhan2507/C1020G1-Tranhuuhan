package com.example.service;

import java.util.Map;
import java.util.TreeMap;

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
}
