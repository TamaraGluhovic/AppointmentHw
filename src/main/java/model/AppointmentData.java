package model;

public class AppointmentData {

        private String facility;
        private boolean applyForHospitalReadmission;
        private String healthCareProgram;
        private String appointmentDate;
        private String appointmentNote;

        public AppointmentData() { }

        public AppointmentData(String facility,
                               boolean applyForHospitalReadmission,
                               String healthCareProgram,
                               String appointmentDate,
                               String appointmentNote) {
            this.facility = facility;
            this.applyForHospitalReadmission = applyForHospitalReadmission;
            this.healthCareProgram = healthCareProgram;
            this.appointmentDate = appointmentDate;
            this.appointmentNote = appointmentNote;
        }

        /*
         * Use this method to check if the result has the same values as test data
         */
        public boolean dataIsSameAs(AppointmentData data) {
            return this.facility.equals(data.facility) &&
                    this.applyForHospitalReadmission == data.applyForHospitalReadmission &&
                    this.healthCareProgram.equals(data.healthCareProgram) &&
                    this.appointmentDate.equals(data.appointmentDate) &&
                    this.appointmentNote.equals(data.appointmentNote);
        }

        public String getFacility() {
            return facility;
        }

        public void setFacility(String facility) {
            this.facility = facility;
        }

        public boolean isApplyForHospitalReadmission() {
            return applyForHospitalReadmission;
        }

        public void setApplyForHospitalReadmission(boolean applyForHospitalReadmission) {
            this.applyForHospitalReadmission = applyForHospitalReadmission;
        }

        public String getHealthCareProgram() {
            return healthCareProgram;
        }

        public void setHealthCareProgram(String healthCareProgram) {
            this.healthCareProgram = healthCareProgram;
        }

        public String getAppointmentDate() {
            return appointmentDate;
        }

        public void setAppointmentDate(String appointmentDate) {
            this.appointmentDate = appointmentDate;
        }

        public String getAppointmentNote() {
            return appointmentNote;
        }

        public void setAppointmentNote(String appointmentNote) {
            this.appointmentNote = appointmentNote;
        }
    }

