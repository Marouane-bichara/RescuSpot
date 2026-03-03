package com.example.rescuespot.shelter.mapper;


import com.example.rescuespot.identity.mapper.AccountMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = AccountMapper.class  )
public interface IShelterMapper {
}
