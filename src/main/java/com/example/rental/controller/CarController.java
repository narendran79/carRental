package com.example.rental.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rental.email.Mail;
import com.example.rental.model.Car;
import com.example.rental.repository.CarRepository;

@RestController
@RequestMapping("/api/rental")
public class CarController {
	
	private static final Logger log = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private Mail mail;
	
	@GetMapping("/")
	public List<Car> getAllCar(){
		return this.carRepository.findAll();
	}
	
	@GetMapping("/id")
	public Integer getCarId(@RequestParam("carName") String name){
		List<Car> tmp_cars = this.carRepository.findBycarName(name);
		if(tmp_cars.isEmpty()) return -1;
		return tmp_cars.get(0).getCarId();
	}
	
	@PostMapping("/create")
	public void createCarDetails(@RequestParam("id") Integer id, @RequestParam("carName") String name, 
			@RequestParam("details") String details, @RequestParam("milege") String mileage, @RequestParam("image") String image ) {
		Car carDetail = new Car();
		carDetail.setCarId(id);
		carDetail.setCarName(name);
		carDetail.setDetails(details);
		carDetail.setMilege(mileage);
		carDetail.setImage(image);
		carRepository.save(carDetail);
		log.info("Car Detail have been added");
		
//		String to = "narennarendran797@gmail.com";
//		String subject = "Added upp!";
//		String body = "You car has been to the rental list of Avis "+ "\n" + id + "\n" + name + "\n" + details + "\n" +mileage;
//		mail.sendEmail(to, body, subject);
//		log.info("Email has been sented!");
	}
	
//	@PutMapping("/update")
//	public Car updateCar(@RequestParam Integer carId, @RequestBody Car car) {
//		Optional<Car> carNo = this.carRepository.findById(carId);
//		if(carNo != null) {
//			this.carRepository.save(car);
//		}
//		return car;
//	}
	
//	@DeleteMapping("/delete")
//	public Car deleteCar(@RequestParam Integer carId, @RequestBody Car car) {
//		Optional<Car> carNo = this.carRepository.findById(carId);
//		if(carNo != null) {
//			this.carRepository.delete(car);
//		}
//		return null;
//	}

	@PostMapping("/delete")
	public void deleteCar(@RequestParam Integer id) {
		Optional<Car> optCar = carRepository.findById(id);
		if(optCar.isPresent()) {
		carRepository.deleteById(id);
		log.info("Car Detail have been deleted!");
		
		Car car = optCar.get();
		String to = "narennarendran797@gmail.com";
		String subject = "Deleted :(";
		String body = "You car has been deleted from the rental list of Avis "+ "\n" + id + "\n" + car.getCarName();
		mail.sendEmail(to, body, subject);
		log.info("Email has been sented!");
		}
	}
	
	@PostMapping("/book")
	public void bookCar(@RequestParam("id") Integer id, @RequestParam("email") String username,
			@RequestParam("name") String name, @RequestParam("time") String time) {
		Optional<Car> optCar = carRepository.findById(id);
		if(optCar.isPresent()) {
			Car car = optCar.get();
			String details = "\n" + "Name: " + name + "\n"+ "Time: " + time; 
			String subject = "It's yours now!";
			String text = "Your Booking is confirmed for:  " + car.getCarName() + "\n" + "Your id: " + id + details ;
			mail.sendEmail(username, text, subject);
			log.info("Booking has done");
		}
	}
}
