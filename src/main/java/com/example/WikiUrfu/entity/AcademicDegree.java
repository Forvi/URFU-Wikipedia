package com.example.WikiUrfu.entity;

public enum AcademicDegree {
    // Первые ступени
    BACHELOR("", "Бакалавр"),
    MASTER("", "Магистр"),
    
    // Биологические науки
    DOCTOR_OF_BIOLOGICAL_SCIENCES("д.б.н.", "Доктор биологических наук"),
    CANDIDATE_OF_BIOLOGICAL_SCIENCES("к.б.н.", "Кандидат биологических наук"),

    // Военные науки
    CANDIDATE_OF_MILITARY_SCIENCES("к.воен.н.", "Кандидат военных наук"),

    // Географические науки
    DOCTOR_OF_GEOGRAPHICAL_SCIENCES("д.г.н.", "Доктор географических наук"),
    CANDIDATE_OF_GEOGRAPHICAL_SCIENCES("к.г.н.", "Кандидат географических наук"),

    // Геолого-минералогические науки
    DOCTOR_OF_GEOLOGICAL_MINERAL_SCIENCES("д.г.-м.н.", "Доктор геолого-минералогических наук"),
    CANDIDATE_OF_GEOLOGICAL_MINERAL_SCIENCES("к.г.-м.н.", "Кандидат геолого-минералогических наук"),

    // Исторические науки
    DOCTOR_OF_HISTORICAL_SCIENCES("д.и.н.", "Доктор исторических наук"),
    CANDIDATE_OF_HISTORICAL_SCIENCES("к.и.н.", "Кандидат исторических наук"),

    // Искусствоведение
    DOCTOR_OF_ARTS("д.иск.", "Доктор искусствоведения"),
    CANDIDATE_OF_ARTS("к.иск.", "Кандидат искусствоведения"),

    // Медицинские науки
    DOCTOR_OF_MEDICAL_SCIENCES("д.м.н.", "Доктор медицинских наук"),
    CANDIDATE_OF_MEDICAL_SCIENCES("к.м.н.", "Кандидат медицинских наук"),

    // Педагогические науки
    DOCTOR_OF_PEDAGOGICAL_SCIENCES("д.пед.н.", "Доктор педагогических наук"),
    CANDIDATE_OF_PEDAGOGICAL_SCIENCES("к.пед.н.", "Кандидат педагогических наук"),

    // Политические науки
    DOCTOR_OF_POLITICAL_SCIENCES("д.полит.н.", "Доктор политических наук"),
    CANDIDATE_OF_POLITICAL_SCIENCES("к.полит.н.", "Кандидат политических наук"),

    // Психологические науки
    DOCTOR_OF_PSYCHOLOGICAL_SCIENCES("д.п.н.", "Доктор психологических наук"),
    CANDIDATE_OF_PSYCHOLOGICAL_SCIENCES("к.п.н.", "Кандидат психологических наук"),

    // Сельскохозяйственные науки
    DOCTOR_OF_AGRICULTURAL_SCIENCES("д.с.-х.н.", "Доктор сельскохозяйственных наук"),
    CANDIDATE_OF_AGRICULTURAL_SCIENCES("к.с.-х.н.", "Кандидат сельскохозяйственных наук"),

    // Социологические науки
    DOCTOR_OF_SOCIOLOGICAL_SCIENCES("д.социол.н.", "Доктор социологических наук"),
    CANDIDATE_OF_SOCIOLOGICAL_SCIENCES("к.социол.н.", "Кандидат социологических наук"),

    // Технические науки
    DOCTOR_OF_TECHNICAL_SCIENCES("д.т.н.", "Доктор технических наук"),
    CANDIDATE_OF_TECHNICAL_SCIENCES("к.т.н.", "Кандидат технических наук"),

    // Фармакология
    CANDIDATE_OF_PHARMACOLOGICAL_SCIENCES("к.фарм.н.", "Кандидат фармакологических наук"),

    // Филологические науки
    DOCTOR_OF_PHILOLOGICAL_SCIENCES("д.ф.н.", "Доктор филологических наук"),
    CANDIDATE_OF_PHILOLOGICAL_SCIENCES("к.ф.н.", "Кандидат филологических наук"),

    // Физико-математические науки
    DOCTOR_OF_PHYSICAL_MATHEMATICAL_SCIENCES("д.ф.-м.н.", "Доктор физико-математических наук"),
    CANDIDATE_OF_PHYSICAL_MATHEMATICAL_SCIENCES("к.ф.-м.н.", "Кандидат физико-математических наук"),

    // Философские науки
    DOCTOR_OF_PHILOSOPHICAL_SCIENCES("д.филос.н.", "Доктор философских наук"),
    CANDIDATE_OF_PHILOSOPHICAL_SCIENCES("к.филос.н.", "Кандидат философских наук"),

    // Химические науки
    DOCTOR_OF_CHEMICAL_SCIENCES("д.х.н.", "Доктор химических наук"),
    CANDIDATE_OF_CHEMICAL_SCIENCES("к.х.н.", "Кандидат химических наук"),

    // Экономические науки
    DOCTOR_OF_ECONOMIC_SCIENCES("д.э.н.", "Доктор экономических наук"),
    CANDIDATE_OF_ECONOMIC_SCIENCES("к.э.н.", "Кандидат экономических наук"),

    // Юридические науки
    DOCTOR_OF_LAW("д.ю.н.", "Доктор юридических наук"),
    CANDIDATE_OF_LAW("к.ю.н.", "Кандидат юридических наук");

    private final String abbreviation;
    private final String fullName;

    AcademicDegree(String abbreviation, String fullName) {
        this.abbreviation = abbreviation;
        this.fullName = fullName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getFullName() {
        return fullName;
    }
}
