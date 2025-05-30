CREATE TABLE departments (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE teachers (
    id UUID PRIMARY KEY,
    name VARCHAR(80) NOT NULL,
    bio TEXT,
    academic_degree VARCHAR(255),
    academic_rank VARCHAR(255),
    department_id UUID REFERENCES departments(id)
);
