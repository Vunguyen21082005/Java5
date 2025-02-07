package com.example.vuph54965.KtrLab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DongVatController {
    @Autowired
    private DongVatService dongVatService;
    @GetMapping("dong-vat/hien-thi")
    public String hienThi(Model model){
        model.addAttribute("list",dongVatService.list);
        return "dong-vat/hien-thi";
    }
    @GetMapping("/dong-vat/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        dongVatService.delete(id);
        return "redirect:/dong-vat/hien-thi";
    }
    @PostMapping("dong-vat/add")
    public String add(DongVat dongVat,Model model){
        dongVatService.add(dongVat);
        return "redirect:/dong-vat/hien-thi";
    }
    @GetMapping("dong-vat/detail/{id}")
    public String detail(@PathVariable("id") Integer id,Model model){
        model.addAttribute("list",dongVatService.detail(id));
        return "dong-vat/update";
    }
    @PostMapping("dong-vat/update")
    public String update(DongVat dongVat,Model model){
        dongVatService.update(dongVat);
        return "redirect:/dong-vat/hien-thi";
    }

}
