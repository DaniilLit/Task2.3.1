package web.controller;

import CarService.CarServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import Model.Car;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String getCarTable(@RequestParam(value = "count", defaultValue = "5") int count, Model model )    {
        CarServiceImpl carService = new CarServiceImpl();
        List<Car> carsList = new ArrayList<>();
        carsList = carService.getCarCount(count);
        model.addAttribute("carList", carsList);
        return "cars";
    }
}
