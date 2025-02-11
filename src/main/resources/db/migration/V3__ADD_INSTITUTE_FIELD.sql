ALTER TABLE departments
ADD COLUMN institute_id UUID;

ALTER TABLE departments
ADD CONSTRAINT fk_institute
FOREIGN KEY (institute_id)
REFERENCES institutes(id);

