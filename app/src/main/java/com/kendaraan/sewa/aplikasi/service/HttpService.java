package com.kendaraan.sewa.aplikasi.service;

import com.kendaraan.sewa.aplikasi.Domain.Pelanggan;
import com.kendaraan.sewa.aplikasi.dto.RestBaseRespone;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpService {

    private static final String HOST = "http://192.168.1.94:8080";
    private static final String BASE_URL = HOST + "/api/";
    private RestTemplate restTemplate = new RestTemplate();

    public HttpService(){
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    public RestBaseRespone getAllPelanggan(){
        String url = BASE_URL + "pelanggan";
        return restTemplate.getForObject(url, RestBaseRespone.class);
    }

    public ResponseEntity<RestBaseRespone> getAllPelanggan2(){
        String url = BASE_URL + "pelanggan";
        return restTemplate.getForEntity(url, RestBaseRespone.class);
    }

}
