package com.test.interview;

class BeanData {
    private String title;
    private String action;
    private Class<?> aClass;


    public BeanData(String title, String action, Class<?> aClass) {
        this.title = title;
        this.action = action;
        this.aClass = aClass;
    }

    public Class<?> getaClass() {
        return aClass;
    }

    public void setaClass(Class<?> aClass) {
        this.aClass = aClass;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
