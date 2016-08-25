package com.realdolmen.spring_course.domain;

public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        System.out.println("I'm a knight and I am brave");
        quest.embark();
    }
}
