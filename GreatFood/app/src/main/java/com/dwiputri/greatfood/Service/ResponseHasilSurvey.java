package com.dwiputri.greatfood.Service;

import java.util.List;

public class ResponseHasilSurvey {
    private String error;
    private List<ModelHasilSurvey> survey;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<ModelHasilSurvey> getSurvey() {
        return survey;
    }

    public void setSurvey(List<ModelHasilSurvey> survey) {
        this.survey = survey;
    }
}
