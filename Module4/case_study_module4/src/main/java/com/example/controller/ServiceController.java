package com.example.controller;

import com.example.entity.service.Service;
import com.example.entity.service.ServiceType;
import com.example.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/villa")
    public String pageServiceVilla(Model model, Pageable pageable) {
        ServiceType serviceType = new ServiceType();
        serviceType.setServiceTypeId( 1 );
        serviceType.setServiceTypeName( "Villa" );
        model.addAttribute( "villas", serviceService.findAllServicesByServiceType( serviceType, pageable ) );
        return "/service/listVilla";
    }

    @GetMapping("/house")
    public String pageServiceHouse(Model model, Pageable pageable) {
        ServiceType serviceType = new ServiceType();
        serviceType.setServiceTypeId( 2 );
        serviceType.setServiceTypeName( "House" );
        model.addAttribute( "houses", serviceService.findAllServicesByServiceType( serviceType, pageable ) );
        return "/service/listHouse";
    }

    @GetMapping("/room")
    public String pageServiceRoom(Model model, Pageable pageable) {
        ServiceType serviceType = new ServiceType();
        serviceType.setServiceTypeId( 3 );
        serviceType.setServiceTypeName( "Room" );
        model.addAttribute( "rooms", serviceService.findAllServicesByServiceType( serviceType, pageable ) );
        return "/service/listRoom";
    }

    @GetMapping("/create")
    public String create( Model model) {
        model.addAttribute( "service", new Service() );
        model.addAttribute( "serviceTypes", serviceService.findAllServiceType() );
        model.addAttribute( "rentTypes", serviceService.findAllRentType() );
        return "/service/create";
    }
    @GetMapping("/createService")
    public String create(@RequestParam("service") Integer type , Model model) {
        model.addAttribute( "service",new Service() );
        ServiceType serviceType = serviceService.findTypeById( type );
        model.addAttribute( "type",serviceType );
        model.addAttribute( "rentTypes", serviceService.findAllRentType() );
        if (type==1){
            return "service/createVilla";
        }else if (type==2){
            return "service/createHouse";
        }else {
            return "service/createRoom";
        }
    }


    @PostMapping("/save")
    public String save(@ModelAttribute Service service) {
        serviceService.save( service );
        return "redirect:/service/villa";
    }
}
