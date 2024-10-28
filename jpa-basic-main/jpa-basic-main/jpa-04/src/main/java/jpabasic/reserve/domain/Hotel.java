package jpabasic.reserve.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
    @Entity
    @Table(name = "hotel_info")
    public class Hotel {

        @Id
        @Column(name = "hotel_id")
        private String id;

        private String nm;
        private int year;
        @Enumerated(EnumType.STRING)
        private Grade grade;
        private LocalDateTime created;
        @Column(name = "modified")
        private LocalDateTime lastModified;

        public Hotel() {

        }

        public Hotel(String id, String nm, int year, Grade grade) {
            this.id = id;
            this.nm = nm;
            this.year = year;
            this.grade = grade;
            this.created = LocalDateTime.now();
            this.lastModified = LocalDateTime.now();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNm() {
            return nm;
        }

        public void setNm(String nm) {
            this.nm = nm;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public Grade getGrade() {
            return grade;
        }

        public void setGrade(Grade grade) {
            this.grade = grade;
        }

        public LocalDateTime getCreated() {
            return created;
        }

        public void setCreated(LocalDateTime created) {
            this.created = created;
        }

        public LocalDateTime getLastModified() {
            return lastModified;
        }

        public void setLastModified(LocalDateTime lastModified) {
            this.lastModified = lastModified;
        }

        @Override
        public String toString() {
            return "Hotel{" +
                    "id='" + id + '\'' +
                    ", nm='" + nm + '\'' +
                    ", year=" + year +
                    ", grade=" + grade +
                    ", created=" + created +
                    ", lastModified=" + lastModified +
                    '}';
        }
    }

