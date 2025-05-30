# Википедия УрФУ

Википедия с описанием и отзывами на институты, кафедры и преподавателей. 
  Каждый студент уральского федерального будет иметь возможность узнать чуточку больше о своём месте обучения, преподавателях и кафедрах а также оставить анонимный комментарий и поставить оценку.
  
  Идея взята с https://wiki.mipt.tech

# Инструкция по запуску проекта

## Требования
Необходимы инструменты:
- [Docker](https://www.docker.com/) 
- [Docker Compose](https://docs.docker.com/compose/) 

---

## Запуск

1. Клонирование репозитория
   ```bash
   git clone https://github.com/Forvi/URFU-Wikipedia.git
3. Переход в директорию с приложением
   ```bash
   cd WikiUrfi
5. Сборка docker-образа
   ```bash
   (sudo) docker build -t wikiurfu .
7. Запуск приложения
   ```bash
   (sudo) docker-compose up

---

## Счётчик тем, включённых в проект
1. ~~Environment~~ ✅
2. ~~Spring Boot~~ ✅
3. ~~DI~~ ✅
4. ~~Web Service~~ ✅
5. ~~Validation~~ ✅
6. ~~Config (with Swagger)~~ ✅
7. ~~DB (Hibernate)~~ ✅
8. Spring Security❌
9. App Events and Listeners❌
10. Aspects❌
11. Brockers❌
12. Support❌
13. Jobs❌
14. Cache❌


