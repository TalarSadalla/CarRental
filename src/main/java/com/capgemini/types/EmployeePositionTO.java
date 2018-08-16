package com.capgemini.types;

import javax.persistence.*;

public class EmployeePositionTO {

    private Long id;
    private String jobTitle;

    public EmployeePositionTO(Long id, String jobTitle) {
        this.id = id;
        this.jobTitle = jobTitle;
    }

    public Long getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public static EmployeePositionTOBuilder builder() {
        return new EmployeePositionTOBuilder();
    }

    public static class EmployeePositionTOBuilder {

        private Long id;
        private String jobTitle;

        public EmployeePositionTOBuilder() {
            super();
        }

        public EmployeePositionTOBuilder withJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public EmployeePositionTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeePositionTO build() {
            checkBeforeBuild(jobTitle);
            return new EmployeePositionTO(id, jobTitle);
        }

        private void checkBeforeBuild(String jobTitle) {
            if (jobTitle == null || jobTitle.isEmpty()) {
                throw new RuntimeException("Incorrect Job title to be created");
            }
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmployeePositionTO other = (EmployeePositionTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (jobTitle == null) {
            if (other.jobTitle != null)
                return false;
        } else if (!jobTitle.equals(other.jobTitle))
            return false;
        return true;
    }
}


