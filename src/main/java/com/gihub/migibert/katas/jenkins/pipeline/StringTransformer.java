package com.gihub.migibert.katas.jenkins.pipeline;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StringTransformer {

    /**
     * @param input a string, for example abCndE
     * @return transformed string like this : ABbCccDdddEeeee
     */
    public String firstTransformation(String input) {
        StringBuilder builder = new StringBuilder();
        String toProcess = input.toLowerCase();
        for(int i=0; i<toProcess.length(); i++) {
            Character current = toProcess.charAt(i);
            builder.append(Character.toUpperCase(current));
            for(int j=0; j<i; j++) {
                builder.append(Character.toLowerCase(current));
            }
        }
        return builder.toString();
    }
}
