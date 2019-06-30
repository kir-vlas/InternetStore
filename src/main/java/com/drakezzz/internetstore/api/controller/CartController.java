package com.drakezzz.internetstore.api.controller;

import com.drakezzz.internetstore.api.dto.StatusResult;
import com.drakezzz.internetstore.entity.Cart;
import com.drakezzz.internetstore.entity.Good;
import com.drakezzz.internetstore.service.GoodService;
import com.drakezzz.internetstore.util.CartUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v2/cart")
@RequiredArgsConstructor
public class CartController {

    //todo move cart in database

    private final GoodService goodService;

    @GetMapping
    public Cart getCart(HttpServletRequest request) {
        return CartUtils.getCartInSession(request);
    }

    @PutMapping
    public StatusResult updateCart(HttpServletRequest request, @RequestBody Cart cart) {
        Cart savedCart = CartUtils.getCartInSession(request);
        savedCart.updateQuantity(cart);
        return StatusResult.ok();
    }

    @DeleteMapping("/{goodId}")
    public StatusResult removeGoodFromCart(HttpServletRequest request, @PathVariable Long goodId) {
        Cart cart = CartUtils.getCartInSession(request);
        cart.removeGood(goodId);
        return StatusResult.ok();
    }

    @PatchMapping("/{goodId}")
    public StatusResult addToCart(HttpServletRequest request, @PathVariable Long goodId) {
        Cart cart = CartUtils.getCartInSession(request);
        Good good = goodService.listGoodById(goodId);
        cart.AddItem(good, 1L);
        return StatusResult.ok();
    }

}
