package mag.birds;

import java.util.Calendar;

public class Observation {

        private int BirdId;
        private String Comment;
        private Calendar Created;
        private int Id;
        private double Latitude;
        private double Longitude;
        private String Placename;
        private int Population;
        private String UserId;
        private String NameDanish;
        private String NameEnglish;

        public Observation(){

        }

        public Observation(int BirdId, String Comment, Calendar Created, int Id, double Latitude, double Longitude, String Placename, int Population, String UserId, String NameDanish, String NameEnglish ){

            this.BirdId = BirdId;
            this.Comment = Comment;
            this.Created = Created;
            this.Id = Id;
            this.Latitude = Latitude;
            this.Longitude = Longitude;
            this.Placename = Placename;
            this.Population = Population;
            this.UserId = UserId;
            this.NameDanish = NameDanish;
            this.NameEnglish = NameEnglish;
        }

        public int getBirdId() {
            return BirdId;
        }

        public void setBirdId(int birdId) {
            BirdId = birdId;
        }

        public String getComment() {
            return Comment;
        }

        public void setComment(String comment) {
            Comment = comment;
        }

        public Calendar getCreated() {
            return Created;
        }

        public void setCreated(Calendar created) {
            Created = created;
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public double getLatitude() {
            return Latitude;
        }

        public void setLatitude(double latitude) {
            Latitude = latitude;
        }

        public double getLongitude() {
            return Longitude;
        }

        public void setLongitude(double longitude) {
            Longitude = longitude;
        }

        public String getPlacename() {
            return Placename;
        }

        public void setPlacename(String placename) {
            Placename = placename;
        }

        public int getPopulation() {
            return Population;
        }

        public void setPopulation(int population) {
            Population = population;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String userId) {
            UserId = userId;
        }

        public String getNameDanish() {
            return NameDanish;
        }

        public void setNameDanish(String nameDanish) {
            NameDanish = nameDanish;
        }

        public String getNameEnglish() {
            return NameEnglish;
        }

        public void setNameEnglish(String nameEnglish) {
            NameEnglish = nameEnglish;
        }

        @Override
        public String toString(){
            return NameDanish;
        }
}

