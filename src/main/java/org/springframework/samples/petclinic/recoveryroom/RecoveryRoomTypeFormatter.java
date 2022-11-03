package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{
	
	private RecoveryRoomService recoveryRoomService;
	
	
	@Autowired
    public RecoveryRoomTypeFormatter(RecoveryRoomService recoveryRoomService) {
		super();
		this.recoveryRoomService = recoveryRoomService;
	}

	@Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
    	RecoveryRoomType findRoomType = recoveryRoomService.getRecoveryRoomType(text);
        if(findRoomType != null) {
        	return findRoomType;
        }else {
        	throw new ParseException("Type not found: " + text, 0);
        }
    }
    
}
