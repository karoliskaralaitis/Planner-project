package com.karalaitis.planner;

public class HttpEndpoints {

    public static final String GOALS = "/goals";
    public static final String GOALS_CREATE = GOALS + "/create";
    public static final String GOALS_UPDATE = GOALS + "/{goalId}/update";
    public static final String GOALS_DELETE = GOALS + "/{goalId}/delete";
    public static final String GOALS_PAGE = GOALS + "/{goalId}/page";
}
