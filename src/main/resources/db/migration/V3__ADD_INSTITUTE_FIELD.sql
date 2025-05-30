ALTER TABLE departments
ADD COLUMN institute_id UUID REFERENCES institutes(id);

