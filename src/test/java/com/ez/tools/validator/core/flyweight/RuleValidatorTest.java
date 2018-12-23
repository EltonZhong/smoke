package com.ez.tools.validator.core.flyweight;

import com.ez.tools.validator.Smoke;
import com.ez.tools.validator.factory.rules.Dto2;
import com.ez.tools.validator.factory.rules.DtoForRule1;
import org.junit.Test;

public class RuleValidatorTest {

    @Test(expected = IllegalStateException.class)
    public void smokeTest() {
        DtoForRule1 dtoForRule1 = new DtoForRule1();
        Smoke.validate(dtoForRule1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rulesOnInterfacesWillBeValidated() {
        Smoke.validate(new Dto2.Dto3());
    }
}
