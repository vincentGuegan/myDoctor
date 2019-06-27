package com.doctorwho.myDoctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


@Controller
@SpringBootApplication
public class MyDoctorApplication {



	public static void main(String[] args) {
		SpringApplication.run(MyDoctorApplication.class, args);
	}

	@RequestMapping("/doctor/{incarnation}")
	@ResponseBody
	public Doctor getDoctor (@PathVariable int incarnation, @RequestParam(required = false) boolean details) {
		
		String [][] tableau = {
			{"Christopher Eccleston", "9", "13", "41"},
			{"David Tennant", "10", "34", "47"},
			{"Matt Smith", "11", "44", "27"},
			{"Peter Capaldi", "12", "40", "55"},
			{"Jodie Whittaker", "13", "11", "35"}
		};
		
		if (incarnation >= 9 && incarnation <= 13){
			if (details==true){
				return new ExtendedDoctor(tableau[incarnation-9][0], tableau[incarnation-9][1], tableau[incarnation-9][2], tableau[incarnation-9][3]);
				
			}
			return new Doctor(tableau[incarnation-9][0], tableau[incarnation-9][1]);
		}
		else if (incarnation >=1 && incarnation <=8){
			throw new ResponseStatusException(HttpStatus.SEE_OTHER); //renvoi page 303
		}
		else{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation" + incarnation);
		}
	}
	
	class Doctor {
		private String name;
		private String number;

		public Doctor (String name, String number){ //constructeur

			this.name = name; //this est la référence de l'instance
			this.number=number; //this est la référence de l'instance
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}


	}


	class ExtendedDoctor extends Doctor { //extension class Doctor afin d'y ajouter des attributs

		private String numberOfEpisodes;
		private String ageAtStart;
	
		public ExtendedDoctor(String name, String number, String numberOfEpisodes, String ageAtStart) {
			super(name, number); //super = récupère les attributs présents dans Doctor
			this.numberOfEpisodes = numberOfEpisodes;
			this.ageAtStart = ageAtStart;
		}

		public String getNumberOfEpisodes() {
			return numberOfEpisodes;
		}

		public void setNumberOfEpisodes(String numberOfEpisodes) {
			this.numberOfEpisodes = numberOfEpisodes;
		}

		public String getAgeAtStart() {
			return ageAtStart;
		}

		public void setAgeAtStart(String ageAtStart) {
			this.ageAtStart = ageAtStart;
		}
	}

}
