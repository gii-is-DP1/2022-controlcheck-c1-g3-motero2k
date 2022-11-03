package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom,Integer>{
    List<RecoveryRoom> findAll();
    Optional<RecoveryRoom> findById(int id);
    @Query("SELECT rr FROM RecoveryRoom rr WHERE rr.id = :id")
    RecoveryRoom findById2(@Param("id")int id);
    RecoveryRoom save(RecoveryRoom p) throws DataAccessException;
    @Query("SELECT rrt FROM RecoveryRoomType rrt")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    @Query("SELECT rrt FROM RecoveryRoomType rrt WHERE rrt.name = :name")
    RecoveryRoomType getRecoveryRoomType(@Param("name") String name);
}
