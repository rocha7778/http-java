package com.rocha.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Participant {
	public String email;
	public String eventId; 
	public String location;
	public int raffleNumber;

}


/*{
    "email": "luis_2rocha@epam.com",
    "eventId": "65451177f7fe277aa9a92531",
    "location": "Colombia",
    "raffleNumber": 0
}

*/
