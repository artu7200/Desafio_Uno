package com.desafiouno.springboot.service;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

import com.desafiouno.springboot.pojo.fechaPOJO;

@RestController
@RequestMapping(path = "/servicesREST")
public class RestFecha {

	@RequestMapping(method = RequestMethod.POST, path = "/validateFechas", consumes = "application/json", produces = "application/json")

	/*
	 * public @ResponseBody fechaPOJO validateUser(@RequestBody fechaPOJO user)
	 * throws Exception { fechaPOJO response = new fechaPOJO();
	 * response.setFind(false); System.out.println("User: " + user.getUser());
	 * System.out.println("Password: " + user.getPassword()); try { if
	 * (user.getUser().equals("Java") && user.getPassword().equals("Revolutions")) {
	 * response.setUser(user.getUser()); response.setPassword("mamalo mardito");
	 * response.setFind(true); } return response; } catch (Exception ex) {
	 * 
	 * return response; } }
	 */

	public @ResponseBody fechaPOJO validateUser(@RequestBody fechaPOJO periodo) throws Exception {
		fechaPOJO response = new fechaPOJO();


		try {
			
			if(periodo.getFechaCreacion().isBefore(periodo.getFechaFin()))
			{
			response.setId(periodo.getId());
			response.setFechaCreacion(periodo.getFechaCreacion());
			response.setFechaFin(periodo.getFechaFin());			

			LocalDate fechaAux = periodo.getFechaCreacion();
			System.out.println("Aux: " + fechaAux);
			
			int count =0;

			while (fechaAux.isBefore(periodo.getFechaFin().plusMonths(1))&&count<100) {				
				System.out.println("Fecha Actual ---: " + fechaAux);
				System.out.println("Fecha Actual tiene ---: " + periodo.getFechas().contains(fechaAux));
				if(periodo.getFechas().contains(fechaAux))
					response.addFechasItem(fechaAux);
				else
					response.addFechasFaltantesItem(fechaAux);
				
				fechaAux = fechaAux.plusMonths(1);
				count++;
			}

			System.out.println("Id: " + response.getId());
			System.out.println("FechaCreacion: " + response.getFechaCreacion());
			System.out.println("FechaFin: " + response.getFechaFin());

			System.out.println("Fechas: " + response.getFechas());
			
			System.out.println("FechasFaltantes: " + response.getFechasFaltantes());
			}else {
				System.out.println("Rango invalido ");
			}
			return response;
		} catch (Exception ex) {

			return response;
		}
	}
}
