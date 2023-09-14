package br.anhembi.veiculos.dto;

import br.anhembi.veiculos.entities.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CarDTO {
    private String plate;
    private int year;
    private String color;

    public CarDTO(Car car) {
        plate = car.getPlate();
        year = car.getYear();
        color = car.getColor();
    }

    public Car toCar() {
        return new Car(null, plate, year, color, null);
    }
}
