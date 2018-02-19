package com.mkyong.spring;

import com.mkyong.examples.spring.AppConfig;
import com.mkyong.examples.spring.DataModelService;
import com.mkyong.examples.spring.MachineLearningService;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class MachineLearningTest {

	//DI
    @Autowired
    @Qualifier("ml")
    DataModelService ml;

    @Test
    public void test_ml_always_return_true() {

        //assert correct type/impl
        assertThat(ml, instanceOf(MachineLearningService.class));

        //assert true
        assertThat(ml.isValid(""), is(true));

    }
    
    @Test
    public void testBeginWithTrue() {
    	MachineLearningService m = new MachineLearningService();
    	assertTrue(m.beginWith("ahmed", "ah"));
    }
    
    @Test
    public void testBeginWithNotTrue() {
    	MachineLearningService m = new MachineLearningService();
    	assertThat(m.beginWith("ahmed", "am"), is(false));
    }
    
    @Test
    public void testBeginWithFirstStingIsNull() {
    	MachineLearningService m = new MachineLearningService();
    	assertThat(m.beginWith(null, "am"), is(false));
    }
}