package kz.webProgram.controller;


import kz.webProgram.model.Basket;
import kz.webProgram.model.ResultDto;
import kz.webProgram.model.Toys;
import kz.webProgram.model.User;
import kz.webProgram.service.BasketService;
import kz.webProgram.service.ToysService;
import kz.webProgram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppController {
    @Autowired
    private ToysService service;

    @Autowired
    private BasketService basketService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Toys> getList() {
        List<Toys> listToys = service.listAll();
        return listToys;

    }


    @RequestMapping(value = "/listBasketCab", method = RequestMethod.GET)
    public List<Basket> getListBasketCab() {
        List<Basket> listBasket = basketService.listAll();
        return listBasket;

    }

    @RequestMapping(value = "/deleteBasket/{id}", method = RequestMethod.DELETE)
    public void deleteBasket(@PathVariable(name = "id") int id) {
        basketService.delete(id);
    }

    @RequestMapping(value = "/addBasket", method = RequestMethod.POST)
    public int addBasket(@ModelAttribute("data") Basket basket) {
        basketService.save(basket);
        List<Basket> baskets = basketService.listAll();
        List<Basket> basketList = new ArrayList<>();
        for (Basket basket1 : baskets) {
            if (basket.getUsername().equals(basket1.getUsername())) {
                basketList.add(basket1);
            }
        }
        return basketList.size();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user) {

        String result = null;
        List<User> usersFromDb = userService.listAll();

        if (  checkEmail(usersFromDb, user)  ) {
            result = "уже существует";
        } else {
            result = "success";
            userService.save(user);
        }
        return result;
    }

    private Boolean checkEmail(List<User> users, User user) {
        List<String> stringList = new ArrayList<>();
        for (User user1: users) {
            stringList.add(user1.getEmail());
        }
        return stringList.contains(user.getEmail());
    }




    @RequestMapping(value = "/getListregister", method = RequestMethod.GET)
    public List<User> getListregister() {
        List<User> listUser = userService.listAll();
        return listUser;

    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResultDto auth(@ModelAttribute("user") User user) {

        ResultDto resultDto = new ResultDto();

        List<User> usersFromDb = userService.listAll();
        String res = null;

        Boolean aBoolean = checkEmail(usersFromDb, user);

        if (  aBoolean ) {//da esti v baze
            for (User user1: usersFromDb) {
                if (user1.getEmail().equals(user.getEmail())) {
                    if (user1.getPwd().equals(user.getPwd())) {
                        resultDto.setStatus("success");
                        resultDto.setDescription("Вы успешно авторизовались");
                        resultDto.setUser(user1);
                        break;
                    } else {
                        resultDto.setStatus("failure");
                        resultDto.setDescription("не верный пароль");
                        resultDto.setUser(user1);
                        break;
                    }
                }
            }

        } else {//net v baze
            resultDto.setStatus("failure");
            resultDto.setDescription("вы не зарегистрированы в нашем сайте");
        }
        return  resultDto;
    }
}


