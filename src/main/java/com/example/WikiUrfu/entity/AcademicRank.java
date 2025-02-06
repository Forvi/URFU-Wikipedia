package com.example.WikiUrfu.entity;

public enum AcademicRank {
    ASSISTENT("Ассистент"),
    TEACHER("Преподаватель"),
    SENIOR_TEACHER("Старший преподаватель"),
    DOCENT("Доцент"),
    PROFESSOR("Профессор");

    private final String rank;

    AcademicRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
}
