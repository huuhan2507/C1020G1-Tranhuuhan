package com.example.service.impl;

import com.example.service.SettingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SettingServiceImpl implements SettingService {
    @Override
    public List<String> language() {
        List<String> listLanguage = new ArrayList<>(  );
        listLanguage.add( "English" );
        listLanguage.add( "Vietnamese" );
        listLanguage.add( "Japanese" );
        listLanguage.add( "Chinese" );
        return listLanguage;
    }

    @Override
    public List<Integer> page() {
        List<Integer> listPage = new ArrayList<>(  );
        listPage.add( 5 );
        listPage.add( 10 );
        listPage.add( 15 );
        listPage.add( 25 );
        listPage.add( 50 );
        listPage.add( 100 );

        return listPage;
    }

}
