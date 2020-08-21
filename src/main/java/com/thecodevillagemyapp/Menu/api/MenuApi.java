package com.thecodevillagemyapp.Menu.api;

import com.thecodevillagemyapp.Menu.model.Menu;
import com.thecodevillagemyapp.Menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MenuApi {
    private MenuService menuService;
    @Autowired
    public MenuApi(MenuService menuService) {
        this.menuService = menuService;
    }
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ResponseEntity createCustomerMenu(@RequestBody Menu menu){
        System.out.println("Name:"+menu.getName());
        //return new ResponseEntity<>(menuService.getCustomerMenu(), HttpStatus.OK);
        return new ResponseEntity(menuService.getCustomerMenu(),HttpStatus.OK);
    }
}
