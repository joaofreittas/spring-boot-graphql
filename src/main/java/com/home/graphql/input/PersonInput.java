package com.home.graphql.input;

import com.home.graphql.model.Gender;
import graphql.schema.GraphQLInputType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonInput implements GraphQLInputType {

    private String name;
    private Integer age;
    private Gender gender;

    @Override
    public String getName() {
        return name;
    }
}
