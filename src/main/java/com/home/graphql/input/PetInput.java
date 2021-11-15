package com.home.graphql.input;

import graphql.schema.GraphQLInputType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetInput implements GraphQLInputType {

    private String name;
    private Long ownerId;

    @Override
    public String getName() {
        return name;
    }
}
