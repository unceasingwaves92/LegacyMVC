package com.tim.controller;

import com.tim.entity.Application;
import com.tim.exception.ApplicationNotFoundException;
import com.tim.exceptionhandling.ExceptionResponse;
import com.tim.exceptionhandling.ResourceNotFoundException;
import com.tim.model.ApplicationRequest;
import com.tim.model.ApplicationVO;
import com.tim.service.ApplicationService;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("applications")
//@Slf4j
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;

	@GetMapping("/list")
	public ModelAndView getApplication(Model model) {
		// log.info("Inside the ApplicationController.getApplications");
		List<ApplicationVO> applicationVOS = null;
		try {
			applicationVOS = applicationService.findAll();
			// log.info("Application response:{}", applicationVOS);
			if (CollectionUtils.isEmpty(applicationVOS)) {
				// log.info("Application details not found");
				// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			// log.info("Exception while calling getApplications", ex);
			// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// return new ResponseEntity<List<ApplicationVO>>(applicationVOS,
		// HttpStatus.OK);
		model.addAttribute("applications", applicationVOS);
		return new ModelAndView("listapplications");
	}

	@GetMapping("/add")
	public ModelAndView addCourse(Model model) {
		// Employee employee=new Employee();
		try {
			// ApplicationRequest applicationRequest = new ApplicationRequest();
			model.addAttribute("applicationRequest", new ApplicationRequest());
		} catch (Exception ex) {
			// log.info("Exception while calling getApplications", ex);

		}
		return new ModelAndView("addapplications");
	}

	@PostMapping("/save")
	public String addapplications(@ModelAttribute("applicationRequest") ApplicationRequest applicationRequest) {
		try {
			applicationService.save(applicationRequest);
			// LOGGER.info("Record Inserted Successfully");

		} catch (Exception e) {
			// LOGGER.error("Error Inserting Records", e);
		}
		return "redirect:/applications/list";
	}

	@RequestMapping("/editDetails/{id}")
	public String updateCourse(@PathVariable("id") long id, Model model) {
		ApplicationVO applicationVO = null;
		try {
			applicationVO = applicationService.getAppId(id);
			if (applicationVO == null) {
				// log.info("Application details not found");

			}
			model.addAttribute("application", applicationVO);
		} catch (Exception ex) {
			// log.info("Exception error while processing the
			// ApplicationController.getApplicationById", ex);

		}

		return "editapplications";
	};
		
	 
	
	  @RequestMapping("/update") 
	  public String editapplications(@ModelAttribute("application") ApplicationVO application) {
	  // log.info("Inside ApplicationController.save, applicationVO:{}", application); 
		  if(application==null){ //
	 // log.info("Invalid Application Request");
	  
	  } // Model response applicationVO but service layer expecting applicationRequest we can converting 
	  ApplicationRequest applicationRequest = new ApplicationRequest();
	  applicationRequest.setApplicationId(application.getApplicationId());
	  applicationRequest.setApplicationName(application.getApplicationName());
	  applicationRequest.setDescription(application.getDescription());
	  applicationRequest.setOwner(application.getOwner()); try { application =
	  applicationService.save(applicationRequest); if(application == null){ //
	 // log.info("Application details are not saved");
	  
	  } } catch (Exception ex) { //
	 // log.error("Exception while saving applications");
	  
	  } return "redirect:/applications/list";
	  
	  
	  }
	 
	 
	@RequestMapping("/delete/{id}")
	public String deleteApplicationById(@PathVariable("id") long id) {
		// log.info("Input to ApplicationController.deleteApplicationById, id:{}", id);
		String applicationVO = null;
		try {
			applicationService.delete(id);
			// log.info("Delete Application details for the application id:{}, and
			// details:{}", id, applicationVO);
			// log.info("Application details found");
			// return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception ex) {
			if (applicationVO == null) {
				// log.info("Application details not found");
				// log.info("Exception error while processing the
				// ApplicationController.deleteApplicationById" , ex);

			}
		}

		return "redirect:/applications/list";

	}

}
