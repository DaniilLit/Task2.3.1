package CarService;

import Model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService{
    List<Car> car = new ArrayList<>(List.of(
            new Car("Merc", 244, 155),
            new Car("BMW", 7, 150),
            new Car("Audi", 5, 120),
            new Car("Haval", 227,115),
            new Car("Lada",9, Integer.MAX_VALUE)
    ));

    @Override
    public List<Car> getCarCount(int count) {
        count = count < 5 ? count : 5;
        return car.stream().limit(count).toList();
    }
}
