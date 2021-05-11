package com.example.controller;

import com.example.entity.contract.Contract;
import com.example.entity.contract.ContractDetail;
import com.example.service.ContractDetailService;
import com.example.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contractdetail")
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private ContractService contractService;

    @GetMapping("/")
    public String pageContractDetail(Model model,@PageableDefault(size = 4) Pageable pageable) {
        model.addAttribute( "contractDetails", contractDetailService.findAll( pageable ) );
        return "/contract/listContractDetail";
    }

    @GetMapping("/create")
    public String create(Model model, Pageable pageable) {
        model.addAttribute( "attachServices", contractDetailService.findAllAttachService() );
        model.addAttribute( "contractDetail", new ContractDetail() );
        model.addAttribute( "contracts", contractService.findAll( pageable ) );
        return "/contract/createContractDetail";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, Pageable pageable, @PathVariable Integer id) {
        model.addAttribute( "attachServices", contractDetailService.findAllAttachService() );
        model.addAttribute( "contractDetail", contractDetailService.findById( id ) );
        model.addAttribute( "contracts", contractService.findAll( pageable ) );
        return "/contract/editContractDetail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        contractDetailService.delete( id );
        return "redirect:/contractdetail/";
    }

    @GetMapping("/totalMoney/{id}")
    public String totalMoney(@PathVariable Integer id, Model model) {
        ContractDetail contractDetail = contractDetailService.findById( id );
        model.addAttribute( "contractDetail", contractDetail );
        Double attachServiceMoney = contractDetail.getAttachService().getAttachServiceCost() *
                contractDetail.getAttachService().getAttachServiceUnit();
        Double contractMoney = contractDetail.getContract().getContractTotalMoney() + contractDetail.getContract().getContractDeposit();
        Double totalMoney = attachServiceMoney + contractMoney * contractDetail.getQuantity();
        model.addAttribute( "totalMoney", totalMoney );
        return "/contract/totalMoney";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute ContractDetail contractDetail, BindingResult bindingResult,
                       @RequestParam String action, Model model, Pageable pageable) {
        model.addAttribute( "attachServices", contractDetailService.findAllAttachService() );
        model.addAttribute( "contractDetail", contractDetail );
        model.addAttribute( "contracts", contractService.findAll( pageable ) );
        if (bindingResult.hasErrors()) {
            if (action.equals( "create" )) {
                return "/contract/createContractDetail";
            } else {
                return "/contract/editContractDetail";
            }
        } else {
            contractDetailService.save( contractDetail );
            return "redirect:/contractdetail/";
        }
    }
}
