package com.example.formBinding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.formBinding.entity.Student;

import jakarta.validation.Valid;

@Controller
public class FormController {
	
	@Value("${streams}")
	List<String> streams;
	
	@Value("${languages}")
	List<String> langList;
	
	public void populateList(Model model) {
		model.addAttribute("streamsList", streams);
		model.addAttribute("langList", langList);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringEditor);
	}

	@GetMapping("/show-form")
	public String showForm(Model theModel) {
		theModel.addAttribute("mystudent", new Student());
		populateList(theModel);
		
		return "student_form";
	}
	
	@PostMapping("/process-form")
	public String processForm(@Valid @ModelAttribute("mystudent") Student theStudent, BindingResult bindingResult, Model theModel) {
		if(bindingResult.hasErrors()) {
			populateList(theModel);
			return "student_form";
		}
		else {
			return "confirmation-page";
		}
	}
}
