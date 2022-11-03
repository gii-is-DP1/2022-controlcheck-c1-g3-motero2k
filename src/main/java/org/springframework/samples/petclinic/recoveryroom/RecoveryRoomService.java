package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class RecoveryRoomService {
	private RecoveryRoomRepository recoveryRoomRepository;
	
	@Autowired
    public RecoveryRoomService(RecoveryRoomRepository recoveryRoomRepository) {
		super();
		this.recoveryRoomRepository = recoveryRoomRepository;
	}
	@Transactional(readOnly = true)
	public List<RecoveryRoom> getAll(){
        return recoveryRoomRepository.findAll();
    }
	
	public RecoveryRoom findById2(int id) {
		return recoveryRoomRepository.findById2(id);
	}
    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }
    @Transactional(readOnly = true)
    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return recoveryRoomRepository.getRecoveryRoomType(typeName);
    }
    @Transactional(rollbackFor = DuplicatedRoomNameException.class)
    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
    	return recoveryRoomRepository.save(p);       
    }

    
}
