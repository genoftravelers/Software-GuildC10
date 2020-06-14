/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Car;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface CarLotDAO {

    public Car addCar(String VIN, Car car);

    public Car getCar(String VIN);

    public List<Car> getCars();

    public void editCar(String VIN, Car car);

    public Car removeCar(String VIN);
}
