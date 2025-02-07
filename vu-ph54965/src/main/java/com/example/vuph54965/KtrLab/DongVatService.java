package com.example.vuph54965.KtrLab;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DongVatService {
    List<DongVat> list= new ArrayList<>();

    public DongVatService() {
        list.add(new DongVat(1,"cho",4,"an thit","Ha Nam",true));
        list.add(new DongVat(2,"meo",4,"an thit","Ha Nam",true));
        list.add(new DongVat(3,"lon",4,"an tap","Ha Nam",false));
        list.add(new DongVat(4,"ga",4,"an chay","Ha Nam",true));
        list.add(new DongVat(5,"vit",4,"an chay","Ha Nam",false));
    }

    public List<DongVat> getList() {
        return list;
    }
    public void delete(Integer id){
        list.removeIf( i ->i.getId().equals(id));
    }
    public void add(DongVat dongVat){
        list.add(dongVat);
    }
    public  DongVat detail(Integer id){
        return  list.stream().filter(d-> d.getId().equals(id)).findFirst().orElse(null);
    }
    public void update(DongVat dongVat){
        list.replaceAll(id->id.getId().equals(dongVat.getId()) ?dongVat:id);
    }
}
