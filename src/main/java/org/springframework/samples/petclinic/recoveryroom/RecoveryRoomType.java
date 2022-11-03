package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_room_types")
public class RecoveryRoomType extends BaseEntity{
	
	@NotNull
	@Size(min = 5,max = 50,message = "name must have between 5 and 50 char")
	String name;
}
