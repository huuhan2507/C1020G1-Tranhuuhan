package com.example.controller;

import com.example.entity.contract.ContractDetail;
import com.example.service.ContractDetailService;
import com.example.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contractdetail")
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private ContractService contractService;

    @GetMapping("/")
    public String pageContractDetail(Model model, Pageable pageable){
        model.addAttribute( "contractDetails",contractDetailService.findAll( pageable ) );
        return "/contract/listContractDetail";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute( "attachServices",contractDetailService.findAllAttachService() );
        model.addAttribute( "contractDetail",new ContractDetail() );
        return "/contract/createContractDetail";
    }
}
