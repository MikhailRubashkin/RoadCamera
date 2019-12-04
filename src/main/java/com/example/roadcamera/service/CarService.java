package com.example.roadcamera.service;

import com.example.roadcamera.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CarService  {

    @Autowired
    public CarRepo carRepo;



    public class CarNumberValidator{

        private Pattern pattern;
        private Matcher matcher;

        private static final String IPADDRESS_PATTERN =
                "[A-Z0-9\\- ]{4,16}";

        public CarNumberValidator(){
            pattern = Pattern.compile(IPADDRESS_PATTERN);
        }

        public boolean validate(final String carNumber){
            matcher = pattern.matcher(carNumber);
            return matcher.matches();
        }
    }
}
