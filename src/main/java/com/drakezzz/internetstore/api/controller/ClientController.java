package com.drakezzz.internetstore.api.controller;

import com.drakezzz.internetstore.api.dto.ShopClient;
import com.drakezzz.internetstore.api.dto.StatusResult;
import com.drakezzz.internetstore.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/client")
@RequiredArgsConstructor
public class ClientController {

    private final AccountService accountService;

    @PostMapping
    public StatusResult registerClient(@RequestBody ShopClient shopClient) {
        return accountService.registerClient(shopClient);
    }

    @GetMapping("/{username}")
    public ShopClient getClientInfo(@PathVariable String username) {
        return null;
    }

}
