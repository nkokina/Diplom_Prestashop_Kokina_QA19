package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Authentication {

        public static Authentication AuthenticationBuilder;
        private String title;
        private String lastName;
        private String firstName;
        private String password;
        private String data;
        private String months;
        private String years;

}
