package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
    
	private static final String VIEWS_RECOVERY_ROOMS_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	private RecoveryRoomService recoveryRoomService;
	@Autowired
	public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
		super();
		this.recoveryRoomService = recoveryRoomService;
	}
	
	@GetMapping(value = "/create")
	public String initCreationForm(ModelMap model) {
		RecoveryRoom RecoveryRoom = new RecoveryRoom();
        model.put("recoveryRoom", RecoveryRoom);
		return VIEWS_RECOVERY_ROOMS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/create")
	public String processCreationForm(@Valid RecoveryRoom RecoveryRoom, BindingResult result, ModelMap model) throws DuplicatedRoomNameException{		
		if (result.hasErrors()) {
			model.put("recoveryRoom", RecoveryRoom);
			return VIEWS_RECOVERY_ROOMS_CREATE_OR_UPDATE_FORM;
		}
		else {
            try {
            	this.recoveryRoomService.save(RecoveryRoom);
                return "welcome";
			} catch (Exception e) {
				// TODO: handle exception
				return "/oups";
			}
			 
		}
	}
	
}
