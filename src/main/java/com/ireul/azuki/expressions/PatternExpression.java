package com.ireul.azuki.expressions;

import com.ireul.azuki.AzukiException;
import com.ireul.azuki.expressions.base.EvaluationExpression;

import java.util.Map;

/**
 * @author Ryan Wade
 */
public class PatternExpression extends EvaluationExpression {

    public PatternExpression(Object object) throws AzukiException {
        super(object);
    }

    @Override
    public boolean validate(Map<String, String> map) {
        for (Map.Entry<String, String> entry : getValues().entrySet()) {
            String value = map.get(entry.getKey());
            if (value == null || !value.matches(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

}
