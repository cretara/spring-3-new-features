package dev.cretara.spring3newfeatures.person.dto.mapper;

import dev.cretara.spring3newfeatures.person.model.Person;
import dev.cretara.spring3newfeatures.person.model.PersonDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface PersonMapper {
    Person toEntity(PersonDto personDto);

    PersonDto toDto(Person person);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    Person partialUpdate(PersonDto personDto, @MappingTarget Person person);
}