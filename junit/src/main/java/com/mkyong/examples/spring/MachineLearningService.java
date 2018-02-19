package com.mkyong.examples.spring;

import org.springframework.stereotype.Service;

@Service("ml")
public class MachineLearningService implements DataModelService {

    public boolean isValid(String input) {
        return true;
    }
    
    public boolean beginWith(String s1, String s2) {
    	if (s1 == null)
    		return false;
    	return s1.startsWith(s2);
    }

}