package models;

import enums.Title;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

        public static User userBuilder;
        private Title title;
        private String lastName;
        private String firstName;
        private String password;
        private String data;
        private String months;
        private String years;

}
